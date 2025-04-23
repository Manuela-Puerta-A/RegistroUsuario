package co.edu.uniquindio.registrousuario.registrousuario.model;
import java.util.ArrayList;
import java.util.List;
public class BaseDeDatosSimulada {


    public List<Usuario> getUsuarios() {
        return listaUsuarios;
    }
    private static BaseDeDatosSimulada instancia;
    private static final List<Usuario> listaUsuarios = new ArrayList<>();
    public static BaseDeDatosSimulada getInstancia() {
        if (instancia == null) {
            instancia = new BaseDeDatosSimulada();
        }
        return instancia;
    }

    public void guardarUsuario(Usuario usuario) {
        listaUsuarios.add(usuario);
    }
    public static void agregarUsuario(Usuario usuario) {
        listaUsuarios.add(usuario);
    }

    public static Usuario buscarUsuario(String correo, String contraseña) {
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getCorreo().equals(correo) && usuario.getContrasena().equals(contraseña)) {
                return usuario;
            }
        }
        return null;
    }

    public static boolean existeUsuario(String correo) {
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getCorreo().equals(correo)) {
                return true;
            }
        }
        return false;
    }



}
