package Controller.Statements;

import java.util.regex.Pattern;

public abstract class ConditionalStatementController {
    // Each class that inherits this one will have its own regex defined in the constructor
    protected String namingConventionRegex;
    protected Pattern conditionalStatementPattern;
    public boolean checkConditionalStatement(String methodName) {
        if(methodName == null || methodName.length() == 0)
            return false;

        return conditionalStatementPattern.matcher(methodName).matches();
    }
}
