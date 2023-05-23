/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package EJERCICIODEROBOTSFICHEROS;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Fer
 */
public class Main {

   
    private static Random rd = new Random();

    public static void main(String[] args) {

        List<Robot> listaRobots = Robot.generarListaRobots();
        
        generarFichero("archivo.txt", listaRobots);
        
        //Leo fichero
        leerFichero("archivo.txt");
        
        //Coincide con la lista
        List<Robot> listadoRecibido = sacarListaArchivo("archivo.txt");
        
        for (Robot r : listadoRecibido) {
            System.out.println(r.toString());
        }

    }

    public static void generarFichero(String nomFichero, List<Robot> lista) {
        // Fichero a crear. Ruta relativa a la carpeta raíz del proyecto
        String idFichero = nomFichero;
        String tmp;
        //
        try ( BufferedWriter flujo = new BufferedWriter(new FileWriter(idFichero))) {

            for (Robot r : lista) {
                tmp = r.getNumSerie() + ";" + r.getNivelBateria() + ";";
                flujo.write(tmp);
                flujo.newLine();
            }
            flujo.flush();
            System.out.println("Fichero " + nomFichero + " creado correctamente.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void leerFichero(String nomFichero) {

        // Fichero a leer con datos de ejemplo
        String idFichero = nomFichero;

        // Variables para guardar los datos que se van leyendo
        String[] tokens;
        String linea;

        System.out.println("Leyendo el fichero: " + idFichero);

        // Inicialización del flujo "datosFichero" en función del archivo llamado "idFichero"
        // Estructura try-with-resources. Permite cerrar los recursos una vez finalizadas
        // las operaciones con el archivo
        try ( Scanner datosFichero = new Scanner(new File(idFichero), "UTF-8")) {
            // hasNextLine devuelve true mientras haya líneas por leer
            while (datosFichero.hasNextLine()) {
                // Guarda la línea completa en un String
                linea = datosFichero.nextLine();
                // Se guarda en el array de String cada elemento de la
                // línea en función del carácter separador de campos del fichero CSV
                tokens = linea.split(";");

                System.out.println("Robot: " + tokens[0] + " - Vida: " + tokens[1]);

            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public static List<Robot> sacarListaArchivo(String nomFichero) {
        List<Robot> lista = new ArrayList<>();

        // Fichero a leer con datos de ejemplo
        String idFichero = nomFichero;

        // Variables para guardar los datos que se van leyendo
        String[] tokens;
        String linea;

        System.out.println("Leyendo el fichero: " + idFichero);

        // Inicialización del flujo "datosFichero" en función del archivo llamado "idFichero"
        // Estructura try-with-resources. Permite cerrar los recursos una vez finalizadas
        // las operaciones con el archivo
        try ( Scanner datosFichero = new Scanner(new File(idFichero), "UTF-8")) {
            // hasNextLine devuelve true mientras haya líneas por leer
            while (datosFichero.hasNextLine()) {
                // Guarda la línea completa en un String
                linea = datosFichero.nextLine();
                // Se guarda en el array de String cada elemento de la
               
                tokens = linea.split(";");
                //
                Robot r = new Robot(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]));

                lista.add(r);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        return lista;
    }
}