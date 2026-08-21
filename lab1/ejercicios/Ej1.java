package ejercicios;

public class Ej1 {
    public static void main(String[] args) {
        int[] Numeros = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        System.out.println("Suma del arreglo 'Numeros' -> ");
        System.out.print(sumarArreglo(Numeros));
    }

    public static int sumarArreglo(int[] arreglo) {
        int total = 0;
        for(int i = 0; i < arreglo.length; i++) {
            total += arreglo[i];
        }

        return total;
    }

}
