package Controller.Statements;

import java.util.regex.Pattern;

public class WhileStatementController extends ConditionalStatementController{
    public WhileStatementController()
    {
        this.namingConventionRegex = "\\bwhile\\b.*";
        this.conditionalStatementPattern = Pattern.compile(namingConventionRegex);
    }
}
