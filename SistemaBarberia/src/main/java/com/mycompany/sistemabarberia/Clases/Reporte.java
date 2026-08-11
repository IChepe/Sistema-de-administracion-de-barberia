package com.mycompany.sistemabarberia.Clases;

import com.mycompany.sistemabarberia.Enumeradores.Tipo;

public class Reporte {

    private int id;
    private Tipo tipos;
    private Inventario idInventario;
    private Venta idVenta;
    private Citas idCita;
    private Cliente idCliente;
    private boolean estado;

    public Reporte() {
        this.estado = true;
    }

    public Reporte(int id, Tipo tipos, Inventario idInventario, Venta idVenta, Citas idCita, Cliente idCliente, boolean estado) {
        this.id = id;
        this.tipos = tipos;
        this.idInventario = idInventario;
        this.idVenta = idVenta;
        this.idCita = idCita;
        this.idCliente = idCliente;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Tipo getTipos() {
        return tipos;
    }

    public void setTipos(Tipo tipos) {
        this.tipos = tipos;
    }

    public Inventario getIdInventario() {
        return idInventario;
    }

    public void setIdInventario(Inventario idInventario) {
        this.idInventario = idInventario;
    }

    public Venta getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Venta idVenta) {
        this.idVenta = idVenta;
    }

    public Citas getIdCita() {
        return idCita;
    }

    public void setIdCita(Citas idCita) {
        this.idCita = idCita;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "----- Reporte -----" + "\n"
             + "ID: " + id + "\n"
             + "Tipo: " + tipos + "\n"
             + "Estado: " + (estado ? "Activo" : "Inactivo") + "\n";
    }

}
