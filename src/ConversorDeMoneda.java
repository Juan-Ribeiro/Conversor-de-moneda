import javax.swing.*;

public class ConversorDeMoneda {

    private static final Object[] opciones = new String[]{"De Pesos a Dólar Americano", "De Pesos a Euro",
            "De Pesos a Libra Esterlina", "De Pesos a Yen Japonés", "De Pesos a Won Coreano",
            "De Dólar Americano a Pesos", "De Euro a Pesos", "De Libra Esterlina a Pesos",
            "De Yen Japonés a Pesos", "De Won Coreano a Pesos", "De Euros a Pesos"};

    public void iniciarConversor() {
        try {
            double valor = solicitarValor();
            Object opcion = solicitarOpcionDeConversion();
        } catch (CancelarException e) {
            System.out.println("Abandonando menú. Hasta la próxima.");
        }
    }

    public double solicitarValor() throws CancelarException {
        double valor = 0;
        boolean valido = false;

        while (!valido) {
            try {
                valor = Double.parseDouble(JOptionPane.showInputDialog(null,
                        "Ingrese el valor de moneda a convertir.", "Valor", JOptionPane.QUESTION_MESSAGE));
                if (valor > 0) {
                    valido = true;
                } else {
                    throw new ValorNumericoNegativoException();
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Valor inválido. Intente nuevamente.");
            } catch (NullPointerException e) {
                throw new CancelarException();
            }
        }
        return valor;
    }

    public Object solicitarOpcionDeConversion() throws CancelarException {
        Object opcion = JOptionPane.showInputDialog(null, "Seleccione una opción de conversión",
                "MONEDAS", JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
        if (opcion == null) {
            throw new CancelarException();
        }
        return opcion;
    }
}