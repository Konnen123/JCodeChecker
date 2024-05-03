package Panel;

import Utils.AnalyzeJavaCode;
import com.src.jcodechecker.MainController;

public class FooterPanel {
    private final MainController mainController;
    public FooterPanel(MainController mainController)
    {
        this.mainController = mainController;
        AnalyzeJavaCode analyzeJavaCode = new AnalyzeJavaCode(mainController, this);
        mainController.checkJavaCodeButton.setOnAction(actionEvent -> analyzeJavaCode.analyze());
    }
    public void setErrorTextMessage(String errorMessage)
    {
        mainController.errorText.setVisible(true);
        mainController.errorText.setText(errorMessage);
    }
    public void hideErrorTextMessage()
    {
        mainController.errorText.setVisible(false);
    }
}
