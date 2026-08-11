package com.mycompany.sistemabarberia.Clases;

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

    
    public Inventario(int id, String nombre, String descripcion, Categoria categorias,
                      int stock, int stockMinimo, double precioCompra, double precioVenta, String unidadMedida) {
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

   
    public void crear() {
        System.out.println("Producto creado: " + nombre);
    }

    public void consultar() {
        System.out.println("Consulta de producto: " + this);
    }

    public void actualizar(String nuevoNombre, String nuevaDescripcion, double nuevoPrecioVenta) {
        this.nombre = nuevoNombre;
        this.descripcion = nuevaDescripcion;
        this.precioVenta = nuevoPrecioVenta;
        System.out.println("Producto actualizado: " + nombre);
    }

    public void eliminar() {
        System.out.println("Producto eliminado: " + nombre);
    }

    public void actualizarStock(int nuevoStock) {
        this.stock = nuevoStock;
        System.out.println("Stock actualizado: " + stock);
    }

    public boolean verificarStockMinimo() {
        return stock <= stockMinimo;
    }

    public void descontarStock(int cantidad) {
        if (cantidad <= stock) {
            stock -= cantidad;
            System.out.println("Stock descontado. Nuevo stock: " + stock);
        } else {
            System.out.println("Error: cantidad a descontar mayor que el stock disponible.");
        }
    }

    @Override
    public String toString() {
        return "Inventario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", categoria=" + (categorias != null ? categorias.getNombre() : "Sin categoría") +
                ", stock=" + stock +
                ", stockMinimo=" + stockMinimo +
                ", precioCompra=" + precioCompra +
                ", precioVenta=" + precioVenta +
                ", unidadMedida='" + unidadMedida + '\'' +
                '}';
    }
}
