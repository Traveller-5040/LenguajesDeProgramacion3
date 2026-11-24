package act_command;

import java.util.Random;

public class Televisor {
    private boolean estado;
    private int canal;
    private int vol;

    public Televisor() {
        this.estado = false;
        this.canal = 2;
        this.vol = 10;
    }

    Random rand = new Random();

    public void apagar() {
        this.estado = false;
        System.out.println("TV apagado");
    }

    public void encender() {
        this.estado = true;
        System.out.println("TV encendido");
    }

    public void subirVolumen() {
        if(this.estado) {
            this.vol += 10;
            System.out.println("TV volumen: " + this.vol);
        }
    }

    public void bajarVolumen() {
        if(this.estado) {
            this.vol -= 10;
            System.out.println("TV volumen: " + this.vol);
        }
    }

    public void cambiarCanal() {
        if(this.estado) {
            int canal = rand.nextInt(100);
            this.canal = canal;
            System.out.println("TV canal actual: " + this.canal);
        }
    }
}
