module org.project.app.Practica_03 {
    requires javafx.controls;
    requires javafx.fxml;
	requires java.sql;
	requires java.desktop;

    opens org.project.app.Practica_03 to javafx.fxml;
    opens org.project.app.model to javafx.base;
    exports org.project.app.Practica_03;
}
