package actividades;

import java.util.List;
import java.util.Scanner;

public class PedidoVista {
    private Scanner scanner;

    public PedidoVista() {
        this.scanner = new Scanner(System.in);
    }

    public String solicitarPlato() {
        System.out.print("Introduzca el nombre del plato -> ");
        return scanner.nextLine();
    }

    public String solicitarTipo() {
        System.out.print("Introduzca el nombre del tipo -> ");
        return scanner.nextLine();
    }

    public String solicitarBusqueda() {
        System.out.print("Introduzca la busqueda -> ");
        return scanner.nextLine();
    }

    public String solicitarEstado() {
        System.out.print("Estado a mostrar (1 = pendientes, 2 = completos) -> ");
        return scanner.nextLine();
    }

    public Integer solicitarIndice() {
        System.out.print("Introduzca el indice del pedido -> ");
        int index = this.scanner.nextInt();
        scanner.nextLine();
        return index;
    }

    public void mostrarPedidos(List<Pedido> pedidos) {
        if(pedidos.isEmpty()) {
            System.out.println("No hay pedidos registrados");
        } else {
            System.out.println("Lista de pedidos");
            int cont = 0;
            for(Pedido ped : pedidos) {
                System.out.println(++cont + " - " +ped.getNombre() + " | Tipo: " + ped.getTipo() + " | Estado: " + ped.getEstado());
            }
        }
    }

    public void mostrarMenu() {
        System.out.println("Menu de opciones");
        System.out.println("1. Agregar pedido");
        System.out.println("2. Actualizar pedido");
        System.out.println("3. Borrar pedido");
        System.out.println("4. Mostrar pedidos");
        System.out.println("5. Buscar pedido");
        System.out.println("6. Contar pedidos");
        System.out.println("7. Completar pedido");
        System.out.println("8. Mostrar estados de pedidos");
        System.out.println("9. Pedidos pendientes");
        System.out.println("10. Historial de pedidos");
        System.out.println("11. Salir del programa");
    }

    public String solicitarOpcion() {
        System.out.print("Introduzca una opcion -> ");
        return this.scanner.nextLine();
    }

    public void mostrarMensaje(String message) {
        System.out.println(message);
    }

    // Metodo implementado que muestra solo los pedidos que tienen el estado indicado
    public void mostrarPedidosPorEstado(List<Pedido> pedidos, String estado) {
        // Contador que lleva el numero de cada pedido en la lista completa,
        // asi el usuario puede usar ese mismo numero en las demas opciones
        int cont = 0;
        // Indica si se encontro al menos un pedido con el estado buscado
        boolean hay = false;
        // Recorre todos los pedidos de la lista
        for(Pedido ped : pedidos) {
            // El contador aumenta con cada pedido, tenga o no el estado buscado
            cont++;
            // Solo se imprimen los pedidos cuyo estado coincide con el indicado
            if(ped.getEstado().equals(estado)) {
                System.out.println(cont + " - " + ped.getNombre() + " | Tipo: " + ped.getTipo());
                hay = true;
            }
        }
        // Si ningun pedido coincidio, se imprime el mensaje de que no hay resultados
        if(!hay) {
            System.out.println("No hay pedidos con estado " + estado);
        }
    }

    // Metodo implementado que muestra el historial de pedidos completados o eliminados
    public void mostrarHistorial(List<Pedido> historial) {
        // Verifica si el historial esta vacio
        if(historial.isEmpty()) {
            // De estarlo imprime el mensaje de error y finaliza
            System.out.println("El historial esta vacio");
        } else {
            // De lo contrario, se procede a imprimir todo el historial
            System.out.println("Historial de pedidos");
            int cont = 0;
            for(Pedido ped : historial) {
                // Se muestra el estado para distinguir los pedidos completados de los eliminados
                System.out.println(++cont + " - " + ped.getNombre() + " | Tipo: " + ped.getTipo()
                        + " | Estado: " + ped.getEstado());
            }
        }
    }

    public void cerrarScanner() {
        this.scanner.close();
    }
}
