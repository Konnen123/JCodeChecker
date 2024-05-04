package Controller.Statements;

import java.util.regex.Pattern;

public class ForStatementController extends ConditionalStatementController{
    public ForStatementController()
    {
        this.namingConventionRegex = "\\bfor\\b.*";
        this.conditionalStatementPattern = Pattern.compile(namingConventionRegex);
    }
}
