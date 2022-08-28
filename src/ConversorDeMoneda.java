import javax.swing.*;

public class ConversorDeMoneda {

    public void iniciar() {

        double valor = solicitarValor();
    }

    public double solicitarValor() {
        double valor = 0;
        boolean valido = false;

        while(!valido){
            try {
                valor = Double.parseDouble(JOptionPane.showInputDialog(null,
                        "Ingrese el valor de moneda a convertir.", "Valor", JOptionPane.QUESTION_MESSAGE));
                valido = true;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Valor inválido. Intente nuevamente.");
            }
        }

        return valor;
    }
}