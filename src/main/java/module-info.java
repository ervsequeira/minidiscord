module cr.ac.una.est.minidiscord {
    requires javafx.controls;
    requires javafx.fxml;

    opens cr.ac.una.est.minidiscord.presentation.controller to javafx.fxml;

    exports cr.ac.una.est.minidiscord;
    exports cr.ac.una.est.minidiscord.presentation.controller;
}