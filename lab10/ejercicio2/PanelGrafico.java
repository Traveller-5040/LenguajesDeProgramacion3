package ejercicio2;

import javax.swing.*;
import java.awt.*;

public class PanelGrafico extends JPanel {
    private final String[] dias = {"Lun", "Mar", "Mié", "Jue", "Vie", "Sáb", "Dom"};
    private double[] temperaturas = null;

    public void setTemperaturas(double[] temps) {
        this.temperaturas = temps;
        repaint(); // pide a Swing que vuelva a dibujar el panel
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int margen = 50;
        int w = getWidth() - 2 * margen;
        int h = getHeight() - 2 * margen;

        // Ejes
        g2d.setColor(Color.BLACK);
        g2d.drawLine(margen, margen, margen, margen + h);
        g2d.drawLine(margen, margen + h, margen + w, margen + h);
        g2d.drawString("Temp (°C)", 5, margen - 10);

        // Mientras no haya datos solo se muestra un mensaje
        if (temperaturas == null) {
            g2d.drawString("Ingrese las temperaturas y pulse 'Mostrar Gráfico'",
                    margen + 20, margen + h / 2);
            return;
        }

        // Se busca el mínimo y el máximo para escalar los puntos al alto del panel
        double min = temperaturas[0], max = temperaturas[0];
        for (double t : temperaturas) {
            if (t < min) min = t;
            if (t > max) max = t;
        }
        if (max == min) { max += 1; min -= 1; } // evita dividir entre cero

        // Coordenadas en pantalla de cada punto (el eje Y de Swing crece hacia abajo)
        int n = temperaturas.length;
        int[] xs = new int[n];
        int[] ys = new int[n];
        for (int i = 0; i < n; i++) {
            xs[i] = margen + i * w / (n - 1);
            ys[i] = margen + h - (int) ((temperaturas[i] - min) / (max - min) * h);
        }

        // Línea que une los puntos
        g2d.setColor(Color.BLUE);
        g2d.setStroke(new BasicStroke(2));
        for (int i = 0; i < n - 1; i++) {
            g2d.drawLine(xs[i], ys[i], xs[i + 1], ys[i + 1]);
        }

        // Puntos, valor de cada temperatura y nombre del día
        for (int i = 0; i < n; i++) {
            g2d.setColor(Color.RED);
            g2d.fillOval(xs[i] - 5, ys[i] - 5, 10, 10);
            g2d.setColor(Color.BLACK);
            g2d.drawString(temperaturas[i] + "°", xs[i] - 10, ys[i] - 10);
            g2d.drawString(dias[i], xs[i] - 10, margen + h + 20);
        }
    }
}