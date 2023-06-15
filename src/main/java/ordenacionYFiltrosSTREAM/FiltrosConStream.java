/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ordenacionYFiltrosSTREAM;

import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Fer
 */
public class FiltrosConStream {
    
        public static void matriculaOrdenada(List<Vehiculo> listaVehiculos) {

        // Imprimir por pantalla todas las matrículas ordenadas alfabéticamente de todos los coches grises distintos
        System.out.println("Matrículas de coches grises ordenadas alfabéticamente:");
        listaVehiculos.stream()
                .filter(vehiculo -> vehiculo.getColor().equalsIgnoreCase("gris"))
                .map(Vehiculo::getMatricula)
                .distinct()
                .sorted()
                .forEach(System.out::println);

    }

    public static void marcasCoche(List<Vehiculo> listaVehiculos) {

        // Imprimir por pantalla todas las marcas de coches distintas de aquellos coches que estén disponibles
        System.out.println("Marcas de coches no disponibles:");
        listaVehiculos.stream()
                .filter(vehiculo -> !vehiculo.isDisponible())
                .map(Vehiculo::getMarca)
                .distinct()
                .forEach(System.out::println);

    }

    public static void cantidadCitroen(List<Vehiculo> listaVehiculos) {

        // Saber la cantidad de vehículos Citroën
        long cantidadCitroen = listaVehiculos.stream()
                .filter(vehiculo -> vehiculo.getMarca().equalsIgnoreCase("Citroën"))
                .count();
        System.out.println("Cantidad de vehículos Citroën: " + cantidadCitroen);

    }

    public static void comprobarPeugeotN(List<Vehiculo> listaVehiculos) {

        // Comprobar si hay algún Peugeot negro disponible en la lista
        boolean peugeotNegroDisponible = listaVehiculos.stream()
                .anyMatch(vehiculo -> vehiculo.getMarca().equalsIgnoreCase("Peugeot")
                && vehiculo.getColor().equalsIgnoreCase("negro")
                && vehiculo.isDisponible());
        System.out.println("¿Hay algún Peugeot negro disponible?: " + peugeotNegroDisponible);

    }

    public static List<Double> listaTarifas(List<Vehiculo> listaVehiculos) {

        List<Double> listaTarifas = listaVehiculos.stream()
                .map(Vehiculo::getTarifa)
                .distinct()
                .collect(Collectors.toList());

        return listaTarifas;
        
        
        
        //--- Contar el número de profesores de Tecnología.
        int profTecnología = (int) lista.stream()
                .filter(p -> p.getPuesto().contains("Tecnología"))
                .count();
        System.out.println("Hay " + profTecnología + " profesores de tecnología.");
        
        
        
        
        
        
        //--- Saber si algún profesor/a de Informática es también coordinador
        boolean informaticoCoordinador = lista.stream()
                .noneMatch(p -> p.getPuesto()
                        .contains("Informática") && p.isCoordinador() == true);
        System.out.println(informaticoCoordinador ? "No hay informáticos coordinadores" : "Hay un informático coordinador");
        
        
        
        
        
        
        
        //--- Obtener una lista ordenada alfabéticamente con todos los apellidos de los empleados cuyo NIF contenga la letra J.
        System.out.println("Apellidos de profesores con DNI con J");
        List<String> apellidos = lista.stream()                
                .filter(p -> p.getDni().contains("J"))                
                .map(p -> p.getApellido())
                .collect(Collectors.toList());
        //---
        apellidos.forEach(System.out::println);
        
        
        
        
        //--- Verificar que ningún profesor se llama "Jonh".
        boolean hayJonh = lista.stream().anyMatch(p -> p.getNombre().contains("Jonh"));
        System.out.println(hayJonh ? "Si hay Jonh" : "No hay Jonh");

    }
    
}
