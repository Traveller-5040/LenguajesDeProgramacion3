/*Tienes una clase Empleado que se encarga de almacenar la información del empleado (nombre,
salario, departamento) y también de calcular el pago mensual del empleado. Refactorizar el código
para cumplir con SRP, separando la lógica de cálculo del pago en una clase separada.*/

package Ej1;

public class Empleado {
    private String nombre;
    private double salario;
    private String departamento;

    public Empleado(String n, double s, String dep) {
        this.nombre = n;
        this.salario = s;
        this.departamento = dep;
    }

    public String getNombre() { return this.nombre; }
    public double getSalario() { return this.salario; }
    public String getDepartamento() { return this.departamento; }

    public void setNombre(String nNombre) {
        this.nombre = nNombre;
    }

    public void setSalario(double nSalario) {
        this.salario = nSalario;
    }

    public void setDepartamento(String nDep) {
        this.departamento = nDep;
    }
}
