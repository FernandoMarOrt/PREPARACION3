/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package APISTREAM_JSON;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author Fer
 */
public class Empleado {

    private String nombre;
    private String apellido1;
    private String dni;
    private String puesto;
    private LocalDate fechaTomaPosicion;
    private LocalDate fechaCese;
    private String telefono;
    private boolean evaluador;
    private boolean coordinador;

    public Empleado() {
    }

    public Empleado(String nombre, String apellido1, String dni, String puesto, LocalDate fechaTomaPosicion, LocalDate fechaCese, String telefono, boolean evaluador, boolean coordinador) {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.dni = dni;
        this.puesto = puesto;
        this.fechaTomaPosicion = fechaTomaPosicion;
        this.fechaCese = fechaCese;
        this.telefono = telefono;
        this.evaluador = evaluador;
        this.coordinador = coordinador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido1;
    }

    public void setApellido(String apellido) {
        this.apellido1 = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public LocalDate getFechaTomaPosicion() {
        return fechaTomaPosicion;
    }

    public void setFechaTomaPosicion(LocalDate fechaTomaPasicion) {
        this.fechaTomaPosicion = fechaTomaPasicion;
    }

    public LocalDate getFechaCese() {
        return fechaCese;
    }

    public void setFechaCese(LocalDate fechaCese) {
        this.fechaCese = fechaCese;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public boolean isEvaluador() {
        return evaluador;
    }

    public void setEvaluador(boolean evaluador) {
        this.evaluador = evaluador;
    }

    public boolean isCoordinador() {
        return coordinador;
    }

    public void setCoordinador(boolean coordinador) {
        this.coordinador = coordinador;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.nombre);
        hash = 67 * hash + Objects.hashCode(this.dni);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Empleado other = (Empleado) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return Objects.equals(this.dni, other.dni);
    }

   

    @Override
    public String toString() {
        return apellido1 + "," + nombre + "," + dni + "," + puesto + "," + fechaTomaPosicion + "," + fechaCese + "," + telefono + "," + evaluador + "," + coordinador + ",";
    }

}
