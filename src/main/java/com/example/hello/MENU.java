package com.example.hello;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.*;
import java.util.List;
import static com.example.hello.add_items.itemList;


public class MENU {

    //Making dealers list public and static, then we will be able to call them in different classes
    public static List<Dealer> randomDealers;


    @FXML
    public AnchorPane startup_anc;


    @FXML
    public AnchorPane menuanc;

    @FXML
    public Button view_bb;



    // Open menu page from the startup
    public void onStartButtonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("menu.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(fxmlLoader.load(), 650.0, 450.0);
        stage.setTitle("MENU");
        stage.setScene(scene);
        stage.show();

        Stage currentStage = (Stage) startup_anc.getScene().getWindow();
        currentStage.close();
    }



    // Open item adding function
    public void onAddButtonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("ADD_item.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(fxmlLoader.load(), 800, 450.0);
        stage.setTitle("ADD ITEMS");
        stage.setScene(scene);
        stage.show();

        Stage currentStage = (Stage) menuanc.getScene().getWindow();
        currentStage.close();
    }

    //open funtion deleting
    public void onDelButtonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("DELETE_item.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(fxmlLoader.load(), 650.0, 450.0);
        stage.setTitle("DELETE ITEMS");
        stage.setScene(scene);
        stage.show();

        Stage currentStage = (Stage) menuanc.getScene().getWindow();
        currentStage.close();
    }

    // open update function
    public void onUpButtonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("UPDATE_item.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(fxmlLoader.load(), 650.0, 450.0);
        stage.setTitle("UPDATE ITEMS");
        stage.setScene(scene);
        stage.show();

        Stage currentStage = (Stage) menuanc.getScene().getWindow();
        currentStage.close();
    }


    // view items
    public void onViewButtonClick() throws IOException {


        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("VIEW_item.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(fxmlLoader.load(), 925, 513);
        stage.setTitle("VIEW ITEMS");
        stage.setScene(scene);
        stage.show();

        Stage currentStage = (Stage) menuanc.getScene().getWindow();
        currentStage.close();

    }

    // savingitems into a text file
    public void onSaveButtonClick() throws IOException{

        // create text file without serialize
        // write item list into a text file called item_details
        try {
            String fileName = "item_details.txt";
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));

            for (List<Object> item : itemList) {
                writer.write(formatItemString(item));
                writer.newLine();
            }

            writer.close();



            // creating text file with serialize
            String name = "item_details_with_serialization.txt";
//            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));

            FileOutputStream file = new FileOutputStream(name);
            ObjectOutputStream object = new ObjectOutputStream(file);


            for (List<Object> item : itemList) {
                object.writeObject(item);

            }
            object.close();

            // pop up message
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("item_save_popup_msg.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(fxmlLoader.load(), 500, 150);
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();

        }
    }


    // String formatting method, and append || to the between of items in the item list
    public String formatItemString(List<Object> item) {
        StringBuilder sb = new StringBuilder();
        for (Object value : item) {
            sb.append(value).append(" || ");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }



    // randomize dealers
    public void onSelectButtonclick() throws IOException {


        // creating a variable to assign dealers details
        List<Dealer> allDealers = DealerReader.readDealersFromFile();
        // randomize all dealers to get four random dealers
        randomDealers = DealerSelector.getRandomDealers(allDealers, 4);


        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("selectedMsg.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(fxmlLoader.load(), 450, 150);
        stage.setTitle("SELECTED");
        stage.setScene(scene);
        stage.show();

    }



    // Display all the detail of randomized dealers
        public void onDis1ButtonClick() throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(MENU.class.getResource("RANDOM_DEALERS.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(fxmlLoader.load(), 650.0, 450.0);
        stage.setTitle("RANDOMLY SELECTED DEALERS DETAILS");
        stage.setScene(scene);
        stage.show();

        Stage currentStage = (Stage) menuanc.getScene().getWindow();
        currentStage.close();
    }


    // getting dealer ID to display item details of random dealrs
    public void onDis2ButtonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("RANDOM_DEALER_2.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(fxmlLoader.load(), 650.0, 450.0);
        stage.setTitle("RANDOMLY SELECTED DEALERS ITEMS");
        stage.setScene(scene);
        stage.show();

        Stage currentStage = (Stage) menuanc.getScene().getWindow();
        currentStage.close();
    }


    // go back from the current tab
    public void onBackButtonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("startup.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(fxmlLoader.load(), 650.0, 450.0);
        stage.setTitle("ONE-NET CAFE");
        stage.setScene(scene);
        stage.show();

        Stage currentStage = (Stage) menuanc.getScene().getWindow();
        currentStage.close();
    }


    // terminate the program
    public void onExitButtonClick(ActionEvent event) {

        Platform.exit();
        System.out.println("Thank you for using John’s internet café!");
    }
}

