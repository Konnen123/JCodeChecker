package Utils;

import com.src.jcodechecker.MainController;

import java.io.BufferedReader;

public class CodeStyleEvaluator {
    private final MainController mainController;
    private final BufferedReader bufferedReader;
    private int totalMethods;
    private int nonConformingMethodCount;
    public CodeStyleEvaluator(MainController mainController, BufferedReader bufferedReader)
    {
        this.mainController = mainController;
        this.bufferedReader = bufferedReader;
    }
}
