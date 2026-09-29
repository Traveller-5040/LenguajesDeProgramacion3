// Escriba una clase genérica llamada Par, que tenga dos parámetros de tipo: F y S,
// cada uno de los cuales representa el tipo del primer y segundo elementos del par,
// respectivamente. Agregue métodos getPrimero, getSegundo, setPrimero y setSegundo
// para los elementos primero y segundo del par. [Sugerencia: el encabezado de la clase
// debe ser public class Par< F, S >]. Agregue el método toString que devuelva la
//  representación del par de la forma “(Primero: x, Segundo: y)”.

package ejercicios;

public class Par<F, S> {
    F f;
    S s;
    public Par(F f, S s) {
        this.f = f;
        this.s = s;
    }

    public F getF() { return f; }
    public S getS() { return this.s; }

    public void setF(F newF) {
        this.f = newF;
    }
    public void setS(S newS) {
        this.s = newS;
    }

    @Override
    public String toString() {
        return "Primero: " + this.f + ", Segundo: " + this.s ;
    }

    public boolean esIgual(Par<F, S> otroPar) {
        return this.f.equals(otroPar.getF()) && this.s.equals(otroPar.getS());
    }
}
