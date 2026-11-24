package ej2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ej2AppTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Producto> carrito = new ArrayList<>();
        carrito.add(new Producto("Teclado Mecanico", 200.0));
        carrito.add(new Producto("Teclado Mecanico", 200.0));
        carrito.add(new Producto("Mouse Optico", 50.0));

        CalculadoraDePrecios calculadora = new CalculadoraDePrecios();
        int opcion;

        do {
            System.out.println("\n=== MENU DE DESCUENTOS ====");
            System.out.println("Productos en carrito: 2 Teclados (S/ 200 c/u) + 1 Mouse (S/ 50)");
            System.out.println("1. Sin Descuento");
            System.out.println("2. Descuento Fijo (10% al total)");
            System.out.println("3. Descuento Porcentual (30% en 2 productos iguales)");
            System.out.println("4. Descuento Porcentual Acumulado (50% en el producto mas barato desde 3 unid.)");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opcion -> ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    calculadora.setEstrategia(new SinDescuento());
                    System.out.println("Total a pagar: S/ " + calculadora.calcular(carrito));
                    break;
                case 2:
                    calculadora.setEstrategia(new DescuentoFijo());
                    System.out.println("Total a pagar: S/ " + calculadora.calcular(carrito));
                    break;
                case 3:
                    calculadora.setEstrategia(new DescuentoPorcentual());
                    System.out.println("Total a pagar: S/ " + calculadora.calcular(carrito));
                    break;
                case 4:
                    calculadora.setEstrategia(new DescPorcentualAcumulado());
                    System.out.println("Total a pagar: S/ " + calculadora.calcular(carrito));
                    break;
                case 0:
                    System.out.println("Finalizando programa...");
                    break;
                default:
                    System.out.println("Opcion invalida");
            }
        } while (opcion != 0);
        sc.close();
    }
}
