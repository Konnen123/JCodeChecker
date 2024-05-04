package Controller.Statements;

import java.util.regex.Pattern;

public class SwitchStatementController extends ConditionalStatementController{
    public SwitchStatementController()
    {
        this.namingConventionRegex = "\\bswitch\\b.*";
        this.conditionalStatementPattern = Pattern.compile(namingConventionRegex);
    }
}
