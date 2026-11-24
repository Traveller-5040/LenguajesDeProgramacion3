package act_observer;

public class ObserverTest {
    public static void main(String[] args) {
        Notificaciones not = new Notificaciones();
        Observer u1 = new UObserver("Carlos");
        Observer u2 = new UObserver("Marcus");
        Observer u3 = new UObserver("Beatriz");

        not.suscribir(u1);
        not.suscribir(u2);
        not.suscribir(u3);

        not.desuscribir(u2);
        System.out.println("Marcus se desuscribio");
        not.notificacionGeneral("+1 mes gratuito por la compra de una mejor suscripcion");
    }
}
