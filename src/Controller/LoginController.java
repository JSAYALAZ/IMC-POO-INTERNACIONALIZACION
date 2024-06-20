package Controller;

import java.awt.event.*;
import java.util.ResourceBundle;

import View.ImcView;
import View.LoginView;

public class LoginController {
    private LoginView view;
    private String username="";
    private String passwd="";
    private ResourceBundle bundleLogin= ResourceBundle.getBundle("Data.Session");
    private int cantFails = 0;
    private ResourceBundle bundle;

    public LoginController(LoginView view, ResourceBundle bundle){
        this.bundle = bundle;
        this.view = view;
        eventListeners();
    }


    public void eventListeners(){
        
        view.getBtnLogin().addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(username.equals(bundleLogin.getString("user"))&&passwd.equals(bundleLogin.getString("password"))){
                    new ImcView(bundle);
                    view.dispose();
                }else{
                    view.getEntPasswd().setText("");
                    view.getEntUser().setText("");
                    passwd="";
                    username="";
                    cantFails++;
                    view.getLabelFails().setText(String.valueOf(cantFails));
                }
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


        view.getEntPasswd().addKeyListener(new KeyListener() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                    if (passwd.length() > 0) {
                        passwd = passwd.substring(0, passwd.length() - 1);
                    }
                    return;
                }
                char chart = e.getKeyChar();
                if (Character.isLetterOrDigit(chart)) {
                    passwd += chart;
                }
                System.out.println(passwd);
            };
            public void keyReleased(KeyEvent e) {};
            public void keyTyped(KeyEvent e) {};

        });
        view.getEntUser().addKeyListener(new KeyListener() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                    if (username.length() > 0) {
                        username = username.substring(0, username.length() - 1);
                    }
                    return;
                }
                char chart = e.getKeyChar();
                if (Character.isLetterOrDigit(chart)) {
                    username += chart;
                }
                
            };
            public void keyReleased(KeyEvent e) {};
            public void keyTyped(KeyEvent e) {};
        });

    }
}
