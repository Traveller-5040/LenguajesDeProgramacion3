/*Tienes una clase Forma con un método dibujar(). Hay subclases Circulo y Rectángulo
que implementan este método. Se requiere añadir la capacidad de dibujar un Triángulo
sin modificar la clase Forma ni las subclases existentes. Refactorizar el código para
cumplir con OCP, permitiendo añadir nuevas formas geométricas sin modificar la clase
Forma ni las subclases existentes.*/

package Ej2;

public abstract class Forma {

    public abstract void Dibujar();
}
