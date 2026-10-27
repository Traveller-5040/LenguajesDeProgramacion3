package ej2;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DBArreglo {

    private static final Scanner sc = new Scanner(System.in);

    // Clase gestora: guarda los registros en un arreglo y hace las consultas
    private static final GestorEstudiantes gestor = new GestorEstudiantes();

    public static void ejecutar() {
        try {
            // Registrar el controlador y abrir la conexion (misma BD del ejercicio 1)
            Class.forName("org.sqlite.JDBC");
            Connection con = DriverManager.getConnection("jdbc:sqlite:ejemplo.db");

            // Por si este ejercicio se ejecuta antes que el ejercicio 1,
            // se asegura que la tabla exista
            try (Statement stmt = con.createStatement()) {
                stmt.execute("CREATE TABLE IF NOT EXISTS estudiantes ("
                        + "id INTEGER PRIMARY KEY, "
                        + "nombre TEXT NOT NULL, "
                        + "edad INTEGER, "
                        + "carrera TEXT)");
            }

            int opcion;
            do {
                System.out.println("\nMENU");
                System.out.println("1. Consultar registros");
                System.out.println("0. Salir");
                opcion = leerEntero("Elija una opcion: ");

                if (opcion == 1) {
                    try {
                        consulta(con);
                    } catch (SQLException e) {
                        System.out.println("Error de base de datos: " + e.getMessage());
                    }
                } else if (opcion != 0) {
                    System.out.println("Opcion no valida.");
                }
            } while (opcion != 0);

            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // Pide al usuario los 4 parametros de la consulta (a, b, c y d del enunciado)
    // y se los envia al metodo consultar() de la clase gestora.
    private static void consulta(Connection con) throws SQLException {
        // Se vuelve a leer la tabla para que el arreglo tenga los datos mas recientes
        gestor.cargarDesdeBD(con);

        System.out.println("Campos disponibles: id, nombre, edad, carrera");

        // a) Campos a mostrar: se separan por coma y se validan uno por uno
        String entrada = leerTexto("a) Campos a mostrar separados por coma (* = todos): ");
        String[] campos = null; // null significa "mostrar todos"
        if (!entrada.equals("*") && !entrada.isEmpty()) {
            campos = entrada.split("\\s*,\\s*"); // separa por coma ignorando espacios
            for (String c : campos) {
                if (!Estudiante.campoValido(c)) {
                    System.out.println("Campo no valido: " + c);
                    return;
                }
            }
        }

        // b) Condicion (equivale al WHERE). Es opcional.
        String campoCond = null, operador = null, valorCond = null;
        if (leerTexto("b) Desea aplicar una condicion? (s/n): ").equalsIgnoreCase("s")) {
            campoCond = leerTexto("   Campo de la condicion: ");
            if (!Estudiante.campoValido(campoCond)) {
                System.out.println("Campo no valido.");
                return;
            }
            operador = leerTexto("   Operador (=, <>, >, <, >=, <=, contiene): ");
            valorCond = leerTexto("   Valor: ");
        }

        // c) Orden (equivale al ORDER BY). Es opcional.
        String campoOrden = null;
        boolean ascendente = true;
        if (leerTexto("c) Desea ordenar? (s/n): ").equalsIgnoreCase("s")) {
            campoOrden = leerTexto("   Campo para ordenar: ");
            if (!Estudiante.campoValido(campoOrden)) {
                System.out.println("Campo no valido.");
                return;
            }
            // Si escribe "desc" es descendente; cualquier otra cosa se toma como ascendente
            ascendente = !leerTexto("   Direccion (asc/desc): ").equalsIgnoreCase("desc");
        }

        // d) Limite (equivale al LIMIT). 0 significa sin limite.
        int limite = leerEntero("d) Cantidad maxima de registros (0 = todos): ");

        try {
            gestor.consultar(campos, campoCond, operador, valorCond, campoOrden, ascendente, limite);
        } catch (NumberFormatException e) {
            // Pasa si el campo es numerico (id, edad) y el valor escrito no es un numero
            System.out.println("El valor de la condicion debe ser numerico para ese campo.");
        } catch (IllegalArgumentException e) {
            // Pasa si el operador escrito no existe
            System.out.println(e.getMessage());
        }
    }

    // Muestra un mensaje y lee una linea de texto (sin espacios sobrantes).
    private static String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return sc.nextLine().trim();
    }

    // Lee un numero entero; si el usuario escribe otra cosa, vuelve a pedirlo.
    private static int leerEntero(String mensaje) {
        while (true) {
            try {
                return Integer.parseInt(leerTexto(mensaje));
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un numero entero valido.");
            }
        }
    }
}