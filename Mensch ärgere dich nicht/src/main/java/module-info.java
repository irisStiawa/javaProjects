module com.example.menschaergeredichnicht {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.menschaergeredichnicht to javafx.fxml;
    exports com.example.menschaergeredichnicht;
}