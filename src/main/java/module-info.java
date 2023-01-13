module com.example.game7wondersarchitect {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.testng;


    opens com.example.game7wondersarchitect to javafx.fxml;
    exports com.example.game7wondersarchitect;
}