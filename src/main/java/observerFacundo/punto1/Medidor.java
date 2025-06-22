package observerFacundo.punto1;

import java.util.ArrayList;
import java.util.List;

public class Medidor{

    private String temperatura;
    private WhatherChanelService clima;
    private List<Observador> observadores = new ArrayList<>();

    public Medidor(WhatherChanelService clima) {
        this.clima = clima;
    }

    public void agregarObservador(Observador observador) {
        observadores.add(observador);
    }

    public void quitarObservador(Observador observador) {
        observadores.remove(observador);
    }

    private void notificarObservadores() {
        for (Observador observador : observadores) {
            observador.actualizar(temperatura);
        }
    }

    public String leerTemperatura() {
        this.temperatura = this.clima.temperatura();
        notificarObservadores();
        return this.temperatura;
    }


}
