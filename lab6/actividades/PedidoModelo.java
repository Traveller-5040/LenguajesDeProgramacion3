package actividades;

import java.util.ArrayList;
import java.util.List;

public class PedidoModelo {

    private List<Pedido> pedidos;
    // Se agrega un ArrayList como nuevo atributo
    // el cual registrara pedidos completados o eliminados
    private List<Pedido> historial;

    public PedidoModelo() {
        this.pedidos = new ArrayList<>();
        // Se inicializa el nuevo ArrayList
        this.historial = new ArrayList<>();
    }

    public void agregarPedido(Pedido pedido) {
        this.pedidos.add(pedido);
    }

    public void borrarPedido(int index) {
        Pedido pedido = this.pedidos.remove(index);
        pedido.setEstado("Eliminado");
        this.historial.add(pedido);
    }

    public void actualizarPedido(int index, Pedido pedido) {
        this.pedidos.get(index).setNombre(pedido.getNombre());
        this.pedidos.get(index).setTipo(pedido.getTipo());
    }

    public List<Pedido> buscarPedido(String busqueda) {
        List<Pedido> resultados = new ArrayList<>();
        String val = busqueda.toLowerCase();
        for (Pedido p : pedidos) {
            if (p.getNombre().toLowerCase().contains(val) || p.getTipo().toLowerCase().contains(val)) {
                resultados.add(p);
            }
        }
        return resultados;
    }

    public java.util.Map<String, Integer> obtenerConteoTipos() {
        java.util.Map<String, Integer> conteoTipos = new java.util.HashMap<>();
        for (Pedido p : pedidos) {
            conteoTipos.put(p.getTipo(), conteoTipos.getOrDefault(p.getTipo(), 0) + 1);
        }
        return conteoTipos;
    }

    public List<Pedido> getPedidos() {
        return this.pedidos;
    }

    // Metodo que marca un pedido como completado y lo registra en el historial
    public void marcarCompleto(int index) {
        // Obtiene el pedido de la lista activa usando el indice (base 0) ya validado por el controlador
        Pedido pedido = this.pedidos.get(index);
        // Cambia el estado del pedido; el pedido sigue en la lista de pedidos
        pedido.setEstado("Completado");
        // Guarda el pedido en el historial de pedidos completados o eliminados
        this.historial.add(pedido);
    }

    // Metodo que cuenta cuantos pedidos de la lista siguen con estado pendiente
    public int contarPendientes() {
        // Contador que acumula los pedidos pendientes encontrados
        int cont = 0;
        // Recorre todos los pedidos de la lista activa
        for (Pedido p : pedidos) {
            // Solo se cuentan los pedidos cuyo estado es "Pendiente"
            if (p.getEstado().equals("Pendiente")) {
                cont++;
            }
        }
        // Retorna el total de pedidos pendientes
        return cont;
    }

    // Metodo de instancia que retorna el historial de pedidos completados o eliminados
    public List<Pedido> getHistorial() {
        // Retorna toda la lista del historial de la instancia
        return this.historial;
    }
}
