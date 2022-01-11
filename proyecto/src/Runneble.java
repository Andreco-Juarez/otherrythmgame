import java.awt.*;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
//import javax.swing.Timer;
import java.io.File;
import java.io.FileInputStream;
import java.awt.event.*;
import java.util.*;
import java.util.Timer;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
//import java.util.ArrayList;
import java.io.InputStream;




public class Runneble extends Thread{
    public class Nota{
        int alto, ancho;
        int radio=100;

        Nota(int alto, int ancho){
            this.alto=alto;
            this.ancho=ancho;
        }
        void avanzar(){
            alto+=15;
        }
    }

    private JPanel panelJuego;
    private JButton inicio;
    private Vector<Nota> notas = new Vector<Nota>(500);
    private Vector<String> hitobject = new Vector<String>(1500);
    private Integer tiempo = 0, currentTime=0;
    public Graphics g;
    //private Graphics g = null;

    Runneble(Graphics g){
        this.g=g;
    }

    public void juegoGrafico(){
        g.setColor(Color.gray);
        g.fillRect(225,0,550,1000);
        g.setColor(Color.BLACK);
        g.fillOval(255,850,100,100);
        g.fillOval(380,850,100,100);
        g.fillOval(505,850,100,100);
        g.fillOval(630,850,100,100);

    }

    public void inicialObject(){
        int i=0;
        File config = new File("spear1.arg");
        try (Scanner obj = new Scanner(config)) {
            while(obj.hasNextLine()){
                String linea = obj.nextLine();
                if(i==0)
                {
                    String[] split =linea.split("=");
                    tiempo = Integer.parseInt(split[1]);
                    //System.out.println(tiempo);
                }
                else if(i>1){
                    String[] split =linea.split(",");
                    hitobject.add(split[0]+","+split[2]);
                    //System.out.println(split[0]+","+split[2]);
                }
                i++;
            }
            obj.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

   

    public void run(){

        juegoGrafico();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }

        

        Timer timer2 = new Timer();

        TimerTask tarea2 = new TimerTask(){
            public void run(){
                for(int i=0;i<hitobject.size();i++){
                    String[] split = hitobject.get(i).split(",");
                    if(currentTime==Integer.parseInt(split[1])){
                        if(split[0].equals("64")){
                            notas.addElement(new Nota(0,255));
                        }
                        else if(split[0].equals("192")){
                            notas.addElement(new Nota(0,380));
                        }
                        else if(split[0].equals("320")){
                            notas.addElement(new Nota(0,505));
                        }
                        else if(split[0].equals("448")){
                            notas.addElement(new Nota(0,630));
                        }
                    }
                }
                currentTime++;
                System.out.println(currentTime);
            }
        };

        timer2.schedule(tarea2, 0, 1);


        Timer timer = new Timer();

        TimerTask tarea = new TimerTask(){
            public void run() {
                panelJuego.update(g);
                juegoGrafico();
                for(int i=0;i<notas.size();i++){
                    g.setColor(Color.WHITE);
                    g.fillOval(notas.elementAt(i).ancho, notas.elementAt(i).alto, notas.elementAt(i).radio, notas.elementAt(i).radio);
                    notas.elementAt(i).avanzar();
                }
            }
        };

        timer.schedule(tarea, 0, 10);

        try {
            Thread.sleep(667);
            try{
                File file = new File("audio.wav");
                AudioInputStream audio = AudioSystem.getAudioInputStream(file);
                Clip clip = AudioSystem.getClip();
                clip.open(audio);
                clip.setFramePosition(0);
                clip.start();
            }
            catch(Exception e){
                e.printStackTrace();
            }
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }

    }
    public Runneble() {
        inicialObject();
    }
}