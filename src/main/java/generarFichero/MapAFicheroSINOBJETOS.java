/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package generarFichero;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 *
 * @author fer
 */
public class MapAFichero {
    
     public static void generarFichero(String nomFichero, Map<String, String> listaMap) {

        File file = new File(nomFichero);

        try ( FileWriter fileWriter = new FileWriter(file);  BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

            for (Map.Entry<String, String> entry : listaMap.entrySet()) {
                bufferedWriter.write(entry.getKey() + "-" + entry.getValue());//EL "-" ES LA SEPARACION QUE APARECERA EN EL DOCUMENTO
                bufferedWriter.newLine();
            }
            System.out.println("Fichero " + nomFichero + " creado correctamente");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
     
    
}
