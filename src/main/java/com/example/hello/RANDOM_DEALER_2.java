package com.example.hello;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RANDOM_DEALER_2 {

    @FXML
    private AnchorPane dis1;

    @FXML
    private TextField getDealerId;
    public static String code;

    public static String name;

    public static List<List<Object>> dealerItem = new ArrayList<>();
    public void onSelectButtonClick() throws IOException {
        code = getDealerId.getText().trim().toUpperCase();
        List<Dealer> randomDealers = MENU.randomDealers;
        name = code.toUpperCase();


        for (Dealer dealer : randomDealers) {
            if (dealer.getDealerID().equals(code)) {
                displayDealerItems(code);
                FXMLLoader fxmlLoader = new FXMLLoader(MENU.class.getResource("RANDOM_DEALER_DETAIL.fxml"));
                Stage stage = new Stage();
                Scene scene = new Scene(fxmlLoader.load(), 650.0, 450.0);
                stage.setTitle("DEALER ITEM");
                stage.setScene(scene);
                stage.show();

                Stage currentStage = (Stage) dis1.getScene().getWindow();
                currentStage.close();
                return; // Exit the method after showing the details
            }
        }

        System.out.println(dealerItem);

        showAlert("Dealer is not in the list.");
    }

    private void displayDealerItems(String dealerId) {
        try (BufferedReader br = new BufferedReader(new FileReader("dealers_items.txt"))) {
            String line;
            boolean foundDealer = true;
            while ((line = br.readLine()) != null) {
                line = line.replace("[","");
                line = line.replace("]","");
                String[] attributes = line.split(",");
                if (attributes.length == 5) {
                    String itemDealerId = attributes[0].trim();
                    String itemName = attributes[1].trim();
                    String itemBrand = attributes[2].trim();
                    String itemPrice = attributes[3].trim();
                    String itemStock = attributes[4].trim();

                    if (itemDealerId.equals(code)) {
                        List<Object> temp = new ArrayList<>();
                        temp.add(itemName);
                        temp.add(itemBrand);
                        temp.add(itemPrice);
                        temp.add(itemStock);
                        System.out.println(temp);
                        foundDealer = true;
                        dealerItem.add(temp);

                    }
                }
            }

            if (!foundDealer) {
                System.out.println(foundDealer);
                showAlert("Dealer is in the list, but no items found for this dealer.");
            }
        } catch (IOException e) {
            showAlert("Error reading dealer items file.");
        }
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public void onBackButtonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MENU.class.getResource("menu.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(fxmlLoader.load(), 650.0, 450.0);
        stage.setTitle("MENU");
        stage.setScene(scene);
        stage.show();

        Stage currentStage = (Stage) dis1.getScene().getWindow();
        currentStage.close();
    }
}
