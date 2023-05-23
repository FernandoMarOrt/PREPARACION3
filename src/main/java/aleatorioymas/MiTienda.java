/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aleatorioymas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author fer
 */
public class MiTienda {

    public static void main(String[] args) {
        

        //Apartado1    
        List<Producto> listaProductos = new ArrayList<>();

        // coversiones implicitas
        Producto ropa1 = new Pantalon("M", "Marca1", "1", 15.50, 20, "Pantalon 1");
        Producto ropa2 = new Pantalon("L", "Marca2", "2", 10.50, 20, "Pantalon 2");

        Libro librod1 = new LibroDigital(1234.5, "1234", "3", 5.50, 10, "LibroDigital 1");
        Libro librod2 = new LibroDigital(4321.5, "12345", "4", 6.50, 10, "LibroDigital 2");

        Libro librop1 = new LibroPapel(100, "5678", "5", 4.50, 10, "LibroPapel 1");
        Libro librop2 = new LibroPapel(150, "8765", "6", 3.50, 10, "LibroPapel 2");

        listaProductos.add(ropa1);
        listaProductos.add(ropa2);
        listaProductos.add(librod1);
        listaProductos.add(librod2);
        listaProductos.add(librop1);
        listaProductos.add(librop2);

        //Apartado2
        listaProductos.forEach(System.out::println);

        //Apartado3
        Comparator<Producto> ordenarPrecio = (p1, p2) -> Double.compare(p1.getPrecio(), p2.getPrecio());
        Collections.sort(listaProductos, ordenarPrecio);

        listaProductos.forEach(System.out::println);

        //Apartado4
        Comparator<Producto> ordenarCodigo = (p1, p2) -> p1.getCodigo().compareTo(p2.getCodigo());

        Collections.sort(listaProductos, ordenarCodigo);

        listaProductos.forEach(System.out::println);

        //Apartado5
        Collections.binarySearch(listaProductos, librop1, ordenarCodigo);

        //Apartado6
        List<Libro> listaLibros = new ArrayList<>();
        for (Producto p : listaProductos) {

            if (p instanceof Libro) {

                listaLibros.add((Libro) p); // conversion explicita

            }

        }

        //Apartado7 Muestra los datos de la lista de libros usando un objeto Iterator. 

        Iterator<Libro> iterator = listaLibros.iterator();

        while (iterator.hasNext()) {

            Libro libro = iterator.next();

            System.out.println(libro.toString());

        }

        //Apartado8
        Collections.sort(listaLibros);
        listaLibros.forEach(System.out::println);

        //Apartado9
        for (Libro l : listaLibros) {

            if (l instanceof LibroDigital) {   // conversion explicita
                ((LibroDigital) l).descargar();
            }

            if (l instanceof LibroPapel) {
                ((LibroPapel) l).enviar("Direccion random");
            }

        }

        //Apartado11
        if (listaLibros.contains(librop1)) {

            System.out.println("Tiene el libro 1");
        } else {

            System.out.println("No tiene el libro 1");
        }

        //Apartado12
        List<SeEnvia> listaEnvia = new ArrayList<>();

        for (Producto p : listaProductos) {
            if (p instanceof SeEnvia) {
                listaEnvia.add((SeEnvia) p);
            }
        }

        //Apartado13
        for (SeEnvia seEnvia : listaEnvia) {

            seEnvia.enviar("Direccion random");

        }

        //Apartado14
        for (Libro l : listaLibros) {

            l.tirarLibro();

        }

    }

}
