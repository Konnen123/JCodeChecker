package Panel;

import Utils.AnalyzeJavaCode;
import com.src.jcodechecker.MainController;

public class FooterPanel {
    private final MainController mainController;
    public FooterPanel(MainController mainController)
    {
        this.mainController = mainController;
        mainController.checkJavaCodeButton.setOnAction(actionEvent -> setButtonAction());
    }
    private void setButtonAction()
    {
        // On button click, analyze the java file from the path given
        AnalyzeJavaCode analyzeJavaCode = new AnalyzeJavaCode(mainController);
        analyzeJavaCode.analyze();
    }
}
