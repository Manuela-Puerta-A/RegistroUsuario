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
        Usuario nuevoUsuario = new Usuario(nombre, correo, contrasena);
        baseDeDatos.guardarUsuario(nuevoUsuario);
        System.out.println("Usuario registrado: " + nombre);
    }


}
