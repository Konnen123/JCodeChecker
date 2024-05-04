package Model.Statements;

public class ConditionalStatementFactory {
    public static ConditionalStatement createConditionalStatement(String statement)
    {
        if(statement.startsWith("if") || statement.startsWith("else"))
        {
            return new IfStatement(statement);
        }
        if(statement.startsWith("switch"))
        {
            return new SwitchStatement(statement);
        }
        if(statement.startsWith("while"))
        {
            return new WhileStatement(statement);
        }
        if(statement.startsWith("for"))
        {
            return new ForStatement(statement);
        }
        return null;


    }
}
