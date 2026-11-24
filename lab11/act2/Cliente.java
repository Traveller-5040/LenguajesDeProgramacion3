package act2;

class Cliente implements CObserver {
    private String nombre;
    public Cliente(String nombre) { this.nombre = nombre; }
    @Override
    public void recibirAlerta(String mensaje) {
        System.out.println("[Email a " + nombre + "] " + mensaje);
    }
}
