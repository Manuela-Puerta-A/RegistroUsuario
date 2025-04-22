package co.edu.uniquindio.registrousuario.registrousuario.model;
import javafx.scene.control.Alert;
public class Notificador {
    public void enviarCorreoBienvenida(Usuario usuario) {
        mostrarMensaje("Bienvenido, " + usuario.getNombre() + "!");
    }

    public void mostrarMensaje(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(mensaje);
        alert.setTitle("Notificación");
        alert.showAndWait();
    }
}
