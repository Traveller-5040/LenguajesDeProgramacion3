package act_strategy;

public class StrategyTest {
    public static void main(String[] args) {
        PromoStrategy p1 = new PagoRegular();
        PromoStrategy p2 = new PromoDosPorUno();
        PromoStrategy p3 = new PromoMitadDePrecio();

        Carrito car1 = new Carrito();

        car1.setPromoStrategy(p1);
        System.out.println("Total a pagar -> " + car1.calcularTotal(12, 4));

        car1.setPromoStrategy(p2);
        System.out.println("Total a pagar -> " + car1.calcularTotal(12, 4));

        car1.setPromoStrategy(p3);
        double pagoP3 =car1.calcularTotal(12, 4);
        System.out.println("Total a pagar -> " + (pagoP3 > 0 ? pagoP3 : "No aplica para la promocion") );
    }
}
