package actividad;


import java.awt.*;
import javax.swing.*;

public class AppLayout {

    public static void main(String[] args)
    {
        FLayout flow = new FLayout();
        flow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        flow.setSize(480, 240);
        flow.setVisible(true);

        BLayout border = new BLayout();
        border.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        border.setSize(480, 240);
        border.setVisible(true);

        GLayout grid = new GLayout();
        grid.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        grid.setSize(480, 240);
        grid.setVisible(true);
    }
}

