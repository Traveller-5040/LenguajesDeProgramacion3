package actividad5;

public class CuentaCorriente extends Cuenta {
    private int retiros;
    private static final int LIBRE_RETIROS = 3;
    private static final double TARIFA_TRANSACCION = 3.0;

    // constructor de una cuenta corriente nueva, arranca con saldo 0
    public CuentaCorriente(int numeroCuenta) {
        super(numeroCuenta, 0);
        this.retiros = 0;
    }

    // se sobrescribe retirar para cobrar tarifa despues de 3 retiros gratis
    @Override
    public void retirar(double monto) {
        super.retirar(monto);
        retiros++;
        if (retiros > LIBRE_RETIROS) {
            super.retirar(TARIFA_TRANSACCION); // cobro de la tarifa adicional
        }
    }

    // al consultar simplemente se reinicia el contador de retiros del mes
    @Override
    public void consultar() {
        retiros = 0;
    }
}
