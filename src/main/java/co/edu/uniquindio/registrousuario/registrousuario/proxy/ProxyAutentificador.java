package co.edu.uniquindio.registrousuario.registrousuario.proxy;
import co.edu.uniquindio.registrousuario.registrousuario.service.IAutentificador;
import javafx.scene.control.Alert;

public class ProxyAutentificador implements IAutentificador {
    private final AutenticadorReal autenticadorReal = new AutenticadorReal();

    @Override
    public boolean iniciarSesion(String correo, String contrasena) {
        if (correo.isEmpty() || contrasena.isEmpty()) {
            mostrarMensaje("Correo y contraseña obligatorios");
            return false;
        }

        boolean exito = autenticadorReal.iniciarSesion(correo, contrasena);
        if (!exito) {
            mostrarMensaje("Credenciales inválidas");
        }

        return exito;
    }

    private void mostrarMensaje(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
    }

