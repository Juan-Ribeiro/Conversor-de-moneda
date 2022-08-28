public class ValorNumericoNegativoException extends NumberFormatException {
    public ValorNumericoNegativoException() {
        super("El valor numérico debe ser mayor a 0.");
    }
}
