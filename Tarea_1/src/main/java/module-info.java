module com.example.tarea_1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens sample to javafx.fxml;
    exports sample;
}