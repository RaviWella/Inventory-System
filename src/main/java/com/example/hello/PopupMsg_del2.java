package com.example.hello;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class PopupMsg_del2 {

    @FXML
    public Button okButt;

    @FXML
    public AnchorPane anc4;


    public void onOkButtonClck(ActionEvent event) {

        Stage currentStage = (Stage) anc4.getScene().getWindow();
        currentStage.close();

    }
}
