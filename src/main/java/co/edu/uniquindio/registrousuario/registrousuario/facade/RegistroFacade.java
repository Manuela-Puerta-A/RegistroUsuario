package co.edu.uniquindio.registrousuario.registrousuario.facade;

import co.edu.uniquindio.registrousuario.registrousuario.model.BaseDeDatosSimulada;
import co.edu.uniquindio.registrousuario.registrousuario.model.Notificador;
import co.edu.uniquindio.registrousuario.registrousuario.model.Usuario;
import co.edu.uniquindio.registrousuario.registrousuario.model.Validador;
import javafx.scene.control.Alert;

public class RegistroFacade {
    private final BaseDeDatosSimulada baseDeDatos = BaseDeDatosSimulada.getInstancia();


    private final Validador validador = new Validador();
    private final BaseDeDatosSimulada baseDatos = new BaseDeDatosSimulada();
    private final Notificador notificador = new Notificador();



    public void registrarUsuario(String nombre, String correo, String contrasena) {

        if (!validador.validar(nombre, correo, contrasena)) {
            mostrarAlerta("Datos inválidos", "Verifica que el nombre no esté vacío, el correo sea válido y la contraseña tenga al menos 6 caracteres.");
            return;
        }

        if (BaseDeDatosSimulada.existeUsuario(correo)) {
            mostrarAlerta("Correo duplicado", "El correo ya está registrado. Usa uno diferente.");
            return;
        }

        Usuario nuevoUsuario = new Usuario(nombre, correo, contrasena);
        baseDeDatos.guardarUsuario(nuevoUsuario);

        // Simular envío de correo
        notificador.enviarCorreoBienvenida(nuevoUsuario);
        mostrarAlerta("Registro exitoso", "Usuario registrado y correo de bienvenida enviado.");
        System.out.println("Usuario registrado: " + nombre+" "+correo);    }
    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
    }



