package Ej2;

import java.util.ArrayList;
import java.util.Arrays;

public class FormaTest {
    public static void main(String[] args) {
        ArrayList<Forma> formas = new ArrayList<>();
        Forma f1 = new Circulo();
        Forma f2 = new Rectangulo();
        Forma f3 = new Triangulo();

        formas.addAll(Arrays.asList(f1, f2, f3));

        for(Forma f : formas) {
            f.Dibujar();
        }
    }
}
