import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

public class TitleScreen extends JFrame implements ActionListener{
    private Font titleFont, buttonFont;
    public static void main(String[] args) throws Exception {
        TitleScreen marco = new TitleScreen();
        marco.setSize(800, 600);
        marco.setVisible(true);
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco.setTitle("Other Rythm Game");
        //TitleScreen.loadRecursos();
    }

    /*public static void loadRecursos(){
        try {
                GraphicsEnvironment TitleFont = 
                    GraphicsEnvironment.getLocalGraphicsEnvironment();
                TitleFont.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Heavy Data Nerd Font Complete.ttf")));
        } catch (IOException|FontFormatException e) {
                System.exit(1);
        }
    }*/

    public TitleScreen(){
        //creo la ventana
        setLayout(null);
        Container c = getContentPane();
        c.setBackground(Color.BLACK);


        //Instancio colores
        Color colorTitulo = new Color(0, 202, 0);
        Color textoBotones = new Color(142, 230, 88);
        Color fondoBotones = new Color(31, 105, 96);

        //intancio la fuente
        try {
            GraphicsEnvironment TitleFont = 
                GraphicsEnvironment.getLocalGraphicsEnvironment();
            TitleFont.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Heavy Data Nerd Font Complete Windows Compatible.ttf")));
            titleFont = new Font("Heavy Data Nerd Font Complete Windows Compatible", Font.PLAIN, 40);
        } catch (IOException|FontFormatException e) {
            titleFont = new Font("Arial", Font.PLAIN, 30);
        }

        try {
            GraphicsEnvironment TitleFont = 
                GraphicsEnvironment.getLocalGraphicsEnvironment();
            TitleFont.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Shure Tech Mono Nerd Font Complete Windows Compatible.ttf")));
            buttonFont = new Font("Shure Tech Mono Nerd Font Complete Windows Compatible", Font.PLAIN, 20);
        } catch (IOException|FontFormatException e) {
            buttonFont = new Font("Arial", Font.PLAIN, 30);
        }

        //Implemento el titulo
        JLabel titulo = new JLabel("Another Rhythm Game", SwingConstants.CENTER);
        titulo.setBounds(200, 40, 400, 40);
        titulo.setForeground(colorTitulo);
        titulo.setFont(titleFont);
        c.add(titulo);

        //implemento botones
        JButton btnJugar = new JButton("Jugar");
        btnJugar.setBounds(250, 150, 300, 30);
        btnJugar.setFont(buttonFont);
        btnJugar.setForeground(textoBotones);
        btnJugar.setBackground(fondoBotones);
        btnJugar.setFocusable(false);
        btnJugar.setBorder(null);
        btnJugar.addActionListener(this);
        c.add(btnJugar);

        JButton btnInstrucciones = new JButton("Instrucciones");
        btnInstrucciones.setBounds(250, 200, 300, 30);
        btnInstrucciones.setFont(buttonFont);
        btnInstrucciones.setForeground(textoBotones);
        btnInstrucciones.setBackground(fondoBotones);
        btnInstrucciones.setFocusable(false);
        btnInstrucciones.setBorder(null);
        btnInstrucciones.addActionListener(this);
        c.add(btnInstrucciones);

        JButton btnSalir = new JButton("Salir");
        btnSalir.setBounds(250, 250, 300, 30);
        btnSalir.setFont(buttonFont);
        btnSalir.setForeground(textoBotones);
        btnSalir.setBackground(fondoBotones);
        btnSalir.setFocusable(false);
        btnSalir.setBorder(null);
        btnSalir.addActionListener(this);
        c.add(btnSalir);

        JButton btnCreditos = new JButton("Creditos");
        btnCreditos.setBounds(250, 300, 300, 30);
        btnCreditos.setFont(buttonFont);
        btnCreditos.setForeground(textoBotones);
        btnCreditos.setBackground(fondoBotones);
        btnCreditos.setFocusable(false);
        btnCreditos.setBorder(null);
        btnCreditos.addActionListener(this);
        c.add(btnCreditos);

        JButton btnConfig = new JButton("Configuracion");
        btnConfig.setBounds(250, 350, 300, 30);
        btnConfig.setFont(buttonFont);
        btnConfig.setForeground(textoBotones);
        btnConfig.setBackground(fondoBotones);
        btnConfig.setFocusable(false);
        btnConfig.setBorder(null);
        btnConfig.addActionListener(this);
        c.add(btnConfig);
    }



    @Override
    public void actionPerformed(ActionEvent arg0) {
        // TODO Auto-generated method stub
        
    }
}
