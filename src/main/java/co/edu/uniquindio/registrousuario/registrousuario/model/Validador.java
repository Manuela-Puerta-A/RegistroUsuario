package co.edu.uniquindio.registrousuario.registrousuario.model;

public class Validador {
    public boolean validar(String nombre, String correo, String contraseña) {
        return !nombre.isEmpty()
                && correo.contains("@")
                && contraseña.length() >= 6;
    }
}
