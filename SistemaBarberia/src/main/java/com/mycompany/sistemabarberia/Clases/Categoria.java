package com.mycompany.sistemabarberia.Clases;

public class Categoria {
    private int id;
    private String nombre;
    private String descripcion;

    // Constructor
    public Categoria(int id, String nombre, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    // Getters y Setters
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

    public String getDescripcion() { 
        return descripcion; 
    }
    public void setDescripcion(String descripcion) { 
        this.descripcion = descripcion; 
    }

    // Métodos funcionales
    public void crear() {
        System.out.println("Categoría creada: " + nombre);
    }

    public void consultar() {
        System.out.println("Consulta de categoría: " + this);
    }

    public void actualizar(String nuevoNombre, String nuevaDescripcion) {
        this.nombre = nuevoNombre;
        this.descripcion = nuevaDescripcion;
        System.out.println("Categoría actualizada: " + nombre);
    }

    public void eliminar() {
        System.out.println("Categoría eliminada: " + nombre);
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
