package com.mycompany.sistemabarberia.Clases;

import com.mycompany.sistemabarberia.Enumeradores.Categoria;

public class Inventario {

    private int id;
    private String nombre;
    private String descripcion;
    private Categoria categoria;
    private int stock;
    private int stockMinimo;
    private double precioCompra;
    private double precioVenta;
    private String unidadMedida;
    private boolean estado;

    public Inventario() {
        this.estado = true;
    }

    public Inventario(int id, String nombre, String descripcion, Categoria categoria, int stock, int stockMinimo, double precioCompra, double precioVenta, String unidadMedida, boolean estado) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.stock = stock;
        this.stockMinimo = stockMinimo;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
        this.unidadMedida = unidadMedida;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getStockMinimo() {
        return stockMinimo;
    }

    public void setStockMinimo(int stockMinimo) {
        this.stockMinimo = stockMinimo;
    }

    public double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "----- Producto -----" + "\n"
             + "ID: " + id + "\n"
             + "Nombre: " + nombre + "\n"
             + "Descripcion: " + descripcion + "\n"
             + "Categoria: " + categoria + "\n"
             + "Stock: " + stock + " " + unidadMedida + "\n"
             + "Stock minimo: " + stockMinimo + "\n"
             + "Precio de compra: " + precioCompra + "\n"
             + "Precio de venta: " + precioVenta + "\n"
             + "Estado: " + (estado ? "Activo" : "Inactivo") + "\n";
    }

}
