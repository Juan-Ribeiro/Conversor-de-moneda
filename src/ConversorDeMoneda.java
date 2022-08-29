import javax.swing.*;

public class ConversorDeMoneda extends Conversor{

    private static Object[] OPCIONES;

    // Cotización de monedas Peso Argentino. Fecha: 28/8/2022
    private static final double VALOR_DOLAR_AMERICANO = 138.12;
    private static final double VALOR_EURO = 137.60;
    private static final double VALOR_LIBRA_ESTERLINA = 162.10;
    private static final double VALOR_YEN_JAPONES = 1;
    private static final double VALOR_WON_COREANO = 9.72;

    public ConversorDeMoneda() {
        OPCIONES = new String[]{"De Pesos a Dólar Americano", "De Pesos a Euro",
                "De Pesos a Libra Esterlina", "De Pesos a Yen Japonés", "De Pesos a Won Coreano",
                "De Dólar Americano a Pesos", "De Euro a Pesos", "De Libra Esterlina a Pesos",
                "De Yen Japonés a Pesos", "De Won Coreano a Pesos", "De Euros a Pesos"};
    }

    public void iniciarConversor() {
        try {
            double valor = solicitarValor();
            String opcion = solicitarOpcionDeConversion();
            String resultado = realizarConversion(valor, opcion);
            JOptionPane.showMessageDialog(null, resultado);
        } catch (CancelarException e) {
            JOptionPane.showMessageDialog(null, "Operación de conversión cancelada.");
        }
    }

    protected double solicitarValor() throws CancelarException {
        double valor = 0;
        boolean valido = false;

        while (!valido) {
            try {
                valor = Double.parseDouble(JOptionPane.showInputDialog(null,
                        "Ingrese el valor de moneda a convertir.", "Valor", JOptionPane.QUESTION_MESSAGE));
                if (valor > 0) {
                    valido = true;
                } else {
                    throw new ValorNumericoInvalidoException("El valor numérico debe ser mayor a 0.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Valor inválido. Intente nuevamente.");
            } catch (NullPointerException e) {
                throw new CancelarException();
            }
        }
        return valor;
    }

    protected String solicitarOpcionDeConversion() throws CancelarException {
        String opcion = JOptionPane.showInputDialog(null, "Seleccione una opción de conversión",
                "MONEDAS", JOptionPane.QUESTION_MESSAGE, null, OPCIONES, OPCIONES[0]).toString();
        if (opcion == null) {
            throw new CancelarException();
        }
        return opcion;
    }

    protected String realizarConversion(double valor, String opcion) {
        String conversion = "";
        double resultado;

        switch (opcion) {
            case "De Pesos a Dólar Americano":
                resultado = valor / VALOR_DOLAR_AMERICANO;
                conversion = "Usted tiene " + resultado + " USD.";
                break;
            case "De Pesos a Euro":
                resultado = valor / VALOR_EURO;
                conversion = "Usted tiene " + resultado + " Euros.";
                break;
            case "De Pesos a Libra Esterlina":
                resultado = valor / VALOR_LIBRA_ESTERLINA;
                conversion = "Usted tiene " + resultado + " Libras Esterlinas.";
                break;
            case "De Pesos a Yen Japonés":
                resultado = valor / VALOR_YEN_JAPONES;
                conversion = "Usted tiene " + resultado + " Yenes Japoneses.";
                break;
            case "De Pesos a Won Coreano":
                resultado = valor / VALOR_WON_COREANO;
                conversion = "Usted tiene " + resultado + " Wones Coreanos.";
                break;
            case "De Dólar Americano a Pesos":
                resultado = valor * VALOR_DOLAR_AMERICANO;
                conversion = "Usted tiene " + resultado + " Pesos.";
                break;
            case "De Euro a Pesos":
                resultado = valor * VALOR_EURO;
                conversion = "Usted tiene " + resultado + " Pesos.";
                break;
            case "De Libra Esterlina a Pesos":
                resultado = valor * VALOR_LIBRA_ESTERLINA;
                conversion = "Usted tiene " + resultado + " Pesos.";
                break;
            case "De Yen Japonés a Pesos":
                resultado = valor * VALOR_YEN_JAPONES;
                conversion = "Usted tiene " + resultado + " Pesos.";
                break;
            case "De Won Coreano a Pesos":
                resultado = valor * VALOR_WON_COREANO;
                conversion = "Usted tiene " + resultado + " Pesos.";
                break;
        }

        return conversion;
    }
}