package ejercicios;
import java.util.ArrayList;

public class Contenedor<F, S> {
    private final ArrayList<Par<F, S>> pares;

    public Contenedor() {
        pares = new ArrayList<>();
    }

    public void agregarPar(F primero, S segundo) {
        this.pares.add(new Par<>(primero, segundo));
    }

    public Par<F, S> obtenerPar(int indice) {
        if(indice < 0 || indice >= pares.size()) {
            throw new IndexOutOfBoundsException("Indice fuera de rango");
        }
        return this.pares.get(indice);
    }

    public ArrayList<Par<F, S>> obtenerTodoPar() {
        return this.pares;
    }

    public void imprimirPares() {
        for(Par<F, S> p : this.pares) {
            System.out.println(p.toString());
        }
    }
}
