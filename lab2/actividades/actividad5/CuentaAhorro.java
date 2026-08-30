package actividad5;

public class CuentaAhorro extends Cuenta {
    private double tasaInteres;
    private double minSaldo;

    // constructor de una cuenta de ahorro nueva, arranca con saldo 0
    public CuentaAhorro(int numeroCuenta) {
        super(numeroCuenta, 0);
        this.minSaldo = 0;
    }

    // define la tasa de interes mensual, en porcentaje
    public void setTasaInteres(double interes) {
        this.tasaInteres = interes;
    }

    // se sobrescribe retirar para llevar el control del saldo minimo del mes
    @Override
    public void retirar(double monto) {
        super.retirar(monto); // primero se hace el retiro normal
        double saldoActual = getSaldo();
        if (saldoActual < minSaldo) {
            minSaldo = saldoActual; // se guarda el saldo mas bajo del mes
        }
    }

    // al consultar se calculan y depositan los intereses sobre el saldo minimo
    @Override
    public void consultar() {
        double interes = minSaldo * tasaInteres / 100;
        depositar(interes); // se usa depositar porque saldo es protected, no privado, pero asi se respeta el mismo camino que usa Cuenta
        minSaldo = getSaldo(); // se reinicia el saldo minimo para el siguiente mes
    }
}
