module edu.asu.com360.maven.example {
    requires javafx.controls;
    requires javafx.fxml;

    opens edu.asu.com360.maven.example to javafx.fxml;
    exports edu.asu.com360.maven.example;
}
