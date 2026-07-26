/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemabarberia.Clases;

/**
 *
 * @author sscr
 */
public class Servicio {
    
    private int idServicio;
    private String Nombreser;
    private double precio;
    private int Duracionest;
    private String categoria;
 
    
    public Servicio (){
       idServicio = 0;
       Nombreser = "";
       precio = 0;
       Duracionest = 0;
       categoria = "";
    }

    public Servicio(int idServicio, String Nombreser, double precio, int Duracionest, String categoria) {
        this.idServicio = idServicio;
        this.Nombreser = Nombreser;
        this.precio = precio;
        this.Duracionest = Duracionest;
        this.categoria = categoria;
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
    
    
    
}
