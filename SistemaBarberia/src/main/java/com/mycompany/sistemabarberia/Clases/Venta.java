package com.mycompany.sistemabarberia.Clases;

public class Venta {
private int id;
private Servicio idServicio;
private Cliente idCliente;
private Barbero idBarbero;
private double subtotal;
private double descuento;
private double impuesto;
private double total;
private boolean estado;
private String fechaVenta;

    public Venta() {
        this.estado = true;
    }

    public Venta(int id, Servicio idServicio, Cliente idCliente, Barbero idBarbero, double subtotal, double descuento, double impuesto, double total, boolean estado, String fechaVenta) {
        this.id = id;
        this.idServicio = idServicio;
        this.idCliente = idCliente;
        this.idBarbero = idBarbero;
        this.subtotal = subtotal;
        this.descuento = descuento;
        this.impuesto = impuesto;
        this.total = total;
        this.estado = estado;
        this.fechaVenta = fechaVenta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Servicio getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(Servicio idServicio) {
        this.idServicio = idServicio;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    public Barbero getIdBarbero() {
        return idBarbero;
    }

    public void setIdBarbero(Barbero idBarbero) {
        this.idBarbero = idBarbero;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public double getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(double impuesto) {
        this.impuesto = impuesto;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(String fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    @Override
    public String toString() {
        return "----- Venta -----" + "\n"
             + "ID: " + id + "\n"
             + "Fecha: " + fechaVenta + "\n"
             + "Cliente: " + (idCliente != null ? idCliente.getNombre() + " " + idCliente.getApellido() : "Sin asignar") + "\n"
             + "Barbero: " + (idBarbero != null ? idBarbero.getNombre() : "Sin asignar") + "\n"
             + "Servicio: " + (idServicio != null ? idServicio.getNombreser() : "Sin asignar") + "\n"
             + "Subtotal: " + subtotal + "\n"
             + "Descuento: " + descuento + "\n"
             + "Impuesto: " + impuesto + "\n"
             + "Total: " + total + "\n"
             + "Estado: " + (estado ? "Activa" : "Anulada") + "\n";
    }







}
