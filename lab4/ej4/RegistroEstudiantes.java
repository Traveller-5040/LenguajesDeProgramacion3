/*Registro de Estudiantes: Diseña una clase RegistroEstudiantes que permita agregar
estudiantes a un arreglo y buscar estudiantes por su nombre. Implementa el método
agregarEstudiante() para que lance una IllegalArgumentException si el nombre es nulo
o vacío, y el método buscarEstudiante() para que lance una NoSuchElementException
si el estudiante no está en el arreglo. Asegúrate de manejar estas excepciones en
el código de invocación utilizando bloques catch adecuados.*/

package ej4;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class RegistroEstudiantes {
    private ArrayList<String> estudiantes;

    public RegistroEstudiantes() {
        this.estudiantes = new ArrayList<>();
    }

    public void agregarEstudiante(String est) {
        if(est == null || est.isEmpty()) {
            throw new IllegalArgumentException("No es posible agregar valores invalidos o nulos");
        }
        this.estudiantes.add(est);
    }

    public String buscarEstudiante(String sEst) {
        for(String e : estudiantes) {
            if(e.equalsIgnoreCase(sEst)) {
                return e;
            }
        }
        throw new NoSuchElementException("No se pudo encontrar al elemento deseado");
    }
}
