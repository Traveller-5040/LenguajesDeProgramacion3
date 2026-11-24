package actividad;

import javax.swing.*;
import java.awt.*;

public class FLayout extends JFrame {
    public FLayout()
    {
        // Se define el titulo de la ventana
        super("FlowLayout - Cruz, Machaca, Peña");

        // Se define la plantilla de la ventana
        setLayout(new FlowLayout());

        // Inicia el bucle for encargado de agregar 8 botones
        for(int i = 0; i < 8; i++)
        {
            // Por cada ciclo se agrega un boton
            add(new JButton("Boton " + (i + 1)));
        }
    }
}
