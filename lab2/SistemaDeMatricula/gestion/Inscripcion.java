package gestion;

import cursos.*;
import entidades.*;

public class Inscripcion {
    private Estudiante estudiante;
    private Curso curso;

    public Inscripcion(Estudiante est, Curso cur) {
        this.estudiante = est;
        this.curso = cur;
    }

    public Estudiante getEstudiante() { return this.estudiante; }
    public Curso getCurso() { return this.curso; }
}
