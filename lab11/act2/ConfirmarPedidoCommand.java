package act2;

class ConfirmarPedidoCommand implements OrderCommand {
    private SistemaPedidos sistema;
    private String producto;
    private double precio;

    public ConfirmarPedidoCommand(SistemaPedidos sistema, String producto, double precio) {
        this.sistema = sistema;
        this.producto = producto;
        this.precio = precio;
    }

    @Override
    public void ejecutar() {
        sistema.confirmarOrden(producto, precio);
    }
}