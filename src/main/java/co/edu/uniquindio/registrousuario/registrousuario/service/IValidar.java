package co.edu.uniquindio.registrousuario.registrousuario.service;

public interface IValidar {
     default boolean validar(String nombre, String correo, String contrasena) {
        return !nombre.isEmpty() && correo.contains("@") && contrasena.length() >= 6;

    }
}
