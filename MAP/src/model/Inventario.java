package model;
import java.util.Map;

public class Inventario {
    private Map<String, String> data;

    public Inventario(Map<String, String> data) {
        this.data = data;
    }

    public boolean existe(String producto) {
        return data.containsKey(producto);
    }

    public String getCategoria(String producto) {
        return data.get(producto);
    }

    public void mostrarCategoria(String producto) {
        if (existe(producto))
            System.out.println(data.get(producto));
        else
            System.out.println("No existe");
    }

    public void mostrar() {
        data.forEach((p, c) -> System.out.println(p + " | " + c));
    }

    public void mostrarOrdenado() {
        data.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(e -> System.out.println(e.getKey() + " | " + e.getValue()));
    }
}
