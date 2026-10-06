package ej2;

public class PruebaInventario {
    public static void main(String[] args) {
        InventarioView vista = new InventarioView();
        InventarioModel model = new InventarioModel();

        model.agregarItem(new Item("Espada", 1, "Arma", "Espada de hierro"));
        model.agregarItem(new Item("Pocion de fuerza", 3, "Pocion", "Aumenta la fuerza"));

        InventarioController controller = new InventarioController(model, vista);

        controller.iniciar();
    }
}
