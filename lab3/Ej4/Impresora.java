package Ej4;

public class Impresora implements Impresor {
    @Override // Se sobreescribe el metodo "imprimir"
    public void imprimir() {
        System.out.println("Impresora: imprimiendo documento...");
    }
}
