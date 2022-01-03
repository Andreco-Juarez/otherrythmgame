import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;


public class Juego extends JFrame {
    private JPanel panelJuego;
    
    public void CrearGUI(){
        setTitle("Another Rhythm Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800,600);
        setLayout(null);
        Container c = getContentPane();
        c.setBackground(new Color(0,0,0));

        panelJuego = new JPanel();
        panelJuego.setLayout(null); 
        c.add(panelJuego);
    }

    public Juego(){
        CrearGUI();
        
    }
    
    
}
