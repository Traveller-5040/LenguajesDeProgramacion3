package actividades;

public class PruebaPedidos {
    public static void main(String[] args) {
        PedidoVista vista = new PedidoVista();
        PedidoModelo model = new PedidoModelo();

        PedidoControlador controller = new PedidoControlador(model, vista);

        controller.iniciar();
    }
}
