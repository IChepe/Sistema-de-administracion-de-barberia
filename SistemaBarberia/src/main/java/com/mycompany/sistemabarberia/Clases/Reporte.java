package com.mycompany.sistemabarberia.Clases;

import com.mycompany.sistemabarberia.Enumeradores.Tipo;

public class Reporte {
private int id;
private Tipo tipos;
private Inventario idInventario;
private Venta idVenta;
private Citas idCita;
private Cliente idCliente;

    public Reporte(int id, Tipo tipos, Inventario idInventario, Venta idVenta, Citas idCita, Cliente idCliente) {
        this.id = id;
        this.tipos = tipos;
        this.idInventario = idInventario;
        this.idVenta = idVenta;
        this.idCita = idCita;
        this.idCliente = idCliente;
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

    @Override
    public String toString() {
        return "Reporte{" + "id=" + id + ", tipos=" + tipos + ", idInventario=" + idInventario + ", idVenta=" + idVenta + ", idCita=" + idCita + ", idCliente=" + idCliente + '}';
    }


    
    
    
    






}
