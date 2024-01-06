public class ProductoSinIva extends Producto{
    public ProductoSinIva(String nombre, double precioUnitario, int cantidad) {
        super(nombre, precioUnitario, cantidad);
    }

    @Override
    public double calcularIVA() {
        return 0;
    }

    @Override
    public double calcularIVA(Cliente cliente) {
        return 0;
    }
}
