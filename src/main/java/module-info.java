module org.example.kalkulator {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens org.example.kalkulator to javafx.fxml;
    exports org.example.kalkulator;
}