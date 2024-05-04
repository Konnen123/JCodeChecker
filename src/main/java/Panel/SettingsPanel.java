package Panel;

import com.src.jcodechecker.MainController;
import javafx.collections.FXCollections;
import javafx.scene.control.ComboBox;

public class SettingsPanel {
    private final MainController mainController;

    public SettingsPanel(MainController mainController) {
        this.mainController = mainController;
        createNamingConventionsBox();
    }
    private void createNamingConventionsBox()
    {
        ComboBox<String> namingConventionBox = mainController.namingConventionsBox;

        namingConventionBox.setItems(FXCollections.observableArrayList(
                "camelCase",
                "snake_case"
        ));
        namingConventionBox.setValue("camelCase");

    }

}
