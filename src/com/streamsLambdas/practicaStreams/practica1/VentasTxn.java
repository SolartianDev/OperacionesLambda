// Paso 1: Declaración de un paquete.
package com.streamsLambdas.practicaStreams.practica1;

// Paso 2: Importación de clases necesarias.
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

// Paso 3: Declaración de la clase "VentasTxn".
public class VentasTxn {
    
    // Paso 4: Declaración de atributos de la clase.
    private long txnId;
    private String personaVenta;
    private Comprador comprador;
    private String producto;
    private String tipoDepago;
    private double preciounidad;
    private double cantidadUnidades;
    private LocalDate fecha;
    private String ciudad;
    private Departamento departamento;
    private String codigo;
    
    // Paso 5: Declaración de una clase interna estática llamada "Builder" para construir instancias de VentasTxn.
    public static class Builder {
        // Paso 6: Declaración de atributos para construir una instancia de VentasTxn con valores predeterminados.
        private long txnId = 0;
        private String personaVenta = "";
        private Comprador comprador;
        private String producto = "";
        private String tipoDepago = "";
        private double preciounidad = 0;
        private double cantidadUnidades = 0;
        private LocalDate fecha = LocalDate.now();
        private String ciudad = "";
        private Departamento departamento;
        private String codigo = "";

        // Paso 7: Métodos para configurar los valores de los atributos.
        public VentasTxn.Builder txnId(long txnId) {
            this.txnId = txnId;
            return this;
        }

        public VentasTxn.Builder personaVenta(String personaVenta) {
            this.personaVenta = personaVenta;
            return this;
        }

        public VentasTxn.Builder comprador(Comprador comprador) {
            this.comprador = comprador;
            return this;
        }

        public VentasTxn.Builder producto(String producto) {
            this.producto = producto;
            return this;
        }

        public VentasTxn.Builder tipoDepago(String tipoDepago) {
            this.tipoDepago = tipoDepago;
            return this;
        }

        public VentasTxn.Builder preciounidad(double preciounidad) {
            this.preciounidad = preciounidad;
            return this;
        }

        public VentasTxn.Builder cantidadUnidades(double cantidadUnidades) {
            this.cantidadUnidades = cantidadUnidades;
            return this;
        }

        public VentasTxn.Builder fecha(LocalDate fecha) {
            this.fecha = fecha;
            return this;
        }

        public VentasTxn.Builder ciudad(String ciudad) {
            this.ciudad = ciudad;
            return this;
        }

        public VentasTxn.Builder departamento(Departamento departamento) {
            this.departamento = departamento;
            return this;
        }

        public VentasTxn.Builder codigo(String codigo) {
            this.codigo = codigo;
            return this;
        }
    
        // Paso 8: Método para construir una instancia de VentasTxn con los valores configurados.
        public VentasTxn build() {
            return new VentasTxn(this);
        }
    }
    
    // Paso 9: Constructor privado de VentasTxn que recibe un objeto Builder y asigna sus valores a los atributos.
    private VentasTxn(VentasTxn.Builder builder) {
        txnId = builder.txnId;
        personaVenta = builder.personaVenta;
        comprador = builder.comprador;
        producto = builder.producto;
        tipoDepago = builder.tipoDepago;
        preciounidad = builder.preciounidad;
        cantidadUnidades = builder.cantidadUnidades;
        fecha = builder.fecha;
        ciudad = builder.ciudad;
        departamento = builder.departamento;
        codigo = builder.codigo;
    }

    // Paso 10: Métodos getter para obtener los valores de los atributos.
    public long getTxnId() {
        return txnId;
    }

    public String getPersonaVenta() {
        return personaVenta;
    }

    public Comprador getComprador() {
        return comprador;
    }

    public String getProducto() {
        return producto;
    }

    public String getTipoDepago() {
        return tipoDepago;
    }

    public double getPreciounidad() {
        return preciounidad;
    }

