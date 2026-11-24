package act_strategy;

public class PromoMitadDePrecio implements PromoStrategy {
    // La promocion se aplica si se lleva 5 unidades o mas de un
    // mismo producto
    @Override
    public double applyPromo(double price, int cantidad) {
        if(cantidad >= 5) {
            return (price * cantidad) / 2;
        } else {
            return 0;
        }
    }
}
