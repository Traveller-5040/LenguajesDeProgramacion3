package principal; // paquete donde guardamos las clases de la guia

import javax.sound.sampled.*; // importamos las clases de audio (Clip, AudioSystem, AudioInputStream, etc)
import javax.swing.*; // importamos los componentes de swing (JFrame, JButton, JLabel)
import java.awt.*; // importamos los layouts y la clase Color
import java.io.File; // importamos File para leer los archivos wav
import java.io.IOException; // importamos la excepcion que puede saltar al leer el archivo

// Ejercicio 3: reproductor de efectos de sonido con botones
public class Ejercicio3 {

    public static void main(String[] args) { // metodo principal donde arranca el programa
        JFrame frame = new JFrame("Efectos de Sonido"); // creamos la ventana con su titulo
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // hacemos que el programa termine al cerrar la ventana
        frame.setSize(400, 200); // le damos un tamano a la ventana
        frame.setLayout(new BorderLayout()); // usamos BorderLayout para ordenar titulo arriba y botones al centro

        JLabel titulo = new JLabel("Elige un efecto de sonido", SwingConstants.CENTER); // creamos una etiqueta centrada
        titulo.setFont(new Font("Arial", Font.BOLD, 16)); // le ponemos una letra mas grande y en negrita
        frame.add(titulo, BorderLayout.NORTH); // ponemos la etiqueta en la parte de arriba

        JPanel panelBotones = new JPanel(new FlowLayout()); // creamos un panel para poner los botones en fila

        JButton btnAplausos = new JButton("Aplausos"); // creamos el boton de aplausos
        JButton btnCampana = new JButton("Campana"); // creamos el boton de campana
        JButton btnExplosion = new JButton("Explosion"); // creamos el boton de explosion

        btnAplausos.addActionListener(e -> reproducirSonido("sonidos/aplausos.wav")); // al hacer clic se reproduce el sonido de aplausos
        btnCampana.addActionListener(e -> reproducirSonido("sonidos/campana.wav")); // al hacer clic se reproduce el sonido de campana
        btnExplosion.addActionListener(e -> reproducirSonido("sonidos/explosion.wav")); // al hacer clic se reproduce el sonido de explosion

        panelBotones.add(btnAplausos); // agregamos el boton de aplausos al panel
        panelBotones.add(btnCampana); // agregamos el boton de campana al panel
        panelBotones.add(btnExplosion); // agregamos el boton de explosion al panel

        frame.add(panelBotones, BorderLayout.CENTER); // ponemos el panel de botones en el centro de la ventana
        frame.setLocationRelativeTo(null); // centramos la ventana en la pantalla
        frame.setVisible(true); // mostramos la ventana
    }

    // metodo que recibe la ruta de un archivo wav y lo reproduce con un Clip
    public static void reproducirSonido(String ruta) {
        try { // usamos try porque abrir audio puede lanzar excepciones
            File archivo = new File(ruta); // creamos el objeto File con la ruta del sonido
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(archivo); // obtenemos el flujo de audio del archivo
            Clip clip = AudioSystem.getClip(); // pedimos un Clip al sistema de audio
            clip.open(audioStream); // cargamos el audio dentro del clip

            clip.addLineListener(evento -> { // agregamos un listener para saber cuando termina el sonido
                if (evento.getType() == LineEvent.Type.STOP) { // si el evento es que el clip se detuvo
                    clip.close(); // cerramos el clip para liberar memoria
                }
            });

            clip.start(); // empezamos a reproducir el sonido
            System.out.println("Reproduciendo: " + ruta); // mostramos en consola que sonido se esta reproduciendo
        } catch (UnsupportedAudioFileException ex) { // si el formato del archivo no es soportado
            System.out.println("El formato del archivo no es valido, tiene que ser wav"); // avisamos en consola
        } catch (IOException ex) { // si no se encuentra el archivo o no se puede leer
            System.out.println("No se encontro el archivo: " + ruta); // avisamos en consola
        } catch (LineUnavailableException ex) { // si la linea de audio esta ocupada o no existe
            System.out.println("No se pudo abrir la linea de audio"); // avisamos en consola
        }
    }
}
