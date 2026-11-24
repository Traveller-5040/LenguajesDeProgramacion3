package act_strategy;

public class PagoRegular implements PromoStrategy {
    @Override
    public double applyPromo(double price, int cantidad) {
        return price * cantidad;
    }
}
