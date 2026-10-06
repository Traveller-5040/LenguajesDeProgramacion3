package actividades;

public class Pedido {
    private String nombrePlato;
    private String tipoPlato;
    // El estado puede variar entre "Pendiente", "Completado" o "Eliminado"
    private String estado;

    public Pedido(String plato, String tipo) {
        this.nombrePlato = plato;
        this.tipoPlato = tipo;
        this.estado = "Pendiente";
    }

    public String getNombre() {
        return this.nombrePlato;
    }

    public String getTipo() {
        return this.tipoPlato;
    }

    public String getEstado() {
        return this.estado;
    }

    public void setNombre(String nombre) {
        this.nombrePlato = nombre;
    }

    public void setTipo(String tipo) {
        this.tipoPlato = tipo;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
