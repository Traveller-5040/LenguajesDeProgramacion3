// Se importa la libreria Scanner par obtener valores ingresados en el teclado
import java.util.Scanner;

public class Ej4 {
    public static void main(String[] args) {

        // Se crea el objeto "scan" de la clase Scanner para
        // poder obtener los valores ingresados por el teclado
        Scanner scan = new Scanner(System.in);

        // Se declaran las variables "num1", "num2" y "num3"
        // como double
        double num1, num2, num3;

        // Se solicita al usuario ingresar los valores de los tres numeros
        System.out.print("Ingrese un numero decimal -> ");
        num1 = scan.nextDouble();

        System.out.print("Ingrese un numero decimal -> ");
        num2 = scan.nextDouble();

        System.out.print("Ingrese un numero decimal -> ");
        num3 = scan.nextDouble();

        // Se cierra el objeto "scan"
        scan.close();

        // Se imprime el numero menos de los tres usando la funcion "menorDeTres"
        // para la cual se envian los 3 numeros ingresados como parametros
        System.out.println("El numero menor es: " + menorDeTres(num1, num2, num3));
    }

    public static double menorDeTres(double a, double b, double c) {

        // Inicia la condicional que verifica si "a" es menor que "b" y "c"
        if(a < b && a < c) {
            // De ser verdad retorna "a"
            return a;
            // De ser falso procede al siguiente else if
            // la cual verifica si "b" es menor "a" y "c"
        } else if (b < a && b < c){
            // De ser verdad retorna "b"
            return b;
        } else {
            // de ser falso retorna "c"
            return c;
        }
    }
}
