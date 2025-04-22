module co.edu.uniquindio.registrousuario.registrousuario {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens co.edu.uniquindio.registrousuario.registrousuario to javafx.fxml;
    exports co.edu.uniquindio.registrousuario.registrousuario;
    opens co.edu.uniquindio.registrousuario.registrousuario.viewController;
    exports co.edu.uniquindio.registrousuario.registrousuario.viewController;
    opens co.edu.uniquindio.registrousuario.registrousuario.model;
    exports co.edu.uniquindio.registrousuario.registrousuario.model;
}