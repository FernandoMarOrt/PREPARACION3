/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aleatorioymas;

import java.util.Random;

/**
 *
 * @author Fer
 */
public class aleatorio {

    public static void main(String[] args) {

        Random numeroAleatorio = new Random(); //RANDOM
        int nAleatorio;
        int numeroTOPOE = 100;
        nAleatorio = numeroAleatorio.nextInt(1, numeroTOPOE + 1);
    }

}
