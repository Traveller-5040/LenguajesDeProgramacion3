package actividad5;

import java.util.Scanner;

public class BancoApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // se crean 5 cuentas de ahorro y 5 cuentas corrientes, tal como pide el paso 7
        Cuenta[] cuentas = new Cuenta[10];
        for (int i = 0; i < 5; i++) {
            CuentaAhorro ca = new CuentaAhorro(100 + i);
            ca.setTasaInteres(2.5); // 2.5 por ciento de interes mensual
            cuentas[i] = ca;
        }
        for (int i = 0; i < 5; i++) {
            cuentas[5 + i] = new CuentaCorriente(200 + i);
        }

        boolean salir = false;
        while (!salir) {
            System.out.println("");
            System.out.println("Menu");
            System.out.println("D) Depositar");
            System.out.println("R) Retirar");
            System.out.println("C) Consultar");
            System.out.println("S) Salir");
            System.out.print("Elija una opcion: ");
            String opcion = sc.next().toUpperCase();

            // el switch decide que accion tomar segun la letra elegida
            switch (opcion) {
                case "D":
                    hacerTransaccion(sc, cuentas, true);
                    break;
                case "R":
                    hacerTransaccion(sc, cuentas, false);
                    break;
                case "C":
                    // se recorren todas las cuentas para hacer la consulta mensual
                    for (Cuenta c : cuentas) {
                        c.consultar();
                        System.out.println("Cuenta " + c.getNumeroCuenta() + " saldo: " + c.getSaldo());
                    }
                    break;
                case "S":
                    salir = true;
                    break;
                default:
                    System.out.println("Opcion no valida");
            }
        }

        System.out.println("Fin del programa");
        sc.close();
    }

    // metodo compartido por depositar y retirar, para no repetir codigo
    private static void hacerTransaccion(Scanner sc, Cuenta[] cuentas, boolean esDeposito) {
        System.out.print("Numero de cuenta: ");
        int numero = sc.nextInt();
        System.out.print("Importe: ");
        double importe = sc.nextDouble();

        Cuenta cuenta = buscarCuenta(cuentas, numero);
        if (cuenta == null) {
            System.out.println("No existe esa cuenta");
            return;
        }

        if (esDeposito) {
            cuenta.depositar(importe);
        } else {
            cuenta.retirar(importe);
        }
        System.out.println("Saldo despues de la operacion: " + cuenta.getSaldo());
    }

    // busca una cuenta en el arreglo por su numero
    private static Cuenta buscarCuenta(Cuenta[] cuentas, int numero) {
        for (Cuenta c : cuentas) {
            if (c.getNumeroCuenta() == numero) {
                return c;
            }
        }
        return null;
    }
}
