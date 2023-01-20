package com.example.game7wondersarchitect;

import javafx.fxml.Initializable;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import main.Player;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static main.Game.addPlayer;

public class PlayerNameController implements Initializable {
    public TextField playerName;
    public Spinner playerAge;

    public void OnOKButtonMouseClicked(MouseEvent event) throws IOException {
        String name = getPlayerName();
        int age = getPlayerAge();
        addPlayer(new Player(name, age));
    }

    private int getPlayerAge() {
        return (int) playerAge.getValue();
    }

    private String getPlayerName() {
         return playerName.getText();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(3,99);
        valueFactory.setValue(20);

        playerAge.setValueFactory(valueFactory);
    }
}
