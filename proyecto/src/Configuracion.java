import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Configuracion extends JFrame implements ActionListener {
    
    Timer timer ;
    private Color colorFondo = new Color(14,14,14), colorInput = new Color(6,127,8), fondoBotones = new Color(31, 105, 96), textoBotones = new Color(142, 230, 88);;
    private Color colorNota1, colorNota2, colorNota3, colorNota4;
    private Font fuenteInstrucciones;
    private JPanel notas;
    private JTextArea teclas_input1, teclas_input2, teclas_input3, teclas_input4,input_colorR1, input_colorR2, input_colorR3, input_colorR4, input_colorG1, input_colorG2, input_colorG3, input_colorG4, input_colorB1, input_colorB2, input_colorB3, input_colorB4;
    private JLabel label1, label2, label3, label4;
    private char[] configuracion = {'a', 'w', 's', 'd'};
    private String[] teclas_split = {"",""};
    private JButton boton_guardar, boton_salir;
    private int[][] colores = {{0,0,0}, {0,0,0}, {0,0,0}, {0,0,0}};
    private boolean check=true;

    public void CrearGUI() throws FileNotFoundException {
        setTitle("Another Rhythm Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800,600);
        setLayout(null);
        Container c = getContentPane();
        c.setBackground(colorFondo);

        //instancio fuente
        try {
            GraphicsEnvironment fFont = 
                GraphicsEnvironment.getLocalGraphicsEnvironment();
            fFont.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Terminess (TTF) Nerd Font Complete Windows Compatible.ttf")));
            fuenteInstrucciones = new Font("Terminess (TTF) Nerd Font Complete Windows Compatible", Font.PLAIN, 20);
        } catch (IOException|FontFormatException e) {
            fuenteInstrucciones = new Font("Arial", Font.PLAIN, 30);
        }

        //abrir archivo de configuracion
        File config = new File("config.conf");
        Scanner obj = new Scanner(config);
        int i=0, k=0, j=0;
        boolean color=false;
        while (obj.hasNextLine()) {
            String linea = obj.nextLine();
            
            if(j==4) {
                color = true;
                i=0;
                linea=obj.nextLine();
            }
            if(color){
                teclas_split = linea.split("=");
                colores[i][k] = Integer.parseInt(teclas_split[1]);
                k++;
                if(k==3)
                {
                    i++;
                    k=0;
                }
            }
            else{
                teclas_split = linea.split("=");
                configuracion[i] = teclas_split[1].charAt(1);
                i++;
            }
            j++;
        }
        obj.close();

        //Instancio colores
        colorNota1 = new Color(colores[0][0], colores[0][1], colores[0][2]);
        colorNota2 = new Color(colores[1][0], colores[1][1], colores[1][2]);
        colorNota3 = new Color(colores[2][0], colores[2][1], colores[2][2]);
        colorNota4 = new Color(colores[3][0], colores[3][1], colores[3][2]);
        
        //instanciar label
        label1 = new JLabel("Left = " + configuracion[0]);
        label1.setBounds(50, 120, 100, 50);
        label1.setForeground(Color.GREEN);
        label1.setFont(fuenteInstrucciones);
        c.add(label1);

        label2 = new JLabel("Up = " + configuracion[1]);
        label2.setBounds(50, 220, 100, 50);
        label2.setForeground(Color.GREEN);
        label2.setFont(fuenteInstrucciones);
        c.add(label2);

        label3 = new JLabel("Down = " + configuracion[2]);
        label3.setBounds(50, 320, 100, 50);
        label3.setForeground(Color.GREEN);
        label3.setFont(fuenteInstrucciones);
        c.add(label3);

        label4 = new JLabel("Right = " + configuracion[3]);
        label4.setBounds(50, 420, 100, 50);
        label4.setForeground(Color.GREEN);
        label4.setFont(fuenteInstrucciones);
        c.add(label4);

        //instanciar textarea
        teclas_input1 = new JTextArea();
        teclas_input1.setBounds(150, 130, 20, 20);
        teclas_input1.setFont(fuenteInstrucciones);
        teclas_input1.setForeground(colorInput);
        teclas_input1.setBackground(colorFondo);
        teclas_input1.setBorder(null);
        teclas_input1.setText(configuracion[0]+"");
        c.add(teclas_input1);

        teclas_input2 = new JTextArea();
        teclas_input2.setBounds(150, 230, 20, 20);
        teclas_input2.setFont(fuenteInstrucciones);
        teclas_input2.setForeground(colorInput);
        teclas_input2.setBackground(colorFondo);
        teclas_input2.setBorder(null);
        teclas_input2.setText(configuracion[1]+"");
        c.add(teclas_input2);

        teclas_input3 = new JTextArea();
        teclas_input3.setBounds(150, 330, 20, 20);
        teclas_input3.setFont(fuenteInstrucciones);
        teclas_input3.setForeground(colorInput);
        teclas_input3.setBackground(colorFondo);
        teclas_input3.setBorder(null);
        teclas_input3.setText(configuracion[2]+"");
        c.add(teclas_input3);

        teclas_input4 = new JTextArea();
        teclas_input4.setBounds(150, 430, 20, 20);
        teclas_input4.setFont(fuenteInstrucciones);
        teclas_input4.setForeground(colorInput);
        teclas_input4.setBackground(colorFondo);
        teclas_input4.setBorder(null);
        teclas_input4.setText(configuracion[3]+"");
        c.add(teclas_input4);

        input_colorR1 = new JTextArea();
        input_colorR1.setBounds(410, 120, 40, 40);
        input_colorR1.setFont(fuenteInstrucciones);
        input_colorR1.setForeground(colorInput);
        input_colorR1.setBackground(colorFondo);
        input_colorR1.setBorder(null); 
        input_colorR1.setText(""+colores[0][0]);
        c.add(input_colorR1);

        input_colorG1 = new JTextArea();
        input_colorG1.setBounds(500, 120, 40, 40);
        input_colorG1.setFont(fuenteInstrucciones);
        input_colorG1.setForeground(colorInput);
        input_colorG1.setBackground(colorFondo);
        input_colorG1.setBorder(null);
        input_colorG1.setText(""+colores[0][1]);
        c.add(input_colorG1);

        input_colorB1 = new JTextArea();
        input_colorB1.setBounds(590, 120, 40, 40);
        input_colorB1.setFont(fuenteInstrucciones);
        input_colorB1.setForeground(colorInput);
        input_colorB1.setBackground(colorFondo);
        input_colorB1.setBorder(null);
        input_colorB1.setText(""+colores[0][2]);
        c.add(input_colorB1);

        input_colorR2 = new JTextArea();
        input_colorR2.setBounds(410, 220, 40, 40);
        input_colorR2.setFont(fuenteInstrucciones);
        input_colorR2.setForeground(colorInput);
        input_colorR2.setBackground(colorFondo);
        input_colorR2.setBorder(null);
        input_colorR2.setText(""+colores[1][0]);
        c.add(input_colorR2);

        input_colorG2 = new JTextArea();
        input_colorG2.setBounds(500, 220, 40, 40);
        input_colorG2.setFont(fuenteInstrucciones);
        input_colorG2.setForeground(colorInput);
        input_colorG2.setBackground(colorFondo);
        input_colorG2.setBorder(null);
        input_colorG2.setText(""+colores[1][1]);
        c.add(input_colorG2);

        input_colorB2 = new JTextArea();
        input_colorB2.setBounds(590, 220, 40, 40);
        input_colorB2.setFont(fuenteInstrucciones);
        input_colorB2.setForeground(colorInput);
        input_colorB2.setBackground(colorFondo);
        input_colorB2.setBorder(null);
        input_colorB2.setText(""+colores[1][2]);
        c.add(input_colorB2);

        input_colorR3 = new JTextArea();
        input_colorR3.setBounds(410, 320, 40, 40);
        input_colorR3.setFont(fuenteInstrucciones);
        input_colorR3.setForeground(colorInput);
        input_colorR3.setBackground(colorFondo);
        input_colorR3.setBorder(null);
        input_colorR3.setText(""+colores[2][0]);
        c.add(input_colorR3);

        input_colorG3 = new JTextArea();
        input_colorG3.setBounds(500, 320, 40, 40);
        input_colorG3.setFont(fuenteInstrucciones);
        input_colorG3.setForeground(colorInput);
        input_colorG3.setBackground(colorFondo);
        input_colorG3.setBorder(null);
        input_colorG3.setText(""+colores[2][1]);
        c.add(input_colorG3);

        input_colorB3 = new JTextArea();
        input_colorB3.setBounds(590, 320, 40, 40);
        input_colorB3.setFont(fuenteInstrucciones);
        input_colorB3.setForeground(colorInput);
        input_colorB3.setBackground(colorFondo);
        input_colorB3.setBorder(null);
        input_colorB3.setText(""+colores[2][2]);
        c.add(input_colorB3);

        input_colorR4 = new JTextArea();
        input_colorR4.setBounds(410, 420, 40, 40);
        input_colorR4.setFont(fuenteInstrucciones);
        input_colorR4.setForeground(colorInput);
        input_colorR4.setBackground(colorFondo);
        input_colorR4.setBorder(null);
        input_colorR4.setText(""+colores[3][0]);
        c.add(input_colorR4);

        input_colorG4 = new JTextArea();
        input_colorG4.setBounds(500, 420, 40, 40);
        input_colorG4.setFont(fuenteInstrucciones);
        input_colorG4.setForeground(colorInput);
        input_colorG4.setBackground(colorFondo);
        input_colorG4.setBorder(null);
        input_colorG4.setText(""+colores[3][1]);
        c.add(input_colorG4);

        input_colorB4 = new JTextArea();
        input_colorB4.setBounds(590, 420, 40, 40);
        input_colorB4.setFont(fuenteInstrucciones);
        input_colorB4.setForeground(colorInput);
        input_colorB4.setBackground(colorFondo);
        input_colorB4.setBorder(null);
        input_colorB4.setText(""+colores[3][2]);
        c.add(input_colorB4);


        //instanciar panel
        notas = new JPanel();
        notas.setBounds(200, 50, 120, 400);
        notas.setBackground(colorFondo);
        c.add(notas);

        //instanciar botones
        boton_guardar = new JButton("Guardar Configuracion");
        boton_guardar.setBounds(400, 500, 300, 40);
        boton_guardar.setFont(fuenteInstrucciones);
        boton_guardar.setBackground(fondoBotones);
        boton_guardar.setForeground(textoBotones);
        boton_guardar.setBorder(null);
        boton_guardar.addActionListener(this);
        c.add(boton_guardar);

        boton_salir = new JButton("Regresar");
        boton_salir.setBounds(30, 500, 300, 40);
        boton_salir.setFont(fuenteInstrucciones);
        boton_salir.setBackground(fondoBotones);
        boton_salir.setForeground(textoBotones);
        boton_salir.setBorder(null);
        boton_salir.addActionListener(this);
        c.add(boton_salir);
        
    }

    public Configuracion() throws FileNotFoundException {
        CrearGUI();
        timer = new Timer(1/24 * 1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                Graphics g = notas.getGraphics();
                g.setColor(colorNota1);
                g.fillOval(50, 50, 50, 50);
                g.setColor(colorNota2);
                g.fillOval(50, 150, 50, 50);
                g.setColor(colorNota3);
                g.fillOval(50, 250, 50, 50);
                g.setColor(colorNota4);
                g.fillOval(50, 350, 50, 50);
                
            }
        });

        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == boton_salir) {
            TitleScreen marco = new TitleScreen();
            marco.setSize(800, 600);
            marco.setVisible(true);
            marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            marco.setTitle("Other Rythm Game");
            dispose();
            timer.stop();
        }
        if(source == boton_guardar){
            String[] conf = new String[16];
            conf[0] = teclas_input1.getText();
            conf[1] = teclas_input2.getText();
            conf[2] = teclas_input3.getText();
            conf[3] = teclas_input4.getText();
            conf[4] = input_colorR1.getText();
            conf[5] = input_colorG1.getText();
            conf[6] = input_colorB1.getText();
            conf[7] = input_colorR2.getText();
            conf[8] = input_colorG2.getText();
            conf[9] = input_colorB2.getText();
            conf[10] = input_colorR3.getText();
            conf[11] = input_colorG3.getText();
            conf[12] = input_colorB3.getText();
            conf[13] = input_colorR4.getText();
            conf[14] = input_colorG4.getText();
            conf[15] = input_colorB4.getText();
            for(int p=0; p<15; p++){
                if(p<4){
                    if(conf[p].length()!=1){
                        check = false;
                    }
                }
                else{
                    int integrNum = Integer.parseInt(conf[p]);
                    if(integrNum < 0 || integrNum > 255){
                        check = false;
                    }
                }
            }
            if(check)
            {
                FileWriter fichero = null;
                PrintWriter pw = null;
                try
                {
                    fichero = new FileWriter("config.conf");
                    pw = new PrintWriter(fichero);

                    pw.println("left=\""+conf[0]+"\"");
                    pw.println("down=\""+conf[1]+"\"");
                    pw.println("up=\""+conf[2]+"\"");
                    pw.println("right=\""+conf[3]+"\"");
                    pw.println("[COLORES]");
                    pw.println("color1notaR="+conf[4]);
                    pw.println("color1notaG="+conf[5]);
                    pw.println("color1notaB="+conf[6]);
                    pw.println("color2notaR="+conf[7]);
                    pw.println("color2notaG="+conf[8]);
                    pw.println("color2notaB="+conf[9]);
                    pw.println("color3notaR="+conf[10]);
                    pw.println("color3notaG="+conf[11]);
                    pw.println("color3notaB="+conf[12]);
                    pw.println("color4notaR="+conf[13]);
                    pw.println("color4notaG="+conf[14]);
                    pw.println("color4notaB="+conf[15]);
                    

                } catch (Exception ex) {
                    ex.printStackTrace();
                }finally {
                    try {
                        if (null != fichero)
                        fichero.close();
                    } catch (Exception e2) {
                    e2.printStackTrace();
                    }
                }
                try {
                    CrearGUI();
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Error en la configuracion\n vuelva a intentarlo:(");

            }
            TitleScreen marco = new TitleScreen();
            marco.setSize(800, 600);
            marco.setVisible(true);
            marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            marco.setTitle("Another Rhythm Game");
            dispose();
            timer.stop();
        }
        
    }
}
