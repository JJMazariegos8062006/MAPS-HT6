package main;

import factory.MapFactory;
import model.ColeccionUsuario;
import model.Inventario;
import util.FileReaderUtil;

import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Seleccione implementación de Map:");
        System.out.println("1. HashMap\n2. TreeMap\n3. LinkedHashMap");
        int opcion = sc.nextInt();
        sc.nextLine();

        Map<String, String> inventarioMap = MapFactory.getMap(opcion);
        Map<String, Integer> carritoMap = MapFactory.getMap(opcion);

        FileReaderUtil.cargarInventario("MAP/src/ListadoProducto.txt", inventarioMap);

        Inventario inventario = new Inventario(inventarioMap);
        ColeccionUsuario carrito = new ColeccionUsuario(carritoMap);

        int choice;
        do {
            System.out.println("\n1. Agregar producto");
            System.out.println("2. Mostrar categoría");
            System.out.println("3. Mostrar colección");
            System.out.println("4. Mostrar colección ordenada");
            System.out.println("5. Mostrar inventario");
            System.out.println("6. Mostrar inventario ordenado");
            System.out.println("0. Salir");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Producto: ");
                    String prod = sc.nextLine();
                    carrito.agregarProducto(prod, inventario);
                    break;

                case 2:
                    System.out.print("Producto: ");
                    inventario.mostrarCategoria(sc.nextLine());
                    break;

                case 3:
                    carrito.mostrar(inventario);
                    break;

                case 4:
                    carrito.mostrarOrdenado(inventario);
                    break;

                case 5:
                    inventario.mostrar();
                    break;

                case 6:
                    inventario.mostrarOrdenado();
                    break;
            }

        } while (choice != 0);
    }
}
