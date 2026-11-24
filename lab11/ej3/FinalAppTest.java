package ej3;

public class FinalAppTest {
    public static void main(String[] args) {
        DocTxt doc = new DocTxt();
        EditManager gestor = new EditManager();

        gestor.ejecutarComando(new WriteCommand(doc, "UCSM - Facultad de Ingenierias"));
        gestor.ejecutarComando(new WriteCommand(doc, " - EPIS "));
        System.out.println("Texto actual: " + doc.getContenido());

        gestor.deshacerUltimo();
        System.out.println("Tras deshacer: " + doc.getContenido());
    }
}
