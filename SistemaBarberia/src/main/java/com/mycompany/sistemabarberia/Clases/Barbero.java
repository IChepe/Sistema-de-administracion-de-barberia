package com.mycompany.sistemabarberia.Clases;

public class Barbero {

// Catalogo de dias. El lunes es el indice 0, el sabado el 5.
public static String[] DIAS = {
    "Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado"
};

// Catalogo de bloques de hora. El de 06:00-07:00 es el indice 0.
public static String[] BLOQUES = {
    "06:00-07:00", "07:00-08:00", "08:00-09:00", "09:00-10:00", "10:00-11:00",
    "11:00-12:00", "12:00-13:00", "13:00-14:00", "14:00-15:00", "15:00-16:00",
    "16:00-17:00", "17:00-18:00", "18:00-19:00", "19:00-20:00"
};

private int id;
private String nombre;
private String especialidad;
private String fechaRegistro;
private boolean[] dias;      // marca que dias trabaja: dias[0] = Lunes
private boolean[] bloques;   // marca que bloques atiende: bloques[0] = 06:00-07:00
private Double comision;
private String estado;
private boolean estadousuario;

    public Barbero() {
        this.dias = new boolean[DIAS.length];
        this.bloques = new boolean[BLOQUES.length];
    }

    public Barbero(int id, String nombre, String especialidad, String fechaRegistro, boolean[] dias, boolean[] bloques, Double comision, String estado, boolean estadousuario) {
        this.id = id;
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.fechaRegistro = fechaRegistro;
        this.dias = dias;
        this.bloques = bloques;
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

    public boolean[] getDias() {
        return dias;
    }

    public void setDias(boolean[] dias) {
        this.dias = dias;
    }

    public boolean[] getBloques() {
        return bloques;
    }

    public void setBloques(boolean[] bloques) {
        this.bloques = bloques;
    }

    // Devuelve true si el barbero trabaja ese dia Y atiende ese bloque.
    public boolean trabajaEn(int dia, int bloque) {
        return dias[dia] && bloques[bloque];
    }

    // Arma el texto de los dias marcados, para poder mostrarlos.
    public String getDiasTexto() {
        String texto = "";
        for (int i = 0; i < DIAS.length; i++) {
            if (dias[i]) {
                texto += DIAS[i] + " ";
            }
        }
        if (texto.equals("")) {
            return "Sin dias asignados";
        }
        return texto;
    }

    // Arma el texto de los bloques marcados, para poder mostrarlos.
    public String getBloquesTexto() {
        String texto = "";
        for (int i = 0; i < BLOQUES.length; i++) {
            if (bloques[i]) {
                texto += BLOQUES[i] + " ";
            }
        }
        if (texto.equals("")) {
            return "Sin horario asignado";
        }
        return texto;
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
             + "\n\nID: " + id
             + "\nNombre: " + nombre 
             + "\nEspecialidad: " + especialidad 
             + "\nFecha de registro del barbero: " + fechaRegistro 
             + "\nDias que trabaja: " + getDiasTexto()
             + "\nHorario del barbero: " + getBloquesTexto()
             + "\nComisión del barbero: " + comision 
             + "\nEstado: " + estado 
             + "\nEstado del usuario: " + (estadousuario ? "Activo" : "Inactivo");
    }

    
    

}
