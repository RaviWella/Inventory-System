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
import java.util.Objects;

import static com.example.hello.add_items.itemList;

public class UPDATE_item2 {

    @FXML
    public AnchorPane up2_anc;

    @FXML
    public Button up_bb;

    @FXML
    public Button back;

    @FXML
    public TextField update_itemCode;

    @FXML
    public TextField update_itemName;

    @FXML
    public TextField update_itemBrand;

    @FXML
    public TextField update_itemPrice;

    @FXML
    public TextField update_itemQuantity;

    @FXML
    public TextField update_itemCategory;

    @FXML
    public TextField update_Date;


    private List<Object> selectedItem;
    private List<Object> temp;


    public void setSelectedItem(List<Object> item){
        selectedItem = item;

        update_itemCode.setText(String.valueOf(selectedItem.get(0)));
        update_itemName.setText((String) selectedItem.get(1));
        update_itemBrand.setText((String) selectedItem.get(2));
        update_itemPrice.setText(String.valueOf(selectedItem.get(3)));
        update_itemQuantity.setText(String.valueOf(selectedItem.get(4)));
        update_itemCategory.setText((String) selectedItem.get(5));
        update_Date.setText((String) selectedItem.get(6));
    }


    public  void onUpButtonClick() throws IOException {

        if (!isAllFieldsFilled()) {
            error("Please fill all fields.");
            return;
        }

        int code = 0;
        String name = null;
        String brand = null;
        double price = 0;
        int quantity = 0;
        String category = null;
        String date = null;
        itemList.remove(selectedItem);

        try {
            code = Integer.parseInt(update_itemCode.getText().trim());
            name = update_itemName.getText();
            brand = update_itemBrand.getText();
            price = Double.parseDouble(update_itemPrice.getText());
            quantity = Integer.parseInt(update_itemQuantity.getText().trim());
            category = update_itemCategory.getText();
            date = update_Date.getText();



            for (List<Object> itemm : itemList) {
                int existingItemCode = (int) itemm.get(0);

                if (existingItemCode == code) {
                    FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("error_add.fxml"));
                    Stage stage = new Stage();
                    Scene scene = new Scene(fxmlLoader.load(), 500, 150);
                    stage.setScene(scene);
                    stage.show();

                    return;

                }
            }

            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("item_update_popup_msg.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(fxmlLoader.load(), 500, 150);
            stage.setScene(scene);
            stage.show();


        } catch (NumberFormatException e) {
            error("Please enter correct numeric values for Item code,Price and Quantity.");
            e.printStackTrace();
        }

        // assing values to the above created variables...
        selectedItem.set(0, code);
        selectedItem.set(1, name);
        selectedItem.set(2, brand);
        selectedItem.set(3, price);
        selectedItem.set(4, quantity);
        selectedItem.set(5, category);
        selectedItem.set(6, date);

        temp = selectedItem;


        itemList.add(temp);

    }

    private boolean isAllFieldsFilled() {
        return !update_itemCode.getText().trim().isEmpty()
                && !update_itemName.getText().isEmpty()
                && !update_itemBrand.getText().isEmpty()
                && !update_itemPrice.getText().isEmpty()
                && !update_itemQuantity.getText().isEmpty()
                && !update_itemCategory.getText().isEmpty()
                && !update_Date.getText().isEmpty();
    }


    public void error(String erroMessage) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Invalid Input");
        alert.setContentText(erroMessage);

        alert.showAndWait();
        alert.close();
    }


    public  void onBackButtonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("UPDATE_item.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(fxmlLoader.load(), 650.0, 450.0);
        stage.setTitle("UPDATE ITEMS");
        stage.setScene(scene);
        stage.show();

        Stage currentStage = (Stage) up2_anc.getScene().getWindow();
        currentStage.close();
    }
}
