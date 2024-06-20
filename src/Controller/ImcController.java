package Controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;
import View.ImcView;

public class ImcController {
    private ImcView view;
    private ResourceBundle bundle;

    public ImcController(ImcView view, ResourceBundle bundle) {
        this.bundle=bundle;
        this.view = view;
        eventListeners();
    }

    public void eventListeners() {
        view.getBtnCalculate().addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
               calculateImc();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                // Optional: Handle mouse entered event
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // Optional: Handle mouse exited event
            }

            @Override
            public void mousePressed(MouseEvent e) {
                // Optional: Handle mouse pressed event
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // Optional: Handle mouse released event
            }
        });
    }

    private void calculateImc() {
        try {
            double peso = Double.parseDouble(view.getPeso().getText());
            double altura = Double.parseDouble(view.getAltura().getText());
            String unidadPeso = (String) view.getUnidadPeso().getSelectedItem();
            String unidadAltura = (String) view.getUnidadAltura().getSelectedItem();
            String resultado = calcularIMC(peso, altura, unidadPeso, unidadAltura);
            view.getLabelResult().setText(resultado);
            view.getLabelResult().setVisible(true);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(view, bundle.getString("inp_error_tr"), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public String calcularIMC(double peso, double altura, String unidadPeso, String unidadAltura) {
        double valor = 0;
        String resultado = "Invalid";
        if (unidadPeso.equalsIgnoreCase("kg") && unidadAltura.equalsIgnoreCase("mts")) {
            valor = peso / Math.pow(altura, 2);
            resultado = obtenerValor(valor);
        } else if (unidadPeso.equalsIgnoreCase("lb") && unidadAltura.equalsIgnoreCase("mts")) {
            peso = peso * 0.453592;
            valor = peso / Math.pow(altura, 2);
            resultado = obtenerValor(valor);
        } else if (unidadPeso.equalsIgnoreCase("kg") && unidadAltura.equalsIgnoreCase("cm")) {
            altura = altura * 0.01;
            valor = peso / Math.pow(altura, 2);
            resultado = obtenerValor(valor);
        } else if (unidadPeso.equalsIgnoreCase("lb") && unidadAltura.equalsIgnoreCase("cm")) {
            peso = peso * 0.453592;
            altura = altura * 0.01;
            valor = peso / Math.pow(altura, 2);
            resultado = obtenerValor(valor);
        } else if (unidadPeso.equalsIgnoreCase("kg") && unidadAltura.equalsIgnoreCase("fts")) {
            altura = altura * 0.3048;
            valor = peso / Math.pow(altura, 2);
            resultado = obtenerValor(valor);
        } else if (unidadPeso.equalsIgnoreCase("lb") && unidadAltura.equalsIgnoreCase("fts")) {
            altura = altura * 0.3048;
            peso = peso * 0.453592;
            valor = peso / Math.pow(altura, 2);
            resultado = obtenerValor(valor);
        }
        return resultado;
    }

    private String obtenerValor(double valor) {
        if (valor < 16) {
            return bundle.getString("imc_severe_underweight_tr");
        } else if (valor >= 16 && valor < 17) {
            return bundle.getString("imc_moderate_underweight_tr");
        } else if (valor >= 17 && valor < 18.5) {
            return bundle.getString("imc_mild_underweight_tr");
        } else if (valor >= 18.5 && valor < 25) {
            return bundle.getString("imc_normal_tr");
        } else if (valor >= 25 && valor < 30) {
            return bundle.getString("imc_overweight_tr");
        } else if (valor >= 30 && valor < 35) {
            return bundle.getString("imc_obesity_type1_tr");
        } else if (valor >= 35 && valor < 40) {
            return bundle.getString("imc_obesity_type2_tr");
        } else {
            return bundle.getString("imc_obesity_type3_tr");
        }
    }
}
