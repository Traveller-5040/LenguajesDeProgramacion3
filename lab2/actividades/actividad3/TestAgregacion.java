package actividad3;

public class TestAgregacion {
    public static void main(String[] args) {
        // el motor se crea aparte, puede existir sin el automovil
        Motor motor1 = new Motor(1001, 6000);
        Motor motor2 = new Motor(1002, 5500);

        Automovil auto1 = new Automovil("ABC-123", 4, "Toyota", "Corolla");
        Automovil auto2 = new Automovil("XYZ-987", 2, "Mazda", "MX-5");

        // se asigna el motor ya existente a cada automovil
        auto1.setMotor(motor1);
        auto2.setMotor(motor2);

        System.out.println(auto1);
        System.out.println(auto2);
    }
}
