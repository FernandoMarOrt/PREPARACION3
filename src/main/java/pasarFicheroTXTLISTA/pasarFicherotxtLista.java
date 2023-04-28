/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pasarFicheroTXTLISTA;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author fer
 */
public class pasarFicherotxtLista {
    
    public static List<String> pasarFicheroLista(String nomFichero) {

        List<String> listaString = new ArrayList<>();
        // Fichero a leer con datos de ejemplo
        String idFichero = nomFichero;

        try ( Scanner datosFichero = new Scanner(new File(idFichero), "UTF-8")) {
            // hasNextLine devuelve true mientras haya líneas por leer
            while (datosFichero.hasNextLine()) {

                listaString.add(datosFichero.nextLine());

            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        return listaString;
    }
    
}
