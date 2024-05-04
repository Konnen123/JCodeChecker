package Utils;

import java.util.regex.Pattern;

public class MethodPattern {
    // A singleton class that is responsible for getting a method from a String
    private static MethodPattern methodPattern;
    private Pattern pattern;
    private static final String METHOD_REGEX = "(public|protected|private|static|\\s) +[\\w\\<\\>\\[\\]]+\\s+(\\w+) *\\([^\\)]*\\) *(\\{?|[^;])";
    private MethodPattern() {}

    public static MethodPattern getMethodPattern() {
        if(methodPattern == null)
        {
            methodPattern = new MethodPattern();
        }
        return methodPattern;
    }
    public Pattern getPattern()
    {
        if(pattern == null)
        {
            pattern =  Pattern.compile(METHOD_REGEX);
        }
        return pattern;
    }
}
