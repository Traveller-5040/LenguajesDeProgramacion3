package ej1;

import java.util.List;
import java.util.Scanner;

public class CarritoVista {
    private Scanner scanner;

    public CarritoVista() {
        // Inicializa el objeto Scanner
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        // Imprime el menu de opciones del programa
        System.out.println("Menu de opciones");
        System.out.println("1. Agregar producto");
        System.out.println("2. Listar productos");
        System.out.println("3. Agregar producto al carrito");
        System.out.println("4. Ver carrito");
        System.out.println("5. Quitar producto del carrito");
        System.out.println("6. Aplicar descuento");
        System.out.println("7. Calcular envio");
        System.out.println("8. Historial de compras");
        System.out.println("9. Realizar compra");
        System.out.println("10. Salir del programa");
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

    public double solicitarPrecio() {
        System.out.print("Introduzca el precio -> ");
        try {
            return Double.parseDouble(this.scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    // Metodo que muestra todos los productos de la tienda con su stock
    public void mostrarProductos(List<Producto> productos) {
        System.out.println("Lista de productos");
        int cont = 0;
        for(Producto p : productos) {
            System.out.println(++cont + " - " + p.getNombre() + " | Precio: S/ "
                    + String.format("%.2f", p.getPrecio()) + " | Stock: " + p.getStock());
        }
    }

    // Metodo que muestra los productos que hay en el carrito
    public void mostrarCarrito(List<Producto> carrito) {
        System.out.println("Productos en el carrito");
        int cont = 0;
        for(Producto p : carrito) {
            System.out.println(++cont + " - " + p.getNombre() + " | Precio: S/ "
                    + String.format("%.2f", p.getPrecio()));
        }
    }

    public void mostrarHistorial(List<String> historial) {
        System.out.println("Historial de compras");
        for(String compra : historial) {
            System.out.println(compra);
        }
    }

    public void mostrarMensaje(String message) {
        // Imprime lo ingresado (message)
        System.out.println(message);
    }

    public void cerrarScanner() {
        // Cierra el scanner para controlar el uso de recursos
        this.scanner.close();
    }
}
