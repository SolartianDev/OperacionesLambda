
package com.streamsLambdas.practicaStreams.practica3;

import com.streamsLambdas.practicaStreams.*;

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
