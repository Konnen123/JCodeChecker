package Model;

import Model.Statements.ConditionalStatement;

import java.util.LinkedList;
import java.util.List;

public class Method implements Comparable {
    private final String functionName;
    private final List<ConditionalStatement> conditionalStatements;

    public Method(String functionName) {
        this.functionName = functionName;
        conditionalStatements = new LinkedList<>();
    }

    @Override
    public String toString() {
        return functionName;
    }
    public String getFunctionName() {
        return functionName;
    }

    public List<ConditionalStatement> getConditionalStatements() {
        return conditionalStatements;
    }

    @Override
    public int compareTo(Object o) {
        if(!(o instanceof Method))
            return -1;

        Method method = (Method) o;

        if(method.getConditionalStatements().size() > conditionalStatements.size())
            return 1;
        else if(method.getConditionalStatements().size() < conditionalStatements.size())
            return -1;
        return 0;
    }
}