package com.mycompany.sistemabarberia.Clases;

public class ProductoVendido {

    private int id;
    private Inventario inventario;
    private Venta venta;
    private int cantidad;
    private double precioUnitario;
    private double subtotal;

    public ProductoVendido() {
    }

    public ProductoVendido(int id, Inventario inventario, Venta venta, int cantidad, double precioUnitario) {
        this.id = id;
        this.inventario = inventario;
        this.venta = venta;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.subtotal = cantidad * precioUnitario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Inventario getInventario() {
        return inventario;
    }

    public void setInventario(Inventario inventario) {
        this.inventario = inventario;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
        this.subtotal = cantidad * precioUnitario;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
        this.subtotal = cantidad * precioUnitario;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    @Override
    public String toString() {
        String nombreproducto = "";
        if(inventario != null){
            nombreproducto = inventario.getNombre();
        }else{
            nombreproducto = "Sin aignar";
        }
        int idventa = 0;
        if(venta != null){
            idventa = venta.getId();
        }else{
            idventa = 0;
        }
        return "----- Producto Vendido -----" + "\n"
             + "ID: " + id + "\n"
             + "Producto: " + nombreproducto + "\n"
             + "Venta N°: " + idventa + "\n"
             + "Cantidad: " + cantidad + "\n"
             + "Precio unitario: " + precioUnitario + "\n"
             + "Subtotal: " + subtotal + "\n";
    }

}
