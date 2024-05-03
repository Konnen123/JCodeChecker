module com.src.jcodechecker {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.src.jcodechecker to javafx.fxml;
    exports com.src.jcodechecker;
}