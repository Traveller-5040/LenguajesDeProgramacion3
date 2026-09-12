import ej1.*;

import java.io.IOException;

public class Main {
    private LeerEntrada entrada;

    public Main() {
        this.entrada = new LeerEntrada(System.in);
    }

    public void procesar() throws IOException {
        char caracter = entrada.getChar();

        if(caracter == 'a' || caracter == 'e' || caracter == 'i' || caracter == 'o' || caracter == 'u'
        || caracter == 'A' || caracter == 'E' || caracter == 'I' || caracter == 'O' || caracter == 'U') {
            throw new ExcVocal("El caracter ingresado en una vocal");
        } else if(Character.isDigit(caracter)) {
            throw new ExcNum("EL caracter ingresado es un numero");
        } else if(caracter == '\n') {
            return;
        } else if(Character.isWhitespace(caracter)) {
            throw new ExcBlanco("Se ingreso un valor en blanco");
        } else if(caracter == 'S' || caracter == 's') {
            throw new ExcSalida("Se ingreso el caracter de salida");
        }
    }

    public static void main(String[] args) {
        Main test = new Main();

        while (true) {
            try {
                test.procesar();
            }
            catch (ExcVocal e) {
                System.err.println("Aviso (v) : " + e.getMessage());
            }
            catch (ExcNum e) {
                System.err.println("Aviso (n): " + e.getMessage());
            }
            catch (ExcBlanco e) {
                System.err.println("Aviso (b): " + e.getMessage());
            }
            catch (ExcSalida e) {
                System.err.println("Aviso de salida: " + e.getMessage());
                break;
            }
            catch (IOException e) {
                System.err.println("Error de lectura: " + e.getMessage());
                break;
            }
        }
    }
}