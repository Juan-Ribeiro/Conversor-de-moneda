import javax.swing.*;

public class ConversorDeTemperatura extends Conversor {

    public ConversorDeTemperatura() {
        OPCIONES = new String[]
                {"De grados Celsius a Fahrenheit", "De grados Celsius a Kelvin", "De grados Fahrenheit a Celsius",
                        "De grados Fahrenheit a Kelvin", "De grados Kelvin a Celsius", "De grados Kelvin a Fahrenheit"};
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
                        "Ingrese el valor de temperatura en grados a convertir.", "Valor", JOptionPane.QUESTION_MESSAGE));
                if (valor > 0) {
                    valido = true;
                } else {
                    throw new ValorNumericoInvalidoException("El valor ingresado debe ser numérico.");
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
                "TEMPERATURAS", JOptionPane.QUESTION_MESSAGE, null, OPCIONES, OPCIONES[0]).toString();
        if (opcion == null) {
            throw new CancelarException();
        }
        return opcion;
    }

    protected String realizarConversion(double valor, String opcion) {
        double resultado;
        String conversion = "";

        switch (opcion) {
            case "De grados Celsius a Fahrenheit":
                resultado = (valor * (1.8)) + 32;
                conversion = "El resultado es: " + resultado + " grados Fahrenheit.";
                break;
            case "De grados Celsius a Kelvin":
                resultado = valor + 273.15;
                conversion = "El resultado es: " + resultado + " grados Kelvin.";
                break;
            case "De grados Fahrenheit a Celsius":
                resultado = ((valor - 32) * 5) / 9;
                conversion = "El resultado es: " + resultado + " grados Celsius.";
                break;
            case "De grados Fahrenheit a Kelvin":
                resultado = ((valor - 32) * 5) / 9 + 273.15;
                conversion = "El resultado es: " + resultado + " grados Kelvin.";
                break;
            case "De grados Kelvin a Celsius":
                resultado = valor - 273.15;
                conversion = "El resultado es: " + resultado + " grados Celsius.";
                break;
            case "De grados Kelvin a Fahrenheit":
                resultado = (valor - 273.15) * (1.8) + 32;
                conversion = "El resultado es: " + resultado + " grados Fahrenheit.";
                break;
        }

        return conversion;
    }
}
