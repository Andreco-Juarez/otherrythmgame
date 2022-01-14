import java.awt.*;
import javax.swing.*;
import javax.swing.text.AttributeSet.ColorAttribute;
import java.io.*;

import java.util.*;

public class Score extends JFrame{
    /*public class Nota{
        int alto, ancho;
        int radio=100;
        boolean block=false;
        //s a b c n f
        char ps='n';

        Nota(int alto, int ancho){
            this.alto=alto;
            this.ancho=ancho;
        }
        void avanzar(){
            alto+=2;
        }
    }*/

    public Vector<Nota> notas;
    public JTextArea perfect, great, good, bad, miss, precisionJT;
    public int contS=0, contA=0, contB=0, contC=0, ContF=0;
    public Font fuente;
    public float precision;
    public int sumaPrecision=0;

    public void CrearGUI(){


        
    }


    public Score(Vector<Nota> notaarray){
        notas = notaarray;

        try {
            GraphicsEnvironment fFont = 
                GraphicsEnvironment.getLocalGraphicsEnvironment();
            fFont.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Terminess (TTF) Nerd Font Complete Windows Compatible.ttf")));
            fuente = new Font("Terminess (TTF) Nerd Font Complete Windows Compatible", Font.PLAIN, 20);
        } catch (IOException|FontFormatException e) {
            fuente = new Font("Arial", Font.PLAIN, 30);
        }


        setTitle("Another Rhythm Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000,1000);
        setLayout(null);
        Container c = getContentPane();
        c.setBackground(Color.BLACK);
       

        

        notas.forEach(nota -> {
            if(nota.ps == 's'){
                contS++;
                sumaPrecision += 100;
            }
            if(nota.ps == 'a'){
                contA++;
                sumaPrecision += 90;
            }
            if(nota.ps == 'b'){
                contB++;
                sumaPrecision += 80;
            }
            if(nota.ps == 'c'){
                contC++;
                sumaPrecision += 70;
            }
            if(nota.ps == 'f'){
                ContF++;
                sumaPrecision += 0;
            }
        });

        precision = sumaPrecision/notas.size();

        precisionJT = new JTextArea("Precision: "+precision+"%"); 
        perfect = new JTextArea("Perfect: "+contS);
        great = new JTextArea("Great: "+contA);
        good = new JTextArea("Good: "+contB);
        bad = new JTextArea("Bad: "+contC);
        miss = new JTextArea("Miss: "+ContF);

        perfect.setBounds(10, 10, 100, 100);
        great.setBounds(10, 110, 100, 100);
        good.setBounds(10, 210, 100, 100);
        bad.setBounds(10, 310, 100, 100);
        miss.setBounds(10, 410, 100, 100);
        precisionJT.setBounds(10, 510, 200, 200);

        perfect.setForeground(Color.WHITE);
        great.setForeground(Color.WHITE);
        good.setForeground(Color.WHITE);
        bad.setForeground(Color.WHITE);
        miss.setForeground(Color.WHITE);
        precisionJT.setForeground(Color.WHITE);

        perfect.setFont(fuente);
        great.setFont(fuente);
        good.setFont(fuente);
        bad.setFont(fuente);
        miss.setFont(fuente);
        precisionJT.setFont(fuente);

        perfect.setBackground(Color.BLACK);
        great.setBackground(Color.BLACK);
        good.setBackground(Color.BLACK);
        bad.setBackground(Color.BLACK);
        miss.setBackground(Color.BLACK);
        precisionJT.setBackground(Color.BLACK);

        perfect.setEditable(false);
        great.setEditable(false);
        good.setEditable(false);
        bad.setEditable(false);
        miss.setEditable(false);
        precisionJT.setEditable(false);


        //
        c.add(perfect);
        c.add(great);
        c.add(good);
        c.add(bad);
        c.add(miss);
        c.add(precisionJT);
    }
}
