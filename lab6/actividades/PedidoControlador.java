package actividades;

import java.util.List;
import java.util.Map;

public class PedidoControlador {
    private PedidoModelo modelo;
    private PedidoVista view;

    public PedidoControlador(PedidoModelo ped, PedidoVista vista) {
        this.modelo = ped;
        this.view = vista;
    }

    public void agregarPedido(String nombrePlato, String tipoPlato) {
        if(!nombrePlato.isEmpty()) {
            Pedido pedido1 = new Pedido(nombrePlato, tipoPlato);
            this.modelo.agregarPedido(pedido1);
            this.view.mostrarMensaje("Pedido registrado");
        } else {
            this.view.mostrarMensaje("Nombre o tipo de plato vacio");
        }
    }

    public void borrarPedido(int index) {
        if(this.modelo.getPedidos().isEmpty()) {
            view.mostrarMensaje("No hay pedidos registrados");
        }

        index -= 1;

        if(index >= 0 && index < this.modelo.getPedidos().size()) {
            this.modelo.borrarPedido(index);
            this.view.mostrarMensaje("Pedido eliminado");
        } else {
            this.view.mostrarMensaje("Indice no valido");
        }
    }

    public void actualizarPedido(int index, String nombrePlato, String tipoPlato) {
        if(this.modelo.getPedidos().isEmpty()) {
            view.mostrarMensaje("No hay pedidos registrados");
        }

        index -= 1;

        if(index >= 0 && index < this.modelo.getPedidos().size()) {
            Pedido pedido = new Pedido(nombrePlato, tipoPlato);
            this.modelo.actualizarPedido(index, pedido);
            this.view.mostrarMensaje("Pedido actualizado");
        } else {
            this.view.mostrarMensaje("Nombre o tipo de plato vacio");
        }
    }

    public void buscarPedido(String busqueda) {
        if (modelo.getPedidos().isEmpty()) {
            view.mostrarMensaje("No hay pedidos registrados");
            return;
        }

        if (busqueda.isEmpty()) {
            view.mostrarMensaje("Nombre o tipo de plato vacío");
            return;
        }

        List<Pedido> resultados = modelo.buscarPedido(busqueda);

        if (resultados.isEmpty()) {
            view.mostrarMensaje("No se encontraron coincidencias");
        } else {
            for (Pedido pedido : resultados) {
                view.mostrarMensaje(pedido.getNombre() + " | Tipo: " + pedido.getTipo());
            }
        }
    }

    public void contarPedidos() {
        if (this.modelo.getPedidos().isEmpty()) {
            view.mostrarMensaje("No hay pedidos registrados");
            return;
        }

        int total = modelo.getPedidos().size();
        Map<String, Integer> conteoTipos = modelo.obtenerConteoTipos();

        view.mostrarMensaje("Cantidad total de pedidos: " + total);
        view.mostrarMensaje("Conteo por tipos:");
        for (Map.Entry<String, Integer> entry : conteoTipos.entrySet()) {
            view.mostrarMensaje(" - " + entry.getKey() + ": " + entry.getValue());
        }
    }

    // Metodo que marca un pedido pendiente como completo, seleccionandolo mediante su indice
    public void marcarCompleto(int index) {
        // Verifica si la lista esta vacia para informar al usuario que no hay pedidos que completar
        if(this.modelo.getPedidos().isEmpty()) {
            view.mostrarMensaje("No hay pedidos registrados");
            return;
        }

        // Ajusta el indice ingresado por el usuario para adaptarlo al sistema de indices base 0
        index -= 1;

        // Valida que el indice este dentro del rango permitido para proceder con el cambio de estado
        if(index >= 0 && index < this.modelo.getPedidos().size()) {
            // Si el pedido ya estaba completado no se vuelve a registrar en el historial
            if(this.modelo.getPedidos().get(index).getEstado().equals("Completado")) {
                this.view.mostrarMensaje("El pedido ya estaba completado");
            } else {
                // De lo contrario, se le pide al modelo que cambie el estado y lo guarde en el historial
                this.modelo.marcarCompleto(index);
                this.view.mostrarMensaje("Pedido marcado como completo");
            }
        } else {
            this.view.mostrarMensaje("Indice no valido");
        }
    }

    // Metodo que muestra solo los pedidos pendientes o solo los completos segun la opcion ingresada
    public void mostrarPorEstado(String opcion) {
        // La opcion 1 filtra los pedidos pendientes
        if(opcion.equals("1")) {
            view.mostrarPedidosPorEstado(this.modelo.getPedidos(), "Pendiente");
            // La opcion 2 filtra los pedidos completados
        } else if(opcion.equals("2")) {
            view.mostrarPedidosPorEstado(this.modelo.getPedidos(), "Completado");
        } else {
            // Cualquier otra opcion se notifica como invalida
            view.mostrarMensaje("Estado no valido");
        }
    }

    // Metodo que muestra cuantos pedidos siguen pendientes
    public void contarPendientes() {
        // El modelo calcula el total y el controlador lo envia a la vista para que lo imprima
        view.mostrarMensaje("Pedidos pendientes: " + this.modelo.contarPendientes());
    }

    // Metodo que muestra el historial de pedidos completados o eliminados
    public void mostrarHistorial() {
        // Se envia la lista del historial al metodo mostrarHistorial de PedidoVista para que proceda a imprimirse
        view.mostrarHistorial(this.modelo.getHistorial());
    }

    public void mostrarPedidos() {
        List<Pedido> listPed = this.modelo.getPedidos();
        view.mostrarPedidos(listPed);
    }

    public void iniciar() {
        String opc;
        do {
            view.mostrarMensaje(" ");
            view.mostrarMenu();
            opc = view.solicitarOpcion();
            switch (opc) {
                case "1":
                    String nombrePlato = view.solicitarPlato();
                    String nombreTipo = view.solicitarTipo();
                    this.agregarPedido(nombrePlato,  nombreTipo);
                    break;

                case "2":
                    int nIndex = view.solicitarIndice();
                    String sPlato = view.solicitarPlato();
                    String sTipo = view.solicitarTipo();
                    this.actualizarPedido(nIndex, sPlato, sTipo);
                    break;

                case "3":
                    int n1Index = view.solicitarIndice();
                    this.borrarPedido(n1Index);
                    break;

                case "4":
                    this.mostrarPedidos();
                    break;

                case "5":
                    String s1Plato = view.solicitarBusqueda().toLowerCase().trim();
                    this.buscarPedido(s1Plato);
                    break;

                case "6":
                    this.contarPedidos();
                    break;

                case "7":
                    int n2Index = view.solicitarIndice();
                    this.marcarCompleto(n2Index);
                    break;

                case "8":
                    this.mostrarPorEstado(view.solicitarEstado());
                    break;

                case "9":
                    this.contarPendientes();
                    break;

                case "10":
                    this.mostrarHistorial();
                    break;

                case "11":
                    view.mostrarMensaje("Saliendo del programa...");
                    break;

                default:
                    view.mostrarMensaje("Opcion invalida, intente otra vez");
            }
        } while(!opc.equals("11"));
        this.view.cerrarScanner();
    }
}
