module School_Database {
  requires javafx.controls;
  requires javafx.fxml;
  requires java.desktop;
  requires javafx.base;
  requires java.sql;
  requires javafx.graphics;

  opens application to javafx.graphics, javafx.fxml, javafx.base;
}
