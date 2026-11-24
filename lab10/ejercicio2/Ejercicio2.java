package ejercicio2;
import javax.swing.*;
import java.awt.*;

public class Ejercicio2 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Temperatura Semanal");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 500);
        frame.setLayout(new BorderLayout());

        String[] dias = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};
        JTextField[] campos = new JTextField[7];

        // Panel superior, un campo por día y el botón
        JPanel entrada = new JPanel(new FlowLayout());
        for (int i = 0; i < 7; i++) {
            campos[i] = new JTextField(3);
            entrada.add(new JLabel(dias[i] + ":"));
            entrada.add(campos[i]);
        }
        JButton boton = new JButton("Mostrar Gráfico");
        entrada.add(boton);
        PanelGrafico grafico = new PanelGrafico();

        // Lee los 7 campos y se los pasa al panel, que se redibuja solo
        boton.addActionListener(e -> {
            try {
                double[] temps = new double[7];
                for (int i = 0; i < 7; i++) {
                    temps[i] = Double.parseDouble(campos[i].getText().trim());
                }
                grafico.setTemperaturas(temps);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame,
                        "Ingrese una temperatura válida en los 7 campos.");
            }
        });

        frame.add(entrada, BorderLayout.NORTH);
        frame.add(grafico, BorderLayout.CENTER);
        frame.setVisible(true);
    }
}