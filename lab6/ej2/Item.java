package ej2;

public class Item {
    // La clase "Item" contiene nombre, cantidad, tipo ("Arma" o "Pocion") y descripcion
    private String nombre;
    private int cantidad;
    private String tipo;
    private String descripcion;

    public Item(String nombre, int cantidad, String tipo, String descripcion) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.tipo = tipo;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return this.nombre;
    }

    public int getCantidad() {
        return this.cantidad;
    }

    public String getTipo() {
        return this.tipo;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    // Metodo que usa el item: una pocion se gasta (-1 unidad), un arma no se gasta.
    // Retorna false si es una pocion y ya no quedan unidades
    public boolean usarItem() {
        if(this.tipo.equals("Pocion")) {
            if(this.cantidad <= 0) {
                return false;
            }
            this.cantidad--;
        }
        return true;
    }
}
