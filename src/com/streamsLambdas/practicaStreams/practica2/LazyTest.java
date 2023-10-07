// Paso 1: Declaración de un paquete.
package com.streamsLambdas.practicaStreams.practica2;

// Paso 2: Importación de clases necesarias.
import com.streamsLambdas.practicaStreams.*;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

// Paso 3: Declaración de la clase "LazyTest".
public class LazyTest {
    // Paso 4: Método principal "main".
    public static void main(String[] args) {
        // Paso 5: Creación de una lista de transacciones usando el método "createTxnList" de la clase "VentasTxn".
        List<VentasTxn> tLista = VentasTxn.createTxnList();
        
        // Paso 6: Declaración de un consumidor "reporteCantidad" que imprime información sobre las unidades vendidas.
        Consumer<VentasTxn> reporteCantidad = 
                t-> System.out.println("Vendedor: "+
                t.getPersonaVenta()+ "-- Comprador: "+ t.getCompradorNombre()
                + "Cantidad: "+t.getCantidadUnidades());
        
        // Paso 7: Declaración de un consumidor "inicioStream" que imprime un mensaje al inicio del flujo de transacciones.
        Consumer<VentasTxn> inicioStream =
                t-> System.out.println("Inicio del flujo: "+t.getPersonaVenta()
                +" ID: "+t.getTxnId());
        
        // Paso 8: Declaración de un consumidor "buscarDepart" que imprime información sobre el departamento buscado.
        Consumer<VentasTxn> buscarDepart =
                t-> System.out.println("Departamento buscado: "+ t.getPersonaVenta()
                        +"Departamento: "+ t.getDepartamento());
        
        // Paso 9: Declaración de un consumidor "buscarProducto" que imprime un mensaje sobre la búsqueda de un producto.
        Consumer<VentasTxn> buscarProducto =
                 t-> System.out.println("Producto a buscar");
        
        
        // Paso 10: Imprime un encabezado para indicar la operación que se realizará a continuación.
        System.out.println("\n=== Cantidad de Fundas de celular en Boyacá ===");
        
        // Paso 11: Utiliza una secuencia de operaciones de flujo para filtrar transacciones específicas y luego ejecuta el consumidor "reporteCantidad" en cada una.
        tLista.stream()
                .filter(t -> t.getDepartamento().equals(Departamento.BOY))
                .filter(t-> t.getProducto().equals("Fundas de celular"))
                .forEach(reporteCantidad);
        
        // Paso 12: Imprime un encabezado para indicar la operación que se realizará a continuación.
        System.out.println("\n=== Cantidad de Fundas de celular en Boyacá (FindFirst) ===");
        
        // Paso 13: Utiliza una secuencia de operaciones de flujo para buscar la primera transacción que cumpla con ciertos criterios.
        Optional<VentasTxn> ft = tLista.stream()
                .peek(inicioStream)
                .filter(t-> t.getDepartamento().equals(Departamento.BOY))
                .peek(buscarDepart)
                .filter(t -> t.getProducto().equals("Fundas de celular"))
                .peek(buscarProducto)
                .findFirst();
        
        // Paso 14: Comprueba si se encontró una transacción (usando Optional) y, si es así, ejecuta el consumidor "reporteCantidad" en ella.
        if(ft.isPresent()){
            reporteCantidad.accept(ft.get());
        }
    }
}

   
     
