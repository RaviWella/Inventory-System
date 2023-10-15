package com.example.hello;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.Comparator;
import java.util.List;
import java.util.ResourceBundle;

public class VIEW_item  implements Initializable {


    @FXML
    public AnchorPane aa;

    @FXML
    public Label totalPrice;

    @FXML
    private TextField imageField;

    @FXML
    private TableView <items> itemTableView;

    @FXML
    private TableColumn<items, Integer> c_itemCode;
    @FXML
    private TableColumn<items, String> c_itemName;
    @FXML
    private TableColumn<items, String> c_itemBrand;
    @FXML
    private TableColumn<items, Double> c_itemPrice;
    @FXML
    private TableColumn<items, Integer> c_itemQuantity;
    @FXML
    private TableColumn<items, String> c_itemCategory;
    @FXML
    private TableColumn<items, String> c_date;



    // get initialize method to store values to table columns
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<List<Object>> itemList = add_items.itemList;

        ObservableList<items> listView = FXCollections.observableArrayList();


        // create an instance to store values one by one cearly

        // set all the values using items object to store values in tablle columns.
        c_itemCode.setCellValueFactory(new PropertyValueFactory<items, Integer>("item_code"));
        c_itemName.setCellValueFactory(new PropertyValueFactory<items, String>("item_name"));
        c_itemBrand.setCellValueFactory(new PropertyValueFactory<items, String>("item_brand"));
        c_itemPrice.setCellValueFactory(new PropertyValueFactory<items, Double>("item_Price"));
        c_itemQuantity.setCellValueFactory(new PropertyValueFactory<items, Integer>("item_quantity"));
        c_itemCategory.setCellValueFactory(new PropertyValueFactory<items, String>("item_category"));
        c_date.setCellValueFactory(new PropertyValueFactory<items, String>("date"));



        for (List<Object> sample : itemList) {
            items newItem = new items(
                    (Integer) sample.get(0),
                    (String) sample.get(1),
                    (String) sample.get(2),
                    (Double) sample.get(3),
                    (Integer) sample.get(4),
                    (String) sample.get(5),
                    (String) sample.get(6)

            );
            listView.add(newItem);
        }

        // sorting item details by their item code in ascending order
        listView.sort(Comparator.comparingInt(items::getItem_code));
        itemTableView.setItems(listView);

        // find the total price of added items
        double total = 0;

        for (List<Object> i : itemList) {
            total = total + ((Double) i.get(3) * (Integer) i.get(4));
            String x = String.format("%.2f", total);
            totalPrice.setText(String.valueOf(x));

        }


    }

    // viewing item images by searching their item code
    public void onView() throws IOException {

        List<List<Object>> itemList = add_items.itemList;
        try{

            int no = Integer.parseInt(imageField.getText());
            int position =0;
            int codeExsist = 0;
            for(List<Object> i : itemList){
                if( i.get(0).equals(no)){
                    position = itemList.indexOf(i);
                    codeExsist++;
                }
            }
            if(codeExsist>0){
                Image image = new Image((String) itemList.get(position).get(7));
                ImageView imageView = new ImageView(image);
                Scene scene = new Scene(new javafx.scene.layout.StackPane(imageView),600,600);


                Stage imageStage = new Stage();
                imageStage.setTitle("Image View");
                imageStage.setScene(scene);
                imageStage.show();


            }else {
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("error_image.fxml"));
                Stage stage = new Stage();
                Scene scene = new Scene(fxmlLoader.load(), 500, 150);
                stage.setScene(scene);
                stage.show();

            }



        }catch (NumberFormatException e){
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("error_image.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(fxmlLoader.load(), 500, 150);
            stage.setScene(scene);
            stage.show();        }
    }



    public void onBackButtonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("menu.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(fxmlLoader.load(), 650.0, 450.0);
        stage.setTitle("MENU");
        stage.setScene(scene);
        stage.show();

        Stage currentStage = (Stage) aa.getScene().getWindow();
        currentStage.close();
    }






}
