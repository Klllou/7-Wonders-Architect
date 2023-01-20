package com.example.game7wondersarchitect;


import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class ChooseYourWonderController {

    public void OnRhodesButtonMouseClicked(MouseEvent event) throws IOException {
        setChosenWonder("Rhodes");

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("ChooseYourNameAndAge-view.fxml")));
        stage =(Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public void OnOlympieButtonMouseClicked(MouseEvent event) throws IOException {
        setChosenWonder("Olympie");

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("ChooseYourNameAndAge-view.fxml")));
        stage =(Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public void OnHalicarnasseButtonMouseClicked(MouseEvent event) throws IOException {
        setChosenWonder("Halicarnasse");

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("ChooseYourNameAndAge-view.fxml")));
        stage =(Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public void OnÉphèseButtonMouseClicked(MouseEvent event) throws IOException {
        setChosenWonder("Éphèse");

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("ChooseYourNameAndAge-view.fxml")));
        stage =(Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public void OnGizehButtonMouseClicked(MouseEvent event) throws IOException {
        setChosenWonder("Gizeh");

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("ChooseYourNameAndAge-view.fxml")));
        stage =(Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public void OnBabyloneButtonMouseClicked(MouseEvent event) throws IOException {
        setChosenWonder("Babylone");

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("ChooseYourNameAndAge-view.fxml")));
        stage =(Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public void OnAlexandrieButtonMouseClicked(MouseEvent event) throws IOException {
        setChosenWonder("Alexandrie");

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("ChooseYourNameAndAge-view.fxml")));
        stage =(Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    private static String chosenWonder;

    public static String getChosenWonder(String wonder) {
        return chosenWonder;
    }

    public void setChosenWonder(String wonder){
        chosenWonder = wonder;
    }

    private Stage stage;
    private Scene scene;
    private Parent root;

}
