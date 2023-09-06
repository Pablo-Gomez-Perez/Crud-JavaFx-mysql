module org.project.app.Practica_03 {
    requires javafx.controls;
    requires javafx.fxml;
	requires java.sql;

    opens org.project.app.Practica_03 to javafx.fxml;
    exports org.project.app.Practica_03;
}
