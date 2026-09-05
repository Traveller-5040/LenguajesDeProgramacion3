package Ej4;

public class ImpresoraMultiFuncional implements Impresor, Escaner{
    @Override // Se sobreescribe el metodo "imprimir"
    public void imprimir() {
        System.out.println("ImpresoraMF: imprimiendo documento...");
    }

    @Override // Se sobreescribe el metodo "escanear"
    public void escanear() {
        System.out.println("ImpresoraMF: escaneando documento...");
    }
}
