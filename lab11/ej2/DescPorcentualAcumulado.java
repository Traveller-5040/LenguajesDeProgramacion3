package ej2;

import java.util.List;

class DescPorcentualAcumulado implements EstrategiaDescuento {
    @Override
    public double calcularPrecioFinal(List<Producto> productos) {
        double total = 0;
        double precioMinimo = Double.MAX_VALUE;

        for (Producto p : productos) {
            total += p.getPrecio();
            if (p.getPrecio() < precioMinimo) {
                precioMinimo = p.getPrecio();
            }
        }

        if (productos.size() >= 3) {
            total -= (precioMinimo * 0.50);
        }
        return total;
    }
}
