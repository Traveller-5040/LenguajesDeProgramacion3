package act6;

import java.io.*;

class Fecha implements Serializable {
    // La clase "Fecha" contiene el dia, el mes y el año. Implementa Serializable
    // para que sus objetos puedan guardarse en un archivo y leerse despues
    private int dia, mes, año;

    public Fecha(int dia, int mes, int año) {
        // Se inicializan los tres atributos con los valores ingresados
        this.dia = dia;
        this.mes = mes;
        this.año = año;
    }

    // Se implementan los metodos de instancia que retornan
    // cada valor de la fecha cuando sea necesario
    public int getDia() { return dia; }

    // Metodo que permite modificar el dia de la fecha
    public void setDia(int dia) { this.dia = dia; }

    public int getMes() { return mes; }

    // Metodo que permite modificar el mes de la fecha
    public void setMes(int mes) { this.mes = mes; }

    public int getAño() { return año; }

    // Metodo que permite modificar el año de la fecha
    public void setAño(int año) { this.año = año; }
}