package actividad1;

public class Coche {

    // Atributos originales
    public String color;
    private String modelo;
    private int velocidadMaxima;
    private int potenciaMotor;
    private boolean enMarcha;

    // Atributos nuevos pedidos en la actividad
    private String marca;
    private int anioFabricacion;
    private double precio;

    // Constructor original (ya venia en la guia)
    public Coche(String modelo, int velocidadMaxima, int potenciaMotor) {
        this.modelo = modelo;
        this.velocidadMaxima = velocidadMaxima;
        this.potenciaMotor = potenciaMotor;
        this.enMarcha = false; // el coche arranca apagado
    }

    // Segundo constructor: por defecto, deja todo en valores base
    public Coche() {
        this.modelo = "Sin modelo";
        this.marca = "Sin marca";
        this.anioFabricacion = 0;
        this.precio = 0.0;
        this.enMarcha = false;
    }

    // Tercer constructor: recibe marca, modelo, anio y precio
    public Coche(String marca, String modelo, int anioFabricacion, double precio) {
        this.marca = marca;
        this.modelo = modelo;
        this.anioFabricacion = anioFabricacion;
        this.precio = precio;
        this.enMarcha = false;
    }

    // Metodo que aplica un descuento al precio si el coche es antiguo (antes del 2010)
    public boolean aplicarDescuento(double descuento) {
        if (anioFabricacion < 2010) {
            // el descuento llega como porcentaje, por eso se divide entre 100
            precio = precio - (precio * descuento / 100);
            return true; // si se aplico el descuento
        }
        return false; // no se aplico porque el coche no es antiguo
    }

    // Metodos originales
    public void acelerar() {
        if (enMarcha) {
            System.out.println("El coche " + modelo + " esta acelerando.");
        } else {
            System.out.println("Primero enciende el coche.");
        }
    }

    public void frenar() {
        if (enMarcha) {
            System.out.println("El coche " + modelo + " esta frenando.");
        } else {
            System.out.println("El coche esta apagado, no se puede frenar.");
        }
    }

    public void encender() {
        enMarcha = true;
        System.out.println("El coche " + modelo + " se ha encendido.");
    }

    public void apagar() {
        enMarcha = false;
        System.out.println("El coche " + modelo + " se ha apagado.");
    }

    // Getters y setters de todos los atributos
    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getAnioFabricacion() {
        return anioFabricacion;
    }

    public void setAnioFabricacion(int anioFabricacion) {
        this.anioFabricacion = anioFabricacion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getVelocidadMaxima() {
        return velocidadMaxima;
    }

    public void setVelocidadMaxima(int velocidadMaxima) {
        this.velocidadMaxima = velocidadMaxima;
    }

    public int getPotenciaMotor() {
        return potenciaMotor;
    }

    public void setPotenciaMotor(int potenciaMotor) {
        this.potenciaMotor = potenciaMotor;
    }

    public boolean isEnMarcha() {
        return enMarcha;
    }
}
