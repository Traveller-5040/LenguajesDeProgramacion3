package actividades;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;

public class AppGraphics extends JPanel {
    private final String[] cursos = {"LP III", "Redes I", "Física II", "FSI"};
    private final int[] notas = {17, 15, 18, 16}; // Escala vigesimal (0-20)

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // S1: Gráficos Simples y Transformaciones Graphics2D
        g2d.setColor(Color.DARK_GRAY);
        g2d.setFont(new Font("SansSerif", Font.BOLD, 14));
        g2d.drawString("1. Primitivas y Transformaciones Graphics2D", 20, 25);

        AffineTransform original = g2d.getTransform();

        // Figura base (Polígono triángulo)
        int[] xPoints = {50, 80, 20};
        int[] yPoints = {45, 95, 95};
        g2d.setColor(new Color(52, 152, 219));
        g2d.fillPolygon(xPoints, yPoints, 3);

        // Transformación 1: Traslación + Rotación (45°)
        g2d.translate(120, 0);
        g2d.rotate(Math.toRadians(45), 50, 70);
        g2d.setColor(new Color(46, 204, 113));
        g2d.fillRoundRect(25, 45, 50, 50, 15, 15);
        g2d.setTransform(original);

        // Transformación 2: Traslación + Escalado (1.4x en X)
        g2d.translate(230, 0);
        g2d.scale(1.4, 1.0);
        g2d.setColor(new Color(230, 126, 34));
        g2d.fillOval(20, 45, 50, 50);
        g2d.setTransform(original);

        // S2: Visualización de Datos (Barras Horizontales)
        g2d.setColor(Color.DARK_GRAY);
        g2d.drawString("2. Visualización de Datos: Promedio por Curso (Escala 0 - 20)", 20, 140);

        int margenIzq = 90;
        int inicioY = 160;
        int altoBarra = 28;
        int espacio = 15;
        int anchoMax = 320;
        int notaMaxima = 20;

        // Eje vertical
        g2d.setStroke(new BasicStroke(2f));
        g2d.drawLine(margenIzq, inicioY - 5, margenIzq, inicioY + (cursos.length * (altoBarra + espacio)));

        for (int i = 0; i < cursos.length; i++) {
            int y = inicioY + i * (altoBarra + espacio);
            int anchoBarra = (int) (((double) notas[i] / notaMaxima) * anchoMax);

            // Etiqueta del curso
            g2d.setColor(Color.BLACK);
            g2d.drawString(cursos[i], 25, y + 19);

            // Barra proporcional
            g2d.setColor(new Color(108, 92, 231));
            g2d.fillRect(margenIzq, y, anchoBarra, altoBarra);

            // Valor numérico al final de la barra
            g2d.setColor(Color.BLACK);
            g2d.drawString(notas[i] + " pts", margenIzq + anchoBarra + 10, y + 19);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Actividad - Gráficos Simples, 2D y Datos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 380);
        frame.add(new AppGraphics());
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}