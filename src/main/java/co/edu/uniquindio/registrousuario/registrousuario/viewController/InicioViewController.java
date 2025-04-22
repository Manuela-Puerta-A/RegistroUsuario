package co.edu.uniquindio.registrousuario.registrousuario.viewController;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Button;
import javafx.scene.control.Alert;
import co.edu.uniquindio.registrousuario.registrousuario.proxy.ProxyAutentificador;
public class InicioViewController {

    @FXML
    private TextField txtCorreo;

    @FXML
    private PasswordField txtContrasena;

    @FXML
    private Button btnIniciarSesion;

    private final ProxyAutentificador proxyAutenticador = new ProxyAutentificador();

    @FXML
    private void initialize() {
        if (btnIniciarSesion != null) {
            btnIniciarSesion.setOnAction(event -> {
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
}
