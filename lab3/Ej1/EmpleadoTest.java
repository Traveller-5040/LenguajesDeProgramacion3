package Ej1;

public class EmpleadoTest {
    public static void main(String[] args) {
        Empleado e1 = new Empleado("Antonio Torres", 1350, "Contabilidad");

        System.out.println("El pago mensual de " + e1.getNombre() + " es de : S/" + CalcSalario.calcularSalario(e1));
    }
}
