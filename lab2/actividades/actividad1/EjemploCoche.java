package actividad1;

public class EjemploCoche {
    public static void main(String[] args) {

        // Crear objetos coche usando el constructor de 4 parametros
        Coche cocheDeportivo = new Coche("Ferrari", "F8", 2015, 250000.0);
        Coche cocheTodoTerreno = new Coche("Toyota", "Land Cruiser", 2008, 60000.0);
        cocheDeportivo.color = "Rojo";
        cocheTodoTerreno.color = "Verde";

        // Encender los coches
        cocheDeportivo.encender();
        cocheTodoTerreno.encender();

        // Acelerar y frenar los coches
        cocheDeportivo.acelerar();
        cocheTodoTerreno.acelerar();
        cocheDeportivo.frenar();
        cocheTodoTerreno.frenar();

        // Apagar los coches
        cocheDeportivo.apagar();
        cocheTodoTerreno.apagar();

        // Probar el metodo aplicarDescuento
        boolean seAplico = cocheTodoTerreno.aplicarDescuento(10);
        System.out.println("Se aplico descuento al todo terreno: " + seAplico);
        System.out.println("Precio final del todo terreno: " + cocheTodoTerreno.getPrecio());

        boolean seAplico2 = cocheDeportivo.aplicarDescuento(10);
        System.out.println("Se aplico descuento al deportivo: " + seAplico2);
        System.out.println("Precio final del deportivo: " + cocheDeportivo.getPrecio());

        // Probar los setters y getters
        cocheDeportivo.setMarca("Lamborghini");
        System.out.println("Nueva marca del deportivo: " + cocheDeportivo.getMarca());
    }
}
