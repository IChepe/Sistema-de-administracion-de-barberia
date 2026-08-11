package com.mycompany.sistemabarberia.Clases;

import com.mycompany.sistemabarberia.Enumeradores.Categoria;

public class Inventario {
   private int id;
    private String nombre;
    private String descripcion;
    private Categoria categorias;
    private int stock;
    private int stockMinimo;
    private double precioCompra;
    private double precioVenta;
    private String unidadMedida;

    // Constructor
    public Inventario(int id, String nombre, String descripcion, Categoria categorias, int stock, int stockMinimo, double precioCompra, double precioVenta, String unidadMedida) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.categorias = categorias;
        this.stock = stock;
        this.stockMinimo = stockMinimo;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
        this.unidadMedida = unidadMedida;
    }

    // Métodos de acceso (getters y setters)
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public Categoria getCategorias() { return categorias; }
    public void setCategorias(Categoria categorias) { this.categorias = categorias; }

    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }

    public int getStockMinimo() { return stockMinimo; }
    public void setStockMinimo(int stockMinimo) { this.stockMinimo = stockMinimo; }

    public double getPrecioCompra() { return precioCompra; }
    public void setPrecioCompra(double precioCompra) { this.precioCompra = precioCompra; }

    public double getPrecioVenta() { return precioVenta; }
    public void setPrecioVenta(double precioVenta) { this.precioVenta = precioVenta; }

    public String getUnidadMedida() { return unidadMedida; }
    public void setUnidadMedida(String unidadMedida) { this.unidadMedida = unidadMedida; }

    // Métodos funcionales
    public void agregarStock(int cantidad) {
        this.stock += cantidad;
    }

    public void reducirStock(int cantidad) {
        if (cantidad <= this.stock) {
            this.stock -= cantidad;
        } else {
            System.out.println("Error: Stock insuficiente para reducir " + cantidad);
        }
    }

    public boolean necesitaReabastecer() {
        return this.stock <= this.stockMinimo;
    }

    public double calcularMargen() {
        return this.precioVenta - this.precioCompra;
    }

    public double calcularValorInventario() {
        return this.stock * this.precioCompra;
    }

    @Override
    public String toString() {
        return "Inventario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", categorias=" + categorias +
                ", stock=" + stock +
                ", stockMinimo=" + stockMinimo +
                ", precioCompra=" + precioCompra +
                ", precioVenta=" + precioVenta +
                ", unidadMedida='" + unidadMedida + '\'' +
                '}';
    }

    
    
    
    
    
    
    
    
    
    
    

}
