package Ej4;

public class ImpresoraTest {
    public static void main(String[] args) {
        Impresora d1 = new Impresora();
        ImpresoraMultiFuncional d2 = new ImpresoraMultiFuncional();

        d1.imprimir();
        d2.escanear();
        d2.imprimir();
    }
}
