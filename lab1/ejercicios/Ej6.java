package ejercicios;
// Se importa la clase "Scanner" para obtener valores ingresador por teclado
import java.util.Scanner;

public class Ej6 {
    public static void main(String[] args) {

        // Se crea el objeto "scan" de la clase Scanner
        Scanner scan = new Scanner(System.in);

        // Se declaran las variables "h", "m" y "s" que almacenaran
        // las horas, minutos y segundos que ingrese el usuario
        int h, m, s;

        // Se declara la variable "tiempoTotal" que funcionara como acumulador
        // para el tiempo total ingresado en segundos
        int tiempoTotal = 0;

        // Se solicita al usuario ingresar la cantidad de horas, dicha cantidad
        // se almacera en la variable "h"
        System.out.print("Ingrese una cantidad de horas -> ");
        h = scan.nextInt();

        // Se solicita al usuario ingresar la cantidad de minutos, dicha cantidad
        // se almacera en la variable "m"
        System.out.print("Ingrese una cantidad de minutos -> ");
        m = scan.nextInt();

        // Se solicita al usuario ingresar la cantidad de segundos, dicha cantidad
        // se almacera en la variable "s"
        System.out.print("Ingrese una cantidad de segundos -> ");
        s = scan.nextInt();

        // Se cierra el objeto "scan"
        scan.close();

        // Las horas se multiplican por 3600 (cantidad de segundos en una hora) y se
        // suman a la variable acumuladora
        tiempoTotal += (h * 60) * 60;

        // Los minutos se multiplican por 60 y se suman a la variable acumuladora
        tiempoTotal += m * 60;

        // Los segundos son sumados directamente a la variable acumuladora
        tiempoTotal += s;

        // Se muestra en pantalla el tiempo total en segundos
        System.out.println("Cantidad de tiempo total en segundos: " + tiempoTotal + "s");
    }
}
