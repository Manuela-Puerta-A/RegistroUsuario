package co.edu.uniquindio.registrousuario.registrousuario.model;
import java.util.ArrayList;
import java.util.List;
import co.edu.uniquindio.registrousuario.registrousuario.service.IObserver;
public class Estacion {
    private final List<IObserver> observadores = new ArrayList<>();
    private float temperatura, humedad, presion;

    public void agregarObservador(IObserver obs) {
        observadores.add(obs);
    }

    public void eliminarObservador(IObserver obs) {
        observadores.remove(obs);
    }

    public void notificarObservadores() {
        for (IObserver obs : observadores) {
            obs.actualizar(temperatura, humedad, presion);
        }
    }

    public void setTemplaeratura(float temperatura) {
        this.temperatura = temperatura;
        notificarObservadores();
    }

    public void setHumedad(float humedad) {
        this.humedad = humedad;
        notificarObservadores();
    }

    public void setPresion(float presion) {
        this.presion = presion;
        notificarObservadores();
    }
}
