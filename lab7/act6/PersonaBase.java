package act6;

import java.io.Serializable;

class PersonaBase implements Serializable {
    private String nif, nombre;
    private int edad;

    public PersonaBase(String nif, String nombre, int edad) {
        this.nif = nif;
        this.nombre = nombre;
        this.edad = edad;
    }
}