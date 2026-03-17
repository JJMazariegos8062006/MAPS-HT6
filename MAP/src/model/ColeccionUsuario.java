package model;

import java.util.Comparator;
import java.util.Map;

public class ColeccionUsuario {
    private Map<String, Integer> carrito;

    public ColeccionUsuario(Map<String, Integer> carrito) {
        this.carrito = carrito;
    }

    public void agregarProducto(String producto, Inventario inventario) {
        if (!inventario.existe(producto)) {
            System.out.println("Error: no existe");
            return;
        }
        carrito.put(producto, carrito.getOrDefault(producto, 0) + 1);
    }

    public void mostrar(Inventario inventario) {
        carrito.forEach((p, cant) ->
                System.out.println(p + " | " + inventario.getCategoria(p) + " | " + cant));
    }

    public void mostrarOrdenado(Inventario inventario) {
        carrito.entrySet().stream()
                .sorted(Comparator.comparing(e -> inventario.getCategoria(e.getKey())))
                .forEach(e -> System.out.println(
                        e.getKey() + " | " + inventario.getCategoria(e.getKey()) + " | " + e.getValue()
                ));
    }
}

