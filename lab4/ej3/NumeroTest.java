package ej3;

public class NumeroTest {
    public static void main(String[] args) {
        Numero n1 = new Numero(2);

        try {
            System.out.println("Numero: " + n1.getValor());
            n1.setValor(-1);
        }
        catch(IllegalArgumentException e) {
            System.err.println("Error argumental: " + e.getMessage());
        }
    }
}
