package cursos;

import gestion.Categoria;
import entidades.Profesor;

public class CursoTeorico extends Curso {
    private final String tipo;
    public CursoTeorico(String n, String cod, Profesor doc, Categoria cat) {
        super(n, cod, doc, cat);
        this.tipo = "Teorico";
    }

    public String getTipo() { return this.tipo;}
}
