// Paso 1: Declaración de un paquete.
package com.streamsLambdas.practicaStreams.practica1;

// Paso 2: Declaración de una enumeración llamada "RangoImpuesto".
public enum RangoImpuesto {
    // Paso 3: Enumerados con valores y montos de rango asociados.
    DC(0.09d),
    ANT(0.09d),
    BOY(0.08d);
    
    // Paso 4: Declaración de un atributo privado llamado "rango" para almacenar el monto de rango.
    private final double rango;

    // Paso 5: Constructor de la enumeración que recibe un monto de rango y lo asigna al atributo "rango".
    private RangoImpuesto(double rango) {
        this.rango = rango; // Asigna el monto de rango recibido al atributo "rango".
    }

    // Paso 6: Método getter para obtener el monto de rango.
    public double getRango() {
        return rango; // Devuelve el monto de rango.
    }
    
    // Paso 7: Método estático que recibe un departamento y devuelve el monto de rango asociado a ese departamento.
    public static double porDepartamento(Departamento d){
        double rango = 0.0d; // Inicializa la variable rango con un valor predeterminado de 0.0.
        
        // Paso 8: Usa un switch para asignar el monto de rango correspondiente según el departamento recibido.
        switch(d){
            case DC: rango = DC.getRango(); break; // Asigna el monto de rango para el departamento "DC".
            case ANT: rango = ANT.getRango(); break; // Asigna el monto de rango para el departamento "ANT".
            case BOY: rango = BOY.getRango(); break; // Asigna el monto de rango para el departamento "BOY".
        }
        
        // Paso 9: Devuelve el monto de rango correspondiente al departamento recibido.
        return rango;
    }
}

