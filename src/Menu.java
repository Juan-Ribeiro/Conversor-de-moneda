import javax.swing.*;

public class Menu {
    public static void main(String[] args) {
        String[] opciones = new String[]{"1. Conversor de Moneda", "2. Conversor de Temperatura"};

        int respuesta = JOptionPane.showOptionDialog(null,
                "Bienvenid@. Seleccione un conversor.", "Conversor de unidades",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opciones, opciones[0]);
        ConversorDeMoneda conversor;

        switch (respuesta) {
            case 0:
                System.out.println("Conversor de moneda");
                conversor = new ConversorDeMoneda();
                conversor.iniciar();
                break;
            case 1:
                System.out.println("Conversor de temperatura");
                // TODO: 28/8/2022 Implementar
                break;
            default:
                System.out.println("Error");
        }
    }
}
