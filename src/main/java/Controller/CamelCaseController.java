package Controller;

import java.util.regex.Pattern;

public class CamelCaseController extends NamingConventionController{

    public CamelCaseController()
    {
        namingConventionRegex = "[a-z]+((\\d)|([A-Z0-9][a-z0-9]+))*([A-Z])?";
        namingConventionPattern = Pattern.compile(namingConventionRegex);
    }
}
