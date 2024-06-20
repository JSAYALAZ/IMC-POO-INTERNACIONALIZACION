package View;

import javax.swing.*;

import Controller.LoginController;

import java.awt.*;
import java.util.ResourceBundle;

public class LoginView extends JFrame {
    private Label label_main = new Label();
    private Label label_login = new Label();
    private Label label_fails = new Label();
    private Label label_passwd = new Label();
    private TextField ent_user = new TextField(15);
    private JPasswordField ent_passwd = new JPasswordField(15);
    private JButton btn_login = new JButton();
    private ResourceBundle bundle;


    public LoginView(ResourceBundle bundle) {
        this.bundle=bundle;
        new LoginController(this,bundle);
        setTitle(bundle.getString("login_main_tr"));
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // CENTRA LA VENTANA A LA MITAD DE LA PANTALLA
        initComponents();
        setVisible(true);
    }

    private void initComponents() {
        label_main.setText(bundle.getString("login_main_tr"));
        label_login.setText(bundle.getString("login_user_tr"));
        label_passwd.setText(bundle.getString("login_passwd_tr"));
        btn_login.setText(bundle.getString("login_login_tr"));


        // Establecer LookAndFeel
        try {
            UIManager.setLookAndFeel("com.formdev.flatlaf.FlatLightLaf");
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Personalizar componentes
        label_main.setFont(new Font("Arial", Font.BOLD, 24));
        label_main.setForeground(new Color(50, 50, 150));

        label_login.setFont(new Font("Arial", Font.PLAIN, 14));
        label_passwd.setFont(new Font("Arial", Font.PLAIN, 14));

        btn_login.setFont(new Font("Arial", Font.BOLD, 16));
        btn_login.setBackground(new Color(30, 144, 255));
        btn_login.setForeground(Color.WHITE);
        btn_login.setFocusPainted(false);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(label_main, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        panel.add(label_login, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(ent_user, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(label_passwd, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(ent_passwd, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        panel.add(btn_login, gbc);

        panel.add(label_fails);

        add(panel);
    }

    // Getters
    public Label getLabelMain() {
        return label_main;
    }

    public Label getLabelLogin() {
        return label_login;
    }
    public Label getLabelFails() {
        return label_fails;
    }

    public Label getLabelPasswd() {
        return label_passwd;
    }

    public TextField getEntUser() {
        return ent_user;
    }

    public JPasswordField getEntPasswd() {
        return ent_passwd;
    }

    public JButton getBtnLogin() {
        return btn_login;
    }
}
