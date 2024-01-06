public abstract class Cliente {
    private String nombre;
    private String cédula;
    private Producto[] productos;
    private Compra[] compras;
    private int númeroDeCompras;

    public Cliente(String nombre, String cédula) {
        this.nombre = nombre;
        this.cédula = cédula;
        compras = new Compra[10];
        númeroDeCompras = 0;
        productos = new Producto[númeroDeCompras];
    }

    @Override
    public String toString() {
        return "Cliente: " + nombre + " Cédula: " + cédula;
    }

    public void agregarACarrito(Compra compra) {
        for(Producto productoABuscar: productos){
            if(!productoEsVálido(productoABuscar)){
                return;
            }
            if(compra.getProducto().equals(productoABuscar)){
                compras[númeroDeCompras++] = compra;
            }
        }
    }

    private static boolean productoEsVálido(Producto productoABuscar) {
        return productoABuscar != null;
    }

    public void habilitarProductos(Producto[] productos) {
        this.productos = productos;
    }

    public Compra[] getCompras() {
        return compras;
    }

    public abstract double getIVA();
}
