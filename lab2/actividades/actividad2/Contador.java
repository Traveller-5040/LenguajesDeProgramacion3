package actividad2;

public class Contador {

    static int acumulador = 0;
    final static int VALOR_INICIAL = 10; // constante agregada en el punto e
    private int valor;

    // variables de clase pedidas en el punto j
    static int nContadores = 0;     // cuenta cuantos contadores se han creado
    static int ultimoContador;      // guarda el valor inicial del ultimo contador creado

    public static int acumulador() {
        return acumulador;
    }

    public Contador(int valor) {
        this.valor = valor;
        acumulador += valor;
        nContadores++;           // cada vez que se crea un contador, se suma uno
        ultimoContador = valor;  // se guarda el valor inicial de este contador
    }

    // constructor sin parametros, delega en el constructor de arriba usando this()
    public Contador() {
        this(Contador.VALOR_INICIAL);
    }

    public void inc() {
        valor++;
        acumulador++;
    }

    public int getValor() {
        return this.valor;
    }

    public static int getnContadores() {
        return nContadores;
    }

    public static int getUltimoContador() {
        return ultimoContador;
    }
}

