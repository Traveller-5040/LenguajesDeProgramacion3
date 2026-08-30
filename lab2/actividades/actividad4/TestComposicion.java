package actividad4;

public class TestComposicion {
    public static void main(String[] args) {
        // al crear la persona, se crea automaticamente su cuenta (composicion)
        Persona p1 = new Persona(1, "Juan", "Perez");
        Persona p2 = new Persona(2, "Maria", "Lopez");

        System.out.println(p1);
        System.out.println(p2);

        // se puede acceder a la cuenta desde la persona
        p1.getCuenta().setSaldo(500);
        System.out.println("Saldo actualizado de p1: " + p1.getCuenta());
    }
}
