package ejercicio4; // paquete donde guardamos las clases de la guia

import javax.sound.sampled.*; // importamos las clases de audio (Clip, AudioSystem, AudioInputStream, etc)
import javax.swing.*; // importamos los componentes de swing (JFrame, JButton, JLabel)
import java.awt.*; // importamos los layouts y la clase Font
import java.io.File; // importamos File para leer el archivo wav
import java.io.IOException; // importamos la excepcion que puede saltar al leer el archivo

// Ejercicio 4: reproductor de musica con Reproducir, Pausar y Reanudar
public class Ejercicio4 {

    static Clip clip; // aqui guardamos el clip con la cancion para usarlo en todos los botones
    static long posicionPausa = 0; // aqui guardamos en que microsegundo se pauso la cancion
    static JLabel lblEstado; // etiqueta para mostrar el estado del reproductor

    public static void main(String[] args) { // metodo principal donde arranca el programa
        JFrame frame = new JFrame("Reproductor de Musica"); // creamos la ventana con su titulo
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // hacemos que el programa termine al cerrar la ventana
        frame.setSize(420, 180); // le damos un tamano a la ventana
        frame.setLayout(new BorderLayout()); // usamos BorderLayout para ordenar estado arriba y botones al centro

        lblEstado = new JLabel("Estado: detenido", SwingConstants.CENTER); // creamos la etiqueta del estado centrada
        lblEstado.setFont(new Font("Arial", Font.BOLD, 16)); // le ponemos una letra mas grande y en negrita
        frame.add(lblEstado, BorderLayout.NORTH); // ponemos la etiqueta en la parte de arriba

        JPanel panelBotones = new JPanel(new FlowLayout()); // creamos un panel para poner los botones en fila

        JButton btnReproducir = new JButton("Reproducir"); // creamos el boton para reproducir desde el inicio
        JButton btnPausar = new JButton("Pausar"); // creamos el boton para pausar
        JButton btnReanudar = new JButton("Reanudar"); // creamos el boton para reanudar

        btnReproducir.addActionListener(e -> reproducir()); // al hacer clic llamamos al metodo reproducir
        btnPausar.addActionListener(e -> pausar()); // al hacer clic llamamos al metodo pausar
        btnReanudar.addActionListener(e -> reanudar()); // al hacer clic llamamos al metodo reanudar

        panelBotones.add(btnReproducir); // agregamos el boton reproducir al panel
        panelBotones.add(btnPausar); // agregamos el boton pausar al panel
        panelBotones.add(btnReanudar); // agregamos el boton reanudar al panel

        frame.add(panelBotones, BorderLayout.CENTER); // ponemos el panel de botones en el centro de la ventana

        cargarAudio("C:/Users/Admin/Downloads/CTR.wav"); // cargamos la cancion una sola vez al iniciar el programa

        frame.setLocationRelativeTo(null); // centramos la ventana en la pantalla
        frame.setVisible(true); // mostramos la ventana
    }

    // metodo que abre el archivo wav y lo deja listo dentro del clip
    public static void cargarAudio(String ruta) {
        try { // usamos try porque abrir audio puede lanzar excepciones
            File archivo = new File(ruta); // creamos el objeto File con la ruta de la cancion
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(archivo); // obtenemos el flujo de audio del archivo
            clip = AudioSystem.getClip(); // pedimos un Clip al sistema de audio
            clip.open(audioStream); // cargamos la cancion dentro del clip
            System.out.println("Cancion cargada: " + ruta); // avisamos en consola que se cargo bien
        } catch (UnsupportedAudioFileException ex) { // si el formato del archivo no es soportado
            System.out.println("El formato del archivo no es valido, tiene que ser wav"); // avisamos en consola
        } catch (IOException ex) { // si no se encuentra el archivo o no se puede leer
            System.out.println("No se encontro el archivo: " + ruta); // avisamos en consola
        } catch (LineUnavailableException ex) { // si la linea de audio esta ocupada o no existe
            System.out.println("No se pudo abrir la linea de audio"); // avisamos en consola
        }
    }

    // metodo para reproducir la cancion desde el inicio
    public static void reproducir() {
        if (clip == null) { // si el clip no se cargo no podemos reproducir nada
            System.out.println("No hay cancion cargada"); // avisamos en consola
            return; // salimos del metodo
        }
        clip.stop(); // detenemos el clip por si ya estaba sonando
        clip.setFramePosition(0); // regresamos la cancion al inicio
        posicionPausa = 0; // reiniciamos la posicion guardada
        clip.start(); // empezamos a reproducir
        lblEstado.setText("Estado: reproduciendo"); // actualizamos la etiqueta
        System.out.println("Reproduciendo desde el inicio"); // mostramos en consola
    }

    // metodo para pausar la cancion y guardar donde se quedo
    public static void pausar() {
        if (clip != null && clip.isRunning()) { // solo pausamos si hay clip y esta sonando
            posicionPausa = clip.getMicrosecondPosition(); // guardamos la posicion actual en microsegundos
            clip.stop(); // detenemos el clip
            lblEstado.setText("Estado: en pausa"); // actualizamos la etiqueta
            System.out.println("Pausado en el segundo: " + (posicionPausa / 1000000)); // mostramos en que segundo se pauso
        } else { // si no esta sonando
            System.out.println("No se puede pausar, la cancion no esta sonando"); // avisamos en consola
        }
    }

    // metodo para continuar la cancion desde donde se pauso
    public static void reanudar() {
        if (clip != null && !clip.isRunning() && posicionPausa > 0) { // solo reanudamos si hay clip, esta detenido y se pauso antes
            clip.setMicrosecondPosition(posicionPausa); // ponemos el clip en la posicion donde se pauso
            clip.start(); // continuamos la reproduccion
            lblEstado.setText("Estado: reproduciendo"); // actualizamos la etiqueta
            System.out.println("Reanudando desde el segundo: " + (posicionPausa / 1000000)); // mostramos desde que segundo continua
        } else { // si no se cumple lo anterior
            System.out.println("No hay nada que reanudar"); // avisamos en consola
        }
    }
}
