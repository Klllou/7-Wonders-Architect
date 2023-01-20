package com.example.game7wondersarchitect;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import main.Player;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

import static com.example.game7wondersarchitect.NumberOfPlayersController.getSliderValue;
import static main.Game.addPlayer;

public class PlayerNameController implements Initializable {
    public TextField playerName;
    public Spinner playerAge;

    public void OnOKButtonMouseClicked(MouseEvent event) throws IOException {
        String name = getPlayerName();
        int age = getPlayerAge();
        addPlayer(new Player(name, age));

        // Fonction if pour :
        // Si j'ai répeté autant de fois qu'il y'a de joueurs,
        // alors je commence le jeu, sinon, je reviens à la page qui me permet de choisir ma wonder

        if (getSliderValue() <= 1) { //Si on a fini d'ajouter les joueurs.
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/game7wondersarchitect/GameBoard-view.fxml")));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } else { //S'il reste des joueurs pour qui il faut choisir le nom et l'âge
            //on retire 1 au compteur de joueurs a rajouter, avec la méthode dans NumberOfPlayersController
            //playerDecrementing();
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/game7wondersarchitect/ChooseYourWonder-View.fxml")));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }

    }

    private Stage stage;
    private Scene scene;
    private Parent root;

    private int getPlayerAge() {
        return (int) playerAge.getValue();
    }

    private String getPlayerName() {
         return playerName.getText();
    }

    //pour le spinner qui récupère l'âge :
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(3,99);
        valueFactory.setValue(20);

        playerAge.setValueFactory(valueFactory);
    }
}
