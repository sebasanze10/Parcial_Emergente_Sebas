package com.example.Practica_1;

public class Cursos {
    private int id;
    private String nombre;
    private int duracion;
    private String nivel;
    private String instructor;
    private double costo;

    public Cursos() {}

    public Cursos(String nombre, int duracion, String nivel, String instructor, double costo) {
        this.nombre = nombre;
        this.duracion = duracion;
        this.nivel = nivel;
        this.instructor = instructor;
        this.costo = costo;
    }

    public Cursos(int id, String nombre, int duracion, String nivel, String instructor, double costo) {
        this.id = id;
        this.nombre = nombre;
        this.duracion = duracion;
        this.nivel = nivel;
        this.instructor = instructor;
        this.costo = costo;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public int getDuracion() { return duracion; }
    public void setDuracion(int duracion) { this.duracion = duracion; }
    public String getNivel() { return nivel; }
    public void setNivel(String nivel) { this.nivel = nivel; }
    public String getInstructor() { return instructor; }
    public void setInstructor(String instructor) { this.instructor = instructor; }
    public double getCosto() { return costo; }
    public void setCosto(double costo) { this.costo = costo; }
}