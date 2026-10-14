package act2;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Se crea un objeto Scanner para leer la entrada del teclado del sistema
        Scanner sc = new Scanner(System.in);
        String cadena;

        // Se crea un bloque try-with-resources
        try (PrintWriter salida = new PrintWriter("src/archivos/datos.txt")) {
            System.out.println("Introduce texto. Para acabar introduce la cadena FIN:");
            // Se guarda la linea de entrada en el Objeto String "cadena"
            cadena = sc.nextLine();
            // Se crea un candado el cual comprueba que el valor del objeto "cadena"
            // Sea diferente a "FIN".
            while (!cadena.equalsIgnoreCase("FIN")) {
                salida.println(cadena);
                cadena = sc.nextLine();
            }
        } catch (FileNotFoundException e) { // Si el archivo no fue encontrado se lanza una excepcion
            System.out.println("No se pudo crear o encontrar el archivo: " + e.getMessage());
        }
    }
}
