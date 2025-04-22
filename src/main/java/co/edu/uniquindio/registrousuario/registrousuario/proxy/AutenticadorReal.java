package co.edu.uniquindio.registrousuario.registrousuario.proxy;
import co.edu.uniquindio.registrousuario.registrousuario.model.BaseDeDatosSimulada;
import co.edu.uniquindio.registrousuario.registrousuario.model.Usuario;
import co.edu.uniquindio.registrousuario.registrousuario.service.IAutentificador;

public class AutenticadorReal implements IAutentificador{

    private final BaseDeDatosSimulada baseDatos = BaseDeDatosSimulada.getInstancia();

    @Override
    public boolean iniciarSesion(String correo, String contrasena) {
        for (Usuario u : baseDatos.getUsuarios()) {
            if (u.getCorreo().equals(correo) && u.getContrasena().equals(contrasena)) {
                return true;
            }
        }
        return false;
    }
}
