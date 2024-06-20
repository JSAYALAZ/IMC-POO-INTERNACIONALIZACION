import java.util.Locale;
import java.util.ResourceBundle;
import Controller.LenguajeController;
import View.LenguajeView;

public class App {
    public static void main(String[] args) {
        Locale locale = Locale.forLanguageTag("es-EC");
        ResourceBundle bundle = ResourceBundle.getBundle("Lenguajes.Traductor", locale);

        LenguajeView view = new LenguajeView();
        new LenguajeController(view, bundle);
        
    }
}
