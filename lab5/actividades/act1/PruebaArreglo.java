package act1;

import static act1.ImprimirArreglo.imprimirArreglo;

public class PruebaArreglo {
    public static void main(String[] args) throws InvalidSubscriptException {
        Integer[] arregloInteger = { 1, 2, 3, 4, 5, 6 };
        Double[] arregloDouble = { 1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7 };
        Character[] arregloCharacter = { 'H', 'O', 'L', 'A' };

        System.out.println( "El arreglo arregloInteger contiene:" );
        imprimirArreglo(arregloInteger);
        System.out.println( "\nEl arreglo arregloDouble contiene:" );
        imprimirArreglo(arregloDouble);
        System.out.println( "\nEl arreglo arregloCharacter contiene:" );
        imprimirArreglo(arregloCharacter);

        System.out.println();

        System.out.println( "El arreglo arregloInteger entre los indices 2 y 4 contiene:" );
        imprimirArreglo(arregloInteger, 2, 4);
        System.out.println( "\nEl arreglo arregloDouble entre los indices 1 y 5 contiene:" );
        imprimirArreglo(arregloDouble, 1, 5);
        System.out.println( "\nEl arreglo arregloCharacter entre los indices 0 y 2 contiene:" );
        imprimirArreglo(arregloCharacter, 0, 2);
    }
}
