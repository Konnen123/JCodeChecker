package Utils;

import Panel.FooterPanel;
import com.src.jcodechecker.MainController;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class AnalyzeJavaCode {
    private final MainController mainController;

    public AnalyzeJavaCode(MainController mainController) {
        this.mainController = mainController;
    }

    public void analyze() {
        String filePath = mainController.pathField.getText();

        FileReader javaFileReader = getJavaFile(filePath);
        if(javaFileReader == null)
            return;

        mainController.errorText.setVisible(false);
        mainController.infoContainer.setVisible(true);

        BufferedReader bufferedReader = new BufferedReader(javaFileReader);

        checkCodeComplexity(bufferedReader);
    }

    private FileReader getJavaFile(String filePath)
    {
        FileReader fileReader;
        try {
            fileReader = new FileReader(new File(filePath));
        } catch (FileNotFoundException e) {
            setErrorMessage("File not found!");
            return null;
        }

        if(!filePath.endsWith(".java"))
        {
            setErrorMessage("File is not java!");
            return null;
        }
        return fileReader;

    }
    private void setErrorMessage(String errorMessage)
    {
        mainController.errorText.setVisible(true);
        mainController.infoContainer.setVisible(false);
        mainController.errorText.setText(errorMessage);
    }
    private void checkCodeComplexity(BufferedReader bufferedReader)
    {
        ComplexityEvaluator complexityEvaluator = new ComplexityEvaluator(mainController, bufferedReader);
        complexityEvaluator.displayMostComplexMethods();
    }
    private void checkCodeStyle(BufferedReader bufferedReader)
    {

    }
}
