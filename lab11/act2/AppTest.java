package act2;

public class AppTest {
    public static void main(String[] args) {
        SistemaPedidos tienda = new SistemaPedidos();
        tienda.suscribir(new Cliente("María"));
        tienda.suscribir(new Cliente("Jorge"));

        tienda.setEstrategiaEnvio(new EnvioExpress());

        GestorTareasTienda gestor = new GestorTareasTienda();
        gestor.agregarComando(new ConfirmarPedidoCommand(tienda, "Laptop Gamer", 4500.0));
        gestor.ejecutarCola();
    }
}
