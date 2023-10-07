// Paso 1: Declaración de un paquete y las importaciones necesarias.
package com.streamsLambdas.practicaStreams.practica1;

import com.streamsLambdas.practicaStreams.*; // Importa clases relacionadas (no proporcionadas en el código).

import java.util.HashMap;
import java.util.Map;

public class Comprador {
    
    // Paso 2: Declaración de atributos privados de la clase.
    private String nombre;
    private ClaseComprador claseComprador;

    // Paso 3: Constructor de la clase Comprador que recibe un nombre y una ClaseComprador.
    public Comprador(String nombre, ClaseComprador claseComprador) {
        this.nombre = nombre; // Asigna el nombre recibido al atributo nombre.
        this.claseComprador = claseComprador; // Asigna la ClaseComprador recibida al atributo claseComprador.
    }
    
    // Paso 4: Método estático que crea y devuelve una instancia de Comprador con el nombre y la ClaseComprador especificados.
    public static Comprador getInstancia(String nombre, ClaseComprador claseComprador ){
       return new Comprador(nombre, claseComprador); // Crea y devuelve una nueva instancia de Comprador.
    }
    
    // Paso 5: Método estático que crea y devuelve un mapa de Compradores con nombres asociados a ClaseComprador.
    public static Map<String, Comprador> getMapComprador(){
         Map<String, Comprador> mapComprador = new HashMap<>(); // Crea un nuevo mapa de Compradores.
        
    // Paso 6: Se agregan diferentes compradores al mapa, cada uno asociado a un nombre y una ClaseComprador.
        mapComprador.put("Electronics", Comprador.getInstancia("Electronics CO", ClaseComprador.PLATA));
        mapComprador.put("Hogar", Comprador.getInstancia("Hogar CO", ClaseComprador.GOLD));
        mapComprador.put("Herramienta", Comprador.getInstancia("Herramientas CO", ClaseComprador.BASICA));
        mapComprador.put("MercadoLibre", Comprador.getInstancia("MercadoLibre CO", ClaseComprador.BASICA));
        mapComprador.put("Aseo", Comprador.getInstancia("Aseo SA", ClaseComprador.PLATINUM));
        mapComprador.put("Camisas", Comprador.getInstancia("Camisas y Pantalones SA", ClaseComprador.PLATA));
        
    // Paso 7: Devuelve el mapa de compradores creado.
        return mapComprador;
    }

    // Paso 8: Método getter para obtener el nombre del comprador.
    public String getNombre() {
        return nombre; // Devuelve el nombre del comprador.
    }

    // Paso 9: Método getter para obtener la ClaseComprador del comprador.
    public ClaseComprador getClaseComprador() {
        return claseComprador; // Devuelve la ClaseComprador del comprador.
    }
}


