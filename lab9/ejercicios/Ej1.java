package ejercicios;

import javax.swing.*;

public class Ej1 {
    private JTextField txtName;
    private JPanel MainPanel;
    private JButton gretting;

    public Ej1() {

        gretting.addActionListener(e -> {

            String nombre = txtName.getText().trim();

            if (nombre.isEmpty()) {

                JOptionPane.showMessageDialog(
                        MainPanel,
                        "Ingrese su nombre."
                );

            } else {

                JOptionPane.showMessageDialog(
                        MainPanel,
                        "Bienvenido, " + nombre
                );

            }
        });
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            JFrame ventana = new JFrame(
                    "Formulario de bienvenida"
            );

            ventana.setContentPane(
                    new Ej1().MainPanel
            );

            ventana.setDefaultCloseOperation(
                    JFrame.EXIT_ON_CLOSE
            );

            ventana.pack();
            ventana.setLocationRelativeTo(null);
            ventana.setVisible(true);

        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
