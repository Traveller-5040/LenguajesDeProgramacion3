package ej4;

import java.util.NoSuchElementException;

public class RegistroTest {
    public static void main(String[] args) {
        RegistroEstudiantes est = new RegistroEstudiantes();

        try {
            est.agregarEstudiante("Juan");
            est.agregarEstudiante("Marcus");
            est.agregarEstudiante("Francisco");
            //est.agregarEstudiante("");

            System.out.println("Alumno encontrado: " + est.buscarEstudiante("marcus"));
            System.out.println(est.buscarEstudiante("jose"));
        }
        catch(IllegalArgumentException e) {
            System.err.println("Error argumental: " + e.getMessage());
        }
        catch(NoSuchElementException e) {
            System.err.println("Error de busqueda: " + e.getMessage());
        }
    }
}
