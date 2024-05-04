package Utils;

import Factory.ConditionalStatementFactory;
import Model.Method;
import Model.Statements.ConditionalStatement;
import com.src.jcodechecker.MainController;

import java.io.BufferedReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;

public class ComplexityEvaluator implements Evaluator {
    private final MainController mainController;
    private final BufferedReader bufferedReader;
    private final List<Method> methods;
    private final Method[] mostComplexMethods;

    public ComplexityEvaluator(MainController mainController, BufferedReader bufferedReader)
    {
        this.mainController = mainController;
        this.bufferedReader = bufferedReader;

        // Use a linked list because we will not need to get an element from a specific index
        methods = new LinkedList<>();
        mostComplexMethods = new Method[3];

        checkComplexityOfMethods();
    }
    private void checkComplexityOfMethods()
    {
        bufferedReader.lines().forEach(this::checkCurrentLine);
        getMostComplexMethods();
    }
    public void checkCurrentLine(String line)
    {
        String trimmedLine = line.trim();
        // Remove the open parenthesis from the line if it exists
        StringBuilder modifiedLine = line.endsWith("{") ? new StringBuilder(trimmedLine.substring(0, trimmedLine.length() - 1)) : new StringBuilder(trimmedLine);

        // Check if the current line is a method using the regex from the singleton class
        Matcher matcher = MethodPattern.getMethodPattern().getPattern().matcher(modifiedLine);
        if(matcher.find())
        {
            // We have found a method, add it into list
            methods.add(new Method(matcher.group()));
            return;
        }
        if(methods.isEmpty())
            return;

        // We are in a method, check if the current line is a conditional statement
        ConditionalStatement conditionalStatement = ConditionalStatementFactory.createConditionalStatement(modifiedLine.toString());
        // If the conditionalStatement is null, it means that the current line is not a conditional statement
        if(conditionalStatement == null)
            return;

        // Get the conditional statement list from the last method found and add the statement.
        List<ConditionalStatement> conditionalStatements = methods.get(methods.size() - 1).getConditionalStatements();
        conditionalStatements.add(conditionalStatement);
    }
    private void getMostComplexMethods()
    {
        // Get the three most complex methods
        mostComplexMethods[0] = methods.size() >=1 ? methods.get(0) : new Method("Not found");
        mostComplexMethods[1] = methods.size() >=2 ? methods.get(1) : new Method("Not found");
        mostComplexMethods[2] = methods.size() >=3 ? methods.get(2) : new Method("Not found");
        for(int i=3;i<methods.size();i++)
        {
            int mostComplexMethodSize = mostComplexMethods[2].getConditionalStatements().size();
            int currentMethodSize = methods.get(i).getConditionalStatements().size();
            if(mostComplexMethodSize < currentMethodSize)
            {
                // Found a method with higher complexity, add it and then sort the array
                mostComplexMethods[2] = methods.get(i);
                Arrays.sort(mostComplexMethods);
            }
        }
        // Sort in case size is smaller than 3
        Arrays.sort(mostComplexMethods);
    }
    public void displayMostComplexMethods()
    {
        mainController.firstMethod.setText(mostComplexMethods[0] + ": " + mostComplexMethods[0].getConditionalStatements().size());
        mainController.secondMethod.setText(mostComplexMethods[1] + ": " + mostComplexMethods[1].getConditionalStatements().size());
        mainController.thirdMethod.setText(mostComplexMethods[2] + ": " + mostComplexMethods[2].getConditionalStatements().size());
    }
}
