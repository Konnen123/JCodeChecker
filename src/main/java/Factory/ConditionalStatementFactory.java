package Factory;

import Controller.Statements.ForStatementController;
import Controller.Statements.IfStatementController;
import Controller.Statements.SwitchStatementController;
import Controller.Statements.WhileStatementController;
import Model.Statements.*;

public class ConditionalStatementFactory {
    public static ConditionalStatement createConditionalStatement(String statement)
    {
        // It is not enough to check if the statement starts with the condition name
        // Also a regex (ex: format starts with for, but it's not a conditional statement)
        if(statement.startsWith("if") || statement.startsWith("else"))
        {
            IfStatementController ifStatementController = new IfStatementController();
            return ifStatementController.checkConditionalStatement(statement) ? new IfStatement(statement) : null;
        }
        if(statement.startsWith("switch"))
        {
            SwitchStatementController switchStatementController = new SwitchStatementController();
            return switchStatementController.checkConditionalStatement(statement) ? new SwitchStatement(statement) : null;
        }
        if(statement.startsWith("while"))
        {
            WhileStatementController whileStatementController = new WhileStatementController();
            return whileStatementController.checkConditionalStatement(statement) ? new WhileStatement(statement) : null;
        }
        if(statement.startsWith("for"))
        {
            ForStatementController forStatementController = new ForStatementController();
            return forStatementController.checkConditionalStatement(statement) ? new ForStatement(statement) : null;
        }
        return null;


    }
}
