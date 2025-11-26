module tt.manager.tttrainingmanager {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens tt.manager to javafx.fxml;
    exports tt.manager;
}