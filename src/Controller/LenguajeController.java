package Controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Locale;
import java.util.ResourceBundle;
import View.LenguajeView;
import View.LoginView;

public class LenguajeController {
    private LenguajeView view;
    private ResourceBundle bundle;

    public LenguajeController(LenguajeView view, ResourceBundle bundle) {
        this.view = view;
        this.bundle = bundle;
        initListeners();
    }

    private void initListeners() {
        view.getBotonSelect().addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                handleLanguageSelection();
                view.getBotonConfirm().setVisible(true);
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

        view.getBotonConfirm().addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                new LoginView(bundle);
                view.dispose();
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


    private void handleLanguageSelection() {
        if (view.getRd_en().isSelected()) {
            Locale locale = Locale.forLanguageTag("en-US");
            bundle = ResourceBundle.getBundle("Lenguajes.Traductor", locale);
        } else if (view.getRd_es().isSelected()) {
            Locale locale = Locale.forLanguageTag("es-EC");
            bundle = ResourceBundle.getBundle("Lenguajes.Traductor", locale);
        }
        updateLabels();
    }

    private void updateLabels() {
        view.getBotonSelect().setText(bundle.getString("selectButton_tr"));
        view.getRd_en().setText(bundle.getString("english_tr"));
        view.getRd_es().setText(bundle.getString("spanish_tr"));
        view.getSaludo().setText(bundle.getString("saludo_tr"));
        view.getBotonConfirm().setText(bundle.getString("confirm_tr"));
    }
}
