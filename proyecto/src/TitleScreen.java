import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

public class TitleScreen extends JFrame implements ActionListener, KeyListener, MouseListener , ItemListener{
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

        //intancio la fuente
        try {
            GraphicsEnvironment TitleFont = 
                GraphicsEnvironment.getLocalGraphicsEnvironment();
            TitleFont.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Heavy Data Nerd Font Complete.ttf")));
        } catch (IOException|FontFormatException e) {
                System.exit(1);
        }
        Font titleFont = new Font("Heavy Data Nerd Font Complete", Font.PLAIN, 30);

        //Implemento el titulo
        JLabel titulo = new JLabel("Another Rhythm\n Game", SwingConstants.CENTER);
        titulo.setBounds(200, 100, 400, 100);
        titulo.setForeground(colorTitulo);
        titulo.setFont(titleFont);
        c.add(titulo);
    }

    @Override
    public void itemStateChanged(ItemEvent arg0) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseClicked(MouseEvent arg0) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseEntered(MouseEvent arg0) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseExited(MouseEvent arg0) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mousePressed(MouseEvent arg0) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseReleased(MouseEvent arg0) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void keyPressed(KeyEvent arg0) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void keyReleased(KeyEvent arg0) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void keyTyped(KeyEvent arg0) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        // TODO Auto-generated method stub
        
    }
}
