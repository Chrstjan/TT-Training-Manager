module tt.manager.tttrainingmanager {
    requires javafx.controls;
    requires javafx.fxml;


    opens tt.manager to javafx.fxml;
    exports tt.manager;
}