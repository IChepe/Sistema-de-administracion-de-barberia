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
   
    private int idCita;
    private Cliente cliente;
    private Barbero barbero;
    private String fecha;
    private String hora;
    private int duracion;
    private String estado;
    
    public Citas(){
        idCita = 0;
        fecha = "";
        hora = "";
        duracion = 0;
        estado = "";     
    }

    public Citas(int idCita, Cliente cliente, Barbero barbero, String fecha, String hora, int duracion, String estado) {
        this.idCita = idCita;
        this.cliente = cliente;
        this.barbero = barbero;
        this.fecha = fecha;
        this.hora = hora;
        this.duracion = duracion;
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getIdCita() {
        return idCita;
    }

    public void setIdCita(int idCita) {
        this.idCita = idCita;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Barbero getBarbero() {
        return barbero;
    }

    public void setBarbero(Barbero barbero) {
        this.barbero = barbero;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }
    
    
    
}
