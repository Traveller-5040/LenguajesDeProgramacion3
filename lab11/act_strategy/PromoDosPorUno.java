package act_strategy;

public class PromoDosPorUno implements PromoStrategy {
    @Override
    public double applyPromo(double price, int cantidad) {
        int pago = (cantidad / 2) + (cantidad % 2);
        return pago * price;
    }
}
