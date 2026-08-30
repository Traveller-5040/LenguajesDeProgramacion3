package actividad2;

public class ContadorTest {
    public static void main(String[] args) {
        Contador c1, c2;

        System.out.println(Contador.acumulador()); // 0, todavia no se crea ningun contador

        c1 = new Contador(3);
        c2 = new Contador(10);
        c1.inc();
        c1.inc();
        c2.inc();
        System.out.println(c1.getValor());          // 5
        System.out.println(c2.getValor());           // 11
        System.out.println(Contador.acumulador);     // 16

        // pruebas del punto g: usando el constructor por defecto con this(VALOR_INICIAL)
        Contador c3 = new Contador();
        System.out.println("Valor de c3 (deberia ser 10): " + c3.getValor());

        // pruebas del punto j: nContadores y ultimoContador
        System.out.println("Contadores creados hasta ahora: " + Contador.getnContadores());
        System.out.println("Valor inicial del ultimo contador creado: " + Contador.getUltimoContador());

        Contador c4 = new Contador(25);
        System.out.println("Contadores creados hasta ahora: " + Contador.getnContadores());
        System.out.println("Valor inicial del ultimo contador creado: " + Contador.getUltimoContador());
    }
}

