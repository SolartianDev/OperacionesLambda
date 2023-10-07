// Paso 1: Declaración de un paquete.
package com.streamsLambdas.practicaStreams.practica1;

// Paso 2: Importación de clases necesarias.
import com.streamsLambdas.practicaStreams.*;
import java.util.List;

// Paso 3: Declaración de la clase "MapTest".
public class MapTest {
    // Paso 4: Método principal "main".
    public static void main(String[] args) {
        // Paso 5: Creación de una lista de transacciones utilizando el método estático "createTxnList()" de la clase "VentasTxn".
        List<VentasTxn> tLista = VentasTxn.createTxnList();
        
        // Paso 6: Imprime la lista de transacciones en la consola.
        System.out.println(tLista);
        
        // Paso 7: Imprime un mensaje de separación.
        System.out.println("=== Ventas de Smarth Watch con impuesto en Bogotá ===");
        
        // Paso 8: Utiliza la API de Stream para realizar operaciones en la lista de transacciones.
        tLista.stream()
                // Paso 9: Filtra las transacciones que pertenecen al departamento de Bogotá (DC).
                .filter(t -> t.getDepartamento().equals(Departamento.DC))
                // Paso 10: Filtra las transacciones que son del producto "Smarth Watch".
                .filter(t -> t.getProducto().equals("Smarth Watch"))
                // Paso 11: Calcula el impuesto de transacción multiplicando el total de la transacción por el rango de impuesto del departamento.
                .map(t -> t.getTransaccionTotal() * RangoImpuesto.porDepartamento(t.getDepartamento()))
                // Paso 12: Imprime el impuesto de cada transacción en la consola.
                .forEach(t -> System.out.println("Impuesto de Transacción: " + t));
    }
}

