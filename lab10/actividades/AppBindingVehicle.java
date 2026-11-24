package actividades;

import javax.swing.*;
import java.awt.*;

public class AppBindingVehicle {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Binding Manual - Vehículo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(320, 240);
        frame.setLayout(new GridLayout(4, 2, 8, 8));

        // 1. Modelo inicial
        Vehiculo auto = new Vehiculo("V4X-812", 2022, "Toyota");

        // 2. Componentes vinculados al modelo
        JTextField txtPlaca = new JTextField(auto.getPlaca());
        JTextField txtAnio = new JTextField(String.valueOf(auto.getAnio()));
        JTextField txtMarca = new JTextField(auto.getMarca());
        JButton btnSincronizar = new JButton("Sincronizar Modelo");

        // 3. Listener de actualización Vista -> Modelo
        btnSincronizar.addActionListener(e -> {
            auto.setPlaca(txtPlaca.getText());
            auto.setMarca(txtMarca.getText());
            try {
                int anio = Integer.parseInt(txtAnio.getText());
                auto.setAnio(anio);

                System.out.println("--- Vehículo Actualizado ---");
                System.out.println("Placa: " + auto.getPlaca());
                System.out.println("Año: " + auto.getAnio());
                System.out.println("Marca: " + auto.getMarca());
                JOptionPane.showMessageDialog(frame, "Modelo sincronizado: " + auto.getMarca() + " (" + auto.getPlaca() + ")");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Ingrese un año numérico válido.");
            }
        });

        frame.add(new JLabel(" Placa:"));
        frame.add(txtPlaca);
        frame.add(new JLabel(" Año:"));
        frame.add(txtAnio);
        frame.add(new JLabel(" Marca:"));
        frame.add(txtMarca);
        frame.add(new JLabel(""));
        frame.add(btnSincronizar);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}