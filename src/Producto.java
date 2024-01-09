public abstract class Producto {
    private String nombre;
    private double precioUnitario;
    private int cantidad;
    private int iva;

    public Producto(String nombre, double precioUnitario, int cantidad){
        this.nombre = nombre;
        this.precioUnitario = precioUnitario;
        this.cantidad = cantidad;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    @Override
    public String toString() {
        return "" + nombre + " | precio Unitario: " + precioUnitario + "$";
    }
    public String getNombre(){
        return nombre;
    }

    public abstract double calcularIVA();

    public abstract double calcularIVA(Cliente cliente);

    public void reducirCantidad(int cantidadAReducir) {
        if(!esCantidadVálida(cantidadAReducir)) {
            return;
        }
        this.cantidad -= cantidadAReducir;
    }

    private boolean esCantidadVálida(int cantidadAReducir) {
        return this.cantidad >= cantidadAReducir;
    }

    public int getCantidad() {
        return cantidad;
    }
}
