/*Tienes una clase Vehículo con un método acelerar(). Hay subclases Coche y Bicicleta que
implementan este método. La clase Bicicleta sobrescribe acelerar() para indicar que se
acelera pedaleando, mientras que Coche indica que se acelera usando el motor. Analizar
si el código cumple con LSP. Si no es así, refactorizar para asegurarte de que las subclases
se comporten de manera consistente con la clase base.*/

package Ej3;

public abstract class Vehiculo {
    public abstract void acelerar();
}
