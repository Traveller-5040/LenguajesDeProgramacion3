package ej2;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

public class GestorEstudiantes {

    // Arreglo donde se guardan los registros (empieza con espacio para 10)
    private Estudiante[] registros = new Estudiante[10];

    // Cuantos registros hay realmente guardados (el arreglo puede tener espacios vacios)
    private int cantidad = 0;

    // Agrega un estudiante al arreglo; si esta lleno, lo hace crecer al doble.
    public void agregar(Estudiante e) {
        if (cantidad == registros.length) {
            registros = Arrays.copyOf(registros, registros.length * 2);
        }
        registros[cantidad] = e;
        cantidad++;
    }

    // Vacia el arreglo (se usa antes de volver a cargar los datos).
    public void limpiar() {
        registros = new Estudiante[10];
        cantidad = 0;
    }

    // Lee la tabla de la base de datos y guarda cada fila como objeto Estudiante.
    public void cargarDesdeBD(Connection con) throws SQLException {
        limpiar();
        // try-with-resources: cierra Statement y ResultSet automaticamente
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT id, nombre, edad, carrera FROM estudiantes")) {
            while (rs.next()) {
                agregar(new Estudiante(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4)));
            }
        }
    }
    
    public void consultar(String[] campos, String campoCond, String operador, String valorCond,
                          String campoOrden, boolean ascendente, int limite) {

        // Si no se indicaron campos, se muestran todos
        if (campos == null || campos.length == 0) {
            campos = Estudiante.CAMPOS;
        }

        // 1) FILTRAR (WHERE): se copian a un arreglo auxiliar solo los que cumplen
        Estudiante[] resultado = new Estudiante[cantidad];
        int n = 0; // cuantos registros pasaron el filtro
        boolean hayCondicion = campoCond != null && !campoCond.isEmpty();
        for (int i = 0; i < cantidad; i++) {
            if (!hayCondicion || cumple(registros[i], campoCond, operador, valorCond)) {
                resultado[n] = registros[i];
                n++;
            }
        }

        // 2) ORDENAR (ORDER BY): ordenamiento por insercion.
        // Cada elemento se va colocando en su posicion correcta
        // dentro de la parte que ya esta ordenada.
        if (campoOrden != null && !campoOrden.isEmpty()) {
            for (int i = 1; i < n; i++) {
                Estudiante actual = resultado[i];
                int j = i - 1;
                // Mientras el anterior deba ir despues del actual, se desplaza una posicion
                while (j >= 0 && debeIrDespues(resultado[j], actual, campoOrden, ascendente)) {
                    resultado[j + 1] = resultado[j];
                    j--;
                }
                resultado[j + 1] = actual;
            }
        }

        // 3) LIMITAR (LIMIT): si hay limite y es menor que lo encontrado, se usa el limite
        int tope = (limite > 0 && limite < n) ? limite : n;

        // 4) MOSTRAR (SELECT campos): solo las columnas pedidas
        System.out.println();
        for (String campo : campos) {
            System.out.printf("%-15s", campo.toUpperCase());
        }
        System.out.println();
        System.out.println("-".repeat(15 * campos.length));

        for (int i = 0; i < tope; i++) {
            for (String campo : campos) {
                System.out.printf("%-15s", resultado[i].getValor(campo));
            }
            System.out.println();
        }
        System.out.println("(" + tope + " registro(s) mostrado(s))");
    }

    // Indica si un estudiante cumple la condicion "campo operador valor".
    private boolean cumple(Estudiante e, String campo, String operador, String valorTxt) {
        Object valor = e.getValor(campo);

        // "contiene" busca el texto dentro del valor, sin distinguir mayusculas
        if (operador.equalsIgnoreCase("contiene")) {
            return valor.toString().toLowerCase().contains(valorTxt.toLowerCase());
        }

        // Si el campo es numerico (id, edad), el valor escrito se convierte a numero
        // para comparar bien (si no, "9" seria mayor que "10" como texto).
        Object referencia = valorTxt;
        if (valor instanceof Integer) {
            referencia = Integer.parseInt(valorTxt.trim()); // lanza NumberFormatException si no es numero
        }
        int c = comparar(valor, referencia); // negativo, 0 o positivo

        switch (operador) {
            case "=":  return c == 0;
            case "<>": return c != 0;
            case ">":  return c > 0;
            case "<":  return c < 0;
            case ">=": return c >= 0;
            case "<=": return c <= 0;
            default:
                throw new IllegalArgumentException("Operador no valido: " + operador);
        }
    }

    // Compara dos valores: numeros como numeros y textos como textos
    // (sin distinguir mayusculas). Devuelve negativo si a < b, 0 si son iguales y positivo si a > b.

    private int comparar(Object a, Object b) {
        if (a instanceof Integer && b instanceof Integer) {
            return Integer.compare((Integer) a, (Integer) b);
        }
        return a.toString().compareToIgnoreCase(b.toString());
    }

    // Devuelve true si 'a' debe colocarse despues de 'b' segun el orden pedido.
    private boolean debeIrDespues(Estudiante a, Estudiante b, String campo, boolean ascendente) {
        int c = comparar(a.getValor(campo), b.getValor(campo));
        // Ascendente: a va despues si es mayor. Descendente: a va despues si es menor.
        return ascendente ? c > 0 : c < 0;
    }
}