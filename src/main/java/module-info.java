module com.example.game7wondersarchitect {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.game7wondersarchitect to javafx.fxml;
    exports com.example.game7wondersarchitect;
}