import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Configuracion extends JFrame {

    private JPanel notas;
    private JTextField teclas_input1;
    private JLabel label1, label2, label3, label4;
    private char[] teclas = {'a', 'w', 's', 'd'};
    private String[] teclas_split = {"a","w","s","d"};

    public Configuracion() throws FileNotFoundException {
        setTitle("Another Rhythm Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800,600);
        setLayout(null);
        Container c = getContentPane();
        c.setBackground(Color.BLACK);

        //abrir archivo de configuracion
        File config = new File("config.txt");
        Scanner obj = new Scanner(config);
        int i=0;
        while (obj.hasNextLine()) {
            teclas_split = obj.nextLine().split("=");
            teclas[i] = teclas_split[1].charAt(1);
            i++;
            //obj.nextLine();
        }
        //instanciar label
        label1 = new JLabel("Left = " + teclas[0]);
        label1.setBounds(50, 50, 200, 50);
        label1.setForeground(Color.GREEN);
        c.add(label1);

        label2 = new JLabel("Up = " + teclas[1]);
        label2.setBounds(50, 100, 200, 50);
        label2.setForeground(Color.GREEN);
        c.add(label2);

        label3 = new JLabel("Right = " + teclas[2]);
        label3.setBounds(50, 150, 200, 50);
        label3.setForeground(Color.GREEN);
        c.add(label3);

        label4 = new JLabel("Down = " + teclas[3]);
        label4.setBounds(50, 200, 200, 50);
        label4.setForeground(Color.GREEN);
        c.add(label4);

    }

}
