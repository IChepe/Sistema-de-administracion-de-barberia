package com.mycompany.sistemabarberia.Clases;

import com.mycompany.sistemabarberia.Enumeradores.Categoria;

public class Inventario {
 
    private int id;
    private String descripcion;
    private Categoria categoria;
    private int stock;
    private int stockMinimo;
    private double precioCompra;
    private double precioVenta;
    private String unidadMedida;

    public Inventario() {
    }

    public Inventario(int id, String descripcion, Categoria categoria, int stock, int stockMinimo,
                      double precioCompra, double precioVenta, String unidadMedida) {
        this.id = id;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.stock = stock;
        this.stockMinimo = stockMinimo;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
        this.unidadMedida = unidadMedida;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public int getStock() {
        return stock;
    }

    public int getStockMinimo() {
        return stockMinimo;
    }

    public double getPrecioCompra() {
        return precioCompra;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setStockMinimo(int stockMinimo) {
        this.stockMinimo = stockMinimo;
    }

    public void setPrecioCompra(double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    @Override
    public String toString() {
        return "Producto ID: " + id +
               "\nDescripción: " + descripcion +
               "\nCategoría: " + categoria +
               "\nStock: " + stock +
               "\nStock mínimo: " + stockMinimo +
               "\nPrecio compra: " + precioCompra +
               "\nPrecio venta: " + precioVenta +
               "\nUnidad de medida: " + unidadMedida;
    }
}
