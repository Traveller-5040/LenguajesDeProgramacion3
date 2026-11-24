package ejercicios;

import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import javax.swing.*;

public class CompraPasajes extends JFrame {

    private JTextField txtNombre;
    private JTextField txtDocumento;
    private JTextField txtFecha;

    private JComboBox<String> cbOrigen;
    private JComboBox<String> cbDestino;

    private JCheckBox chkAudifonos;
    private JCheckBox chkManta;
    private JCheckBox chkRevistas;

    private JRadioButton rbPrimerPiso;
    private JRadioButton rbSegundoPiso;
    private ButtonGroup grupoPisos;

    private JList<String> listaServicio;

    private JButton btnResumen;
    private JButton btnLimpiar;

    public CompraPasajes() {

        setTitle("Empresa de Transporte - Compra de Pasajes");
        setSize(550, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel principal
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(9, 2, 10, 10));
        panel.setBorder(
                BorderFactory.createEmptyBorder(20, 20, 20, 20)
        );

        // Nombre del pasajero
        panel.add(new JLabel("Nombre del pasajero:"));
        txtNombre = new JTextField();
        panel.add(txtNombre);

        // Documento
        panel.add(new JLabel("Documento de identidad:"));
        txtDocumento = new JTextField();
        panel.add(txtDocumento);

        // Fecha del viaje
        panel.add(new JLabel("Fecha de viaje (dd/MM/yyyy):"));
        txtFecha = new JTextField();
        panel.add(txtFecha);

        // Lugar de origen
        panel.add(new JLabel("Lugar de origen:"));

        String[] ciudades = {
                "Seleccione", "Arequipa", "Lima",
                "Cusco", "Puno", "Tacna"
        };

        cbOrigen = new JComboBox<>(ciudades);
        panel.add(cbOrigen);

        // Lugar de destino
        panel.add(new JLabel("Lugar de destino:"));

        cbDestino = new JComboBox<>(ciudades);
        panel.add(cbDestino);

        // Servicios opcionales
        panel.add(new JLabel("Servicios opcionales:"));

        JPanel panelServicios = new JPanel(
                new FlowLayout(FlowLayout.LEFT));

        chkAudifonos = new JCheckBox("Audifonos");
        chkManta = new JCheckBox("Manta");
        chkRevistas = new JCheckBox("Revistas");

        panelServicios.add(chkAudifonos);
        panelServicios.add(chkManta);
        panelServicios.add(chkRevistas);

        panel.add(panelServicios);

        // Seleccion de piso
        panel.add(new JLabel("Piso del bus:"));

        JPanel panelPisos = new JPanel(
                new FlowLayout(FlowLayout.LEFT));

        rbPrimerPiso = new JRadioButton("1er piso");
        rbSegundoPiso = new JRadioButton("2do piso");

        grupoPisos = new ButtonGroup();
        grupoPisos.add(rbPrimerPiso);
        grupoPisos.add(rbSegundoPiso);

        panelPisos.add(rbPrimerPiso);
        panelPisos.add(rbSegundoPiso);

        panel.add(panelPisos);

        // Calidad de servicio
        panel.add(new JLabel("Calidad de servicio:"));

        String[] servicios = {
                "Economico", "Standard", "VIP"
        };

        listaServicio = new JList<>(servicios);

        listaServicio.setSelectionMode(
                ListSelectionModel.SINGLE_SELECTION);

        listaServicio.setVisibleRowCount(3);

        panel.add(new JScrollPane(listaServicio));

        // Botones
        btnResumen = new JButton("Mostrar resumen");
        btnLimpiar = new JButton("Limpiar");

        panel.add(btnResumen);
        panel.add(btnLimpiar);

        // Eventos de los botones
        btnResumen.addActionListener(e -> mostrarResumen());
        btnLimpiar.addActionListener(e -> limpiarCampos());

        add(panel);

    }

    // Metodo para mostrar el resumen
    private void mostrarResumen() {

        String nombre = txtNombre.getText().trim();
        String documento = txtDocumento.getText().trim();
        String fecha = txtFecha.getText().trim();

        if (nombre.isEmpty() ||
                documento.isEmpty() ||
                fecha.isEmpty() ||
                cbOrigen.getSelectedIndex() == 0 ||
                cbDestino.getSelectedIndex() == 0 ||
                grupoPisos.getSelection() == null ||
                listaServicio.isSelectionEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Complete todos los campos obligatorios.",
                    "Datos incompletos",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        // Verificar fecha
        DateTimeFormatter formato =
                DateTimeFormatter.ofPattern("dd/MM/uuuu")
                        .withResolverStyle(ResolverStyle.STRICT);

        try {
            LocalDate.parse(fecha, formato);
        } catch (DateTimeParseException ex) {
            JOptionPane.showMessageDialog(
                    this,
                    "Ingrese una fecha valida (dd/MM/yyyy).",
                    "Fecha incorrecta",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        String origen = cbOrigen.getSelectedItem().toString();
        String destino = cbDestino.getSelectedItem().toString();

        if (origen.equals(destino)) {
            JOptionPane.showMessageDialog(
                    this,
                    "El origen y destino deben ser diferentes.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        // Obtener servicios opcionales
        StringBuilder opcionales = new StringBuilder();

        if (chkAudifonos.isSelected()) {
            opcionales.append("Audifonos, ");
        }

        if (chkManta.isSelected()) {
            opcionales.append("Manta, ");
        }

        if (chkRevistas.isSelected()) {
            opcionales.append("Revistas, ");
        }

        String servicios = opcionales.toString();

        if (servicios.isEmpty()) {
            servicios = "Ninguno";
        } else {
            servicios = servicios.substring(
                    0, servicios.length() - 2
            );
        }

        // Obtener piso
        String piso;

        if (rbPrimerPiso.isSelected()) {
            piso = "Primer piso";
        } else {
            piso = "Segundo piso";
        }

        // Obtener calidad del servicio
        String calidad = listaServicio.getSelectedValue();

        // Construir resumen
        String resumen =
                "RESUMEN DE COMPRA DE PASAJE\n\n" +
                        "Pasajero: " + nombre + "\n" +
                        "Documento: " + documento + "\n" +
                        "Fecha: " + fecha + "\n" +
                        "Origen: " + origen + "\n" +
                        "Destino: " + destino + "\n" +
                        "Piso: " + piso + "\n" +
                        "Calidad: " + calidad + "\n" +
                        "Servicios opcionales: " + servicios;

        // Mostrar cuadro de dialogo
        JOptionPane.showMessageDialog(
                this,
                resumen,
                "Resumen del pasajero",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    // Metodo para limpiar el formulario
    private void limpiarCampos() {

        txtNombre.setText("");
        txtDocumento.setText("");
        txtFecha.setText("");

        cbOrigen.setSelectedIndex(0);
        cbDestino.setSelectedIndex(0);

        chkAudifonos.setSelected(false);
        chkManta.setSelected(false);
        chkRevistas.setSelected(false);

        grupoPisos.clearSelection();
        listaServicio.clearSelection();

        txtNombre.requestFocusInWindow();
    }

    // Metodo principal
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            CompraPasajes ventana = new CompraPasajes();
            ventana.setVisible(true);
        });

    }
}
