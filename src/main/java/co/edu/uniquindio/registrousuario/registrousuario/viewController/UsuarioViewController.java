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
        if (validarDatos(nombre, correo, contrasena)) {
            registroFacade.registrarUsuario(nombre, correo, contrasena);
            enviarCorreoBienvenida(nombre);
        }

    }
    private boolean validarDatos(String nombre, String correo, String contrasena) {
        if (nombre == null || nombre.trim().isEmpty()) {
            mostrarAlerta("El nombre no puede estar vacío");
            return false;
        }

        if (correo == null || !correo.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            mostrarAlerta("El correo electrónico no es válido");
            return false;
        }

        if (contrasena == null || !contrasena.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}$")) {
            mostrarAlerta("La contraseña debe tener al menos 8 caracteres, incluyendo mayúsculas, minúsculas y números.");
            return false;
        }

        return true;
    }

    private void mostrarAlerta(String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.WARNING);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }

    private void enviarCorreoBienvenida(String nombre) {
        Alert bienvenida = new Alert(Alert.AlertType.INFORMATION);
        bienvenida.setTitle("Bienvenido");
        bienvenida.setHeaderText(null);
        bienvenida.setContentText("¡Bienvenido/a " + nombre + "! Tu registro fue exitoso.");
        bienvenida.showAndWait();
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