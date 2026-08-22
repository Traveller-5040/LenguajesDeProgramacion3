package actividades;
import java.util.Scanner;

public class Act2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce un número entero: ");
        int numero = scanner.nextInt();

        // Se guarda el número original para compararlo con su inverso
        int original = numero;
        int inverso = 0;

        // Se obtiene el número invertido extrayendo sus dígitos de derecha a izquierda
        while (numero != 0) {
            inverso = inverso * 10 + (numero % 10);
            numero /= 10;
        }

        // Si el número original y su inverso son iguales, es un palíndromo
        if (original == inverso) {
            System.out.println(original + " es un palíndromo.");
        } else {
            System.out.println(original + " no es un palíndromo.");
        }
    }
}
