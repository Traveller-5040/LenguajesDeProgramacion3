package ej2;

import java.util.List;

class DescuentoFijo implements EstrategiaDescuento {
    @Override
    public double calcularPrecioFinal(List<Producto> productos) {
        double total = 0;
        for (Producto p : productos) {
            total += p.getPrecio();
        }
        return total * 0.90;
    }
}
