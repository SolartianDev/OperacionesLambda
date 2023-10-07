
// Paso 1: Declaración de un paquete.
package com.streamsLambdas.practicaStreams.practica6;

// Paso 2: Importación de clases necesarias.
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

// Paso 3: Declaración de la clase "CollectTest".
public class CollectTest {
    public static void main(String[] args) {
        // Paso 4: Creación de una lista de transacciones usando el método "createTxnList" de la clase "VentasTxn".
        List<VentasTxn> tList = VentasTxn.createTxnList();
        List<VentasTxn> rList; // Declaración de una lista para almacenar resultados.

        // Paso 5: Declaración de un consumidor "reporteTxn" para imprimir los detalles de las transacciones.
        Consumer<VentasTxn> reporteTxn = t -> System.out.println("Id: " + t.getTxnId() + " Vendedor: " + t.getPersonaVenta()
                + " Comprador: " + t.getCompradorNombre() + " Transaccion: " + t.getTransaccionTotal());

        // Paso 6: Imprime un encabezado para indicar la operación que se realizará a continuación.
        System.out.println("=== Transacciones mayores a $300k");

        // Paso 7: Filtra las transacciones cuyo total sea mayor a $300,000.
        rList = tList.stream()
                .filter(t -> t.getTransaccionTotal() > 300_000)
                .sorted(Comparator.comparing(VentasTxn::getTransaccionTotal)) // Ordena las transacciones por total.
                .collect(Collectors.toList()); // Colecta los resultados filtrados en una lista.

        // Paso 8: Itera sobre la lista resultante e imprime los detalles de las transacciones.
        rList.stream()
                .forEach(reporteTxn);
    }
}

