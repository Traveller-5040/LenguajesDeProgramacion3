package actividades;
import java.util.Scanner;

public class Act1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce un número: ");
        int n = scanner.nextInt();

        // Se muestran todos los números primos desde 2 hasta n
        imprimirNumerosPrimos(n);
    }

    public static boolean esPrimo(int num) {
        // Los números menores o iguales a 1 no son primos
        if (num <= 1) {
            return false;
        }

        // Se comprueba si el número es divisible entre algún número
        // desde 2 hasta la mitad del número
        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                return false;
            }
        }

        // Si no se encontró ningún divisor, el número es primo
        return true;
    }

    public static void imprimirNumerosPrimos(int n) {
        // Se recorren los números desde 2 hasta n y se verifica
        // cuáles cumplen la condición de ser números primos
        for (int num = 2; num <= n; num++) {
            if (esPrimo(num)) {
                System.out.println(num + " es primo.");
            }
        }
    }
}
