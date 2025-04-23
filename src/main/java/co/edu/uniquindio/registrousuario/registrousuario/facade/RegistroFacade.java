package co.edu.uniquindio.registrousuario.registrousuario.facade;

import co.edu.uniquindio.registrousuario.registrousuario.model.BaseDeDatosSimulada;
import co.edu.uniquindio.registrousuario.registrousuario.model.Notificador;
import co.edu.uniquindio.registrousuario.registrousuario.model.Usuario;
import co.edu.uniquindio.registrousuario.registrousuario.model.Validador;

public class RegistroFacade {
    private final BaseDeDatosSimulada baseDeDatos = BaseDeDatosSimulada.getInstancia();


    private final Validador validador = new Validador();
    private final BaseDeDatosSimulada baseDatos = new BaseDeDatosSimulada();
    private final Notificador notificador = new Notificador();



    public void registrarUsuario(String nombre, String correo, String contrasena) {

            // Validar datos
            if (!validador.validar(nombre, correo, contrasena)) {
                System.out.println(" Datos inválidos. Verifica nombre, correo y contraseña.");
                return;
            }

            // Validar que el correo no esté registrado
            if (BaseDeDatosSimulada.existeUsuario(correo)) {
                System.out.println(" El correo ya está registrado.");
                return;
            }

            // Crear usuario y guardar
            Usuario nuevoUsuario = new Usuario(nombre, correo, contrasena);
            baseDeDatos.guardarUsuario(nuevoUsuario);

            // Simular envío de correo
            notificador.enviarCorreoBienvenida(nuevoUsuario);
            System.out.println(" Usuario registrado y notificado correctamente.");
        }
    }



