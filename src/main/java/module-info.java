module com.example.hello {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.hello to javafx.fxml;
    exports com.example.hello;
}