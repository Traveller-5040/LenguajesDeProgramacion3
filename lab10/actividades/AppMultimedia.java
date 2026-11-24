package actividades;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class AppMultimedia extends JFrame {
    private MediaPlayer mediaPlayer;

    public AppMultimedia() {
        setTitle("Actividad - Multimedia Swing + JavaFX");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(720, 500);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Panel de controles Swing
        JPanel panelControles = new JPanel(new FlowLayout());
        JButton btnAudioWav = new JButton("Sonar Alerta (.WAV)");
        JButton btnPlayVideo = new JButton("Reproducir Video (.MP4)");
        JButton btnStopVideo = new JButton("Detener Video");

        panelControles.add(btnAudioWav);
        panelControles.add(btnPlayVideo);
        panelControles.add(btnStopVideo);

        // Panel JavaFX incrustado en Swing para Video
        JFXPanel jfxPanel = new JFXPanel();
        add(jfxPanel, BorderLayout.CENTER);
        add(panelControles, BorderLayout.SOUTH);

        // Inicialización del componente de video JavaFX
        Platform.runLater(() -> {
            File videoFile = new File("C:/Users/Admin/Documents/PCSX2/videos/TMBlack_credits.mp4");
            if (videoFile.exists()) {
                Media media = new Media(videoFile.toURI().toString());
                mediaPlayer = new MediaPlayer(media);
                MediaView mediaView = new MediaView(mediaPlayer);
                mediaView.setFitWidth(680);
                mediaView.setFitHeight(400);
                jfxPanel.setScene(new Scene(new Group(mediaView)));
            }
        });

        // Evento Audio Nativo (javax.sound.sampled)
        btnAudioWav.addActionListener(e -> reproducirWav("notificacion.wav"));

        // Eventos Video Externo (JavaFX)
        btnPlayVideo.addActionListener(e -> Platform.runLater(() -> {
            if (mediaPlayer != null) mediaPlayer.play();
        }));

        btnStopVideo.addActionListener(e -> Platform.runLater(() -> {
            if (mediaPlayer != null) mediaPlayer.stop();
        }));
    }

    private void reproducirWav(String ruta) {
        try {
            File file = new File(ruta);
            if (!file.exists()) {
                JOptionPane.showMessageDialog(this, "Coloque el archivo '" + ruta + "' en la raíz del proyecto.");
                return;
            }
            AudioInputStream stream = AudioSystem.getAudioInputStream(file);
            Clip clip = AudioSystem.getClip();
            clip.open(stream);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AppMultimedia().setVisible(true));
    }
}