package actividad4;

public class Persona {
    private int id;
    private String nombre;
    private String apellido;
    private Cuenta cuenta; // composicion: la cuenta no existe sin la persona

    public Persona(int id, String nombre, String apellido) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        // el numero de cuenta se genera a partir del id de la persona
        int numeroDeCuenta = id * 100;
        this.cuenta = new Cuenta(numeroDeCuenta);
    }

    // setter y getter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    // no hay setCuenta porque la cuenta se crea junto con la persona (composicion)
    public Cuenta getCuenta() {
        return cuenta;
    }

    public String toString() {
        return "Persona " + nombre + " " + apellido + " (id " + id + "), " + cuenta;
    }
}
