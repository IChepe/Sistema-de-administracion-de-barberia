package com.mycompany.sistemabarberia.Clases;

public class Barbero {
private int id;
private String nombre;
private String especialidad;
private String fechaRegistro;
private String horario;
private Double comision;
private String estado;
private boolean estadousuario;

    public Barbero() {
    }

    public Barbero(int id, String nombre, String especialidad, String fechaRegistro, String horario, Double comision, String estado, boolean estadousuario) {
        this.id = id;
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.fechaRegistro = fechaRegistro;
        this.horario = horario;
        this.comision = comision;
        this.estado = estado;
        this.estadousuario = estadousuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public Double getComision() {
        return comision;
    }

    public void setComision(Double comision) {
        this.comision = comision;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public boolean isEstadousuario() {
        return estadousuario;
    }

    public void setEstadousuario(boolean estadousuario) {
        this.estadousuario = estadousuario;
    }



    @Override
    public String toString() {
        return "Barbero" 
             + "\nID: " + id
             + "\nNombre: " + nombre 
             + "\nEspecialidad: " + especialidad 
             + "\nFecha de registro del barbero: " + fechaRegistro 
             + "\nHorario del barbero: " + horario 
             + "\nComisión del barbero: " + comision 
             + "\nEstado: " + estado 
             + "\nEstado del usuario: " + (estadousuario ? "Activo" : "Inactivo"
             + "\n");
    }

    
    

}
