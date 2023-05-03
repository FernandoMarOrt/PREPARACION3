/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package directoriosJava;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author Fer
 */
public class crearDirectorio {
    
        public static void crearDirectorio(String rutaDirectorio) {

        Path directorio = Paths.get(rutaDirectorio);

        if (!Files.exists(directorio)) { // Verificar si el directorio no existe
            try {
                Files.createDirectory(directorio); // Intentar crear el directorio
                System.out.println("Directorio creado exitosamente.");
            } catch (IOException e) {
                System.err.println("Error al crear el directorio: " + e.getMessage());
            }
        } else {
            System.out.println("El directorio ya existe.");
        }
    }
    
}
