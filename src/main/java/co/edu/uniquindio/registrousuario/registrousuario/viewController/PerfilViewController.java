package co.edu.uniquindio.registrousuario.registrousuario.viewController;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.registrousuario.registrousuario.model.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class PerfilViewController {
    private Usuario usuario;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button bntCerrarsesion;

    @FXML
    private Label lblCorreoUsuario;

    @FXML
    private Label lblNombreUsuario;

    @FXML
    private Hyperlink linkVolverRegistro;
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
        lblNombreUsuario.setText(usuario.getNombre());
        lblCorreoUsuario.setText(usuario.getCorreo());
    }

    @FXML
    void onCerrarSesion(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/registrousuario/registrousuario/Iniciosesion.fxml"));
            Parent root = loader.load();
            lblNombreUsuario.getScene().setRoot(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onVolver(ActionEvent event) {

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
    @FXML
    void initialize() {}

}
