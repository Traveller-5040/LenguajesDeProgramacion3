package act5;

class ArrayPersona {
    // La clase "ArrayPersona" contiene un arreglo de objetos de la clase "Persona",
    // su capacidad maxima y la cantidad de contactos guardados hasta el momento
    public Persona[] arreglo;
    // Cantidad maxima de contactos que puede almacenar el arreglo
    final int max = 128;
    // Cantidad de contactos guardados actualmente (tambien indica la siguiente posicion libre)
    int tamano = 0;

    public ArrayPersona() {
        // Se inicializa el arreglo con la capacidad maxima
        this.arreglo = new Persona[this.max];
    }

    // Metodo que muestra todos los contactos cuyo nombre coincide con el ingresado
    public void printArray(String nombre) {
        // Recorre solo las posiciones ocupadas del arreglo, no las vacias
        for (int i = 0; i < this.tamano; i++) {
            // Compara el nombre sin distinguir mayusculas de minusculas
            if (this.arreglo[i].getNombre().equalsIgnoreCase(nombre)) {
                // Imprime los datos del contacto encontrado
                System.out.println(this.arreglo[i]);
            }
        }
    }

    // Metodo que agrega un contacto en la siguiente posicion libre del arreglo
    public void addArray(Persona persona) {
        // Si el arreglo ya esta lleno se finaliza el programa con codigo de error
        if (this.tamano == max) System.exit(1);
        // Guarda la persona en la posicion libre y aumenta el contador de contactos
        this.arreglo[this.tamano++] = persona;
    }
}
