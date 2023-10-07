
package com.streamsLambdas.practicaStreams.practica7;



/**
 *
 * @author mont_
 */
public enum ClaseComprador {
    BASICA(0.0d),
    PLATA(0.01d),
    GOLD(0.02d),
    PLATINUM(0.03d);
    
    private final double rango;
    
    ClaseComprador(double rango){
        this.rango = rango;
    }

    public double getRango() {
        return rango;
    }
    
    
}
