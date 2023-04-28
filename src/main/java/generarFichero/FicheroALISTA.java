/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package generarFichero;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author fer
 */
public class FicheroALISTA {
    
    public static void generarFichero2(String nomFichero, List<Object> listaVehiculos) { //OBJECT SE SUSTITUYE POR EL OBJETO QUE QUIERA 

        String idFichero = nomFichero;

        try ( BufferedWriter flujo = new BufferedWriter(new FileWriter(idFichero))) {

            for (Object v : listaVehiculos) { //OBJECT SE SUSTITUYE POR EL OBJETO QUE QUIERA 

                flujo.write(v.toString());
                flujo.newLine();
            }
            flujo.flush();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
    
}
