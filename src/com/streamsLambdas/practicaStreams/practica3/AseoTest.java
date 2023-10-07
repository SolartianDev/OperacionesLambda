// Paso 1: Declaración de un paquete.
package com.streamsLambdas.practicaStreams.practica3;

// Paso 2: Importación de clases necesarias.
import com.streamsLambdas.practicaStreams.*;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

// Paso 3: Declaración de la clase "AseoTest".
public class AseoTest {
    
    // Paso 4: Método principal "main".
    public static void main(String[] args) {
        // Paso 5: Creación de una lista de transacciones usando el método "createTxnList" de la clase "VentasTxn".
        List<VentasTxn> tLista = VentasTxn.createTxnList();
        System.out.println(tLista); // Imprime la lista de transacciones completa.

        // Paso 6: Declaración de un consumidor "reporteAseo" que imprime información detallada sobre las transacciones de Aseo SA.
        Consumer<VentasTxn> reporteAseo =
             t -> System.out.printf("ID: "+ t.getTxnId()+" Vendedor: "+
                     t.getPersonaVenta()+ " -- Comprador: "+ t.getCompradorNombre()+" -- Departamento"
             +t.getDepartamento() + " --Transaccion: "+ t.getTransaccionTotal());

        // Paso 7: Imprime un encabezado para indicar la operación que se realizará a continuación.
        System.out.println("=== Transacciones de Aseo SA ===");

        // Paso 8: Filtra las transacciones de Aseo SA y aplica el consumidor "reporteAseo" a cada una de ellas.
        tLista.stream()
                .filter( t-> t.getCompradorNombre().equals("Aseo SA"))
                .forEach(reporteAseo);

        // Paso 9: Imprime un encabezado para indicar la operación que se realizará a continuación.
        System.out.println("Total transacciones: ");

        // Paso 10: Cuenta el número de transacciones de Aseo SA y lo imprime.
        long tConteo = tLista.stream()
                .filter(t-> t.getCompradorNombre().equals("Aseo SA"))
                .count();
        System.out.println(tConteo);

        // Paso 11: Imprime un encabezado para indicar la operación que se realizará a continuación.
        System.out.println("=== Compra más grande de Aseo SA ===");

        // Paso 12: Encuentra la transacción más grande de Aseo SA basándose en el valor de la transacción total.
        Optional<VentasTxn> tLargo = tLista.stream()
                .filter(t-> t.getCompradorNombre().equals("Aseo SA"))
                .max(Comparator.comparing(VentasTxn :: getTransaccionTotal));

        // Paso 13: Si se encuentra una transacción más grande, se aplica el consumidor "reporteAseo" a ella.
        if(tLargo.isPresent()){
            reporteAseo.accept(tLargo.get());
        }

        // Paso 14: Imprime un encabezado para indicar la operación que se realizará a continuación.
        System.out.println("=== Compra más pequeña de Aseo SA ===");

        // Paso 15: Encuentra la transacción más pequeña de Aseo SA basándose en el valor de la transacción total.
        Optional<VentasTxn> tSmall = tLista.stream()
                .filter(t -> t.getCompradorNombre().equals("Aseo SA"))
                .min(Comparator.comparing(VentasTxn::getTransaccionTotal));

        // Paso 16: Si se encuentra una transacción más pequeña, se aplica el consumidor "reporteAseo" a ella.
        if(tSmall.isPresent()){
            reporteAseo.accept(tSmall.get());
        }
    }
}
