/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MATRIZ_MAP;

import java.util.Random;

/**
 *
 * @author Fer
 */
public class MATRIZ {
    
      public static int[][] rellenarMatriz(int tamanio) {

        int[][] matriz = new int[tamanio][tamanio];

        Random numeroAleatorio = new Random();

        for (int i = 0; i < matriz.length; i++) {

            for (int j = 0; j < matriz[i].length; j++) {

                int nAleatorio;

                nAleatorio = numeroAleatorio.nextInt(0, 1 + 1);

                matriz[i][j] = nAleatorio;
            }
        }
        return matriz;
    }
    
}
