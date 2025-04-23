package co.edu.uniquindio.registrousuario.registrousuario.viewController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import co.edu.uniquindio.registrousuario.registrousuario.facade.RegistroFacade;
import javafx.stage.Stage;

import java.io.IOException;

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
    
    @FXML
    void onAbrirInicio(ActionEvent event) {
        System.out.println("Abrir inicio");
        try {
            // Cargar el archivo FXML de registro
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/registrousuario/registrousuario/Iniciosesion.fxml"));
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