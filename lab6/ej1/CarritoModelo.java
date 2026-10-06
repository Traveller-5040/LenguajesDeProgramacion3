package ej1;

import java.util.ArrayList;
import java.util.List;

public class CarritoModelo {
    // Lista de productos disponibles en la tienda
    private List<Producto> productos;
    // Lista de productos que el usuario agrego al carrito
    private List<Producto> carrito;
    // Historial con el resumen de cada compra realizada
    private List<String> historial;
    // Porcentaje de descuento aplicado al carrito (0 si no hay descuento)
    private int descuento;

    public CarritoModelo() {
        // Se inicializan las listas y el descuento
        this.productos = new ArrayList<>();
        this.carrito = new ArrayList<>();
        this.historial = new ArrayList<>();
        this.descuento = 0;
    }

    public void agregarProducto(Producto producto) {
        // Permite agregar un producto a la lista de la tienda
        this.productos.add(producto);
    }

    // Metodo que pasa un producto de la tienda al carrito, retorna false si no hay stock
    public boolean agregarAlCarrito(int index) {
        Producto producto = this.productos.get(index);
        if(producto.getStock() > 0) {
            // Se descuenta una unidad del stock al agregarlo al carrito
            producto.setStock(producto.getStock() - 1);
            this.carrito.add(producto);
            return true;
        }
        return false;
    }

    // Metodo que quita un producto del carrito y devuelve la unidad al stock
    public void quitarDelCarrito(int index) {
        Producto producto = this.carrito.remove(index);
        producto.setStock(producto.getStock() + 1);
    }

    // Metodo que aplica un descuento si el codigo es valido
    public boolean aplicarDescuento(String codigo) {
        if(codigo.equals("DESC10")) {
            this.descuento = 10;
            return true;
        } else if(codigo.equals("DESC20")) {
            this.descuento = 20;
            return true;
        }
        return false;
    }

    // Suma los precios de todos los productos del carrito
    public double calcularSubtotal() {
        double subtotal = 0;
        for(Producto p : carrito) {
            subtotal += p.getPrecio();
        }
        return subtotal;
    }

    // Calcula cuanto dinero se descuenta segun el porcentaje aplicado
    public double calcularDescuento() {
        return this.calcularSubtotal() * this.descuento / 100;
    }

    // El envio cuesta 10, pero es gratis si lo comprado (ya con descuento) llega a 100
    public double calcularEnvio() {
        if(this.carrito.isEmpty()) {
            return 0;
        }
        if(this.calcularSubtotal() - this.calcularDescuento() >= 100) {
            return 0;
        }
        return 10;
    }

    public double calcularTotal() {
        return this.calcularSubtotal() - this.calcularDescuento() + this.calcularEnvio();
    }

    // Metodo que registra la compra en el historial y vacia el carrito
    public void realizarCompra() {
        String resumen = "Compra " + (this.historial.size() + 1) + " | Productos: "
                + this.carrito.size() + " | Total: S/ " + String.format("%.2f", this.calcularTotal());
        this.historial.add(resumen);
        this.carrito.clear();
        // El descuento solo vale para la compra en la que se aplico
        this.descuento = 0;
    }

    public List<Producto> getProductos() {
        return this.productos;
    }

    public List<Producto> getCarrito() {
        return this.carrito;
    }

    public List<String> getHistorial() {
        return this.historial;
    }
}
