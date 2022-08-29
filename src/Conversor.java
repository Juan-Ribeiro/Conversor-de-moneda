public abstract class Conversor {
    protected static String[] OPCIONES;

    public abstract void iniciarConversor();
    protected abstract double solicitarValor() throws CancelarException;
    protected abstract String solicitarOpcionDeConversion() throws CancelarException;
    protected abstract String realizarConversion(double valor, String opcion);
}
