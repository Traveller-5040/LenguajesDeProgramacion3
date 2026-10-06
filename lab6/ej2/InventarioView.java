package ej2;

import java.util.List;
import java.util.Scanner;

public class InventarioView {
    private Scanner scanner;

    public InventarioView() {
        // Inicializa el objeto Scanner
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        // Imprime el menu de opciones del programa
        System.out.println("Menu de opciones");
        System.out.println("1. Agregar item");
        System.out.println("2. Ver inventario");
        System.out.println("3. Eliminar item");
        System.out.println("4. Buscar item");
        System.out.println("5. Mostrar detalles de un item");
        System.out.println("6. Usar item");
        System.out.println("7. Salir del programa");
    }

    public String solicitarOpcion() {
        // Permite solicitar la entrada de una opcion
        System.out.print("Introduzca una opcion -> ");
        return this.scanner.nextLine().trim();
    }

    public String solicitarTexto(String mensaje) {
        // Permite solicitar un texto cualquiera mostrando el mensaje indicado
        System.out.print(mensaje + " -> ");
        return this.scanner.nextLine().trim();
    }

    public int solicitarEntero(String mensaje) {
        System.out.print(mensaje + " -> ");
        // Se lee como texto para evitar que el programa se caiga si no se ingresa un numero
        try {
            return Integer.parseInt(this.scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1; // el controlador lo reportara como dato no valido
        }
    }

    // Metodo implementado que muestra todos los items del inventario
    public void mostrarInventario(List<Item> items) {
        if(items.isEmpty()) {
            System.out.println("El inventario esta vacio");
        } else {
            System.out.println("Inventario");
            for(Item i : items) {
                System.out.println("- " + i.getNombre() + " x" + i.getCantidad() + " | Tipo: " + i.getTipo());
            }
        }
    }

    public void mostrarMensaje(String message) {
        // Imprime lo ingresado (message)
        System.out.println(message);
    }

    // Metodo que muestra todos los datos de un item
    public void mostrarDetallesItem(Item item) {
        System.out.println("Nombre: " + item.getNombre());
        System.out.println("Cantidad: " + item.getCantidad());
        System.out.println("Tipo: " + item.getTipo());
        System.out.println("Descripcion: " + item.getDescripcion());
    }

    public void cerrarScanner() {
        // Cierra el scanner para controlar el uso de recursos
        this.scanner.close();
    }
}
