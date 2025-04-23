package co.edu.uniquindio.registrousuario.registrousuario.viewController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
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
    @FXML
    void onAbrirRegistro(ActionEvent event) {
        try { FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/registrousuario/registrousuario/Usuario.fxml"));
            Parent root = loader.load();
            // Obtener la escena actual desde el hyperlink
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            // Cambiar la escena
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
        }

}
