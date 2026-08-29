package entidades;

public abstract class Persona {
    protected String nombre;
    protected String dni;

    public Persona(String n, String id) {
        this.nombre = n;
        this.dni = id;
    }

    public String getNombre() { return this.nombre; }
    public String getDni() { return this.dni; }

    public abstract String getRol();

    @Override
    public String toString() {
        String puesto = getRol();
        return String.format("Nombre: %s | DNI: %s | Rol: %s",
                nombre,
                dni,
                puesto
        );
    }
}
