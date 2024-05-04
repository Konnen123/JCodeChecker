package Controller;

import java.util.regex.Pattern;

public class SnakeCaseController extends NamingConventionController{
    public SnakeCaseController()
    {
        namingConventionRegex = "[a-z]+(?:_[a-z]+)*";
        namingConventionPattern = Pattern.compile(namingConventionRegex);
    }

}
