package com.mycompany.sistemabarberia.Clases;

public class Barbero {
private int id;
private Usuario idUsuario;
private String especialidad;
private String fechaRegistro;
private String horario;
private Double comision;
private String estado;

    public Barbero(int id, Usuario idUsuario, String especialidad, String fechaRegistro, String horario, Double comision, String estado) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.especialidad = especialidad;
        this.fechaRegistro = fechaRegistro;
        this.horario = horario;
        this.comision = comision;
        this.estado = estado;
    }

    public Barbero() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
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

    @Override
    public String toString() {
        return "Barbero{" + "id=" + id + ", idUsuario=" + idUsuario + ", especialidad=" + especialidad + ", fechaRegistro=" + fechaRegistro + ", horario=" + horario + ", comision=" + comision + ", estado=" + estado + '}';
    }

    
    

}
