package ejercicio1;

import javax.swing.*;
import java.awt.*;

public class Ejercicio1 {
    public static void main(String[] args) {
        // Empieza vacío, se llena cuando el usuario pulsa el botón
        Producto producto = new Producto("", 0.0, 0, "");

        JFrame frame = new JFrame("Gestión de Producto");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 320);
        frame.setLayout(new BorderLayout(10, 10));

        // Se crean los campos de texto necesario (JTextField)
        JTextField nombreField = new JTextField(15);
        JTextField precioField = new JTextField(15);
        JTextField stockField = new JTextField(15);
        JTextField categoriaField = new JTextField(15);
        JButton button = new JButton("Actualizar Producto");
        JLabel resultado = new JLabel("Aún no hay datos.", SwingConstants.CENTER);

        // Formulario de 4 filas por 2 columnas
        JPanel form = new JPanel(new GridLayout(4, 2, 5, 5));
        form.add(new JLabel("Nombre:"));
        form.add(nombreField);
        form.add(new JLabel("Precio:"));
        form.add(precioField);
        form.add(new JLabel("Cantidad en stock:"));
        form.add(stockField);
        form.add(new JLabel("Categoría:"));
        form.add(categoriaField);

        // Binding manual: al hacer clic se pasan los datos de los campos al modelo
        // y después se muestran en la etiqueta leyendo el modelo
        button.addActionListener(e -> {
            try {
                producto.setNombre(nombreField.getText());
                
                // Si no es un número, parseDouble/parseInt lanzan la excepción
                producto.setPrecio(Double.parseDouble(precioField.getText()));
                producto.setCantidadStock(Integer.parseInt(stockField.getText()));
                producto.setCategoria(categoriaField.getText());

                // El <html> y los <br> permiten mostrar varias líneas en un JLabel
                resultado.setText("<html>Nombre: " + producto.getNombre()
                        + "<br>Precio: " + producto.getPrecio()
                        + "<br>Stock: " + producto.getCantidadStock()
                        + "<br>Categoría: " + producto.getCategoria() + "</html>");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame,
                        "El precio y el stock deben ser números válidos.");
            }
        });

        frame.add(form, BorderLayout.NORTH);
        frame.add(button, BorderLayout.CENTER);
        frame.add(resultado, BorderLayout.SOUTH);
        frame.setVisible(true);
    }
}