/*Crea una clase Calculadora que permita realizar operaciones matemáticas básicas
como suma, resta, multiplicación y división. Implementa métodos para cada operación
y asegúrate de que el método dividir lance una excepción personalizada DivisionPorCeroException
si se intenta dividir por cero. Maneja las excepciones en el código de invocación utilizando
bloques catch múltiples para capturar tanto IllegalArgumentException como ArithmeticException.*/

package ej2;

public class Calculadora {
    // Se crean los metodos sumar, restar, multiplicar y dividir como static
    // para que no dependen de instancias
    public static int sumar(int a, int b) { return a + b;}

    public static int restar(int a, int b) { return a - b; }

    public static int multiplicar(int a, int b) { return a * b; }

    public static double dividir(int a, int b) throws DividirPorCeroException {
        // Se implementa la excepcion personalizada para evaluar el divisor
        if(b == 0) {
            throw new DividirPorCeroException("No es posible dividir entre 0");
        }
        return (double) a / b;
    }
}
