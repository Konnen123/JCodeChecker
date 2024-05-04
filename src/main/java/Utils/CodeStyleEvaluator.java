package Utils;

import Controller.NamingConventionController;
import Factory.NamingConventionFactory;
import Model.Method;
import Model.NamingConvention.NamingConvention;
import com.src.jcodechecker.MainController;

import java.io.BufferedReader;
import java.util.regex.Matcher;

public class CodeStyleEvaluator implements Evaluator {
    private final MainController mainController;
    private final BufferedReader bufferedReader;
    private int totalMethods;
    private int nonConformingMethodCount;
    private final String namingConvention;
    public CodeStyleEvaluator(MainController mainController, BufferedReader bufferedReader)
    {
        this.mainController = mainController;
        this.bufferedReader = bufferedReader;
        totalMethods = 0;
        nonConformingMethodCount = 0;
        namingConvention = mainController.namingConventionsBox.getSelectionModel().getSelectedItem();

        checkCodeStyle();
    }
    private void checkCodeStyle()
    {
        bufferedReader.lines().forEach(this::checkCurrentLine);
        mainController.totalMethodsText.setText("Total methods: " + totalMethods);
        mainController.nonConformingMethodCountText.setText("Total methods that are not " + namingConvention +": "+ nonConformingMethodCount);
        mainController.nonConformingMethodPercentageText.setText("Percentage of methods that are not " + namingConvention +": " + ((float)nonConformingMethodCount* 100/ totalMethods) + "%");
    }

    @Override
    public void checkCurrentLine(String line) {
        String trimmedLine = line.trim();
        // Remove the open parenthesis from the line
        String modifiedLine = line.endsWith("{") ? trimmedLine.substring(0, trimmedLine.length() - 1) : trimmedLine;
        // Check if the current line is a method using a regex from the singleton class
        Matcher matcher = MethodPattern.getMethodPattern().getPattern().matcher(modifiedLine);
        if(!matcher.find())
            return;

        String methodName = extractMethodName(modifiedLine);
        if(methodName == null)
            return;

        totalMethods++;
        NamingConvention methodNamingConvention = NamingConventionFactory.createNamingConvention(methodName, namingConvention);
        if(methodNamingConvention == null)
        {
            nonConformingMethodCount++;
        }

    }
    private String extractMethodName(String rawName)
    {
        String getNameWithoutParameters = rawName.substring(0, rawName.indexOf("("));
        String[] tokens = getNameWithoutParameters.split(" ");

        return tokens.length == 0 ? null : tokens[tokens.length - 1].trim();
    }
}
