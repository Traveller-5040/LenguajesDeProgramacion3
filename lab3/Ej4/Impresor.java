/*Tienes una interfaz Imprimible con métodos imprimir() y escanear(). Hay clases Impresora
e ImpresoraMultifuncional que implementan esta interfaz. La clase Impresora no tiene la
capacidad de escanear, por lo que su método escanear() lanza una excepción. Refactorizar
el código para cumplir con ISP, creando interfaces más específicas para evitar que las
clases implementen métodos que no necesitan. Desarrolle una aplicación.*/
package Ej4;

public interface Impresor {
    // Se crea el metodo "imprimir" el cual deben implementar
    // todas las clases que usen esta interfaz
    public void imprimir();
}
