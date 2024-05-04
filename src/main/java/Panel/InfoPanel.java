package Panel;

import com.src.jcodechecker.MainController;

public class InfoPanel {
    private final MainController mainController;

    public InfoPanel(MainController mainController) {
        this.mainController = mainController;
        mainController.infoContainer.setVisible(false);
    }
}
