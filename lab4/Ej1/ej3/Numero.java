/*Gestión de Números Negativos: Implementa una clase Numero que tenga un atributo
valor (double) y métodos para establecer y obtener el valor. Asegúrate de que el
método setValor() lance una IllegalArgumentException si el valor es negativo.
Maneja esta excepción correctamente en el código que utiliza la clase.*/

package ej3;

public class Numero {
    private double valor;

    public Numero(double n) {
        this.valor = n;
    }

    public double getValor() { return this.valor; }
    public void setValor(double nValor) throws IllegalArgumentException {
        if(nValor < 0) {
            throw new IllegalArgumentException("El valor ingresado no puede ser negativo");
        }
        this.valor = nValor;
    }
}
