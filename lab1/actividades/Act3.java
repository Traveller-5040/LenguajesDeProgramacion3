package actividades;
import java.util.Scanner;

public class Act3 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce un número: ");
        int n = scanner.nextInt();

        // Se muestran los números perfectos menores que n
        imprimirNumerosPerfectos(n);
    }

    // Función que verifica si un número es perfecto
    public static boolean esPerfecto(int num) {
        int sumaDivisores = 0;

        // Se recorren los posibles divisores propios del número
        for (int i = 1; i <= num / 2; i++)
        {
            if (num % i == 0) {
                sumaDivisores += i;
            }
        }

        // Un número es perfecto si la suma de sus divisores propios
        // es igual al mismo número
        return sumaDivisores == num;
    }

    // Función que busca y muestra todos los números perfectos
    // menores que el número ingresado
    public static void imprimirNumerosPerfectos(int n) {
        for (int num = 1; num < n; num++)
        {
            if (esPerfecto(num)) {
                System.out.println(num + " es un número perfecto.");
            }
        }
    }
}
