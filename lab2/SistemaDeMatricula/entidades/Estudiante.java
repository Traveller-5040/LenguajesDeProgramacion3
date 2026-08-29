package entidades;

import cursos.Curso;
import gestion.Inscripcion;
import java.util.ArrayList;

public class Estudiante extends Persona {
    private final String codigo;
    private final String tipo;
    private ArrayList<Inscripcion> inscripciones;

    public Estudiante(String n, String dni, String cod) {
        super(n, dni);
        this.codigo = cod;
        this.tipo = "Estudiante";
        this.inscripciones = new ArrayList<>();
    }

    public String getCod() { return this.codigo; }

    @Override
    public String getRol() { return this.tipo;}

    public void inscribir(Curso crso) {
        Inscripcion ins = new Inscripcion(this, crso);
        inscripciones.add(ins);
        crso.registrar(ins);
    }

    public void mostrarCursos() {
        for(Inscripcion i : inscripciones) {
            System.out.println(i.getCurso());
        }
    }
}
