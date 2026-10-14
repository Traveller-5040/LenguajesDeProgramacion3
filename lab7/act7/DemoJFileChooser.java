package act7;

import javax.swing.*;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;

class DemoJFileChooser extends JFrame {
    // La clase "DemoJFileChooser" es una ventana que permite elegir un archivo o directorio
    // y muestra en un area de texto la informacion de la ruta seleccionada
    private final JTextArea areaSalida;

    public DemoJFileChooser() throws IOException {
        // Se asigna el titulo de la ventana llamando al constructor de la clase padre
        super("Demo de JFileChooser");
        // Se crea el area de texto donde se mostrara la informacion
        areaSalida = new JTextArea();
        // Se agrega el area dentro de un JScrollPane para que tenga barras de desplazamiento
        add(new JScrollPane(areaSalida));
        // Al crear la ventana se pide la ruta y se analiza de inmediato
        analizarRuta();
    }

    // Metodo que muestra la informacion de la ruta elegida por el usuario: nombre, tipo,
    // fechas, tamanio y, si es un directorio, tambien su contenido
    public void analizarRuta() throws IOException {
        // Se abre el selector de archivos y se guarda la ruta elegida
        Path ruta = obtenerRutaArchivoDirectorio();
        // Verifica que la ruta exista antes de leer sus datos
        if (ruta != null && Files.exists(ruta)) {
            // El StringBuilder junta todas las lineas de informacion en un solo texto
            StringBuilder builder = new StringBuilder();
            // Nombre del archivo o directorio
            builder.append(String.format("%s:%n", ruta.getFileName()));
            // Indica si la ruta es un directorio o un archivo
            builder.append(String.format("%s un directorio%n", Files.isDirectory(ruta) ? "Es" : "No es"));
            // Indica si la ruta es absoluta o relativa
            builder.append(String.format("%s una ruta absoluta%n", ruta.isAbsolute() ? "Es" : "No es"));
            // Fecha de la ultima modificacion del archivo
            builder.append(String.format("Ultima modificacion: %s%n", Files.getLastModifiedTime(ruta)));
            // Tamanio del archivo en bytes
            builder.append(String.format("Tamanio: %s bytes%n", Files.size(ruta)));
            // Ruta tal como fue seleccionada y su version absoluta
            builder.append(String.format("Ruta: %s%n", ruta));
            builder.append(String.format("Ruta absoluta: %s%n", ruta.toAbsolutePath()));

            // Si la ruta es un directorio, se agrega la lista de lo que contiene
            if (Files.isDirectory(ruta)) {
                builder.append(String.format("%nContenido del directorio:%n"));
                // El try-with-resources cierra el flujo del directorio automaticamente
                try (DirectoryStream<Path> flujoDirectorio = Files.newDirectoryStream(ruta)) {
                    // Recorre cada archivo o subdirectorio y agrega su ruta al texto
                    for (Path p : flujoDirectorio) {
                        builder.append(String.format("%s%n", p));
                    }
                }
            }
            // Muestra todo el texto armado en el area de salida
            areaSalida.setText(builder.toString());
        } else if (ruta != null) {
            // Si la ruta no existe, se avisa al usuario con un cuadro de dialogo de error
            JOptionPane.showMessageDialog(this, ruta.getFileName() + " no existe.", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Metodo que abre el selector de archivos y retorna la ruta elegida por el usuario
    private Path obtenerRutaArchivoDirectorio() {
        // Se crea el selector y se configura para poder elegir archivos y directorios
        JFileChooser selectorArchivos = new JFileChooser();
        selectorArchivos.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        // Muestra el cuadro de dialogo para abrir y guarda la opcion que eligio el usuario
        int resultado = selectorArchivos.showOpenDialog(this);

        // Si el usuario cancela la seleccion, se finaliza el programa
        if (resultado == JFileChooser.CANCEL_OPTION) {
            System.exit(0);
        }
        // Convierte el archivo seleccionado en un objeto Path y lo retorna
        return selectorArchivos.getSelectedFile().toPath();
    }
}