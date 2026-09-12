package ej2;

public class CalculadoraTest {
    public static void main(String[] args) {
        try {
            System.out.println("Suma: " + Calculadora.sumar(2, 190));
            System.out.println("Resta: " + Calculadora.restar(134, 1));
            System.out.println("Multiplicacion: " + Calculadora.multiplicar(9, 8));
            System.out.println("Division: " + Calculadora.dividir(90, 0));
        }
        catch(IllegalArgumentException e) {
            System.err.println("Error de argumento: " + e.getMessage());
        }
        catch(ArithmeticException e) {
            System.err.println("Error aritmetico: " + e.getMessage());
        }
        catch(DividirPorCeroException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
