package gestion;

import java.util.ArrayList;
import entidades.*;
import cursos.*;

public class SistemaGestion {
    private ArrayList<Estudiante> estudiantes;
    private ArrayList<Profesor> profesores;
    private ArrayList<Curso> cursos;
    private ArrayList<Categoria> categorias;

    public SistemaGestion() {
        this.estudiantes = new ArrayList<>();
        this.profesores = new ArrayList<>();
        this.cursos = new ArrayList<>();
        this.categorias = new ArrayList<>();
    }

    public void agregarEstudiante(Estudiante e) {
        estudiantes.add(e);
    }

    public void agregarProfesor(Profesor d) {
        profesores.add(d);
    }

    public void agregarCurso(Curso c) {
        cursos.add(c);
    }

    public void agregarCategoria(Categoria cat) {
        categorias.add(cat);
    }

    public void listarEstudiantes() {
        for(Estudiante es : estudiantes) {
            System.out.println(es);
        }
    }

    public void listarProfesores() {
        for(Profesor doc : profesores) {
            System.out.println(doc);
        }
    }

    public void cursosDisponibles() {
        if(!cursos.isEmpty()) {
            for(Curso c : cursos) {
                if(c.getDisponibilidad()) {
                    System.out.println(c);
                }
            }
        } else {
            System.out.println("No hay cursos en existencia");
        }
    }

}
