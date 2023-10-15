package com.example.hello;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;


public class add_items {

    @FXML
    public Button bk;

    @FXML
    public AnchorPane add_anc;

    @FXML
    public TextField itemCode;

    @FXML
    public TextField itemName;

    @FXML
    public TextField itemBrand;

    @FXML
    public TextField itemQuantity;

    @FXML
    public TextField itemCategory;

    @FXML
    public TextField date;

    @FXML
    public TextField itemPrice;
    public static List<List<Object>> itemList = new ArrayList<>();

    @FXML
    public ImageView picture;


    public File imagePath;

    public static Object a8="";

    public void addButtonClick() throws IOException {
        a8 = "";
        if(imagePath != null){
            System.out.println("item is here");
            a8 = imagePath.getAbsolutePath();
        }else {
            System.out.println("item not here");
        }

        // call method and check whether all the fields are full or not
        if (!isAllFieldsFilled()) {
            error("Please fill all fields.");
            return;
        }

        // to store item details
        List<Object> item = new ArrayList<>();

        try {
            int a1 = Integer.parseInt(itemCode.getText().trim());
            String a2 = itemName.getText();
            Object a3 = itemBrand.getText();
            double a4 = Double.parseDouble(itemPrice.getText());
            int a5 = Integer.parseInt(itemQuantity.getText().trim());
            Object a6 = itemCategory.getText();
            Object a7 = date.getText();
            Object a8 = imagePath.getAbsolutePath();




            // check item code , item name and item quantities are in integer values
            if (isValidInput(a1, a4, a5)) {
                item.add(a1);
                item.add(a2);
                item.add(a3);
                item.add(a4);
                item.add(a5);
                item.add(a6);
                item.add(a7);
                item.add(a8);
                System.out.println(a8);


                // check whether the given item code is existing or not
                for (List<Object> itemm : itemList) {
                    int existingItemCode = (int) itemm.get(0);
                    if (existingItemCode == a1) {
                        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("error_add.fxml"));
                        Stage stage = new Stage();
                        Scene scene = new Scene(fxmlLoader.load(), 500, 150);
                        stage.setScene(scene);
                        stage.show();

                        return;

                    }
                }



                // adding item records main item list
                itemList.add(item);

                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("item_add_popup_msg.fxml"));
                Stage stage = new Stage();
                Scene scene = new Scene(fxmlLoader.load(), 500, 150);
                stage.setScene(scene);
                stage.show();

                clearTextFields();
            } else {
                error("Please enter correct numeric values for Item code,Price and Quantity.");
            }
        } catch (NumberFormatException e) {
            error("Please enter correct numeric values for Item code,Price and Quantity.");
            e.printStackTrace();
        }
    }

    // check whether all the fields are not empty
    private boolean isAllFieldsFilled() {
        return !itemCode.getText().trim().isEmpty()
                && !itemName.getText().isEmpty()
                && !itemBrand.getText().isEmpty()
                && !itemPrice.getText().isEmpty()
                && !itemQuantity.getText().isEmpty()
                && !itemCategory.getText().isEmpty()
                && !date.getText().isEmpty()
                && !a8.toString().isEmpty()
                ;
    }




    // check item code , item price and item quantity
    private boolean isValidInput(int code,double price, int quantity) {

        return price > 0 && quantity > 0 && code > 0;
    }



    // clear all the fields
    private void clearTextFields() {
        itemCode.clear();
        itemBrand.clear();
        itemName.clear();
        itemQuantity.clear();
        itemCategory.clear();
        itemPrice.clear();
        date.clear();
//        imagePath.delete();

    }



    public  void onBackButtonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MENU.class.getResource("menu.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(fxmlLoader.load(), 650.0, 450.0);
        stage.setTitle("MENU");
        stage.setScene(scene);
        stage.show();

        Stage currentStage = (Stage) add_anc.getScene().getWindow();
        currentStage.close();
    }

    // Display error message
    public void error(String erroMessage) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Invalid Input");
        alert.setContentText(erroMessage);

        alert.showAndWait();
        alert.close();
    }

    public void imageButton(ActionEvent event) {

        FileChooser pathOfFile = new FileChooser();
        pathOfFile.getExtensionFilters().add(new FileChooser.ExtensionFilter("Images","*.png","*.jpg","*.jpeg","*.webp"));
        imagePath=pathOfFile.showOpenDialog(null);


        Image image = new Image(imagePath.getAbsolutePath());
        picture.setImage(image);


    }
}


