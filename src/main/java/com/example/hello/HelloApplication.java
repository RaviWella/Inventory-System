package com.example.hello;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {



    @Override
    public void start(Stage stage) throws IOException {


        FXMLLoader fxmlLoader = new FXMLLoader(MENU.class.getResource("startup.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 650, 445);
        stage.setTitle("ONE-NET CAFE");
        stage.setScene(scene);
        stage.show();
    }



    public static void main(String[] args) {

        launch();
    }
}
