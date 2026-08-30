import entidades.*;
import cursos.*;
import gestion.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        // ==================================
        // SISTEMA DE GESTION
        // ==================================

        SistemaGestion sistema = new SistemaGestion();

        // ==================================
        // CATEGORIAS
        // ==================================

        Categoria cat1 = new Categoria("Programacion");
        Categoria cat2 = new Categoria("Bases de Datos");
        Categoria cat3 = new Categoria("Infraestructura y Redes");

        sistema.agregarCategoria(cat1);
        sistema.agregarCategoria(cat2);
        sistema.agregarCategoria(cat3);

        // ==================================
        // PROFESORES
        // ==================================

        Profesor prof1 = new Profesor(
                "Manuel Zuniga",
                "34562378",
                "P001"
        );

        Profesor prof2 = new Profesor(
                "Carlo Corrales",
                "41235678",
                "P002"
        );

        Profesor prof3 = new Profesor(
                "Angel Montesinos",
                "45678912",
                "P003"
        );

        Profesor prof4 = new Profesor(
                "Jose Esquicha",
                "40123567",
                "P004"
        );

        Profesor prof5 = new Profesor(
                "Marisol Galarza",
                "47892345",
                "P005"
        );

        sistema.agregarProfesor(prof1);
        sistema.agregarProfesor(prof2);
        sistema.agregarProfesor(prof3);
        sistema.agregarProfesor(prof4);
        sistema.agregarProfesor(prof5);


        // ==================================
        // ESTUDIANTES
        // ==================================

        Estudiante est1 = new Estudiante(
                "Jose Perez",
                "60315842",
                "2027000234"
        );

        Estudiante est2 = new Estudiante(
                "Gabriel Torres",
                "70452361",
                "2027000156"
        );

        Estudiante est3 = new Estudiante(
                "Luis Garcia",
                "71234567",
                "2027000189"
        );

        Estudiante est4 = new Estudiante(
                "Andrea Flores",
                "72345678",
                "2027000201"
        );

        Estudiante est5 = new Estudiante(
                "Carlos Vargas",
                "73456789",
                "2027000215"
        );

        Estudiante est6 = new Estudiante(
                "Daniela Condori",
                "74567891",
                "2027000248"
        );

        Estudiante est7 = new Estudiante(
                "Miguel Torres",
                "75678912",
                "2027000273"
        );

        sistema.agregarEstudiante(est1);
        sistema.agregarEstudiante(est2);
        sistema.agregarEstudiante(est3);
        sistema.agregarEstudiante(est4);
        sistema.agregarEstudiante(est5);
        sistema.agregarEstudiante(est6);
        sistema.agregarEstudiante(est7);


        // ==================================
        // CURSOS
        // ==================================

        Curso curso1 = new CursoTeorico(
                "Lenguajes de programacion III",
                "SIS201",
                prof5,
                cat1
        );

        Curso curso2 = new CursoPractico(
                "Infraestructura de Tecnologias de la Informacion",
                "SIS202",
                prof4,
                cat3
        );

        Curso curso3 = new CursoTeorico(
                "Estructuras Discretas",
                "SIS301",
                prof2,
                cat2
        );

        Curso curso4 = new CursoPractico(
                "SIA I",
                "SIS401",
                prof1,
                cat3
        );

        Curso curso5 = new CursoTeorico(
                "Desarrollo de Aplicaciones",
                "SIS402",
                prof3,
                cat3
        );

        sistema.agregarCurso(curso1);
        sistema.agregarCurso(curso2);
        sistema.agregarCurso(curso3);
        sistema.agregarCurso(curso4);
        sistema.agregarCurso(curso5);

        // MATRICULA DE ESTUDIANTES

        est1.inscribir(curso1);
        est1.inscribir(curso3);

        est2.inscribir(curso1);
        est2.inscribir(curso2);

        est3.inscribir(curso1);
        est3.inscribir(curso4);

        est4.inscribir(curso2);
        est4.inscribir(curso3);

        est5.inscribir(curso3);
        est5.inscribir(curso5);

        est6.inscribir(curso4);
        est6.inscribir(curso5);

        est7.inscribir(curso1);
        est7.inscribir(curso5);

        // LISTAR ESTUDIANTES

        System.out.println("\n==========================================");
        System.out.println("              ESTUDIANTES");
        System.out.println("==========================================");

        sistema.listarEstudiantes();

        // LISTAR PROFESORES

        System.out.println("\n==========================================");
        System.out.println("               PROFESORES");
        System.out.println("==========================================");

        sistema.listarProfesores();

        // MOSTRAR CURSOS

        System.out.println("\n==========================================");
        System.out.println("                 CURSOS");
        System.out.println("==========================================");

        System.out.println(curso1);
        System.out.println(curso2);
        System.out.println(curso3);
        System.out.println(curso4);
        System.out.println(curso5);

        // CURSOS DISPONIBLES

        System.out.println("\n==========================================");
        System.out.println("          CURSOS DISPONIBLES");
        System.out.println("==========================================");

        sistema.cursosDisponibles();

        // CANTIDAD DE MATRICULADOS

        System.out.println("\n==========================================");
        System.out.println("          CANTIDAD DE MATRICULADOS");
        System.out.println("==========================================");

        System.out.println(curso1.getNombre() + ": "  + curso1.getCantidad() + " estudiantes");

        System.out.println(curso2.getNombre() + ": " + curso2.getCantidad() + " estudiantes");

        System.out.println(curso3.getNombre() + ": " + curso3.getCantidad() + " estudiantes");

        System.out.println(curso4.getNombre() + ": " + curso4.getCantidad() + " estudiantes");

        System.out.println(curso5.getNombre() + ": " + curso5.getCantidad() + " estudiantes");

        // CURSOS DE CADA PROFESOR

        System.out.println("\n==========================================");
        System.out.println("          CURSOS POR PROFESOR");
        System.out.println("==========================================");

        System.out.println("\nCursos de " + prof1.getNombre() + ":");
        prof1.mostrarCursos();

        System.out.println("\nCursos de " + prof2.getNombre() + ":");
        prof2.mostrarCursos();

        System.out.println("\nCursos de " + prof3.getNombre() + ":");
        prof3.mostrarCursos();

        System.out.println("\nCursos de " + prof4.getNombre() + ":");
        prof4.mostrarCursos();

        System.out.println("\nCursos de " + prof5.getNombre() + ":");
        prof5.mostrarCursos();

        // CURSOS DE CADA ESTUDIANTE

        System.out.println("\n==========================================");
        System.out.println("          CURSOS POR ESTUDIANTE");
        System.out.println("==========================================");

        System.out.println("\nCursos de " + est1.getNombre() + ":");
        est1.mostrarCursos();

        System.out.println("\nCursos de " + est2.getNombre() + ":");
        est2.mostrarCursos();

        System.out.println("\nCursos de " + est3.getNombre() + ":");
        est3.mostrarCursos();

        System.out.println("\nCursos de " + est4.getNombre() + ":");
        est4.mostrarCursos();

        System.out.println("\nCursos de " + est5.getNombre() + ":");
        est5.mostrarCursos();

        System.out.println("\nCursos de " + est6.getNombre() + ":");
        est6.mostrarCursos();

        System.out.println("\nCursos de " + est7.getNombre() + ":");
        est7.mostrarCursos();

        // COMPROBAR DISPONIBILIDAD

        System.out.println("\n==========================================");
        System.out.println("       ESTADO DE LOS CURSOS");
        System.out.println("==========================================");

        sistema.cursosDisponibles();
    }
}
