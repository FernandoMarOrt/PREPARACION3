/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LeerFicheroNormal;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 *
 * @author fer
 */
public class LeerFicheroNormal {
    
      public static void leerFichero(String nomFichero) {

        // Fichero a leer
        String idFichero = nomFichero;

        // Variables para guardar los datos que se van leyendo

        String linea;

        System.out.println("Leyendo el fichero: " + idFichero);

        // Inicialización del flujo "datosFichero" en función del archivo llamado "idFichero"
        // Estructura try-with-resources. Permite cerrar los recursos una vez finalizadas
        // las operaciones con el archivo
        try ( Scanner datosFichero = new Scanner(new FileReader(idFichero))) {

            // Mientras haya líneas por leer
            while (datosFichero.hasNextLine()) {

                linea = datosFichero.nextLine(); //Se lee la línea
                System.out.println(linea); // Se imprime en pantalla
            }

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

    }
    
}
