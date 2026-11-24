package actividad;

import javax.swing.*;
import java.awt.*;

public class BLayout extends JFrame {
    public BLayout()
    {
        // Se define el titulo de la ventana
        super("BorderLayout - Cruz, Machaca, Peña");

        // Se define la plantilla de la ventana
        setLayout(new BorderLayout(5, 5));

        // Se agregan 5 botones que cubriran las posiciones de
        // la plantilla: NORTE, SUR, ESTE, OESTE y CENTRO
        add(new JButton("NORTE"),
                BorderLayout.NORTH);

        add(new JButton("SUR"),
                BorderLayout.SOUTH);

        add(new JButton("CENTRO"),
                BorderLayout.CENTER);

        add(new JButton("ESTE"),
                BorderLayout.EAST);

        add(new JButton("OESTE"),
                BorderLayout.WEST);
    }
}
