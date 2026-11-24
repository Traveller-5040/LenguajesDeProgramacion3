package act2;

import java.util.ArrayList;
import java.util.List;

class GestorTareasTienda {
    private List<OrderCommand> colaComandos = new ArrayList<>();

    public void agregarComando(OrderCommand cmd) {
        colaComandos.add(cmd);
    }

    public void ejecutarCola() {
        for (OrderCommand cmd : colaComandos) {
            cmd.ejecutar();
        }
        colaComandos.clear();
    }
}