package co.edu.uniquindio.registrousuario.registrousuario.viewController;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
public class PerfilViewController {
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
    void initialize() {}

}
