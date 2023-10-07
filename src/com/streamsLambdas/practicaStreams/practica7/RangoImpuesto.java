
package com.streamsLambdas.practicaStreams.practica7;


/**
 *
 * @author mont_
 */
public enum RangoImpuesto {
    DC(0.09d),
    ANT(0.09d),
    BOY(0.08d);
    
    private final double rango;

    private RangoImpuesto(double rango) {
        this.rango = rango;
    }

    public double getRango() {
        return rango;
    }
    
    public static double porDepartamento(Departamento d){
        double rango = 0.0d;
        
        switch(d){
            case DC: rango = DC.getRango(); break;
            case ANT: rango =ANT.getRango(); break;
            case BOY: rango =BOY.getRango(); break;
        }
        return rango;
    }
}
