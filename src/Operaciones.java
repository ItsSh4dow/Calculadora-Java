import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Operaciones implements ActionListener {
    static float value=0;
    static String buffer ="";
    static String op = "";
    static int flag=0;
    private static JTextField pantalla;

    public Operaciones(JTextField pantalla){
        Operaciones.pantalla = pantalla;
    }
    @Override
    public void actionPerformed(ActionEvent evento){
        if( (validar_float(evento.getActionCommand(), false)) !=-1 || evento.getActionCommand()=="."){
            buffer+=evento.getActionCommand();
            pantalla.setText(buffer);
        }
        else if(evento.getActionCommand()=="="){
            if(buffer.length()==0) {pantalla.setText(String.format("%.2f",value));}
            else {calcular(validar_float(buffer, true));}
        }
        else{
            operar(buffer, evento.getActionCommand());
        }
    }


    public static void calcular(float x){
        //resultado actual (no había números)
        if(flag==0){value=x; flag=1; pantalla.setText(String.format("%.2f",value));}

        //existe un número y se volvió a añadir otro
        if(flag==1) {value =x; pantalla.setText(String.format("%.2f",value));}
        else{
            switch (op.charAt(0)) {
                case '+': value+= x; break;
                case '-': value-= x; break;
                case '*': value*= x; break;
                case '/': if(x != 0) {value/= x; break;}
                else{mensaje("La división entre 0 no es válida",1); break;}
            }
            flag = 1;
            pantalla.setText(String.format("%.2f",value));
        } buffer="";
    }

    public static void operar(String input, String operacion){
        float tmp=0;
        switch (flag) {
            case 0:
                if(input.length()>0 && (tmp=validar_float(input, true))!=-1){
                    value = tmp;
                    flag=1;
                    buffer="";
                    op = operacion;
                    flag=2;
                }
                break;
            case 1:

            case 2:
                if(buffer.length()==0){
                    op = operacion;
                    flag=2;
                    buffer="";
                    pantalla.setText(String.format("%.2f",value));
                    break;
                }
                tmp=validar_float(input, true);
                if(tmp==-1)break;
                calcular(tmp);
                op = operacion;
                flag=2;
                buffer="";
                break;
            default:
                break;
        }
    }

    public static float validar_float(String x, Boolean msj){
        float number;
        try{
            number = Float.parseFloat(x);
        } catch(NumberFormatException ex){
            if(msj){
                mensaje(x + " no es un número válido!",0);
                buffer = "";
                pantalla.setText(String.format("%.2f",value));
            }
            number =-1;
        }
        return number;
    }

    public static void mensaje(String txt, int icono, String... titulo){
        String title = titulo.length > 0 ? "Calculadora    " + titulo[0] : "Calculadora";
        JOptionPane.showMessageDialog(null, txt, title, icono);
    }
}