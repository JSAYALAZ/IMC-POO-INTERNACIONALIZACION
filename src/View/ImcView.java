package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ResourceBundle;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

import Controller.ImcController;

public class ImcView extends JFrame {
    private ResourceBundle bundle;
    private JLabel labelMain = new JLabel();
    private JLabel labelAltura = new JLabel();
    private JLabel labelPeso = new JLabel();
    private JLabel labelResult = new JLabel();
    private JTextField peso = new JTextField(10);
    private JTextField altura = new JTextField(10);
    private JComboBox<String> unidadAltura = new JComboBox<>();
    private JComboBox<String> unidadPeso = new JComboBox<>();
    private JButton btnCalculate = new JButton();
    private JPanel rootPanel = new JPanel();

    public ImcView(ResourceBundle bundle) {
        this.bundle = bundle;
        new ImcController(this, bundle);
        initComponents();
        setSize(500, 500);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centra la ventana en la pantalla
    }

    public void initComponents() {
        // Establecer LookAndFeel
        try {
            UIManager.setLookAndFeel("com.formdev.flatlaf.FlatLightLaf");
        } catch (Exception e) {
            e.printStackTrace();
        }


        btnCalculate.setText(bundle.getString("imc_calc_tr"));
        labelMain.setText(bundle.getString("imc_main_tr"));
        labelAltura.setText(bundle.getString("imc_altura_tr"));
        labelPeso.setText(bundle.getString("imc_peso_tr"));

        unidadPeso.addItem(bundle.getString("box_select"));
        unidadPeso.addItem("kg");
        unidadPeso.addItem("lb");

        unidadAltura.addItem(bundle.getString("box_select"));
        unidadAltura.addItem("cm");
        unidadAltura.addItem("mts");
        unidadAltura.addItem("fts");

        // Personalizar componentes
        labelMain.setFont(new Font("Arial", Font.BOLD, 24));
        labelMain.setForeground(new Color(50, 50, 150));

        labelAltura.setFont(new Font("Arial", Font.PLAIN, 18));
        labelPeso.setFont(new Font("Arial", Font.PLAIN, 18));

        btnCalculate.setFont(new Font("Arial", Font.BOLD, 16));
        btnCalculate.setBackground(new Color(30, 144, 255));
        btnCalculate.setForeground(Color.WHITE);
        btnCalculate.setFocusPainted(false);

        // Configurar el diseño del panel
        rootPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        rootPanel.add(labelMain, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        rootPanel.add(labelAltura, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        rootPanel.add(altura, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        rootPanel.add(labelPeso, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        rootPanel.add(peso, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        rootPanel.add(unidadAltura, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        rootPanel.add(unidadPeso, gbc);

        labelResult.setFont(new Font("Arial", Font.PLAIN, 18));
        labelResult.setForeground(new Color(255, 0, 0));
        labelResult.setVisible(false);
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        rootPanel.add(labelResult, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        rootPanel.add(btnCalculate, gbc);

        rootPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(rootPanel);
    }

    public ResourceBundle getBundle() {
        return bundle;
    }

    public JLabel getLabelMain() {
        return labelMain;
    }

    public JLabel getLabelAltura() {
        return labelAltura;
    }

    public JLabel getLabelPeso() {
        return labelPeso;
    }

    public JLabel getLabelResult() {
        return labelResult;
    }

    public JTextField getPeso() {
        return peso;
    }

    public JTextField getAltura() {
        return altura;
    }

    public JComboBox<String> getUnidadAltura() {
        return unidadAltura;
    }

    public JComboBox<String> getUnidadPeso() {
        return unidadPeso;
    }

    public JButton getBtnCalculate() {
        return btnCalculate;
    }
}
