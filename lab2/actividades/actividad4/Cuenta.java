package actividad4;

public class Cuenta {
    private int numero;
    private double saldo;

    public Cuenta(int numero, double saldo) {
        this.numero = numero;
        this.saldo = saldo;
    }

    public Cuenta(int numero) {
        this(numero, 0);
    }

    // setter y getter
    public int getNumCuenta() {
        return numero;
    }

    public void setNumCuenta(int numero) {
        this.numero = numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String toString() {
        return "cuenta N " + numero + ", saldo S/. " + saldo;
    }
}
