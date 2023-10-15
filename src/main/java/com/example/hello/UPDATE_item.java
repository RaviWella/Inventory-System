package com.example.hello;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;


public class UPDATE_item {


    @FXML
    public Button select;

    @FXML
    public Button back;

    @FXML
    public AnchorPane up_anc;

    @FXML
    public TextField upLable;


    public void onSelButtonClick() throws IOException {

        // getting item code from user
        int code = Integer.parseInt(upLable.getText().trim());
        // search the validation through the method
        List<Object> selectedItem = updateItem(code);

        if( selectedItem != null){

            // load the next page if selectedItem list is not null
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("UPDATE2.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(fxmlLoader.load(), 650.0, 450.0);
            stage.setTitle("UPDATE ITEMS");
            stage.setScene(scene);
            stage.show();

            UPDATE_item2 controller = fxmlLoader.getController();
            controller.setSelectedItem(selectedItem);

            Stage currentStage = (Stage) up_anc.getScene().getWindow();
            currentStage.close();
        }
        else {
            // Displaying error message
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("item_del2_popup_msg.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(fxmlLoader.load(), 500, 150);
            stage.setScene(scene);
            stage.show();
        }
    }

    // check whether the item code is exsit or not
    public List<Object> updateItem(int findCode){
        for (List<Object> item : add_items.itemList) {

            int itemCode = (int) item.get(0);
            if (itemCode == findCode) {
                return item;
            }
        }
        return null;

    }

    public void onBackButtonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("menu.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(fxmlLoader.load(), 650.0, 450.0);
        stage.setTitle("MENU");
        stage.setScene(scene);
        stage.show();

        Stage currentStage = (Stage) up_anc.getScene().getWindow();
        currentStage.close();
    }

}
