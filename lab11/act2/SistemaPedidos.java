package act2;

import java.util.ArrayList;
import java.util.List;

class SistemaPedidos {
    private List<CObserver> suscriptores = new ArrayList<>();
    private SendStrategy estrategiaEnvio;

    public void suscribir(CObserver c) { suscriptores.add(c); }

    public void setEstrategiaEnvio(SendStrategy estrategia) {
        this.estrategiaEnvio = estrategia;
    }

    public void confirmarOrden(String producto, double precioBase) {
        double costoEnvio = estrategiaEnvio.calcularEnvio(precioBase);
        double total = precioBase + costoEnvio;
        String detalle = "Orden confirmada: " + producto + " | Modalidad: "
                + estrategiaEnvio.getNombre() + " | Total: S/ " + total;
        System.out.println(">> Sistema: " + detalle);
        notificar(detalle);
    }

    private void notificar(String mensaje) {
        for (CObserver c : suscriptores) {
            c.recibirAlerta(mensaje);
        }
    }
}