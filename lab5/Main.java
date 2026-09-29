public class Main {
    public static void main(String[] args) {
        Integer num = 23;
        Integer num2 = 56;
        Pila<Integer> pila = new Pila<>();
        Pila<Integer> pila2 = new Pila<>(5);
        pila.push(23);
        pila.push(56);
        pila2.push(23);
        pila2.push(56);

        System.out.println("Pila1 y Pila2 son iguales? -> " + pila.esIgual(pila2));

        pila.push(78);

        System.out.println("Pila1 y Pila2 siguen siendo iguales? -> " + pila.esIgual(pila2));
    }
}
