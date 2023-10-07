// Paso 1: Declaración de un paquete.
package com.streamsLambdas.practicaStreams.practica5;

// Paso 2: Importación de clases necesarias.
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

// Paso 3: Declaración de la clase "SortTest".
public class SortTest {
    public static void main(String[] args) {
        // Paso 4: Creación de una lista de transacciones usando el método "createTxnList" de la clase "VentasTxn".
        List<VentasTxn> tList = VentasTxn.createTxnList();
        
        // Paso 5: Declaración de un consumidor "transReporte" para imprimir los detalles de las transacciones.
        Consumer<VentasTxn> transReporte = 
          t -> System.out.printf("Id: " + t.getTxnId() 
            + " Vendedor: " + t.getPersonaVenta()+ " Comprador: " 
            + t.getCompradorNombre()+ " Transaccion: "+ t.getTransaccionTotal());
        
        // Paso 6: Imprime un encabezado para indicar la operación que se realizará a continuación.
        System.out.println("=== Transactiones ===");
        
        // Paso 7: Ordena las transacciones por el total de transacción en orden ascendente y las imprime.
        tList.stream()
            .sorted(Comparator.comparing(VentasTxn::getTransaccionTotal))
            .forEach(transReporte);
        
        // Paso 8: Imprime un encabezado para indicar la operación que se realizará a continuación.
        System.out.println("\n=== Transactiones Camisas y Pantalones SA Reversed ===");
        
        // Paso 9: Ordena las transacciones por el total de transacción en orden descendente (reverso) y las imprime.
        tList.stream()
            .sorted(Comparator.comparing(VentasTxn::getTransaccionTotal).reversed())
            .forEach(transReporte);
        
        // Paso 10: Imprime un encabezado para indicar la operación que se realizará a continuación.
        System.out.println("\n=== Triple Transacciones Sort ===");
        
        // Paso 11: Ordena las transacciones por comprador, vendedor y total de transacción en ese orden y las imprime.
        tList.stream()
            .sorted(Comparator
                .comparing(VentasTxn::getCompradorNombre)
                .thenComparing(VentasTxn::getPersonaVenta)
                .thenComparing(VentasTxn::getTransaccionTotal)
            )
            .forEach(transReporte);
    }
}

