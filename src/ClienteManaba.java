public class ClienteManaba extends Cliente{
    private final double IVA = 0.08;

    public ClienteManaba(String nombre, String cédula) {
        super(nombre, cédula);
    }

    @Override
    public double getIVA() {
        return IVA;
    }
}
