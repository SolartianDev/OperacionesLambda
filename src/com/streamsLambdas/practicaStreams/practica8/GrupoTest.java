// Paso 1: Declaración de un paquete.
package com.streamsLambdas.practicaStreams.practica8;

// Paso 2: Importación de clases necesarias.
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// Paso 3: Declaración de la clase "GrupoTest".
public class GrupoTest {
    public static void main(String[] args) {
        // Paso 4: Creación de una lista de transacciones usando el método "createTxnList" de la clase "VentasTxn".
        List<VentasTxn> tList = VentasTxn.createTxnList();
        
        // Paso 5: Declaración de un mapa "tMap" que se utilizará para agrupar las transacciones por comprador.
        Map<String, List<VentasTxn>> tMap;
        
        // Paso 6: Imprime un encabezado para indicar la operación que se realizará a continuación.
        System.out.println("=== Grupo de Transacciones por Comprador ===");
        
        // Paso 7: Utiliza un flujo para realizar las siguientes operaciones en la lista de transacciones:
        // - Agrupa las transacciones por el nombre del comprador utilizando "groupingBy".
        tMap = tList.stream()
                .collect(Collectors.groupingBy(VentasTxn::getCompradorNombre));
        
        // Paso 8: Itera a través de las entradas del mapa "tMap" (comprador y lista de transacciones).
        // Para cada comprador, imprime el nombre del comprador y luego itera a través de las transacciones
        // de ese comprador e imprime un resumen de cada transacción.
        tMap.forEach((k, v) -> {
            System.out.println("\n Comprador: " + k);
            v.forEach(VentasTxn::imprimirResumen);
        });
    }
}

