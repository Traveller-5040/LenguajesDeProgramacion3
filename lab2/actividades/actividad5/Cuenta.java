package actividad5;

// Clase base de la jerarquia. Es abstracta porque no tiene sentido crear
// una "Cuenta" generica, siempre es una cuenta de ahorro o corriente.
public abstract class Cuenta {
    protected double saldo;
    protected int numeroCuenta;

    public Cuenta(int numeroCuenta, double saldoInicial) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldoInicial;
    }

    public void depositar(double monto) {
        saldo = saldo + monto;
    }

    public void retirar(double monto) {
        saldo = saldo - monto;
    }

    public double getSaldo() {
        return saldo;
    }

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    // cada subclase decide que pasa cuando se hace la consulta mensual
    public abstract void consultar();
}
