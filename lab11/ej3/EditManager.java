package ej3;

import java.util.Stack;

public class EditManager {
    // Se crea un Stack como atributo privado, dicho atributo servira
    // para gestionar el historial de comandos, su uso radica en que
    // con Stack solo se pueden agregar o borrar elementos desde la parte superior,
    // el cual es una caracteristica importante para gestionar historiales
    private Stack<CommandEditor> historial = new Stack<>();

    public void ejecutarComando(CommandEditor comando) {
        comando.ejecutar();
        historial.push(comando);
    }

    public void deshacerUltimo() {
        if (!historial.isEmpty()) {
            CommandEditor ultimo = historial.pop();
            ultimo.deshacer();
        }
    }
}
