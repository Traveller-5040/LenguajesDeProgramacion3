package act2;

public class PruebaPila {
    public static void main(String[] args) {
        Pila<Integer> pila = new Pila<>();
        Pila<Integer> pila2 = new Pila<>();
        pila.push(23);
        pila.push(45);
        pila2.push(23);
        pila2.push(45);

        //System.out.println("Pila 1 contiene el valor 56? -> " + pila.contains(56));
        //System.out.println("Pila 1 contiene el valor 45? -> " + pila.contains(45));

        System.out.println("Pila1 y Pila2 son iguales? -> " + pila.esIgual(pila2));

        pila.push(78);

        System.out.println("Pila1 y Pila2 siguen siendo iguales? -> " + pila.esIgual(pila2));
    }
}
