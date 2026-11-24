package act2;

class EnvioEstandar implements SendStrategy {
    @Override public double calcularEnvio(double montoPedido) { return 10.0; }
    @Override public String getNombre() { return "Envío Estándar"; }
}