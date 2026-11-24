package act_observer;

import java.util.List;
import java.util.ArrayList;

class Notificaciones {
    private List<Observer> suscriptores = new ArrayList<>();

    public void suscribir(Observer obs) {
        suscriptores.add(obs);
    }

    public void desuscribir(Observer obs) {
        suscriptores.remove(obs);
    }

    public void notificacionGeneral(String evento) {
        for (Observer obs : suscriptores) {
            obs.update(evento);
        }
    }
}
