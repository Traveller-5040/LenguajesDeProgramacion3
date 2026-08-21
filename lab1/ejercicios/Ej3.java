package ejercicios;
// Se importa la libreria Random para generar numeros aleatorios
import java.util.Random;

public class Ej3 {
    public static void main(String[] args) {

        // Se declara el arreglo "frecuencia", que almacenará
        // la cantidad de veces que aparece cada cara del dado.
        int[] frecuencia = new int[6];

        // Se crea el objeto "aleatorio" de la clase Random
        // para generar los valores aleatorios del dado.
        Random aleatorio = new Random();

        // Se inicia un bucle que simula 20000 lanzamientos del dado
        // para calcular la frecuencia de aparición de cada cara.
        for (int i = 0; i < 20000; i++) {

            // Se genera un valor aleatorio entre 1 y 6 y se asigna
            // a la variable "dado", representando la cara obtenida.
            int dado = aleatorio.nextInt(6) + 1;

            // Se utiliza el valor obtenido en "dado" para determinar
            // la posición correspondiente del arreglo "frecuencia".
            // Se resta 1 porque los índices de un arreglo comienzan en 0.
            frecuencia[dado - 1] += 1;
        }

        // Se recorre el arreglo "frecuencia" para mostrar en pantalla
        // cuántas veces apareció cada una de las seis caras del dado.
        for (int i = 0; i < frecuencia.length; i++) {
            System.out.println("Cara " + (i + 1) + ": " + frecuencia[i] + " veces");
        }
    }
}
