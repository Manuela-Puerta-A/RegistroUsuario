package co.edu.uniquindio.registrousuario.registrousuario.model;
import java.util.ArrayList;
import java.util.List;
public class BaseDeDatosSimulada {

    private static BaseDeDatosSimulada instancia;
    private final List<Usuario> usuarios = new ArrayList<>();

    public static BaseDeDatosSimulada getInstancia() {
        if (instancia == null) {
            instancia = new BaseDeDatosSimulada();
        }
        return instancia;
    }

    public void guardarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }
}
