package com.example.examenfinal;

import java.util.ArrayList;
import java.util.List;

public class Producto {
    private String nombre;
    private int cantidad;
    private double precio;

    public Producto(String nombre, int cantidad, double precio) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    // Getters y setters (opcional)

    public static List<Producto> obtenerProductos() {
        List<Producto> listaProductos = new ArrayList<>();
        listaProductos.add(new Producto("Producto 1", 2, 10.99));
        listaProductos.add(new Producto("Producto 2", 1, 5.99));
        listaProductos.add(new Producto("Producto 3", 3, 8.50));
        // Agrega más productos si es necesario
        return listaProductos;
    }

    public double getPrecio() {
        return 0;
    }

    public int getNombre() {
        return 0;
    }

    public int getCantidad() {
        return 0;
    }
}