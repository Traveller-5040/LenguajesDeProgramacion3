package ej2;

public class Estudiante {

    // Nombres de los campos de la tabla (sirven para validar lo que escribe el usuario)
    public static final String[] CAMPOS = {"id", "nombre", "edad", "carrera"};

    // Atributos: uno por cada columna de la tabla
    private int id;
    private String nombre;
    private int edad;
    private String carrera;

    public Estudiante(int id, String nombre, int edad, String carrera) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.carrera = carrera;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public int getEdad() { return edad; }
    public String getCarrera() { return carrera; }

    /**
     * Devuelve el valor de un campo a partir de su nombre (como texto).
     * Esto permite que el gestor filtre, ordene y muestre por cualquier campo
     * sin escribir codigo distinto para cada uno.
     * Retorna Integer para id/edad y String para nombre/carrera.
     * Retorna null si el campo no existe.
     */
    public Object getValor(String campo) {
        switch (campo.toLowerCase()) {
            case "id":      return id;
            case "nombre":  return nombre;
            case "edad":    return edad;
            case "carrera": return carrera;
            default:        return null;
        }
    }

    // Indica si el texto recibido es un nombre de campo existente.
    public static boolean campoValido(String campo) {
        for (String c : CAMPOS) {
            if (c.equalsIgnoreCase(campo)) return true;
        }
        return false;
    }
}