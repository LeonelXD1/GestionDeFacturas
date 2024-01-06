import java.text.DecimalFormat;

public class Factura {
    private double subTotal;
    private double ivaTotal;
    private double total;
    private Compra[] compras;
    private Cliente cliente;
    private DecimalFormat df = new DecimalFormat("#.00");

    public Factura(double subTotal, double ivaTotal, double total, Compra[] compras, Cliente cliente) {
        this.subTotal = subTotal;
        this.ivaTotal = ivaTotal;
        this.total = total;
        this.compras = compras;
        this.cliente = cliente;
    }


    @Override
    public String toString() {
        System.out.println("***Factura***\n" +
                            cliente);
        imprimirCompras();
        System.out.println("\nsubtotal: " + df.format(subTotal) + "$" +
                           "\nIVA: " + df.format(ivaTotal) + "$");
        return "Total: " + df.format(total) + "$";

    }

    public void imprimirCompras(){
        System.out.println("\t PRODUCTOS");
        for(Compra compra: compras) {
            if(!compraEsVálida(compra)) {
                continue;
            }
            System.out.println("\t" + compra);
        }
    }

    private static boolean compraEsVálida(Compra compra) {
        return compra != null;
    }
}
