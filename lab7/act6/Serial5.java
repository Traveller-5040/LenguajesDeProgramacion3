package act6;

import java.io.*;

public class Serial5 {
    public static void main(String[] args) {
        try (FileOutputStream fos = new FileOutputStream("src/archivos/alumnos.dat");
             ObjectOutputStream salida = new ObjectOutputStream(fos)) {

            Fecha f = new Fecha(5, 9, 2011);
            Alumno a = new Alumno("12345678A", "Lucas González", 20, f);
            salida.writeObject(a);

            f = new Fecha(7, 9, 2011);
            a = new Alumno("98765432B", "Anacleto Jiménez", 19, f);
            salida.writeObject(a);

            f = new Fecha(8, 9, 2011);
            a = new Alumno("782342122", "María Zapata", 21, f);
            salida.writeObject(a);

            System.out.println("Alumnos serializados correctamente con composición.");
        } catch (IOException e) {
            System.out.println("Error en serialización: " + e.getMessage());
        }
    }
}