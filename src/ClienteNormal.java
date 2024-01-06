public class ClienteNormal extends Cliente{
    private final double IVA = 0.14;
    public ClienteNormal(String nombre, String cédula) {
        super(nombre, cédula);
    }

    @Override
    public double getIVA() {
        return IVA;
    }
}
