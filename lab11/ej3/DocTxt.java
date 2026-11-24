package ej3;

public class DocTxt {
    private StringBuilder contenido = new StringBuilder();

    // Metodo que agrega texto
    public void agregarTexto(String texto) {
        contenido.append(texto);
    }

    // Metodo que borra la ultima modificacion
    public void eliminarUltimosCaracteres(int longitud) {
        int inicio = Math.max(0, contenido.length() - longitud);
        contenido.delete(inicio, contenido.length());
    }

    // Metodo que retorna el contenido
    public String getContenido() {
        return contenido.toString();
    }
}
