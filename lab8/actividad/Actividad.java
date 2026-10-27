package actividad;

import java.sql.*;
import java.util.Objects;

public class Actividad {
    public static void main(String[] args) {
        try {
            // Registrar controlador y establecer conexion con la base de datos
            Class.forName("org.sqlite.JDBC");
            new java.io.File("datos").mkdir();
            Connection con = DriverManager.getConnection("jdbc:sqlite:datos/act1.db");

            // Si la conexion cambia a un estado diferente de null, se imprime un mensaje
            // de confirmacion
            if(con != null){
                System.out.println("Conexion establecida\n");
            }

            // Creacion de la tabla "juegos"
            Statement stm = con.createStatement();
            stm.executeUpdate("CREATE TABLE IF NOT EXISTS juegos (id integer PRIMARY KEY, name TEXT, launch INTEGER);");

            // Interfaz Prepared Statement para insertar registros a la tabla
            PreparedStatement pstmIn = con.prepareStatement("INSERT INTO juegos VALUES (?, ?, ?);");

            int i = 0;

            pstmIn.setInt(1, 1);
            pstmIn.setString(2, "Red Dead Revolver");
            pstmIn.setInt(3, 2004);
            i += pstmIn.executeUpdate();

            pstmIn.setInt(1, 2);
            pstmIn.setString(2, "Red Dead Redemption");
            pstmIn.setInt(3, 2009);
            i += pstmIn.executeUpdate();

            pstmIn.setInt(1, 3);
            pstmIn.setString(2, "Red Dead Redemption II");
            pstmIn.setInt(3, 2018);
            i += pstmIn.executeUpdate();

            System.out.println(i + " registros guardados correctamente\n");

            // Actualizar registros usando preparedStatement
            PreparedStatement pstmUp = con.prepareStatement("UPDATE juegos SET name = ? WHERE id = ?");
            pstmUp.setString(1, "RDR");
            pstmUp.setInt(2, 2);
            pstmUp.executeUpdate();

            pstmUp.setString(1, "RDR II");
            pstmUp.setInt(2, 3);
            pstmUp.executeUpdate();

            int j = pstmUp.executeUpdate();
            System.out.println(j + " registros actualizados correctamente\n");

            // Recuperar e imprimir los registros
            ResultSet rs = stm.executeQuery("SELECT * FROM juegos;"); // Obtiene todos los registros de la tabla
            System.out.println("<<<<<<<<<< REGISTROS DE LA TABLA 'JUEGOS' >>>>>>>>>>");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt(1) + " | " + "Nombre: " + rs.getString(2) + " | " + "Lanzamiento: " + rs.getInt(3));
            }

            // Manejo de Transacciones
            con.setAutoCommit(false); // Establece el autoCommit en false para controlar el guardado de los cambios
            try {
                stm.executeUpdate("INSERT INTO juegos VALUES(3, 'RDR ONLINE', 2018);");
                con.commit();
                System.out.println("Registro guardado correctamente: ");
            } catch (Exception e) {
                // Al querer usar una id ocupada por otro registro, se retorna una excepcion no sin antes
                // usar rollback para deshacer todos los cambios realizados
                con.rollback();
                System.err.println("Transaccion revertida, razon: " + e.getMessage());
            }

            // Eliminar un registro [usando preparedStatement]
            PreparedStatement pstmDl = con.prepareStatement("DELETE FROM juegos WHERE id = ?;");
            pstmDl.setInt(1, 3);
            pstmDl.executeUpdate();

            System.out.println("Registro borrado exitosamente\n");

            // Resultado final de los registros
            ResultSet rsF = stm.executeQuery("SELECT * FROM juegos;");
            System.out.println("<<<<<<<<<< REGISTROS DE LA TABLA 'JUEGOS' >>>>>>>>>>");
            while (rsF.next()) {
                System.out.println("ID: " + rsF.getInt(1) + " | " + "Nombre: " + rsF.getString(2) + " | " + "Lanzamiento: " + rsF.getInt(3));
            }

            // Se cierra la conexion para liberar recursos del sistema
            con.close();
        } catch (SQLException | ClassNotFoundException e) {
            System.err.println(e.getMessage());
        }
    }
}
