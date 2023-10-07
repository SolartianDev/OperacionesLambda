// Paso 1: Declaración de un paquete.
package com.streamsLambdas.practicaStreams.practica4;

// Paso 2: Importación de clases necesarias.
import java.util.List;
import java.util.OptionalDouble;

// Paso 3: Declaración de la clase "CalculoTest".
public class CalculoTest {
    public static void main(String[] args) {
        // Paso 4: Creación de una lista de transacciones usando el método "createTxnList" de la clase "VentasTxn".
        List<VentasTxn> tList = VentasTxn.createTxnList();
        System.out.println(tList); // Imprime la lista de transacciones completa.

        // Paso 5: Imprime un encabezado para indicar la operación que se realizará a continuación.
        System.out.println("=== Total Transacciones ===");

        // Paso 6: Calcula el total de transacciones para el comprador "Aseo SA" y lo almacena en la variable "t1".
        double t1 = tList.stream() 
            .filter(t -> t.getCompradorNombre().equals("Aseo SA"))
            .mapToDouble(t -> t.getTransaccionTotal())
            .sum();
        
        // Paso 7: Imprime el total de transacciones para "Aseo SA".
        System.out.printf("Aseo Total: " + t1);

        // Paso 8: Calcula el total de transacciones para el comprador "Camisas y Pantalones SA" y lo almacena en la variable "t2".
        double t2 = tList.stream() 
            .filter(t -> t.getCompradorNombre().equals("Camisas y Pantalones SA"))
            .mapToDouble(t -> t.getTransaccionTotal())
            .sum();
        
        // Paso 9: Imprime el total de transacciones para "Camisas y Pantalones SA".
        System.out.printf("Camisas y Pantalones SA: " + t2);

        // Paso 10: Calcula el total de transacciones para el comprador "Hogar CO" y lo almacena en la variable "t3".
        double t3 = tList.stream() 
            .filter(t -> t.getCompradorNombre().equals("Hogar CO"))
            .mapToDouble(t -> t.getTransaccionTotal())
            .sum();
        
        // Paso 11: Imprime el total de transacciones para "Hogar CO".
        System.out.printf("Hogar CO: " + t3);

        // Paso 12: Imprime un encabezado para indicar la operación que se realizará a continuación.
        System.out.println("=== Average Conteo unidad ===");

        // Paso 13: Calcula el promedio de la cantidad de unidades para el producto "Fundas de celular" y lo almacena en la variable "a1".
        OptionalDouble a1 = tList.stream()
            .filter(t -> t.getProducto().equals("Fundas de celular"))
            .mapToDouble(t -> t.getCantidadUnidades())
            .average();
        
        // Paso 14: Si se encuentra el promedio, lo imprime.
        if (a1.isPresent()){
            System.out.printf("Fundas de celular Avg: " + a1.getAsDouble());
        }

        // Paso 15: Calcula el promedio de la cantidad de unidades para el producto "Televisor LG" y lo almacena en la variable "a2".
        OptionalDouble a2 = tList.stream()
            .filter(t -> t.getProducto().equals("Televisor LG"))
            .mapToDouble(t -> t.getCantidadUnidades())
            .average();
        
        // Paso 16: Si se encuentra el promedio, lo imprime.
        if (a2.isPresent()){
            System.out.printf("Televisor LG AVG: " + a2.getAsDouble());        
        } 
    }
}

