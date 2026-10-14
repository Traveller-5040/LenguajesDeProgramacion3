package act6;

class Alumno extends PersonaBase {
    // La clase "Alumno" hereda de "PersonaBase" (nif, nombre y edad)
    // y agrega como atributo propio la fecha de matricula
    private Fecha fechaMatricula;

    public Alumno(String nif, String nombre, int edad, Fecha fechaMatricula) {
        // Se inicializan los atributos heredados llamando al constructor de la clase padre
        super(nif, nombre, edad);
        // Se inicializa el atributo propio de la clase Alumno
        this.fechaMatricula = fechaMatricula;
    }

    // Se implementa el metodo de instancia que retorna la fecha
    // de matricula del alumno cuando sea necesario
    public Fecha getFechaMatricula() { return fechaMatricula; }
}