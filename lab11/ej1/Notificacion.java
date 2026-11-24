package ej1;

public class Notificacion {
    private String tipoEvento;
    private String contenido;

    public Notificacion(String tipoEvento, String contenido) {
        this.tipoEvento = tipoEvento;
        this.contenido = contenido;
    }

    // Se edita el formato de salida de las instancias de la clase
    @Override
    public String toString() {
        return "[" + tipoEvento + "] " + contenido;
    }
}
