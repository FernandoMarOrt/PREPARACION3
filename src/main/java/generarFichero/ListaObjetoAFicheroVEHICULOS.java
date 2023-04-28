/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package generarFichero;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author fer
 */
public class ListaObjetoAFicheroVEHICULOS {
    
//    public static List<Vehiculo> generarListaFichero(String nomFichero, String separador) {
//
//        List<Vehiculo> listaVehiculos = new ArrayList<>();
//
//        String idFichero = nomFichero;
//        String[] tokens;
//        String linea;
//
//        Vehiculo v = null;
//
//        try ( Scanner datosFichero = new Scanner(new File(idFichero), "UTF-8")) {
//
//            while (datosFichero.hasNextLine()) {
//
//                linea = datosFichero.nextLine();// Guarda la línea completa en un String
//
//                tokens = linea.split(separador); //Se guarda cada elemento en funcion de el separador
//
//                //Paso todos los valores que no son string a string
//                //Si contiene 0 (turismo)
//                if (linea.contains("0 - ")) {
//
//                    tokens[0] = tokens[0].replaceAll("0 - ", "");
//
//                    v = new Turismo(Integer.valueOf(tokens[0]), tokens[1], tokens[2], tokens[3],
//                            tokens[4], Double.parseDouble(tokens[5]), Integer.parseInt(tokens[7]));
//
//                    //Si contiene 0 (Deportivo)
//                } else if (linea.contains("1 - ")) {
//
//                    tokens[0] = tokens[0].replaceAll("1 - ", "");
//
//                    v = new Deportivo(Integer.valueOf(tokens[0]), tokens[1], tokens[2], tokens[3],
//                            tokens[4], Double.parseDouble(tokens[5]), Integer.parseInt(tokens[7]));
//
//                    //Si contiene 2 (Furgoneta)
//                } else if (linea.contains("2 - ")) {
//
//                    tokens[0] = tokens[0].replaceAll("2 - ", "");
//
//                    v = new Furgoneta(Integer.valueOf(tokens[0]), tokens[1], tokens[2], tokens[3],
//                            tokens[4], Double.parseDouble(tokens[5]), Integer.parseInt(tokens[7]));
//
//                }
//
//                listaVehiculos.add(v);
//            }
//        } catch (FileNotFoundException e) {
//            System.out.println(e.getMessage());
//        }
//
//        //Ordeno por marca los vehiculos
//        Comparator<Vehiculo> ordenarMarca = (v1, v2) -> v1.getMarca().compareToIgnoreCase(v2.getMarca());
//
//        Collections.sort(listaVehiculos, ordenarMarca);
//
//        return listaVehiculos;
//
//    }
//    
}
