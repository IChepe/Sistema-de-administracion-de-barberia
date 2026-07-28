package com.mycompany.sistemabarberia.Clases;

import com.mycompany.sistemabarberia.Enumeradores.Categoria;

public class Inventario {
    private int id;
    private String nombre;
    private String descripcion;
    private Categoria categorias;
    private int stock;
    private int stokMinimo;
    private double precioCompra;
    private double precioVenta;
    private String UnidadMedida;

    public Inventario(int id, String nombre, String descripcion, Categoria categorias, int stock, int stokMinimo, double precioCompra, double precioVenta, String UnidadMedida) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.categorias = categorias;
        this.stock = stock;
        this.stokMinimo = stokMinimo;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
        this.UnidadMedida = UnidadMedida;
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

    public Categoria getCategorias() {
        return categorias;
    }

    public void setCategorias(Categoria categorias) {
        this.categorias = categorias;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getStokMinimo() {
        return stokMinimo;
    }

    public void setStokMinimo(int stokMinimo) {
        this.stokMinimo = stokMinimo;
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
        return UnidadMedida;
    }

    public void setUnidadMedida(String UnidadMedida) {
        this.UnidadMedida = UnidadMedida;
    }

    @Override
    public String toString() {
        return "Inventario{" + "id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", categorias=" + categorias + ", stock=" + stock + ", stokMinimo=" + stokMinimo + ", precioCompra=" + precioCompra + ", precioVenta=" + precioVenta + ", UnidadMedida=" + UnidadMedida + '}';
    }

    
    
    
    
    
    
    
    
    
    
    

}
