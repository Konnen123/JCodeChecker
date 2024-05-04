package Controller.NamingConvention;

import java.util.regex.Pattern;

public abstract class NamingConventionController {
    // Each class that inherits this one will have its own regex defined in the constructor
    protected String namingConventionRegex;
    protected Pattern namingConventionPattern;
    public boolean checkNamingConvention(String methodName) {
        if(methodName == null || methodName.length() == 0)
            return false;

        return namingConventionPattern.matcher(methodName).matches();
    }
}
