package com.src.jcodechecker;

import Panel.FooterPanel;
import Panel.InfoPanel;
import Panel.SettingsPanel;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class MainController {
    // Settings
    @FXML
    public TextField pathField;
    @FXML
    public ComboBox<String> namingConventionsBox;

    // Info
    @FXML
    public VBox infoContainer;
    @FXML
    public Text firstMethod;
    @FXML
    public Text secondMethod;
    @FXML
    public Text thirdMethod;
    @FXML
    public Text totalMethodsText;
    @FXML
    public Text nonConformingMethodCountText;
    @FXML
    public Text nonConformingMethodPercentageText;

    // Footer
    @FXML
    public Button checkJavaCodeButton;
    @FXML
    public Text errorText;
    @FXML
    public void initialize() {
        SettingsPanel settingsPanel = new SettingsPanel(this);
        InfoPanel infoPanel = new InfoPanel(this);
        FooterPanel footerPanel = new FooterPanel(this);
    }

}