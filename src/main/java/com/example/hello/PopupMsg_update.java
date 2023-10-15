package com.example.hello;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class PopupMsg_update {

    @FXML
    public Button okButt;

    @FXML
    public AnchorPane anc2;


    public void onOkButtonClck(ActionEvent event) {

        Stage currentStage = (Stage) anc2.getScene().getWindow();
        currentStage.close();

    }
}
