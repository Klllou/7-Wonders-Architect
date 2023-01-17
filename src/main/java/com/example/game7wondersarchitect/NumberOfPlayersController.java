package com.example.game7wondersarchitect;


import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class NumberOfPlayersController {
    private int sliderValue;

    public void OnOKButtonMouseClicked(MouseEvent event) throws IOException {
        getPlayerNumber();
        System.out.println(sliderValue);
    }

    @FXML
    public Slider playerNumber;
    @FXML
    public void getPlayerNumber (){
        sliderValue = (int) playerNumber.getValue();

    }

    private Stage stage;
    private Scene scene;
    private Parent root;
}