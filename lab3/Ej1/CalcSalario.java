package Ej1;

public class CalcSalario {
    public static double calcularSalario(Empleado e) {
        // Se remueve un 10% para el pago del seguro y entre otros
        return e.getSalario() * 0.90;
    }
}
