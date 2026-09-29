package act1;

public class ImprimirArreglo {
    public static <E> void imprimirArreglo(E[] arreglo){
        for(E element : arreglo) {
            System.out.print(element + ", ");
        }
    }

    public static <E> void imprimirArreglo(E[] arreglo, int indiceI, int indiceF) throws InvalidSubscriptException {
        // Se verifica que el subindice final sea menor que el tamaño del arreglo,
        // de ser mayor el programa lanza la excepcion InvalidSubscriptException finalizando su ejecucion.
        if(indiceF > arreglo.length - 1) {
            throw new InvalidSubscriptException("El subindice final no debe ser mayor que la magnitud del arreglo");
        }

        // Se verifica que el subindice inicial sea mayor a 0 o menor que el subindice Final, de incumplir cualquiera de las dos,
        // el programa lanza la excepcion InvalidSubscriptException finalizando su ejecucion.
        if(indiceI < 0 || indiceI > indiceF){
            throw new InvalidSubscriptException("El subindice inicial no puede ser menor que 0 o mayor que el subindice superior");
        }

        // De cumplirse lo requerido inicia el bucle for que recorre el arreglo usando los subindices ingresados
        // como puntos de inicio y fin del recorrido
        for(int i = indiceI; i <= indiceF; i++) {
            // Imprime los elementos del arreglo dentro del rango ingresado
            System.out.print(arreglo[i] + ", ");
        }
    }
}
