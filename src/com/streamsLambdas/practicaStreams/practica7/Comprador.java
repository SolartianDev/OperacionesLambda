
package com.streamsLambdas.practicaStreams.practica7;


import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author mont_
 */
public class Comprador {
    
    private String nombre;
    private ClaseComprador claseComprador;

    public Comprador(String nombre, ClaseComprador claseComprador) {
        this.nombre = nombre;
        this.claseComprador = claseComprador;
    }
    
    
    public static Comprador getInstancia(String nombre,ClaseComprador claseComprador ){
       return new Comprador(nombre, claseComprador);
    }
    
    public static Map<String, Comprador> getMapComprador(){
         Map<String, Comprador> mapComprador = new HashMap<>();
        
        mapComprador.put("Electronics", Comprador.getInstancia("Electronics CO", ClaseComprador.PLATA));
        mapComprador.put("Hogar", Comprador.getInstancia("Hogar CO", ClaseComprador.GOLD));
        mapComprador.put("Herramienta", Comprador.getInstancia("Herramientas CO", ClaseComprador.BASICA));
        mapComprador.put("MercadoLibre", Comprador.getInstancia("MercadoLibre CO", ClaseComprador.BASICA));
        mapComprador.put("Aseo", Comprador.getInstancia("Aseo SA", ClaseComprador.PLATINUM));
        mapComprador.put("Camisas", Comprador.getInstancia("Camisas y Pantalones SA", ClaseComprador.PLATA));
        
        
        return mapComprador;
    }

    public String getNombre() {
        return nombre;
    }

    public ClaseComprador getClaseComprador() {
        return claseComprador;
    }
    
    
}
