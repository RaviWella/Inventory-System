package com.example.hello;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class RANDOM_DEALER_DETAIL implements Initializable {
    public static List<List<Object>> dealerItem = RANDOM_DEALER_2.dealerItem;

    @FXML
    private AnchorPane random_anc;

    @FXML
    private TextField dealerID;

    @FXML
    private TextField dealerName;

    @FXML
    private TableView<itemDealer> itemDetails;

    @FXML
    private TableColumn<itemDealer, String> itemName;

    @FXML
    private TableColumn<itemDealer, String> itemBrand;

    @FXML
    private TableColumn<itemDealer, String> itemPrice;

    @FXML
    private TableColumn<itemDealer, String> itemStock;




    public void onBackButtonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(RANDOM_DEALER_2.class.getResource("RANDOM_DEALER_2.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(fxmlLoader.load(), 650.0, 450.0);
        stage.setTitle("CHECK DEALER");
        stage.setScene(scene);
        stage.show();

        Stage currentStage = (Stage) random_anc.getScene().getWindow();
        currentStage.close();

    }

    // assigning  dealer item detail to the relevant instances

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        itemName.setCellValueFactory(new PropertyValueFactory<itemDealer, String>("dddname"));
        itemBrand.setCellValueFactory(new PropertyValueFactory<itemDealer, String>("dddbrand"));
        itemPrice.setCellValueFactory(new PropertyValueFactory<itemDealer, String>("dddprice"));
        itemStock.setCellValueFactory(new PropertyValueFactory<itemDealer, String>("dddquantity"));
        ObservableList<itemDealer> dItems = FXCollections.observableArrayList();
        for (List<Object> oneItem: dealerItem){
            itemDealer item = new itemDealer(
                    (String) oneItem.get(0),
                    (String) oneItem.get(1),
                    (String) oneItem.get(2),
                    (String) oneItem.get(3)
            );
            dItems.add(item);
        }
        // getting selected dealers name and id
        List<Dealer> selectedDealers = MENU.randomDealers;
        String dName = "";
        for(Dealer i: selectedDealers){
            if (i.getDealerID().equals(RANDOM_DEALER_2.name)){
                dName = i.getDealerName();
            }
        }
        dealerName.setText(dName);
        dealerID.setText(RANDOM_DEALER_2.name);
        itemDetails.setItems(dItems);
        dealerItem.clear();
    }
}
