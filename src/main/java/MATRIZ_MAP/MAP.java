/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MATRIZ_MAP;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author Fer
 */
public class MAP {
    
    public static void main(String[] args) {
        
        
        //PASAR MAP A LISTA
        
        
        Map<String, Integer> map = new HashMap<>();
        map.put("Uno", 1);
        map.put("Dos", 2);
        map.put("Tres", 3);

        // Convertir el Map a una List de pares clave-valor
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());

        // Imprimir la lista resultante
        for (Map.Entry<String, Integer> entry : list) {
            System.out.println("Clave: " + entry.getKey() + ", Valor: " + entry.getValue());
        }
        
        
        
        
        
        
        
        //PASAR DE LISTA A MAP
        
      
         //Crear una List de elementos
        List<String> list2 = new ArrayList<>();
        list2.add("Uno");
        list2.add("Dos");
        list2.add("Tres");

         //Convertir la List a un Map
        Map<String, Integer> map2 = new HashMap<>();
        for (int i = 0; i < list2.size(); i++) {
            map2.put("Elemento " + (i + 1), i);
        }

         //Imprimir el Map resultante
        for (Map.Entry<String, Integer> entry : map2.entrySet()) {
            System.out.println("Clave: " + entry.getKey() + ", Valor: " + entry.getValue());
        }
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        

        int nPasajeros = 0;
        int nVagones = 0;
        int id = 0;

        int[][] matrizTrenes
                = {
                    {1, 20, 20, 20, 20},
                    {2, 25, 25, 25, 25},
                    {3, 0, 0, 0, 0},
                    {4, 50, 0, 50, 0}
                };

        Map<Integer, Tren> trenesMap = new TreeMap<>();

        for (int i = 0; i < matrizTrenes.length; i++) {

            nPasajeros = 0;
            nVagones = 0;

            for (int j = 0; j < matrizTrenes[i].length; j++) {

                if (j == 0) { //Si se situa en la primera columna 

                    id = matrizTrenes[i][j]; //Asigno el numero al id del tren

                } else {

                    if (matrizTrenes[i][j] > 0) { //Si el valor es mayor que 0

                        nVagones++; //Recuento del numero vagones

                        nPasajeros += matrizTrenes[i][j]; //Recuento del numero de pasajeros
                    }

                }

            }

            Object auxTren = new Tren(id, nVagones, nPasajeros); //Asigno valores al tren

            trenesMap.put(id, auxTren); //Lo meto en el map

        }

        //Imprimo la lista de los trenes metidos en el map
        for (Integer Key : trenesMap.keySet()) {
            
            System.out.printf("Clave: %s -- Tren: %s %n ", Key, trenesMap.get(Key));
            
        }

    }
    
    
    
    
    
    
    
    
}
