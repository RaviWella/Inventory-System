package com.example.hello;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class RANDOM_DEALERS implements Initializable {

    @FXML
    private AnchorPane random_anc;

    @FXML
    private TableView<Dealer> dealerTable;

    @FXML
    private TableColumn<Dealer, String> dealerID;

    @FXML
    private TableColumn<Dealer, String> dealerName;

    @FXML
    private TableColumn<Dealer, String> contact;

    @FXML
    private TableColumn<Dealer, String> location;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        // create a list and assign selected random dealers to that list
        List<Dealer> selectedDealers = MENU.randomDealers;

        ObservableList<Dealer> dealerView = FXCollections.observableArrayList(selectedDealers);
        // assign values to relevant variables
        dealerID.setCellValueFactory(new PropertyValueFactory<Dealer, String>("dealerID"));
        dealerName.setCellValueFactory(new PropertyValueFactory<Dealer, String>("dealerName"));
        contact.setCellValueFactory(new PropertyValueFactory<Dealer, String>("phone"));
        location.setCellValueFactory(new PropertyValueFactory<Dealer, String>("location"));


        // set all the details to the table
        dealerTable.setItems(dealerView);
    }

    public void onBackButtonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MENU.class.getResource("menu.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(fxmlLoader.load(), 650.0, 450.0);
        stage.setTitle("MENU");
        stage.setScene(scene);
        stage.show();

        Stage currentStage = (Stage) random_anc.getScene().getWindow();
        currentStage.close();
    }
}
