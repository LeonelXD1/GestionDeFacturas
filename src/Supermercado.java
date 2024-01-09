public class Supermercado {
    private String nombre;
    private Producto[] productos;
    private Factura[] facturas;
    private Cliente[] clientes;
    private int númeroDeProductos;
    private int númeroDeFacturas;
    private int númeroDeClientes;

    public Supermercado(String nombre) {
        this.nombre = nombre;
        productos = new Producto[20];
        facturas = new Factura[20];
        clientes = new Cliente[20];
        númeroDeProductos = 0;
        númeroDeFacturas = 0;
        númeroDeClientes = 0;
    }

    public void abastecer(Producto productoNuevo) {
        if(datosProductoSonVálidos(productoNuevo)){
            return;
        }
        productos[númeroDeProductos++] = productoNuevo;
    }

    private boolean datosProductoSonVálidos(Producto productoNuevo) {
        return productoNuevo.getPrecioUnitario() > 0 && productoNuevo.getCantidad() > 0;
    }

    public Factura generarFactura(Cliente clienteNuevo) {
        Factura nuevaFactura = null;
        Compra[] comprasDeCliente = clienteNuevo.getCompras();

        efectuarCompra(clienteNuevo);

        double subTotal = calcularSubTotal(comprasDeCliente);
        double iva = calcularIVATotal(comprasDeCliente, clienteNuevo);
        double total = calcularTotal(comprasDeCliente, clienteNuevo);

        if(!datosSonVálidos(subTotal, iva, total)) {
            return null;
        }

        nuevaFactura = new Factura(subTotal, iva, total, comprasDeCliente, clienteNuevo);
        registrarFactura(nuevaFactura);
        return nuevaFactura;
    }

    private boolean datosSonVálidos(double subTotal, double iva, double total) {
        return subTotal >= 0 && iva >= 0 && total > 0;
    }

    private void registrarFactura(Factura nuevaFactura) {
        facturas[númeroDeFacturas++] = nuevaFactura;
    }

    private double calcularSubTotal(Compra[] productosAComprar) {
        double subTotal = 0;
        for (Compra compra: productosAComprar) {
            if(!compraEsVálida(compra)) {
                continue;
            }
            subTotal += compra.getProducto().getPrecioUnitario() * compra.getCantidad();
        }
        return subTotal;
    }

    public double calcularIVATotal(Compra[] productosAComprar, Cliente cliente) {
        double ivaTotal = 0;
        for (Compra compra : productosAComprar) {
            if(!compraEsVálida(compra)) {
                continue;
            }
            if(cliente instanceof ClienteNormal) {
                ivaTotal += compra.getProducto().calcularIVA();
            } else {
                ivaTotal += compra.getProducto().calcularIVA(cliente);
            }
        }
        return ivaTotal;
    }

    private static boolean compraEsVálida(Compra compra) {
        return compra != null;
    }

    public void efectuarCompra(Cliente cliente){
        Compra[] nuevasCompras = cliente.getCompras();
        int cantidadAReducir = 0;
        for(Compra compra: nuevasCompras) {
            if(!compraEsVálida(compra)) {
                return;
            }
            cantidadAReducir = compra.getCantidad();
            reducirProducto(cantidadAReducir, compra.getProducto());
        }

    }

    private void reducirProducto(int cantidadAReducir, Producto producto) {
        for(Producto productoAReducir: productos) {
            if(!productoEsVálido(productoAReducir)) {
                return;
            }
            if(productoAReducir.equals(producto)){
                productoAReducir.reducirCantidad(cantidadAReducir);
                break;
            }
        }
    }

    private static boolean productoEsVálido(Producto productoAReducir) {
        return productoAReducir != null;
    }

    public double calcularTotal(Compra[] productosAComprar, Cliente cliente) {
        double subtotal = calcularSubTotal(productosAComprar);
        double iva = calcularIVATotal(productosAComprar, cliente);
        return subtotal + iva;
    }

    public void mostrarFacturas() {
        for(Factura factura: facturas) {
            if(!facturaEsVálida(factura)) {
                return;
            }
            System.out.println(factura);
            System.out.println();
        }
    }

    private static boolean facturaEsVálida(Factura factura) {
        return factura == null;
    }

    public void registrarCliente(Cliente cliente) {
        if(!clienteEsVálido(cliente)) {
            return;
        }
        clientes[númeroDeClientes++] = cliente;
        cliente.habilitarProductos(productos);
    }

    private boolean clienteEsVálido(Cliente clienteAValidar) {
        return clienteAValidar != null;
    }

    public Producto getProducto(int códigoDeProducto) {
        return productos[códigoDeProducto];
    }

    public void mostrarInventario(){
        for(Producto producto: productos) {
            if(!productoEsVálido(producto)) {
                return;
            }
            System.out.println(producto + " cantidad: | " + producto.getCantidad());
        }
    }
}
