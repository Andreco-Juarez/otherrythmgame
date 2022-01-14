import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;




public class LevelSelection implements ActionListener{
    public JRadioButton vida3, vida4, vida5, vidaInfinity;
    public ButtonGroup bg;
    public Font buttonFont;
    public JButton btn1,btn2;
    public JFrame frame ;
    Color textoBotones = new Color(142, 230, 88);
    Color fondoBotones = new Color(31, 105, 96);

    public void CrearGUI(){
        frame = new JFrame("Level Selection");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000,1000);
        frame.setLayout(null);
        frame.setVisible(true);
        Container c = frame.getContentPane();
        c.setBackground(Color.BLACK);

        try {
            GraphicsEnvironment bFont = 
                GraphicsEnvironment.getLocalGraphicsEnvironment();
            bFont.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Shure Tech Mono Nerd Font Complete Windows Compatible.ttf")));
            buttonFont = new Font("Shure Tech Mono Nerd Font Complete Windows Compatible", Font.PLAIN, 20);
        } catch (IOException|FontFormatException e) {
            buttonFont = new Font("Arial", Font.PLAIN, 30);
        }

        btn1 = new JButton("Xevel - Facil");
        btn2 = new JButton("Spear of justice - Dificil");

        btn1.setBounds(200, 200, 200, 50);
        btn1.setFont(buttonFont);
        btn1.setForeground(textoBotones);
        btn1.setBackground(fondoBotones);
        btn1.setFocusable(false);
        btn1.setBorder(null);
        btn1.addActionListener(this);
        c.add(btn1);

        btn2.setBounds(200, 300, 200, 50);
        btn2.setFont(buttonFont);
        btn2.setForeground(textoBotones);
        btn2.setBackground(fondoBotones);
        btn2.setFocusable(false);
        btn2.setBorder(null);
        btn2.addActionListener(this);
        c.add(btn2);

        bg = new ButtonGroup();

        vida3 = new JRadioButton("Vidas: 3", true);
        vida3.setFont(buttonFont);
        vida3.setForeground(textoBotones);
        vida3.setBackground(Color.BLACK);
        vida3.isSelected();
        bg.add(vida3);
        vida3.setBounds(200, 400, 200, 50);
        c.add(vida3);

        vida4 = new JRadioButton("Vidas: 4");
        vida4.setFont(buttonFont);
        vida4.setForeground(textoBotones);
        vida4.setBackground(Color.BLACK);
        bg.add(vida4);
        vida4.setBounds(200, 500, 200, 50);
        c.add(vida4);

        vida5 = new JRadioButton("Vidas: 5");
        vida5.setFont(buttonFont);
        vida5.setForeground(textoBotones);
        vida5.setBackground(Color.BLACK);
        bg.add(vida5);
        vida5.setBounds(200, 600, 200, 50);
        c.add(vida5);

        vidaInfinity = new JRadioButton("Vidas: Infinitas");
        vidaInfinity.setFont(buttonFont);
        vidaInfinity.setForeground(textoBotones);
        vidaInfinity.setBackground(Color.BLACK);
        bg.add(vidaInfinity);
        vidaInfinity.setBounds(200, 700, 200, 100);
        c.add(vidaInfinity);

        
    }

    public LevelSelection(){
        CrearGUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int vidaint=0;
        if(vida3.isSelected()){
            vidaint = 3;
        }
        if(vida4.isSelected()){
            vidaint = 4;
        }
        if(vida5.isSelected()){
            vidaint = 5;
        }
        if(vidaInfinity.isSelected()){
            vidaint = -1;
        }
        Object src = e.getSource();
        if(src == btn1){
            System.out.println("Xevel - Facil");
            new JuegoGrafico("xevel",vidaint);
            
            frame.dispose();
        }
        if(src == btn2){
            System.out.println("Spear of justice - Dificil");
            new JuegoGrafico("spear",vidaint);
            frame.dispose();
        }
        
    }
}
