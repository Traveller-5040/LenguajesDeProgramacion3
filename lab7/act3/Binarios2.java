package act3;

import java.io.*;
import java.util.Scanner;

public class Binarios2 {
    public static void main(String[] args) {
        // Inicializa un Scanner para procesar el flujo de entrada del sistema (System.in)
        Scanner sc = new Scanner(System.in);
        // Se inician dos variables enteras "filas" y "columnas"
        int filas, columnas;

        // Se crea un duble do-while para la entrada del numero de filas, el cual
        // solo cierra cuando el usuario haya ingresado un numero mayor a 0
        do {
            System.out.print("Número de filas: ");
            filas = sc.nextInt();
        } while (filas <= 0);

        // Mismo caso que el anterior pero para las columnas
        do {
            System.out.print("Número de columnas: ");
            columnas = sc.nextInt();
        } while (columnas <= 0);

        // Se crea una matriz usando los valores recibidos
        double[][] matriz = new double[filas][columnas];

        // Se crean un bucle for que contiene otro bucle for, dichos bucles serviran para ingresar
        // los valores deseados en las posiciones de la matriz creada previamente
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print("matriz[" + i + "][" + j + "]: ");
                matriz[i][j] = sc.nextDouble();
            }
        }

        // Inicia un try-with-resources que permitira la escritura en un archivo .dat
        try (FileOutputStream fos = new FileOutputStream("src/archivos/matriz.dat");
             DataOutputStream salida = new DataOutputStream(fos)) {

            salida.writeInt(filas);
            salida.writeInt(columnas);

            // Inicia un bucle for el cual se encargara el introducir la informacion de la matriz
            // en el archivo binario (.dat)
            for (int i = 0; i < filas; i++) {
                for (int j = 0; j < columnas; j++) {
                    salida.writeDouble(matriz[i][j]);
                }
            }
            // Si todo se realizo con normalidad se imprime un mensaje de confirmacion
            System.out.println("Matriz guardada exitosamente en binario.");
        } catch (FileNotFoundException e) { // Si el archivo no existe se lanza una excepcion
            System.out.println("Archivo no encontrado: " + e.getMessage());
        } catch (IOException e) { // Lanza una excepcion general
            System.out.println("Error de E/S: " + e.getMessage());
        }
    }
}
