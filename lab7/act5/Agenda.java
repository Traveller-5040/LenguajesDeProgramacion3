package act5;

import java.io.*;

class Agenda {
    // La clase "Agenda" contiene la lista de contactos, el archivo del que se cargan
    // y la longitud maxima de cada linea que se lee
    ArrayPersona lista;
    FileInputStream agendaFile;
    // Cantidad maxima de caracteres que se leen por linea
    final int longLinea = 32;

    public Agenda() {
        // Al crear la agenda se cargan de inmediato los contactos guardados en el archivo
        this.lista = cargaContactos();
    }

    // Metodo que permite buscar contactos por nombre, utiliza un bucle while para
    // que el usuario decida cuando finalizar el programa (ingresando solo <Enter>)
    public void bucle() {
        try {
            System.out.println("Introduzca un nombre o <Enter> para salir:");
            String nombre;
            // Lee el nombre ingresado por teclado y repite mientras no este vacio
            while (!"".equals(nombre = leeEntrada(System.in))) {
                // Muestra los contactos que coinciden con el nombre ingresado
                lista.printArray(nombre);
                System.out.println("Introduzca un nombre o <Enter> para salir:");
            }
        } catch (Exception e) {
            // Si ocurre algun error de lectura se muestra su mensaje
            System.out.println(e.getMessage());
        }
    }

    // Metodo que lee una linea de texto byte por byte desde el flujo indicado (teclado o archivo)
    // y la retorna como String; retorna null si se llego al final del flujo
    private String leeEntrada(InputStream entrada) throws IOException {
        // Cantidad de bytes leidos hasta el momento
        int contador = 0;
        // Arreglo donde se guardan los bytes de la linea, con un maximo de longLinea
        byte[] chars = new byte[longLinea];
        // Lee un byte a la vez hasta encontrar un salto de linea o llenar el arreglo
        while (contador < longLinea && (chars[contador++] = (byte) entrada.read()) != '\n') {
            // El valor -1 indica que ya no hay mas datos por leer
            if (chars[contador - 1] == -1) return null;
        }
        // Si la linea solo contiene un retorno de carro se considera vacia
        if (contador == 1 && chars[0] == '\r') return "";
        // Convierte los bytes leidos en texto (sin contar el salto de linea) y elimina espacios sobrantes
        return new String(chars, 0, contador - 1).trim();
    }

    // Metodo que lee del archivo los datos de un contacto (nombre, telefono y direccion,
    // cada uno en una linea) y retorna la Persona creada; retorna null si ya no hay mas contactos
    private Persona cargaAgenda() throws IOException {
        String nombre = leeEntrada(agendaFile);
        // Un nombre nulo o vacio indica que se llego al final de los contactos
        if (nombre == null || nombre.isEmpty()) return null;
        // Las siguientes dos lineas corresponden al telefono y a la direccion del contacto
        String telefono = leeEntrada(agendaFile);
        String direccion = leeEntrada(agendaFile);
        return new Persona(nombre, telefono, direccion);
    }

    // Metodo que abre el archivo de la agenda, carga todos los contactos en un
    // ArrayPersona y lo retorna (queda vacio si el archivo no existe o falla la lectura)
    private ArrayPersona cargaContactos() {
        // Se crea el arreglo que almacenara los contactos leidos
        ArrayPersona directorio = new ArrayPersona();
        try {
            // Abre el archivo de la agenda para leerlo
            agendaFile = new FileInputStream("src/archivos/agenda.txt");
            Persona nuevaPersona;
            // Lee contacto por contacto hasta que ya no haya mas
            while (true) {
                nuevaPersona = cargaAgenda();
                if (nuevaPersona == null) break;
                // Agrega el contacto leido al directorio
                directorio.addArray(nuevaPersona);
            }
            // Cierra el archivo para liberar el recurso
            agendaFile.close();
        } catch (FileNotFoundException e) {
            // Se ejecuta cuando la ruta del archivo no existe
            System.out.println("No hay archivo de agenda");
        } catch (Exception e) {
            // Cualquier otro error durante la lectura se informa al usuario
            System.out.println("Error en la carga de los contactos: " + e.getMessage());
        }
        return directorio;
    }
}
