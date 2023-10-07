
package com.streamsLambdas.practicaStreams.practica7;



/**
 *
 * @author mont_
 */
public enum Departamento {
    DC("Bogotá DC"),
    ANT("Antioquia"),
    BOY("Boyacá");
    
    private final String departamento;

    Departamento(String depart) {
        this.departamento= depart;
    }

    public String getDepartamento() {
        return departamento;
    }

    
    
    
}
