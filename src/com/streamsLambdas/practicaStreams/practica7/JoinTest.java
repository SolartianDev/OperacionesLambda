// Paso 1: Declaración de un paquete.
package com.streamsLambdas.practicaStreams.practica7;

// Paso 2: Importación de clases necesarias.
import java.util.List;
import java.util.stream.Collectors;

// Paso 3: Declaración de la clase "JoinTest".
public class JoinTest {
    public static void main(String[] args) {
        // Paso 4: Creación de una lista de transacciones usando el método "createTxnList" de la clase "VentasTxn".
        List<VentasTxn> tList = VentasTxn.createTxnList();

        // Paso 5: Imprime un encabezado para indicar la operación que se realizará a continuación.
        System.out.println("=== Lista Ordenada de Compradores");

        // Paso 6: Utiliza un flujo para realizar las siguientes operaciones en la lista de transacciones:
        // - Mapea cada transacción a su nombre de comprador.
        // - Elimina duplicados usando "distinct".
        // - Ordena los nombres de compradores alfabéticamente.
        // - Colecta los nombres de compradores en una sola cadena separada por comas utilizando "joining".
        String resultado = tList.stream()
                .map(t -> t.getCompradorNombre())
                .distinct()
                .sorted()
                .collect(Collectors.joining(", "));

        // Paso 7: Imprime la lista ordenada de nombres de compradores.
        System.out.println("Lista de Compradores: " + resultado);
    }
}

