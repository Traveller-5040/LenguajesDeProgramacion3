package act4;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

class ViewFile extends JFrame {
    private JTextArea areaTexto;

    public ViewFile(String s) {
        super("Mostrando el contenido de un archivo...");
        areaTexto = new JTextArea(s, 5, 40);
        add(areaTexto);
    }
}

public class TestFilePrueba {
    public static void main(String[] args) {
        byte[] b = new byte[1024];
        try (FileInputStream file = new FileInputStream("src/archivos/TestFile.java")) {
            file.read(b);
            String s = new String(b);
            ViewFile view = new ViewFile(s);
            view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            view.setSize(400, 150);
            view.setVisible(true);
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error de lectura: " + e.getMessage());
        }
    }
}