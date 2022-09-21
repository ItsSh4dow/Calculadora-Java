import javax.swing.JFrame;

public class PruebaGUI {
    public static void main(String[] args){
        //la Clase se refiere al archivo q se pretende probar

        Calculadora prueba = new Calculadora();
        prueba.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        prueba.setSize(248,200);
        prueba.setVisible(true);
    }
}
