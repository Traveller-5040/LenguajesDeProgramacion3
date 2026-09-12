package ej1;

import java.io.IOException;

public class ExcSalida extends IOException {
    public ExcSalida(String mensaje) {
        super(mensaje);
    }
}
