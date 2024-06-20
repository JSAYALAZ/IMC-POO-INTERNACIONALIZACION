package View;

import javax.swing.*;
import java.awt.*;

public class LenguajeView extends JFrame {
    private JLabel saludo = new JLabel();
    private JPanel rootPanel = new JPanel();
    private JRadioButton rd_en = new JRadioButton();
    private JRadioButton rd_es = new JRadioButton();
    private JButton botonSelect = new JButton();
    private JButton botonConfirm = new JButton();

    public LenguajeView() {
        initComponents();
        setSize(500, 500);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centra la ventana en la pantalla
    }

    private void initComponents() {
        // Establecer LookAndFeel
        try {
            UIManager.setLookAndFeel("com.formdev.flatlaf.FlatLightLaf");
        } catch (Exception e) {
            e.printStackTrace();
        }

        rd_en.setText("English");
        rd_es.setText("Spanish");
        saludo.setText("Bienvenido, elige un idioma");
        botonSelect.setText("Seleccionar");
        botonConfirm.setText("Confirmar");

        // Personalizar componentes
        saludo.setFont(new Font("Arial", Font.BOLD, 24));
        saludo.setForeground(new Color(50, 50, 150));
        
        botonSelect.setFont(new Font("Arial", Font.BOLD, 16));
        botonSelect.setBackground(new Color(30, 144, 255));
        botonSelect.setForeground(Color.WHITE);
        botonSelect.setFocusPainted(false);
        
        botonConfirm.setFont(new Font("Arial", Font.BOLD, 16));
        botonConfirm.setBackground(new Color(34, 139, 34));
        botonConfirm.setForeground(Color.WHITE);
        botonConfirm.setFocusPainted(false);
        botonConfirm.setVisible(false);

        ButtonGroup group = new ButtonGroup();
        group.add(rd_en);
        group.add(rd_es);

        rootPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        gbc.gridx = 0;
        gbc.gridy = 0;
        rootPanel.add(saludo, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        rootPanel.add(rd_en, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        rootPanel.add(rd_es, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        rootPanel.add(botonSelect, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        rootPanel.add(botonConfirm, gbc);

        add(rootPanel);
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }

    public JRadioButton getRd_en() {
        return rd_en;
    }

    public JRadioButton getRd_es() {
        return rd_es;
    }

    public JLabel getSaludo() {
        return saludo;
    }

    public JButton getBotonSelect() {
        return botonSelect;
    }
    
    public JButton getBotonConfirm() {
        return botonConfirm;
    }
}
