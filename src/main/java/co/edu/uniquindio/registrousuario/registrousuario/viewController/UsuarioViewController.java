package co.edu.uniquindio.registrousuario.registrousuario.viewController;

import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Button;
import co.edu.uniquindio.registrousuario.registrousuario.facade.RegistroFacade;

public class UsuarioViewController {

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtCorreo;

    @FXML
    private PasswordField txtContrasena;
    @FXML
    private Hyperlink linkIniciarsesion;
    @FXML
    private Button btnRegistrar;

    private final RegistroFacade registroFacade = new RegistroFacade();

    @FXML
    private void initialize() {
        btnRegistrar.setOnAction(event -> registrarUsuario());
    }

    private void registrarUsuario() {
        String nombre = txtNombre.getText();
        String correo = txtCorreo.getText();
        String contrasena = txtContrasena.getText();

        registroFacade.registrarUsuario(nombre, correo, contrasena);
    }
}