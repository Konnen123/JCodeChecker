package Controller;

import java.util.regex.Pattern;

public abstract class NamingConventionController {
    protected String namingConventionRegex;
    protected Pattern namingConventionPattern;
    public boolean checkNamingConvention(String methodName) {
        if(methodName == null || methodName.length() == 0)
            return false;
        return namingConventionPattern.matcher(methodName).matches();
    }
}
