package ej2;

import java.util.ArrayList;
import java.util.List;

public class InventarioModel {
    // Se declara como unico atributo una lista de objetos de la clase "Item"
    private List<Item> items;

    public InventarioModel() {
        // Se inicializa el ArrayList que almacenara los items
        this.items = new ArrayList<>();
    }

    // Metodo que agrega un item; si ya existe uno con el mismo nombre solo suma la cantidad
    public void agregarItem(Item item) {
        Item existente = this.buscarItem(item.getNombre());
        if(existente != null) {
            existente.setCantidad(existente.getCantidad() + item.getCantidad());
        } else {
            this.items.add(item);
        }
    }

    public void eliminarItem(Item item) {
        // Elimina el item indicado de la lista
        this.items.remove(item);
    }

    public List<Item> obtenerItems() {
        // Retorna toda la lista de items de la instancia
        return this.items;
    }

    // Metodo que busca un item por su nombre, retorna null si no existe
    public Item buscarItem(String nombre) {
        for(Item i : items) {
            if(i.getNombre().equalsIgnoreCase(nombre)) {
                return i;
            }
        }
        return null;
    }
}
