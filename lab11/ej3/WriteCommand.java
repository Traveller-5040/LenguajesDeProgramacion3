package ej3;

public class WriteCommand implements CommandEditor {
    private DocTxt documento;
    private String texto;

    public WriteCommand(DocTxt documento, String texto) {
        this.documento = documento;
        this.texto = texto;
    }

    @Override
    public void ejecutar() {
        documento.agregarTexto(texto);
    }

    @Override
    public void deshacer() {
        documento.eliminarUltimosCaracteres(texto.length());
    }
}
