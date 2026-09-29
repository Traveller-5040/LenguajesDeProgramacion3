package ejercicios;

public class PruebaPar {
    public static <F, S> void imprimirPar(Par<F, S> par) {
        System.out.println(par.toString());
    }

    public static void main(String[] args) {
        Par<String, Integer> par1 = new Par<>("h", 3);

        Contenedor<String, Integer> Cont1 = new Contenedor<>();

        Cont1.agregarPar("h", 4);
        Cont1.agregarPar("T", 90013);
        System.out.println(par1.esIgual(Cont1.obtenerPar(0)));
        try {
            imprimirPar(Cont1.obtenerPar(6));
        }
        catch(IndexOutOfBoundsException e) {
            System.err.println("Error: " + e.getMessage());
        }

        Cont1.imprimirPares();
    }
}
