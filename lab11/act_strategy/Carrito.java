package act_strategy;

public class Carrito {
    private PromoStrategy promoStrategy;

    public void setPromoStrategy(PromoStrategy promoStrategy) {
        this.promoStrategy = promoStrategy;
    }

    public double calcularTotal(double price, int cantidad) {
        return promoStrategy.applyPromo(price, cantidad);
    }
}
