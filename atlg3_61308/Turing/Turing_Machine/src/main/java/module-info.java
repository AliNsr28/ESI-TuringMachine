module view {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens view to javafx.fxml;
    exports view;
    exports controller;
    opens controller to javafx.fxml;


}