package ejercicio1;

//Modelo de datos del producto (solo atributos y get/set)
public class Producto {
    // Atributos de la clase
    private String nombre;
    private double precio;
    private int cantidadStock;
    private String categoria;

    // Constructor de clase
    public Producto(String nombre, double precio, int cantidadStock, String categoria) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidadStock = cantidadStock;
        this.categoria = categoria;
    }

    // GETTERS
    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }
    public int getCantidadStock() { return cantidadStock; }
    public String getCategoria() { return categoria; }

    // SETTERS
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setPrecio(double precio) { this.precio = precio; }
    public void setCantidadStock(int cantidadStock) { this.cantidadStock = cantidadStock; }
    public void setCategoria(String categoria) { this.categoria = categoria; }
}
