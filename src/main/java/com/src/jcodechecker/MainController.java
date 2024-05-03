package com.src.jcodechecker;

import Panel.FooterPanel;
import Panel.SettingsPanel;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class MainController {
    @FXML
    public TextField pathField;
    @FXML
    public ComboBox<String> namingConventionsBox;
    @FXML
    public Button checkJavaCodeButton;
    @FXML
    public Text errorText;
    @FXML
    public void initialize() {
        SettingsPanel settingsPanel = new SettingsPanel(this);
        FooterPanel footerPanel = new FooterPanel(this);
    }

}