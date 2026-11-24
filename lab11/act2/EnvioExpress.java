package act2;

class EnvioExpress implements SendStrategy {
    @Override public double calcularEnvio(double montoPedido) { return 25.0; }
    @Override public String getNombre() { return "Envío Express"; }
}