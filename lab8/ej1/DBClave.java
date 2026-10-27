package ej1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DBClave {

    // Clave que el usuario debe ingresar para confirmar los cambios
    private static final String CLAVE = "1234";

    // Scanner unico para leer datos por consola en toda la clase
    private static final Scanner sc = new Scanner(System.in);

    public static void ejecutar() {
        try {
            // PASO 1 (JDBC): registrar el controlador de SQLite
            Class.forName("org.sqlite.JDBC");

            // PASO 2 (JDBC): abrir la conexion. Si ejemplo.db no existe, SQLite lo crea
            Connection con = DriverManager.getConnection("jdbc:sqlite:ejemplo.db");
            System.out.println("Se creo y/o abrio la base de datos.");

            // Desactivamos el autocommit: asi los cambios quedan "pendientes"
            // hasta que nosotros llamemos a commit() o rollback()
            con.setAutoCommit(false);

            // PASO 3 (JDBC): crear la sentencia y crear la tabla de 4 campos.
            // IF NOT EXISTS evita error si la tabla ya fue creada antes.
            // El try-with-resources cierra el Statement automaticamente.
            try (Statement stmt = con.createStatement()) {
                stmt.execute("CREATE TABLE IF NOT EXISTS estudiantes ("
                        + "id INTEGER PRIMARY KEY, "
                        + "nombre TEXT NOT NULL, "
                        + "edad INTEGER, "
                        + "carrera TEXT)");
            }
            con.commit(); // confirmamos la creacion de la tabla

            // Bucle del menu: se repite hasta que el usuario elija 0
            int opcion;
            do {
                System.out.println("\nMENU");
                System.out.println("1. Ingresar registro");
                System.out.println("2. Borrar registro");
                System.out.println("3. Actualizar registro");
                System.out.println("4. Mostrar registros");
                System.out.println("0. Salir");
                opcion = leerEntero("Elija una opcion: ");

                try {
                    switch (opcion) {
                        case 1: ingresar(con);   break;
                        case 2: borrar(con);     break;
                        case 3: actualizar(con); break;
                        case 4: mostrar(con);    break;
                        case 0: System.out.println("Finalizando programa..."); break;
                        default: System.out.println("Opcion no valida.");
                    }
                } catch (SQLException e) {
                    // Si alguna operacion falla (por ejemplo un ID repetido),
                    // se revierte lo pendiente para no dejar la BD a medias
                    System.out.println("Error de base de datos: " + e.getMessage());
                    con.rollback();
                }
            } while (opcion != 0);

            // PASO 5 (JDBC): cerrar la conexion
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // Inserta un registro nuevo y pide la clave para confirmarlo.
    private static void ingresar(Connection con) throws SQLException {
        int id = leerEntero("ID: ");
        String nombre = leerTexto("Nombre: ");
        int edad = leerEntero("Edad: ");
        String carrera = leerTexto("Carrera: ");

        // PreparedStatement: los "?" se reemplazan por los valores con los setXxx.
        // Es mas seguro y rapido que concatenar texto en el SQL.
        PreparedStatement ps = con.prepareStatement(
                "INSERT INTO estudiantes (id, nombre, edad, carrera) VALUES (?,?,?,?)");
        ps.setInt(1, id);          // 1er "?" = id
        ps.setString(2, nombre);   // 2do "?" = nombre
        ps.setInt(3, edad);        // 3er "?" = edad
        ps.setString(4, carrera);  // 4to "?" = carrera
        ps.executeUpdate();        // ejecuta el INSERT (aun sin confirmar)
        ps.close();

        confirmar(con); // aqui se decide commit o rollback segun la clave
    }

    // Borra el registro con el ID indicado y pide la clave para confirmarlo.
    private static void borrar(Connection con) throws SQLException {
        int id = leerEntero("ID del registro a borrar: ");

        PreparedStatement ps = con.prepareStatement("DELETE FROM estudiantes WHERE id = ?");
        ps.setInt(1, id);

        // executeUpdate devuelve cuantas filas fueron afectadas
        int filas = ps.executeUpdate();
        ps.close();

        if (filas == 0) {
            // Ninguna fila coincidio con ese ID: no hay nada que confirmar
            System.out.println("No existe un registro con ese ID.");
            con.rollback();
        } else {
            confirmar(con);
        }
    }

    // Actualiza los datos del registro con el ID indicado y pide la clave.
    private static void actualizar(Connection con) throws SQLException {
        int id = leerEntero("ID del registro a actualizar: ");
        String nombre = leerTexto("Nuevo nombre: ");
        int edad = leerEntero("Nueva edad: ");
        String carrera = leerTexto("Nueva carrera: ");

        PreparedStatement ps = con.prepareStatement(
                "UPDATE estudiantes SET nombre = ?, edad = ?, carrera = ? WHERE id = ?");
        ps.setString(1, nombre);
        ps.setInt(2, edad);
        ps.setString(3, carrera);
        ps.setInt(4, id); // el WHERE usa el ultimo "?"
        int filas = ps.executeUpdate();
        ps.close();

        if (filas == 0) {
            System.out.println("No existe un registro con ese ID.");
            con.rollback();
        } else {
            confirmar(con);
        }
    }

    // Muestra todos los registros de la tabla.
    private static void mostrar(Connection con) throws SQLException {
        Statement stmt = con.createStatement();

        // executeQuery se usa para SELECT y devuelve un ResultSet con las filas
        ResultSet rs = stmt.executeQuery("SELECT * FROM estudiantes");

        // Encabezado de la tabla (%-20s = texto alineado a la izquierda en 20 espacios)
        System.out.printf("%n%-6s%-20s%-6s%-20s%n", "ID", "NOMBRE", "EDAD", "CARRERA");
        System.out.println("-".repeat(52));

        // rs.next() avanza a la siguiente fila y devuelve false cuando ya no hay mas.
        // Las columnas se leen por posicion: 1=id, 2=nombre, 3=edad, 4=carrera
        while (rs.next()) {
            System.out.printf("%-6d%-20s%-6d%-20s%n",
                    rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4));
        }
        rs.close();
        stmt.close();
    }

    /**
     * Pide la clave al usuario.
     * Clave correcta   -> commit()   (los cambios se guardan en la BD)
     * Clave incorrecta -> rollback() (los cambios se descartan)
     */
    private static void confirmar(Connection con) throws SQLException {
        String clave = leerTexto("Ingrese la clave para confirmar los cambios: ");
        if (CLAVE.equals(clave)) {
            con.commit();
            System.out.println("Clave correcta. Cambios confirmados.");
        } else {
            con.rollback();
            System.out.println("Clave incorrecta. Cambios revertidos.");
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