package entidades;

import cursos.Curso;
import java.util.ArrayList;

public class Profesor extends Persona {
    private final String codigo;
    private final String tipo;
    private ArrayList<Curso> cursos;

    public Profesor(String n, String dni, String cod) {
        super(n, dni);
        this.codigo = cod;
        this.tipo = "Profesor";
        this.cursos = new ArrayList<>();
    }

    // GETTERS
    @Override
    public String getRol() { return this.tipo; }
    public String getCodigo() { return this.codigo; }

    // METODOS
    public void asignarCurso(Curso crs) {
        cursos.add(crs);
        crs.setProfesor(this);
    }

    public void mostrarCursos() {
        for(Curso c : cursos) {
            System.out.println(c);
        }
    }
}
