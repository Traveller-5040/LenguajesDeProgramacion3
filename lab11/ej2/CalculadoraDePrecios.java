package ej2;

import java.util.List;

class CalculadoraDePrecios {
    private EstrategiaDescuento estrategia;

    // Metodo que establece una estrategia de descuento
    public void setEstrategia(EstrategiaDescuento estrategia) {
        this.estrategia = estrategia;
    }

    // Metodo que calcula el pago correspondiente no sin antes revisar si se establecio
    // una estrategia de descuento
    public double calcular(List<Producto> productos) {
        if (estrategia == null) {
            throw new IllegalStateException("Debe seleccionar una estrategia de descuento.");
        }
        return estrategia.calcularPrecioFinal(productos);
    }
}
