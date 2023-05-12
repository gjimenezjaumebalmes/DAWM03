module com.example.conectarbdremota_gja {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    opens com.example.conectarbdremota_gja to javafx.fxml;
    exports com.example.conectarbdremota_gja;
    exports conectarbdremota_gja;
}