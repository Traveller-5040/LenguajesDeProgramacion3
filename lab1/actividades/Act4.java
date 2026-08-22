package actividades;
import java.util.Scanner;

public class Act4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce el tamaño del arreglo: ");
        int n = scanner.nextInt();
        int[] arreglo = new int[n];

        System.out.println("Introduce los elementos del arreglo:");
        leerArreglo(scanner, arreglo);

        // Se calcula el promedio de los elementos del arreglo
        double promedio = calcularPromedio(arreglo);
        System.out.println("El promedio de los elementos es: " + promedio);
    }

    // Función que permite ingresar los elementos del arreglo
    public static void leerArreglo(Scanner scanner, int[] arreglo) {
        for (int i = 0; i < arreglo.length; i++)
        {
            arreglo[i] = scanner.nextInt();
        }
    }

    // Función que calcula y devuelve el promedio de los elementos del arreglo
    public static double calcularPromedio(int[] arreglo) {
        int suma = 0;

        // Se suman todos los elementos del arreglo
        for (int num : arreglo) {
            suma += num;
        }

        // Se convierte la suma a double para obtener un resultado decimal
        return (double) suma / arreglo.length;
    }
}
