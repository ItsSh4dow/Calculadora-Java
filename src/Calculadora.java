//GUI de ejercicio 3
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.BoxLayout;

public class Calculadora extends JFrame{
    public static JTextField pantalla;
    public Calculadora(){
        super("Calculadora");
        setLayout(new BoxLayout(getContentPane(),BoxLayout.Y_AXIS));
        add(PanelSuperior());
        add(PanelInferior());
    }

    private static JPanel PanelSuperior(){
        JPanel panelSuperior = new JPanel ();
        panelSuperior.setLayout(new FlowLayout());
        pantalla = new JTextField(20);
        panelSuperior.add(pantalla);
        return panelSuperior;
    }

    private static JPanel PanelInferior(){
        JPanel panelInferior= new JPanel();
        Operaciones manejador = new Operaciones(pantalla);
        panelInferior.setLayout(new GridLayout(5,4,4,4));
        JButton bt1=new JButton("1"); bt1.setBorder(new RoundBtn(5));
        JButton bt2=new JButton("2"); bt2.setBorder(new RoundBtn(5));
        JButton bt3=new JButton("3"); bt3.setBorder(new RoundBtn(5));
        JButton bt4=new JButton("4"); bt4.setBorder(new RoundBtn(5));
        JButton bt5=new JButton("5"); bt5.setBorder(new RoundBtn(5));
        JButton bt6=new JButton("6"); bt6.setBorder(new RoundBtn(5));
        JButton bt7=new JButton("7"); bt7.setBorder(new RoundBtn(5));
        JButton bt8=new JButton("8"); bt8.setBorder(new RoundBtn(5));
        JButton bt9=new JButton("9"); bt9.setBorder(new RoundBtn(5));
        JButton bt0=new JButton("0"); bt0.setBorder(new RoundBtn(5));
        JButton btMas=new JButton("+"); btMas.setBorder(new RoundBtn(5));
        JButton btMenos=new JButton("-"); btMenos.setBorder(new RoundBtn(5));
        JButton btMul=new JButton("*"); btMul.setBorder(new RoundBtn(5));
        JButton btDiv=new JButton("/"); btDiv.setBorder(new RoundBtn(5));
        JButton btIgual=new JButton("="); btIgual.setBorder(new RoundBtn(5));
        JButton btPunto=new JButton("."); btPunto.setBorder(new RoundBtn(5));
        panelInferior.add(bt7); bt7.addActionListener(manejador);
        panelInferior.add(bt8); bt8.addActionListener(manejador);
        panelInferior.add(bt9); bt9.addActionListener(manejador);
        panelInferior.add(btDiv); btDiv.addActionListener(manejador);
        panelInferior.add(bt4); bt4.addActionListener(manejador);
        panelInferior.add(bt5); bt5.addActionListener(manejador);
        panelInferior.add(bt6); bt6.addActionListener(manejador);
        panelInferior.add(btMul); btMul.addActionListener(manejador);
        panelInferior.add(bt1); bt1.addActionListener(manejador);
        panelInferior.add(bt2); bt2.addActionListener(manejador);
        panelInferior.add(bt3); bt3.addActionListener(manejador);
        panelInferior.add(btMenos); btMenos.addActionListener(manejador);
        panelInferior.add(bt0); bt0.addActionListener(manejador);
        panelInferior.add(btPunto); btPunto.addActionListener(manejador);
        panelInferior.add(btIgual); btIgual.addActionListener(manejador);
        panelInferior.add(btMas); btMas.addActionListener(manejador);

        return panelInferior;
    }
}
