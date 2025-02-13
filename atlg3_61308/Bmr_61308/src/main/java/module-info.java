module com.example.bmr_61308 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.bmr_61308 to javafx.fxml;
    exports com.example.bmr_61308;
}