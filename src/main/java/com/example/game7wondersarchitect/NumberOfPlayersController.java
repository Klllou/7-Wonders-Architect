package com.example.game7wondersarchitect;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class NumberOfPlayersController {
    private static int sliderValue;

    public void OnOKButtonMouseClicked(MouseEvent event) throws IOException {
        getPlayerNumber();

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("ChooseYourWonder-view.fxml")));
        stage =(Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public Slider playerNumber;
    @FXML
    public void getPlayerNumber (){
        sliderValue = (int) playerNumber.getValue();

    }

    public static int getSliderValue(){
        return sliderValue;
    }

    //Fonction qui sert à décrémenter le nombre de joueurs
    //pour afficher la vue ChooseYourNameAndAge en fonction du nombre de joueurs
    public void playerDecrementing(){
        sliderValue = sliderValue - 1;
    }

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void OnRhodesButtonMouseClicked(MouseEvent event) {
    }

    public void OnOlympieButtonMouseClicked(MouseEvent event) {
    }

    public void OnHalicarnasseButtonMouseClicked(MouseEvent event) {
    }

    public void OnÉphèseButtonMouseClicked(MouseEvent event) {
    }

    public void OnGizehButtonMouseClicked(MouseEvent event) {
    }

    public void OnBabyloneButtonMouseClicked(MouseEvent event) {
    }

    public void OnAlexandrieButtonMouseClicked(MouseEvent event) {
    }
}