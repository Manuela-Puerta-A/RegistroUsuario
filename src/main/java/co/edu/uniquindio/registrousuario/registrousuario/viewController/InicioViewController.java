package co.edu.uniquindio.registrousuario.registrousuario.viewController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Button;
import javafx.scene.control.Alert;
import co.edu.uniquindio.registrousuario.registrousuario.proxy.ProxyAutentificador;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.scene.control.Hyperlink;
import javafx.stage.Stage;

public class InicioViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnIniciar;

    @FXML
    private Hyperlink linkIniciarsesion;

    @FXML
    private PasswordField txtContrasena;

    @FXML
    private TextField txtCorreo;
    private final ProxyAutentificador proxyAutenticador = new ProxyAutentificador();

    @FXML
    private void initialize() {
        if (btnIniciar != null) {
            btnIniciar.setOnAction(event -> {
                // Acción para iniciar sesión
            });
        } else {
            System.out.println("btnIniciarSesion es null");
        }
        linkIniciarsesion.setOnAction(event -> {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Usuario.fxml"));
                Scene nuevaEscena = new Scene(fxmlLoader.load());

                Stage nuevoStage = new Stage();
                nuevoStage.setTitle("Registro de Usuario");
                nuevoStage.setScene(nuevaEscena);
                nuevoStage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    private void iniciarSesion() {
        String correo = txtCorreo.getText();
        String contrasena = txtContrasena.getText();

        boolean exito = proxyAutenticador.iniciarSesion(correo, contrasena);
        if (exito) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Inicio exitoso");
            alert.setContentText("¡Bienvenido!");
            alert.showAndWait();
        }
    }
}
