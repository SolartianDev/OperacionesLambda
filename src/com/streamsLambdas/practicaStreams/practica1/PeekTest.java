// Paso 1: Declaración de un paquete.
package com.streamsLambdas.practicaStreams.practica1;

// Paso 2: Importación de clases necesarias.
import com.streamsLambdas.practicaStreams.*;
import java.util.List;
import java.util.function.Consumer;

// Paso 3: Declaración de la clase "PeekTest".
public class PeekTest {
    // Paso 4: Método principal "main".
    public static void main(String[] args) {
        // Paso 5: Creación de una lista de transacciones utilizando el método estático "createTxnList()" de la clase "VentasTxn".
        List<VentasTxn> tLista = VentasTxn.createTxnList();
        
        // Paso 6: Declaración de un consumidor (Consumer) llamado "reporteDeImpuesto" que imprime información de la transacción.
        Consumer<VentasTxn> reporteDeImpuesto =
                t -> System.out.println("Id: " + t.getTxnId() +
                        " Comprador " + t.getCompradorNombre() +
                        " Transacción: " + t.getTransaccionTotal());
        
        // Paso 7: Imprime un mensaje de separación.
        System.out.println("=== Ventas de Comedor con impuesto en Antioquia ===");
        
        // Paso 8: Utiliza la API de Stream para realizar operaciones en la lista de transacciones.
        tLista.stream()
                // Paso 9: Filtra las transacciones que pertenecen al departamento de Antioquia (ANT).
                .filter(t -> t.getDepartamento().equals(Departamento.ANT))
                // Paso 10: Filtra las transacciones que son del producto "Comedor".
                .filter(t -> t.getProducto().equals("Comedor"))
                // Paso 11: Utiliza "peek" para aplicar el consumidor "reporteDeImpuesto" a cada transacción y mostrar información de la transacción.
                .peek(reporteDeImpuesto)
                // Paso 12: Calcula el impuesto de transacción multiplicando el total de la transacción por el rango de impuesto del departamento.
                .map(t -> t.getTransaccionTotal() * RangoImpuesto.porDepartamento(t.getDepartamento()))
                // Paso 13: Imprime el impuesto de cada transacción en la consola.
                .forEach(t -> System.out.println("Impuesto: " + t));
    }
}

