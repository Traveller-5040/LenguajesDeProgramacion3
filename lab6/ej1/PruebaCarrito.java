package ej1;

public class PruebaCarrito {
    public static void main(String[] args) {
        CarritoVista vista = new CarritoVista();
        CarritoModelo model = new CarritoModelo();

        model.agregarProducto(new Producto("USB 128GB", 45.0, 3));
        model.agregarProducto(new Producto("Cargador USB - C", 24.3, 124));

        CarritoControlador controller = new CarritoControlador(model, vista);

        controller.iniciar();
    }
}
