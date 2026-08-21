package ejercicios;
// Se importan las clases necesarias para crear el programa
import java.util.Scanner;
import java.util.Vector;

public class Ej2 {
    public static void main(String[] args) {
        // Se declara el vector
        Vector<Integer> Numeros = new Vector<>();
        // Se declaran las variables (enteras) en 0
        int num = 0;
        int cont = 0;

        Scanner tec = new Scanner(System.in);

        // Inicia el candado (while)
        while(cont < 10)
        {
            // Se solicita al usuario ingresar un numero
            System.out.println("Ingrese un numero -> ");
            num = tec.nextInt();

            // Antes de agregar el numero al vector se verifica que sea mayor al anterior
            if(cont == 0 || num >= Numeros.get(cont-1)  ) // De ser el primero se obvia la verificacion
            {
                Numeros.add(num);
                cont += 1;
                continue;
            } else
            {
                // De ser falso se envia el mensaje de error y continua el candado
                System.out.println("Error, el numero ingresado debe ser mayor al anterior: " + Numeros.get(cont-1));
                continue;
            }

        }

        // Se cierra el Scanner y se imprime el Vector
        tec.close();
        System.out.print("Numeros ingresados -> " + Numeros);
    }

}
