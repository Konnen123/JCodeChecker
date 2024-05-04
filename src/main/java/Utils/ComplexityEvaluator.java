package Utils;

import Model.Method;
import Model.Statements.ConditionalStatement;
import Model.Statements.ConditionalStatementFactory;
import com.src.jcodechecker.MainController;

import java.io.BufferedReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ComplexityEvaluator {
    private final MainController mainController;
    private final BufferedReader bufferedReader;
    private final Pattern pattern;
    private final List<Method> methods;
    private final Method[] mostComplexMethods;
    private static final String METHOD_REGEX = "(public|protected|private|static|\\s) +[\\w\\<\\>\\[\\]]+\\s+(\\w+) *\\([^\\)]*\\) *(\\{?|[^;])";

    public ComplexityEvaluator(MainController mainController, BufferedReader bufferedReader)
    {
        this.mainController = mainController;
        this.bufferedReader = bufferedReader;
        pattern =  Pattern.compile(METHOD_REGEX);
        methods = new LinkedList<>();
        mostComplexMethods = new Method[3];

        checkComplexityOfMethods();
    }
    private void checkComplexityOfMethods()
    {
        bufferedReader.lines().forEach(this::checkCurrentLine);
        getMostComplexMethods();
    }
    private void checkCurrentLine(String line)
    {
        String trimmedLine = line.trim();
        // Remove the open parenthesis from the line
        StringBuilder modifiedLine = line.endsWith("{") ? new StringBuilder(trimmedLine.substring(0, trimmedLine.length() - 1)) : new StringBuilder(trimmedLine);
        Matcher matcher = pattern.matcher(modifiedLine);
        if(matcher.find())
        {
            // We have found a method, add it into list
            methods.add(new Method(matcher.group()));
            return;
        }
        if(methods.isEmpty())
            return;

        // We are in a method, find conditional statements
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
        Arrays.fill(mostComplexMethods, new Method("Not found"));
        for(var currentMethod : methods)
        {
            int mostComplexMethodSize = mostComplexMethods[2].getConditionalStatements().size();
            int currentMethodSize = currentMethod.getConditionalStatements().size();
            if(mostComplexMethodSize < currentMethodSize)
            {
                // Found a method with higher complexity, add it and then sort the array
                mostComplexMethods[2] = currentMethod;
                Arrays.sort(mostComplexMethods);
            }
        }
    }
    public void displayMostComplexMethods()
    {
        mainController.firstMethod.setText(mostComplexMethods[0] + ": " + mostComplexMethods[0].getConditionalStatements().size());
        mainController.secondMethod.setText(mostComplexMethods[1] + ": " + mostComplexMethods[1].getConditionalStatements().size());
        mainController.thirdMethod.setText(mostComplexMethods[2] + ": " + mostComplexMethods[2].getConditionalStatements().size());
    }
}
