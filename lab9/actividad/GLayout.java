package actividad;

import javax.swing.*;
import java.awt.*;

public class GLayout extends JFrame {
    public GLayout()
    {
        // Se define el titulo de la ventana
        super("GLayout - Cruz, Machaca, Peña");

        // Se define la plantilla de la ventana
        setLayout(new GridLayout(2, 4, 5, 5));

        // Inicia el bucle for encargado de agregar los botones
        for (int i = 1; i <= 15; i++) {
            // Por cada ciclo se agrega un nuevo boton
            add(new JButton("Boton " + i));
        }
    }
}
