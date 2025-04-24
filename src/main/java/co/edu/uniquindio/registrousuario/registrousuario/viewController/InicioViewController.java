package co.edu.uniquindio.registrousuario.registrousuario.viewController;
import co.edu.uniquindio.registrousuario.registrousuario.model.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import co.edu.uniquindio.registrousuario.registrousuario.proxy.ProxyAutentificador;
import co.edu.uniquindio.registrousuario.registrousuario.model.BaseDeDatosSimulada;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

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
                iniciarSesion();
                // Acción para iniciar sesión
            });
        } else {
            System.out.println("btnIniciarSesion es null");
        }

    }

    public boolean iniciarSesion() {
        String correo = txtCorreo.getText();
        String contrasena = txtContrasena.getText();

        Usuario usuario = BaseDeDatosSimulada.buscarUsuario(correo, contrasena);

        if (usuario != null) {
            mostrarAlerta("Bienvenido, " + usuario.getNombre(), Alert.AlertType.INFORMATION);
            // Simulación de correo al iniciar sesión
            System.out.println("Simulación: se ha enviado un correo de bienvenida a " + correo);
            return true;



        } else {
            mostrarAlerta("Correo o contraseña incorrectos.", Alert.AlertType.ERROR);
            return false;
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
    private void mostrarAlerta(String mensaje, Alert.AlertType tipo){
        Alert alert = new Alert(tipo);
        alert.setTitle("Inicio de sesión");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

}
