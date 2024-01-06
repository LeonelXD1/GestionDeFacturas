// Realice un programa que gestione las facturas de una empresa
public class Main {
    public static void main(String[] args) {
        Supermercado superMaxi = new Supermercado("Tuti");
        superMaxi.abastecer(new ProductoSinIva("Leche", 0.95, 10)); //Productos comestibles no tienen IVA
        superMaxi.abastecer(new ProductoConIVA("Rexona", 4.60, 10));
        superMaxi.abastecer(new ProductoSinIva("Leche", 0.95, 10)); //Productos comestibles no tienen IVA
        superMaxi.abastecer(new ProductoConIVA("Jabón", 1.30, 10));

        ClienteNormal cliente1 = new ClienteNormal("Leonel", "1750188235");
        ClienteManaba cliente2 = new ClienteManaba("Leonel", "1750188235");

        superMaxi.registrarCliente(cliente1);
        superMaxi.registrarCliente(cliente2);

        superMaxi.mostrarInventario();

        cliente2.agregarACarrito(new Compra(superMaxi.getProducto(1), 2));
        cliente2.agregarACarrito(new Compra(superMaxi.getProducto(0), 5));

        cliente1.agregarACarrito(new Compra(superMaxi.getProducto(1), 2));
        cliente1.agregarACarrito(new Compra(superMaxi.getProducto(0), 5));
//        cliente1.agregarACarrito(new Compra(superMaxi.getProducto(1), 1));

        Factura factura1 = superMaxi.generarFactura(cliente2);
        Factura factura2 = superMaxi.generarFactura(cliente1);
        System.out.println();


//        System.out.println(factura1);
        superMaxi.mostrarFacturas();

        superMaxi.mostrarInventario();
    }
}