package actividades;

class Vehiculo {
    private String placa;
    private int anio;
    private String marca;

    // Constructor de clase
    public Vehiculo(String placa, int anio, String marca) {
        this.placa = placa;
        this.anio = anio;
        this.marca = marca;
    }

    // GETTERS
    public String getPlaca() { return placa; }
    public int getAnio() { return anio; }
    public String getMarca() { return marca; }

    // SETTERS
    public void setPlaca(String placa) { this.placa = placa; }
    public void setAnio(int anio) { this.anio = anio; }
    public void setMarca(String marca) { this.marca = marca; }
}
