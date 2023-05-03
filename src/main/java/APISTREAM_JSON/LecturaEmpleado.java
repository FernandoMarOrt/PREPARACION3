/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package APISTREAM_JSON;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 *
 * @author Fer
 */
public class LecturaEmpleado {

    public static void main(String[] args) throws IOException {

        //Creo la lista y la relleno con los datos 
        List<Empleado> listaEmpleado = generarLista("RelPerCen.csv", ",");

        System.out.println("Lista Empleados SIN FILTRAR:");

        listaEmpleado.forEach(System.out::println);
        System.out.println("");

        //Filtro para empleados que llevan entre 10 y 15 años
        List<Empleado> empleadosFiltrados = generarListaFiltrada(listaEmpleado);

        System.out.println("Lista Empleados FILTRADA:");

        listaEmpleado.forEach(System.out::println);
        System.out.println("");

        ObjectMapper mapeador = new ObjectMapper();

        mapeador.registerModule(new JavaTimeModule());

        //Genero el nuevo archivo de JSON apartir de la lista ya filtrada
        generarArchivoJSON("listaEmpleadosFiltrados.json", empleadosFiltrados);

        //AMPLIACION EJERCICIO
        
        
        //APARTADO A SIN USAR API STREAM:
        
        
        //Contar el número de profesores de Tecnología.
        contarNETecnologia(listaEmpleado);
        System.out.println("");

        //Saber si algún profesor/a de Informática es también coordinador
        System.out.println("¿Hay un profesor de informática que sea coordinador?");
        pInformaticaYCoordinador(listaEmpleado);
        System.out.println("");

        //Obtener una lista ordenada alfabéticamente con todos los apellidos de los empleados cuyo NIF contenga la letra J.
        List<String> listaEmpleadoOrdenada = ordenadaApellidoYNIFJ(listaEmpleado);
        listaEmpleadoOrdenada.forEach(System.out::println);
        System.out.println("");

        //Verificar que ningún profesor se llama "Jonh"
        System.out.println("¿Hay algun profesor que se llame Jhon?");
        verificarNombreJonh(listaEmpleado);
         
        
        //APARTADO B USANDO API STREAM:
        
        //Contar el número de profesores de Tecnología.
        contarNETecnologiaAS(listaEmpleado);
        System.out.println("");

        //Saber si algún profesor/a de Informática es también coordinador
        System.out.println("¿Hay un profesor de informática que sea coordinador?");
        pInformaticaYCoordinadorAS(listaEmpleado);
        System.out.println("");

        //Obtener una lista ordenada alfabéticamente con todos los apellidos de los empleados cuyo NIF contenga la letra J.
        List<String> listaEmpleadoOrdenada2 = ordenadaApellidoYNIFJAS(listaEmpleado);
        listaEmpleadoOrdenada2.forEach(System.out::println);
        System.out.println("");

        //Verificar que ningún profesor se llama "Jonh"
        System.out.println("¿Hay algun profesor que se llame Jhon?");
        verificarNombreJonhAS(listaEmpleado);

    }

