/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.streamsLambdas.practicaStreams.practica5;

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
