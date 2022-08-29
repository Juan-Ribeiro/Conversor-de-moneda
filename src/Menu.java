import javax.swing.*;

public class Menu {
    public static void main(String[] args) {
        String[] opciones = new String[]{"1. Conversor de Moneda", "2. Conversor de Temperatura"};
        boolean activo = true;
        while (activo) {
            int respuesta = JOptionPane.showOptionDialog(null,
                    "Bienvenid@. Seleccione un conversor.", "Conversor de unidades",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opciones, opciones[0]);
            Conversor conversor;

            switch (respuesta) {
                case 0:
                    conversor = new ConversorDeMoneda();
                    conversor.iniciarConversor();
                    break;
                case 1:
                    conversor = new ConversorDeTemperatura();
                    conversor.iniciarConversor();
                    break;
            }

            String opcionContinuar =
                    String.valueOf(JOptionPane.showConfirmDialog(null, "¿Desea continuar?"));
            if (!opcionContinuar.equals("0")) {
                activo = false;
                JOptionPane.showMessageDialog(null, "Programa terminado. Hasta la próxima.");
            }
        }
    }
}
