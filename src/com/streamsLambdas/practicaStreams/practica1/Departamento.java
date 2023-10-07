// Paso 1: Declaración de un paquete.
package com.streamsLambdas.practicaStreams.practica1;

// Paso 2: Declaración de una enumeración llamada "Departamento".
public enum Departamento {
// Paso 3: Enumerados con valores y descripciones asociadas.
    DC("Bogotá DC"),
    ANT("Antioquia"),
    BOY("Boyacá");
    
    // Paso 4: Declaración de un atributo privado llamado "departamento".
    private final String departamento;

    // Paso 5: Constructor de la enumeración que recibe una descripción y la asigna al atributo "departamento".
    Departamento(String depart) {
        this.departamento= depart; // Asigna la descripción recibida al atributo "departamento".
    }

    // Paso 6: Método getter para obtener la descripción del departamento.
    public String getDepartamento() {
        return departamento; // Devuelve la descripción del departamento.
    }
}

