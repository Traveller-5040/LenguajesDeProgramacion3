package cursos;

import entidades.Profesor;
import gestion.Categoria;

public class CursoPractico extends Curso{
    private final String tipo;
    public CursoPractico(String n, String cod, Profesor doc, Categoria cat) {
        super(n, cod, doc, cat);
        this.tipo = "Practico";
    }

    public String getTipo() { return this.tipo;}
}
