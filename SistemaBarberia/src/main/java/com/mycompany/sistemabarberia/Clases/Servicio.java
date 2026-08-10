/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemabarberia.Clases;


public class Servicio {
    
    private int idServicio;
    private String Nombreser;
    private double precio;
    private int Duracionest;
    private String categoria;
    private boolean estado;


    public Servicio (){
       idServicio = 0;
       Nombreser = "";
       precio = 0;
       Duracionest = 0;
       categoria = "";
       estado = true;
    }

    public Servicio(int idServicio, String Nombreser, double precio, int Duracionest, String categoria, boolean estado) {
        this.idServicio = idServicio;
        this.Nombreser = Nombreser;
        this.precio = precio;
        this.Duracionest = Duracionest;
        this.categoria = categoria;
        this.estado = estado;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }

    public String getNombreser() {
        return Nombreser;
    }

    public void setNombreser(String Nombreser) {
        this.Nombreser = Nombreser;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getDuracionest() {
        return Duracionest;
    }

    public void setDuracionest(int Duracionest) {
        this.Duracionest = Duracionest;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "----- Servicio -----" + "\n"
             + "ID: " + idServicio + "\n"
             + "Nombre: " + Nombreser + "\n"
             + "Precio: " + precio + "\n"
             + "Duracion estimada: " + Duracionest + " min" + "\n"
             + "Categoria: " + categoria + "\n"
             + "Estado: " + (estado ? "Activo" : "Inactivo") + "\n";
    }
    
    
    
}
