package co.edu.uniquindio.registrousuario.registrousuario.model;

public class Usuario {
    private String nombre;
    private String correo;
    private String contrasena;

    public Usuario(String nombre, String correo, String contrasena) {
        this.nombre = nombre;
        this.correo = correo;
        this.contrasena = contrasena;
    }

    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}
    public String getCorreo() {return correo;}
    public void setCorreo(String correo) {this.correo = correo;}
    public String getContrasena() {return contrasena;}
    public void setContrasena(String contraseña) {this.contrasena = contrasena;}

}
