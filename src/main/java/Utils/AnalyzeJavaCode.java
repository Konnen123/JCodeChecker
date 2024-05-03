package Utils;

import Panel.FooterPanel;
import com.src.jcodechecker.MainController;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class AnalyzeJavaCode {
    private final MainController mainController;
    private final FooterPanel footerPanel;

    public AnalyzeJavaCode(MainController mainController, FooterPanel footerPanel) {
        this.mainController = mainController;
        this.footerPanel = footerPanel;
    }

    public void analyze() {
        String filePath = mainController.pathField.getText();

        FileReader javaFileReader = getJavaFile(filePath);
        System.out.println(filePath);

        if(javaFileReader == null)
        {
            System.out.println("NOT FOUND!");
            footerPanel.setErrorTextMessage("File not found!");
            return;
        }
        if(!filePath.endsWith(".java"))
        {
            System.out.println("FILE IS NOT JAVA!");
            footerPanel.setErrorTextMessage("File is not java!");
            return;
        }
        footerPanel.hideErrorTextMessage();
    }

    private FileReader getJavaFile(String filePath)
    {
        FileReader fileReader;
        try {
            fileReader = new FileReader(new File(filePath));
        } catch (FileNotFoundException e) {
            return null;
        }
        return fileReader;

    }
}
