package ej1;

public class ObserverAppTest {
    public static void main(String[] args) {
        PlataformaTienda tienda = new PlataformaTienda();
        Usuario u1 = new Usuario("John Doe", "doe32@gmail.com");
        Usuario u2 = new Usuario("Marcus Kane", "kane93@gmail.com");

        tienda.suscribir(u1);
        tienda.suscribir(u2);

        tienda.publicarEvento("PROMOCION", "20% de descuento en accesorios tecnologicos.");

        // Desuscripción dinámica
        tienda.desuscribir(u1);
        tienda.publicarEvento("ACTUALIZACION", "Stock renovado de Memorias SSD (1Tb).");
    }
}
