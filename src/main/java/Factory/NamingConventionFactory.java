package Factory;

import Controller.CamelCaseController;
import Controller.SnakeCaseController;
import Model.NamingConvention.CamelCase;
import Model.NamingConvention.NamingConvention;
import Model.NamingConvention.SnakeCase;

public class NamingConventionFactory {
    public static NamingConvention createNamingConvention(String methodName, String namingConvention)
    {
        switch (namingConvention)
        {
            case "camelCase"->{
                CamelCaseController camelCaseController = new CamelCaseController();
                return camelCaseController.checkNamingConvention(methodName) ? new CamelCase(methodName) : null;
            }
            case "snake_case"->{
                SnakeCaseController snakeCaseController = new SnakeCaseController();
                return snakeCaseController.checkNamingConvention(methodName) ? new SnakeCase(methodName) : null;
            }
            default -> {
                return null;
            }
        }
    }
}
