// Se importa la clase Scanner para obtener los valores ingresados por teclado
import java.util.Scanner;

public class Ej5 {
    public static void main(String[] args) {

        // Se crea el objeto "scan" de la clase Scanner
        Scanner scan = new Scanner(System.in);

        // Se declara la variable "horas" para almacenar el
        // numero de horas que el auto estuvo estacionado
        int horas = 0;

        // Se solicita al usuario a ingresar el número de horas
        System.out.print("Ingrese el numero de horas del auto estacionado -> ");
        horas = scan.nextInt();

        // Se cierra el objeto "scan"
        scan.close();

        // Se declara la variable (double) "total" a la cual
        // se le asigna el valor que retorne la funcion calcularPago()
        // al que se envia como unico parametro la variable "horas"
        double total = calcularPago(horas);

        // Se muestra en pantalla el total a pagar
        System.out.println("Total a pagar: S/" + total);
    }

    public static double calcularPago(int h) {

        // Se calcula la cantidad de días completos mediante
        // la división entera de las horas entre 24
        int dias = h / 24;

        // Se calcula la cantidad de horas restantes después
        // de descontar los días completos
        int hrest = h % 24;

        // Cada día completo tiene un costo máximo de S/12
        double monto = dias * 12;

        // Si no quedan horas adicionales, no se agrega ningún monto
        if (hrest == 0) {
            return monto;
            // Si queda exactamente una hora adicional, se cobran S/3
        } else if (hrest == 1) {
            monto += 3;

            // Si quedan más de una hora, se cobran S/3 por la primera hora
            // y S/0.50 por cada hora adicional
        } else {
            monto += 3 + ((hrest - 1) * 0.5);
        }

        // Se devuelve el monto total calculado
        return monto;

    }
}
