public class ProductoConIVA extends Producto {
    private final static double IVA = 0.12;

    public ProductoConIVA(String nombre, double precioUnitario, int cantidad) {
        super(nombre, precioUnitario, cantidad);
    }

    public double calcularIVA() {
        return getPrecioUnitario() * IVA;
    }

    public double calcularIVA(Cliente cliente) {
        return getPrecioUnitario() * cliente.getIVA();
    }

}
