package com.example.hello;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class DELETE_item {

    @FXML
    public Button back_bb;

    @FXML
    public AnchorPane del_anc;

    @FXML
    public TextField deleteField;


    public void onDeleteButtonClick() throws IOException{


        // check whether the given item code is exist or the main item list.
        if(add_items.itemList != null){
            int code = Integer.parseInt(deleteField.getText().trim());
            deleteItem(code);
        }else {
            error("No items Found!");
        }


    }

    // error
    public void error(String erroMessage) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Invalid Input");
        alert.setContentText(erroMessage);}

    // checking validity of the item
    public void deleteItem(int code) throws IOException {
        for (List<Object> item : add_items.itemList) {
            int itemCode = (int) item.get(0);
            if (itemCode == code) {
                // remove particular item list from main item list
                add_items.itemList.remove(item);

                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("item_del_popup_msg.fxml"));
                Stage stage = new Stage();
                Scene scene = new Scene(fxmlLoader.load(), 500, 150);
                stage.setScene(scene);
                stage.show();

                deleteField.clear();
                break;
            } else {
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("item_del2_popup_msg.fxml"));
                Stage stage = new Stage();
                Scene scene = new Scene(fxmlLoader.load(), 500, 150);
                stage.setScene(scene);
                stage.show();
                deleteField.clear();
                break;
            }

        }
    }

    public  void onBackButtonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("menu.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(fxmlLoader.load(), 650.0, 450.0);
        stage.setTitle("MENU");
        stage.setScene(scene);
        stage.show();

        Stage currentStage = (Stage) del_anc.getScene().getWindow();
        currentStage.close();
    }
}
