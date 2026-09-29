// Crea una clase IgualGenerico donde escriba una versión genérica simple del método esIgualA
// que compare sus dos argumentos con el método equals y devuelva true si son iguales, y
// false en caso contrario. Use este método genérico en un programa que llame a esIgualA
// con los tipos integrados, null, Object, Integer y String. ¿Qué resultado obtiene al
// tratar de ejecutar este programa?

package act3;

public class IgualGenerico {
    public static <T> boolean esIgualA(T obj1, T obj2) {
        // Se verifica si el objt1 es nulo, de serlo retorna un valor booleano
        // resultado de la verificacion obj2 == null
        if(obj1 == null) {
            return obj2 == null;
        }
        // Si la primera condicion no se cumple, el metodo retorna un valor
        // booleano resultado de verificar la igualdad de ambos objetos
        return obj1.equals(obj2);
    }
}
