import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;


public class Instrucciones extends JFrame implements ActionListener{
    
    private JButton btnVolver;
    private JLabel lblInstrucciones, lblInstrucciones2, lblInstrucciones3, lblTitulo;
    private Font fontLabel;

    Instrucciones(){
        setTitle("Another Rhythm Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800,600);
        setLayout(null);
        Container c = getContentPane();
        c.setBackground(Color.BLACK);

        //Instanciar fuentes
        try {
            GraphicsEnvironment FontLabel = 
                GraphicsEnvironment.getLocalGraphicsEnvironment();
            FontLabel.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("mononoki-Regular Nerd Font Complete Mono Windows Compatible.ttf")));
            fontLabel = new Font("mononoki-Regular Nerd Font Complete Mono Windows Compatible", Font.PLAIN, 12);
        } catch (IOException|FontFormatException e) {
            fontLabel = new Font("Arial", Font.PLAIN, 12);
        }

        //Instanciar labels
        lblInstrucciones = new JLabel("Instruccion 1: Toca la tecla correspondiente al carril de la nota cuando llegua abajo de la pantalla");
        lblInstrucciones.setBounds(0,100,800,100);
        lblInstrucciones.setFont(fontLabel);
        lblInstrucciones.setForeground(Color.GREEN);
        c.add(lblInstrucciones);

        lblInstrucciones2 = new JLabel("Instruccion 2: Manten presionada la tecla correspondiente al carril de la nota con estela");
        lblInstrucciones2.setBounds(0,200,800,100);
        lblInstrucciones2.setFont(fontLabel);
        lblInstrucciones2.setForeground(Color.GREEN);
        c.add(lblInstrucciones2);

        lblInstrucciones3 = new JLabel("Instruccion 3: Solo puedes fallar 5 veces");
        lblInstrucciones3.setBounds(0,300,800,100);
        lblInstrucciones3.setFont(fontLabel);
        lblInstrucciones3.setForeground(Color.GREEN);
        c.add(lblInstrucciones3);

        lblTitulo = new JLabel("Instrucciones");
        lblTitulo.setBounds(0,0,800,100);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 50));
        lblTitulo.setForeground(Color.GREEN);
        c.add(lblTitulo);

        //instanciar boton volver
        btnVolver = new JButton("Volver");
        btnVolver.setBounds(0,400,200,20);
        btnVolver.setFont(fontLabel);
        btnVolver.setForeground(Color.GREEN);
        btnVolver.setBackground(new Color(31, 105, 96));
        btnVolver.setFocusable(false);
        btnVolver.setBorder(null);
        btnVolver.addActionListener(this);
        c.add(btnVolver);

    }
    
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if(source == btnVolver){
            TitleScreen marco = new TitleScreen();
            marco.setSize(800, 600);
            marco.setVisible(true);
            marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            marco.setTitle("Another Rhythm Game");
            dispose();
        }
        
    }
    
}
