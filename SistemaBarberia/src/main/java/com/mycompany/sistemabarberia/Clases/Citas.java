/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemabarberia.Clases;

/**
 *
 * @author sscr
 */
public class Citas {
   
    private int id;
    private int idCliente;
    private int idBarbero;
    private int idServicio;
    private String fechahora;
    private int duracion;
    private String estado;
    private String notas;
    private String fechacreacion;

    public Citas() {
    }

    public Citas(int id, int idCliente, int idBarbero, int idServicio, String fechahora, int duracion, String estado, String notas, String fechacreacion) {
        this.id = id;
        this.idCliente = idCliente;
        this.idBarbero = idBarbero;
        this.idServicio = idServicio;
        this.fechahora = fechahora;
        this.duracion = duracion;
        this.estado = estado;
        this.notas = notas;
        this.fechacreacion = fechacreacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdBarbero() {
        return idBarbero;
    }

    public void setIdBarbero(int idBarbero) {
        this.idBarbero = idBarbero;
    }

    public int getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }

    public String getFechahora() {
        return fechahora;
    }

    public void setFechahora(String fechahora) {
        this.fechahora = fechahora;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    public String getFechacreacion() {
        return fechacreacion;
    }

    public void setFechacreacion(String fechacreacion) {
        this.fechacreacion = fechacreacion;
    }
    
     @Override
    public String toString() {
        return "Citas" 
             + "\nID: " + id
             + "\nID del cliente: " + idCliente 
             + "\nID del barbero: " + idBarbero 
             + "\nID del servicio: " + idServicio 
             + "\nFecha y hora: " + fechahora 
             + "\nDuración: " + duracion 
             + "\nEstado: " + estado 
             + "\nNotas: " + notas
             + "\nFecha de creación de la cita:  " +fechacreacion 
             + "\n";
    } 
}
