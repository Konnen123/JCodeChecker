package Controller.Statements;

import java.util.regex.Pattern;

public class IfStatementController extends ConditionalStatementController{
    public IfStatementController()
    {
        this.namingConventionRegex = "\\b(if|else)\\b.*";
        this.conditionalStatementPattern = Pattern.compile(namingConventionRegex);
    }
}