    public static List<Empleado> generarLista(String nomFichero, String separador) {

        List<Empleado> listaEmpleado = new ArrayList<>();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy"); //Doy formato a la fecha

        String idFichero = nomFichero;

        String[] tokens;
        String linea;

        try ( Scanner datosFichero = new Scanner(new File(idFichero), "ISO-8859-1")) {

            // hasNextLine devuelve true mientras haya líneas por leer
            datosFichero.nextLine();

            while (datosFichero.hasNextLine()) {

                Empleado p = new Empleado();

                // Guarda la línea completa en un String
                linea = datosFichero.nextLine();
                // Se guarda en el array de String cada elemento de la
                // línea en función del carácter separador de campos del fichero CSV
                // Convierte en String tokens
                tokens = linea.split(separador);

                for (int i = 0; i < tokens.length; i++) {

                    tokens[i] = tokens[i].replaceAll("\"", ""); //Quito espacios
                }

                p.setApellido(tokens[0]);
                p.setNombre(tokens[1]);
                p.setDni(tokens[2]);
                p.setPuesto(tokens[3]);

                try {

                    p.setFechaTomaPosicion(LocalDate.parse(tokens[4], formatter));

                } catch (DateTimeParseException dtpe) {

                    p.setFechaTomaPosicion(null); //Por si la fecha de tomaPosicion esta vacia
                }

                try {

                    p.setFechaCese(LocalDate.parse(tokens[5], formatter));

                } catch (DateTimeParseException dtpe) {

                    p.setFechaCese(null); //Por si la fecha de fechaCese esta vacia
                }

                p.setTelefono(tokens[6]);

                p.setEvaluador(tokens[7].equalsIgnoreCase("Sí"));

                p.setCoordinador(tokens[8].equalsIgnoreCase("Sí"));

                listaEmpleado.add(p);

            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        //---

        return listaEmpleado;

    }

    public static List<Empleado> generarListaFiltrada(List<Empleado> listaEmpleado) {

        List<Empleado> empleadosFiltrados = listaEmpleado.stream()
                .filter(p -> p.getFechaTomaPosicion().isAfter(LocalDate.now().minusYears(15))) //Si tiene entre 15 y 10 años
                .filter(p -> p.getFechaTomaPosicion().isBefore(LocalDate.now().minusYears(10)))
                .toList();

        return empleadosFiltrados;
    }

    public static void generarArchivoJSON(String nomFichero, List<Empleado> lista) throws IOException {

        ObjectMapper mapeador = new ObjectMapper();

        mapeador.registerModule(new JavaTimeModule());

        //Formato del Json
        mapeador.configure(SerializationFeature.INDENT_OUTPUT, true);

        mapeador.writeValue(new File(nomFichero), lista);

    }

    //METODOS APARTADO A SIN API STREAM:
    
    public static void contarNETecnologia(List<Empleado> listaEmpleado) {

        int contadorPTecnologia = 0;
        for (int i = 0; i < listaEmpleado.size(); i++) {

            if (listaEmpleado.get(i).getPuesto().contains("Tecnología")) {

                contadorPTecnologia++;
            }
        }

        System.out.println("Hay un total de " + contadorPTecnologia + " profesores de tecnologia");
    }

    public static void pInformaticaYCoordinador(List<Empleado> listaEmpleado) {

        boolean estaEnLista = false;

        for (int i = 0; i < listaEmpleado.size(); i++) {

            if (listaEmpleado.get(i).getPuesto().contains("Informática") && (listaEmpleado.get(i).isCoordinador() == true)) {

                estaEnLista = true;
            }
        }

        if (estaEnLista) {

            System.out.println("SI hay al menos un profesor de tecnologia que sea coordinador");
        } else {

            System.out.println("NO hay al menos un profesor de tecnologia que sea coordinador");

        }

    }

    public static List<String> ordenadaApellidoYNIFJ(List<Empleado> listaEmpleado) {

        List<String> listaEmpleadoOrdenada = new ArrayList<>();

        for (int i = 0; i < listaEmpleado.size(); i++) {

            if (listaEmpleado.get(i).getDni().contains("J")) { //Cojo los apellidos de los profesores que su dni contengan la j

                listaEmpleadoOrdenada.add(listaEmpleado.get(i).getApellido());
            }
        }

        //Ordeno
        listaEmpleadoOrdenada.sort((s1, s2) -> s1.compareToIgnoreCase(s2));

        return listaEmpleadoOrdenada;
    }

    public static void verificarNombreJonh(List<Empleado> listaEmpleado) {

        boolean jhon = false;

        for (int i = 0; i < listaEmpleado.size(); i++) {
            if (listaEmpleado.get(i).getNombre().equalsIgnoreCase("Jonh")) {

                jhon = true;

            }
        }

        if (jhon) {

            System.out.println("Hay un profesor que se llama Jhon");

        } else {

            System.out.println("No hay ningun profesor que se llame Jhon");
        }

    }

    //METODOS APARTADO B CON API STREAM:
    
    public static void contarNETecnologiaAS(List<Empleado> listaEmpleado) {

        int contadorPTecnologia = (int) listaEmpleado.stream()
                .filter(p -> p.getPuesto().contains("Tecnología"))
                .count();

        System.out.println("Hay un total de " + contadorPTecnologia + " profesores de tecnologia");

    }

    public static void pInformaticaYCoordinadorAS(List<Empleado> listaEmpleado) {

        boolean estaEnLista = listaEmpleado.stream()
                .noneMatch(p -> p.getPuesto()
                .contains("Informática") && p.isCoordinador() == true);

        if (estaEnLista) {

            System.out.println("SI hay al menos un profesor de tecnologia que sea coordinador");
        } else {

            System.out.println("NO hay al menos un profesor de tecnologia que sea coordinador");

        }

    }

    public static List<String> ordenadaApellidoYNIFJAS(List<Empleado> listaEmpleado) {

        List<String> listaEmpleadoOrdenada = listaEmpleado.stream()
                .filter(p -> p.getDni().contains("J"))
                .map(p -> p.getApellido())
                .collect(Collectors.toList());

        return listaEmpleadoOrdenada;
    }

    public static void verificarNombreJonhAS(List<Empleado> listaEmpleado) {


        
        boolean jhon = listaEmpleado.stream().anyMatch(p -> p.getNombre().contains("Jonh"));

        if (jhon) {

            System.out.println("Hay un profesor que se llama Jhon");

        } else {

            System.out.println("No hay ningun profesor que se llame Jhon");
        }

    }

}
