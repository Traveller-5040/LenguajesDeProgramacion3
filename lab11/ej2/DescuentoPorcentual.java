package ej2;

import java.util.List;

class DescuentoPorcentual implements EstrategiaDescuento {
    @Override
    public double calcularPrecioFinal(List<Producto> productos) {
        double total = 0;
        boolean[] descontado = new boolean[productos.size()];

        for (int i = 0; i < productos.size(); i++) {
            total += productos.get(i).getPrecio();
            if (!descontado[i]) {
                for (int j = i + 1; j < productos.size(); j++) {
                    if (!descontado[j] && productos.get(i).getNombre().equalsIgnoreCase(productos.get(j).getNombre())) {
                        // Se aplica 30% de descuento al par de productos iguales
                        double ahorro = (productos.get(i).getPrecio() + productos.get(j).getPrecio()) * 0.30;
                        total -= ahorro;
                        descontado[i] = true;
                        descontado[j] = true;
                        break;
                    }
                }
            }
        }
        return total;
    }
}