    public double getCantidadUnidades() {
        return cantidadUnidades;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public String getCiudad() {
        return ciudad;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public String getCodigo() {
        return codigo;
    }
    
    // Paso 11: Método para obtener el nombre del comprador.
    public String getCompradorNombre() {
        return comprador.getNombre();
    }
    
    // Paso 12: Método para obtener el rango de impuesto según el departamento.
    public double getRangoDeImpuesto() {
        return RangoImpuesto.porDepartamento(this.getDepartamento());
    }
    
    // Paso 13: Método para obtener el rango de descuento del comprador.
    public double getRangoDeDescuento() {
        return this.getComprador().getClaseComprador().getRango();
    }
    
    // Paso 14: Método para obtener el total de la transacción.
    public double getTransaccionTotal() {
        return this.cantidadUnidades * this.preciounidad;
    }
    
    // Paso 15: Método estático para ordenar VentasTxn por el nombre del comprador.
    public static int ordernarPorComprador(VentasTxn a, VentasTxn b) {
        return a.getCompradorNombre().compareTo(b.getCompradorNombre());
    }
    
    // Paso 16: Método para imprimir los detalles de la transacción.
    public String imprimir() {
        return 
        "Transaccion ID: " + txnId + "\n" +
        "Persona de venta: " + personaVenta + "\n" +
        "Nombre Comprador: " + this.getCompradorNombre() + "\n" +
        "Clase Comprador: " + this.getComprador().getClaseComprador() + "\n" +
        "Producto: " + producto + "\n" + 
        "Tipo de Pago: " + tipoDepago + "\n" +
        "Precio de Unidad: $" + preciounidad + "\n" +
        "Cantidad de unidades: " + cantidadUnidades + "\n" +
        "Precio de Venta: " + this.getTransaccionTotal() + "\n" +
        "Rango de impuesto: " + this.getRangoDeImpuesto() + "\n" +
        "Rango de Descuento: " + this.getRangoDeDescuento() + "\n" +
        "Fecha Transaccion: " + fecha + "\n" +
        "Ciudad: " + ciudad + "\n" +
        "Departamento: " + departamento + "\n" +
        "Codigo: " + codigo + "\n";
    }
    
    // Paso 17: Método para imprimir un resumen de la transacción en la consola.
    public void imprimirResumen() {
        System.out.println(
        "ID: " + txnId + " - " +
        "Vendedor: " + personaVenta + " - " +
        "Comprador: " + this.getCompradorNombre() + " - " +
        "Producto: " + producto + " - " + 
        "Departamento: " + this.departamento + " - " + 
        "Total: " + this.getTransaccionTotal() + " - " +
        "Fecha: " + this.fecha );
    }

    // Paso 18: Método para obtener un resumen de la transacción como cadena de texto.
    public String getResumenVenta() {
        return
        "ID: " + txnId + " - " +
        "Vendedor: " + personaVenta + " - " +
        "Comprador: " + this.getCompradorNombre() + " - " +
        "Producto: " + producto + " - " + 
        "Departamento: " + this.departamento + " - " + 
        "Total: " + this.getTransaccionTotal() + " - " +
        "Fecha: " + this.fecha;
    }
    
    // Paso 19: Método toString para obtener una representación de cadena del objeto.
    @Override
    public String toString() {
        return 
        "Transaccion ID: " +
        "Persona de venta: " + personaVenta +
        "Nombre Comprador: " + this.getCompradorNombre() + 
        "Clase Comprador: " + this.getComprador().getClaseComprador() + 
        "Buyer class: " + this.getComprador().getClaseComprador() + 
        "Producto: " + producto + 
        "Tipo de Pago: " + tipoDepago + 
        "Precio de Unidad: $" + preciounidad + 
        "Cantidad de unidades: " + cantidadUnidades + 
        "Precio de Venta: " + this.getTransaccionTotal() + 
        "Rango de impuesto: " + this.getRangoDeImpuesto() +
        "Rango de Descuento: " + this.getRangoDeDescuento() + 
        "Fecha Transaccion: " + fecha + 
        "Ciudad: " + ciudad + 
        "Departamento: " + departamento + 
        "Codigo: " + codigo + "\n";
    } 
    
    // Paso 20: Método estático para crear una lista de transacciones de ejemplo.
    public static List<VentasTxn> createTxnList() {
        List<VentasTxn> txnLista = new ArrayList<>();
        Map<String, Comprador> mapaComprador = Comprador.getMapComprador();
        
        // Paso 21: Agrega instancias de VentasTxn a la lista con valores específicos.
    txnLista.add(
      new VentasTxn.Builder()
            .txnId(11)
            .personaVenta("Andres Martinez")
            .comprador(mapaComprador.get("Electronics"))
            .producto("Smarth Watch")
            .tipoDepago("Efectivo")
            .preciounidad(20)
            .cantidadUnidades(2000)
            .fecha(LocalDate.of(2013,1,25))
            .ciudad("Bogotá")
            .departamento(Departamento.DC)
            .codigo("95101")
            .build());
    
    txnLista.add(
      new VentasTxn.Builder()
            .txnId(12)
            .personaVenta("Andres Martinez")
            .comprador(mapaComprador.get("Electronics"))
            .producto("Smarth Watch Pro")
            .tipoDepago("Efectivo")
            .preciounidad(40)
            .cantidadUnidades(3000)
            .fecha(LocalDate.of(2013,4,5))
            .ciudad("Bogotá")
            .departamento(Departamento.DC)
            .codigo("95101")
            .build());
    
    txnLista.add(
      new VentasTxn.Builder()
            .txnId(13)
            .personaVenta("Camila Garzon")
            .comprador(mapaComprador.get("Hogar"))
            .producto("Sofa Cama")
            .tipoDepago("Credito")
            .preciounidad(40)
            .cantidadUnidades(50000)
            .fecha(LocalDate.of(2013,10,2))
            .ciudad("Medellin")
            .departamento(Departamento.ANT)
            .codigo("95203")
            .build());
    txnLista.add(
      new VentasTxn.Builder()
            .txnId(14)
            .personaVenta("Camila Garzon")
            .comprador(mapaComprador.get("Hogar"))
            .producto("Comedor")
            .tipoDepago("Credito")
            .preciounidad(40)
            .cantidadUnidades(20000)
            .fecha(LocalDate.of(2013,2,12))
            .ciudad("Medellin")
            .departamento(Departamento.ANT)
            .codigo("81293")
            .build());
    
    
    txnLista.add(
      new VentasTxn.Builder()
            .txnId(15)
            .personaVenta("Juan Velasquez")
            .comprador(mapaComprador.get("MercadoLibre"))
            .producto("Fundas de celular")
            .tipoDepago("Credito")
            .preciounidad(20)
            .cantidadUnidades(500)
            .fecha(LocalDate.of(2013,7,14))
            .ciudad("Tunja")
            .departamento(Departamento.BOY)
            .codigo("92779")
            .build());
    
    
    txnLista.add(
      new VentasTxn.Builder()
            .txnId(21)
            .personaVenta("Juan Velasquez")
            .comprador(mapaComprador.get("MercadoLibre"))
            .producto("Fundas de celular")
            .tipoDepago("Credito")
            .preciounidad(40)
            .cantidadUnidades(500)
            .fecha(LocalDate.of(2013,11,24))
            .ciudad("Tunja")
            .departamento(Departamento.BOY)
            .codigo("92779")
            .build());
    
    txnLista.add(
      new VentasTxn.Builder()
            .txnId(22)
            .personaVenta("Juan Velasquez")
            .comprador(mapaComprador.get("MercadoLibre"))
            .producto("Fundas de celular")
            .tipoDepago("Credito")
            .preciounidad(10)
            .cantidadUnidades(500)
            .fecha(LocalDate.of(2013,2,12))
            .ciudad("Tunja")
            .departamento(Departamento.BOY)
            .codigo("92779")
            .build());
    
    txnLista.add(
      new VentasTxn.Builder()
            .txnId(16)
            .personaVenta("Juan Velasquez")
            .comprador(mapaComprador.get("MercadoLibre"))
            .producto("Televisor LG")
            .tipoDepago("Credito")
            .preciounidad(20)
            .cantidadUnidades(100000)
            .fecha(LocalDate.of(2013,11,25))
            .ciudad("Tunja")
            .departamento(Departamento.BOY)
            .codigo("93452")
            .build());
    
    txnLista.add(
      new VentasTxn.Builder()
            .txnId(17)
            .personaVenta("Felipe Gutierrez")
            .comprador(mapaComprador.get("Aseo"))
            .producto("Detergente")
            .tipoDepago("Efectivo")
            .preciounidad(35)
            .cantidadUnidades(100)
            .fecha(LocalDate.of(2013,3,18))
            .ciudad("Bogotá")
            .departamento(Departamento.DC)
            .codigo("91234")
            .build());
    
    
    txnLista.add(
      new VentasTxn.Builder()
            .txnId(18)
            .personaVenta("Manuel Rodriguez")
            .comprador(mapaComprador.get("Aseo"))
            .producto("Jabon Rey")
            .tipoDepago("Efectivo")
            .preciounidad(70)
            .cantidadUnidades(35)
            .fecha(LocalDate.of(2013,8,23))
            .ciudad("Medellin")
            .departamento(Departamento.ANT)
            .codigo("91303")
            .build());
    
    txnLista.add(
      new VentasTxn.Builder()
            .txnId(19)
            .personaVenta("Julian Martinez")
            .comprador(mapaComprador.get("Camisas"))
            .producto("Polo")
            .tipoDepago("Credito")
            .preciounidad(10)
            .cantidadUnidades(200)
            .fecha(LocalDate.of(2013,9,29))
            .ciudad("Bogotá")
            .departamento(Departamento.DC)
            .codigo("92298")
            .build());
    
    txnLista.add(
      new VentasTxn.Builder()
            .txnId(20)
            .personaVenta("Pedro Montenegro")
            .comprador(mapaComprador.get("Herramienta"))
            .producto("Llave Inglesa")
            .tipoDepago("Credito")
            .preciounidad(10)
            .cantidadUnidades(125)
            .fecha(LocalDate.of(2012,2,18))
            .ciudad("Tunja")
            .departamento(Departamento.BOY)
            .codigo("88927")
            .build());
    
    return txnLista;
    }
}
