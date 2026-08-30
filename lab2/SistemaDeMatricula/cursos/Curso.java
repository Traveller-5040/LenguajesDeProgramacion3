package cursos;

import java.util.ArrayList;
import entidades.Profesor;
import gestion.Categoria;
import gestion.Inscripcion;

public abstract class Curso {
    public static final int LIMITE = 25;

    protected final String nombre;
    protected final String codigo;
    protected Profesor profesor;
    protected Categoria categoria;
    private ArrayList<Inscripcion> inscritos;

    public Curso(String n, String cod, Profesor doc, Categoria cat) {
        this.nombre = n;
        this.codigo = cod;
        this.profesor = doc;
        doc.asignarCurso(this);
        this.categoria = cat;

        this.inscritos = new ArrayList<>();
    }

    // GETTERS
    public String getNombre() { return this.nombre; }
    public String getCodigo() { return this.codigo; }
    public String getProfesor() { return this.profesor.getNombre(); }
    public String getCategoria() {return this.categoria.getNombre();}
    public int getCantidad() { return this.inscritos.size(); }
    public boolean getDisponibilidad() { return inscritos.size() < LIMITE; }

    public abstract String getTipo();

    // SETTERS
    public void setProfesor(Profesor newD) { this.profesor = newD; }

    // METODOS
    public void registrar(Inscripcion i) {
        if(inscritos.size() >= LIMITE) {
            System.out.println("No hay cupos en este curso");
        } else {
            inscritos.add(i);
        }
    }

    public String toString() {
        String docente = getProfesor();
        String categoriaS = getCategoria();
        String tipo = getTipo();
        return String.format("Codigo: %s | Nombre: %s | Categoria: %s | Tipo: %s | Docente: %s | Matriculados: %s/25",
                this.codigo,
                this.nombre,
                categoriaS,
                tipo,
                docente,
                inscritos.size()
        );
    }
}
