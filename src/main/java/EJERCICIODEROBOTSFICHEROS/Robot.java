/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EJERCICIODEROBOTSFICHEROS;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Fer
 */
public class Robot implements Comparable<Robot> {

    private static Random rd = new Random();

    private int id;
    private int vida;

    public Robot() {
        this.id = rd.nextInt(5000);
        this.vida = rd.nextInt(101);
    }

    public Robot(int numSerie, int nivelBateria) {
        this.id = numSerie;
        this.vida = nivelBateria;
    }

    public int getNumSerie() {
        return id;
    }

    public int getNivelBateria() {
        return vida;
    }

    public void setNumSerie(int numSerie) {
        this.id = numSerie;
    }

    public void setNivelBateria(int nivelBateria) {
        this.vida = nivelBateria;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + this.id;
        hash = 29 * hash + this.vida;
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
        final Robot other = (Robot) obj;
        if (this.id != other.id) {
            return false;
        }
        return this.vida == other.vida;
    }

  
    public static List<Robot> generarListaRobots() {
        List<Robot> lista = new ArrayList<>();

        for (int i = 0; i < rd.nextInt(35-15+1)+15; i++) {
            lista.add(new Robot());
        }

        return lista;
    }

    @Override
    public String toString() {
        return "Robot: " + id + " - Vida: " + vida;
    }

    @Override
    public int compareTo(Robot o) {
        return Integer.compare(this.id, o.getNumSerie());
    }

}