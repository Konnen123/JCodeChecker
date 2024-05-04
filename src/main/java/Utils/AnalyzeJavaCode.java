package Utils;

import Panel.FooterPanel;
import com.src.jcodechecker.MainController;

import java.io.*;

public class AnalyzeJavaCode {
    private final MainController mainController;

    public AnalyzeJavaCode(MainController mainController) {
        this.mainController = mainController;
    }

    public void analyze() {
        String filePath = mainController.pathField.getText();

        FileReader complexityCheckerReader = getJavaFile(filePath);
        FileReader codeStyleCheckerReader = getJavaFile(filePath);
        if(complexityCheckerReader == null || codeStyleCheckerReader == null)
            return;

        mainController.errorText.setVisible(false);
        mainController.infoContainer.setVisible(true);


        checkCodeComplexity(new BufferedReader(complexityCheckerReader));
        checkCodeStyle(new BufferedReader(codeStyleCheckerReader));
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

        try {
            bufferedReader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private void checkCodeStyle(BufferedReader bufferedReader)
    {
        CodeStyleEvaluator codeStyleEvaluator = new CodeStyleEvaluator(mainController, bufferedReader);

        try {
            bufferedReader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
