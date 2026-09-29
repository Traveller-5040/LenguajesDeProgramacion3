// Modifica la clase Pila para implementar el método contains(E elemento):
// Este método debe recibir un elemento y devolver true si el elemento está en la pila,
// o false si no lo está. La búsqueda debe realizarse desde el tope de la pila hacia
// el fondo, sin modificar el estado actual de la pila.

package act2;

public class Pila <E> {
    private final int tamano;
    private int superior;
    private E[] elementos;
    public Pila() {
        this(10);
    }

    public Pila(int a) {
        this.tamano = a > 0 ? a : 10;
        this.superior = -1;
        this.elementos = (E[]) new Object[tamano];
    }

    public void push(E valorAgregado) {
        if(superior == tamano - 1) {
            throw new ExcepcionPilaLlena("La pila esta llena, no puede recibir mas valores.");
        }
        elementos[++superior]  = valorAgregado;
    }

    public E pop() {
        if(superior == -1) {
            throw new ExcepcionPilaVacia("La pila esta vacia, no hay valores que eleminar");
        }
        return elementos[superior--];
    }

    public boolean contains(E elemento) {
        // Se verifica si la pila esta vacia.
        if(superior == -1) {
            // Si la pila esta vacia, se lanza la excepcion correspondiente.
            throw new ExcepcionPilaVacia("La pila esta vacia, no hay elementos a buscar");
        }

        // Se recorre la pila desde el elemento superior hasta el elemento inferior,
        // sin modificar el estado actual de la pila.
        for(int i = superior; i >= 0; i--) {
            // El operador ternario "?" permite realizar una comparacion diferente
            // dependiendo de si el elemento buscado es nulo o no.
            // Si es nulo, se verifica si el elemento actual tambien es nulo.
            // Si no es nulo, se compara su contenido mediante equals().
            if(elemento == null ? elementos[i] == null : elemento.equals(elementos[i])) {
                // Si se encuentra una coincidencia, el metodo retorna true.
                return true;
            }
        }

        // Si se recorrieron todos los elementos y no se encontro ninguna coincidencia,
        // el metodo retorna false.
        return false;
    }

    public boolean esIgual(Pila<E> otraPila) {
        // Se verifica si la pila esta vacia, de estarlo lanza la excepcion personalida
        if(superior == -1) {
            throw new ExcepcionPilaVacia("La pila esta vacia");
        }

        // Se verifica que ambas pilas tengan el mismo valor de orden del elemento superior
        if(this.superior != otraPila.superior) {
            return false;
        }

        // Inicia el bucle for que recorrera los elementos de ambas pilas en orden descendente.
        for(int i = 0; i <= this.superior; i++) {
            // Se comprueba si algun elemento es distinto al de la otra pila,
            // si llega a encontrar alguna diferencia de elementos retorna False.
            if(!this.elementos[i].equals(otraPila.elementos[i])) {
                return false;
            }
        }
        // Si el bucle for termina satisfactoriamente retorna True.
        return true;
    }
}
