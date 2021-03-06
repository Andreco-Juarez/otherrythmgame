import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.Vector;

import javax.swing.*;
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
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class JuegoGrafico extends Canvas implements Runnable, KeyListener{


    //////////////////////////////////////////////////////////////////
    //////////////////////// Clase Nota #NOTA //////////////////////////////
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

    //////////////////////////////////////////////////////////////////
    //////////////////////// Variblable globales #GLOBALES //////////////////////////////

    private Vector<Nota> notas = new Vector<Nota>(500);
    private Vector<String> hitobject = new Vector<String>(1500);
    private Font font = new Font("Agency FB", Font.BOLD, 50);
    private Integer tiempo = 0, currentTimeSong=0;
    private Color color1,color2,color3,color4;
    public Graphics g;
    public Clip clip;
    public int combo=0;
    public boolean song=false;
    private char[] configuracion = {'a', 'w', 's', 'd'};
    private String[] teclas_split = {"",""};
    private int[][] colores = {{0,0,0}, {0,0,0}, {0,0,0}, {0,0,0}};
    public String nivelA, audio;

    
	private JFrame frame;
	
	private final int WIDTH = 1000, HEIGHT = 1000;
	private int x = 20, y = 20, fps, tps, z=0, w=0, vidasJuego=0;
	
	private boolean running = false;
    private boolean[] keys = {false,false,false,false};


    //////////////////////////////////////////////////////////////////
    //////////////////////// metodo para iniciar configuracion #INICIALCONF //////////////////////////////

    /*JuegoGrafico(String nivel, int vidas){
        this.nivelA = nivel+"Clean.arg";
        this.audio = nivel+".wav";
        this.vidasJuego = vidas;
    }*/

    public void checkInput(int side){
        ///System.out.println(combo);
        for(int i=0; i<notas.size(); i++){
            int alturaactual = notas.get(i).alto;
            switch (side){
                case 1:
                    //System.out.println("Entreeeee!");
                    if(notas.elementAt(i).block==false && notas.elementAt(i).ancho==255){
                        //System.out.println(alturaactual);
                        if(alturaactual > 850 && alturaactual < 900 ){
                            
                            notas.elementAt(i).ps = 'c' ;
                            notas.elementAt(i).block=true;
                            combo++;
                        }else if(alturaactual > 900 && alturaactual < 950 ){
                            
                            notas.elementAt(i).ps = 'b' ;
                            notas.elementAt(i).block=true;
                            combo++;
                        }else if(alturaactual > 950 && alturaactual < 1000 ){
                            
                            notas.elementAt(i).ps = 'a' ;
                            notas.elementAt(i).block=true;
                            combo++;
                        }else if(alturaactual > 1000 && alturaactual < 1050 ){
                            
                            notas.elementAt(i).ps = 's' ;
                            notas.elementAt(i).block=true;
                            combo++;
                        }
                        return ;
                    }
                    break;
                case 2:
                    if(notas.elementAt(i).block==false && notas.elementAt(i).ancho==380){
                        //System.out.println(alturaactual);
                        if(alturaactual > 850 && alturaactual < 900 ){
                            
                            notas.elementAt(i).ps = 'c' ;
                            notas.elementAt(i).block=true;
                            combo++;

                        }else if(alturaactual > 900 && alturaactual < 950 ){
                            
                            notas.elementAt(i).ps = 'b' ;
                            notas.elementAt(i).block=true;
                            combo++;
                        }else if(alturaactual > 950 && alturaactual < 1000 ){
                            
                            notas.elementAt(i).ps = 'a' ;
                            notas.elementAt(i).block=true;
                            combo++;
                        }else if(alturaactual > 1000 && alturaactual < 1050 ){
                            
                            notas.elementAt(i).ps = 's' ;
                            notas.elementAt(i).block=true;
                            combo++;
                        }
                        return ;
                    }
                    break;
                case 3:
                    if(notas.elementAt(i).block==false && notas.elementAt(i).ancho==505){
                        //System.out.println(alturaactual);
                        if(alturaactual > 850 && alturaactual < 900 ){
                            
                            notas.elementAt(i).ps = 'c' ;
                            notas.elementAt(i).block=true;
                            combo++;
                        }else if(alturaactual > 900 && alturaactual < 950 ){
                            
                            notas.elementAt(i).ps = 'b' ;
                            notas.elementAt(i).block=true;
                            combo++;
                        }else if(alturaactual > 950 && alturaactual < 1000 ){
                            
                            notas.elementAt(i).ps = 'a' ;
                            notas.elementAt(i).block=true;
                            combo++;
                        }else if(alturaactual > 1000 && alturaactual < 1050 ){
                            
                            notas.elementAt(i).ps = 's' ;
                            notas.elementAt(i).block=true;
                            combo++;
                        }
                        return ;
                    }
                    break;
                case 4:
                    if(notas.elementAt(i).block==false && notas.elementAt(i).ancho==630){
                        //System.out.println(alturaactual);
                        if(alturaactual > 850 && alturaactual < 900 ){
                            
                            notas.elementAt(i).ps = 'c' ;
                            notas.elementAt(i).block=true;
                            combo++;
                        }else if(alturaactual > 900 && alturaactual < 950 ){
                            
                            notas.elementAt(i).ps = 'b' ;
                            notas.elementAt(i).block=true;
                            combo++;
                        }else if(alturaactual > 950 && alturaactual < 1000 ){
                            
                            notas.elementAt(i).ps = 'a' ;
                            notas.elementAt(i).block=true;
                            combo++;
                        }else if(alturaactual > 1000 && alturaactual < 1050 ){
                            
                            notas.elementAt(i).ps = 's' ;
                            notas.elementAt(i).block=true;
                            combo++;
                        }
                        return ;
                    }
                    break;
            }
        }
    }

    public void inicialConf(){
        File config = new File("config.conf");
        try {
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
        } catch (FileNotFoundException e) {
        }
    }

    //////////////////////////////////////////////////////////////////
    //////////////////////// metodo para iniciar objetos #INICIALOBJECT //////////////////////////////
    public void inicialObject(){
        int i=0;
        File config = new File(nivelA);
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
                    hitobject.add(split[0]+","+split[1]);
                    //System.out.println(split[0]+","+split[2]);
                }
                i++;
            }
            obj.close();

        } catch (FileNotFoundException e) {
            System.out.println("No se encontro el archivo");
        }
        //System.out.println(hitobject);
    }

    //////////////////////////////////////////////////////////////////
    //////////////////////// constructor //////////////////////////////
	
	public JuegoGrafico(String nivel, int vidas) {
        System.out.println("Iniciando Juego");
        nivelA = nivel+"Clean.arg";
        audio = nivel+".wav";
        vidasJuego = vidas;
		frame = new JFrame("FPS: ~ TPS: ~");
		frame.setSize(WIDTH, HEIGHT);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setBackground(Color.black);
		setForeground(Color.white);
		
		frame.add(this);
		frame.setVisible(true);
        inicialObject();
        inicialConf();
		frame.addKeyListener(this);

        //inicializar colores
        color1 = new Color(colores[0][0],colores[0][1],colores[0][2]);
        color2 = new Color(colores[1][0],colores[1][1],colores[1][2]);
        color3 = new Color(colores[2][0],colores[2][1],colores[2][2]);
        color4 = new Color(colores[3][0],colores[3][1],colores[3][2]);

        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
        }

        Timer timer2 = new Timer();

        TimerTask tarea2 = new TimerTask(){
            public void run(){
                //currentTimeSong++;
                
                for(int i=0+z;i<10+z && i<hitobject.size();i++){
                    //System.out.println(i + "||||"+ hitobject.size());
                    String[] split = hitobject.get(i).split(",");
                    if(currentTimeSong>=Integer.parseInt(split[1])-500){
                        //System.out.println(currentTimeSong+"||||"+split[1]);
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
                        z++;
                        
                    }
                    
                    
                }

                
                
                for(int i=0+w; i<notas.size();i++){
                    if(notas.elementAt(i).alto<=1500)
                        notas.elementAt(i).avanzar();
                    else{
                        w++;
                        if(notas.elementAt(i).block==false){
                            combo=0;
                            notas.elementAt(i).ps='f';
                            //System.out.println("entre");
                            notas.elementAt(i).block=true;
                            vidasJuego--;
                        }
                        
                    }
                        

                     
                }
                
                currentTimeSong++;
            }
        };

        timer2.schedule(tarea2, 0, 1);

        


		start();
	}
	
	private void start() {
		if(!running) {
			running = true;
			new Thread(this).start();
		}
	}
	
	private void stop() {
		running = false;
	}
	
	private void preDraw() { //Method which prepares the screen for drawing
		BufferStrategy bs = getBufferStrategy(); //Gets the buffer strategy our canvas is currently using
		if(bs == null) { //True if our canvas has no buffer strategy (should only happen once when we first start the game)
			createBufferStrategy(2); //Create a buffer strategy using two buffers (double buffer the canvas)
			return; //Break out of the preDraw method instead of continuing on, this way we have to check again if bs == null instead of just assuming createBufferStrategy(2) worked
		}
		
		Graphics g = bs.getDrawGraphics(); //Get the graphics from our buffer strategy (which is connected to our canvas)
		g.setColor(getBackground());
		g.fillRect(0, 0, WIDTH, HEIGHT); //Fill the screen with the canvas' background color
		g.setColor(getForeground());
		
		draw(g); //Call our draw method, passing in the graphics object which we just got from our buffer strategy
		
		g.dispose(); //Dispose of our graphics object because it is no longer needed, and unnecessarily taking up memory
		bs.show(); //Show the buffer strategy, flip it if necessary (make back buffer the visible buffer and vice versa) 
	}
	
	private void draw(Graphics g) {
        int i=0, k=0;
        g.setColor(Color.white);
        g.setFont(font);
        g.drawString(combo+"", 100, 100);
		g.setColor(Color.gray);
        g.fillRect(225,0,550,1000);
        g.setColor(Color.BLACK);
        g.fillOval(255,850,100,100);
        g.fillOval(380,850,100,100);
        g.fillOval(505,850,100,100);
        g.fillOval(630,850,100,100);
        for(i=0+w;i<notas.size();i++){
            if(notas.elementAt(i).ancho==255)
            {
                g.setColor(color1);
            }
            else if(notas.elementAt(i).ancho==380)
            {
                g.setColor(color2);
            }
            else if(notas.elementAt(i).ancho==505)
            {
                g.setColor(color3);
            }
            else if(notas.elementAt(i).ancho==630)
            {
                g.setColor(color4);
            }
            //g.setColor(Color.WHITE);
            g.fillOval(notas.elementAt(i).ancho, notas.elementAt(i).alto, notas.elementAt(i).radio, notas.elementAt(i).radio);
        }
        
        
        if(keys[0]==true){
            g.setColor(color1);
            g.fillOval(255,850,100,100);
            checkInput(1);
        }
        if(keys[1]==true){
            g.setColor(color2);
            g.fillOval(380,850,100,100);
            checkInput(2);
        }
        if(keys[2]==true){
            g.setColor(color3);
            g.fillOval(505,850,100,100);
            checkInput(3);
        }
        if(keys[3]==true){
            g.setColor(color4);
            g.fillOval(630,850,100,100);
            checkInput(4);
        }
	}
	
	private void tick(double delta) {
		x += 1 * delta; //Multiply all movements by delta where the number before is your speed, this forces any movements to scale based on time passed since the last tick
		y += 1 * delta;
	}
	
	@Override
	public void run() {
		int desiredTPS = 1000; //Target ticks per second
		
		long lastTime = System.currentTimeMillis(); //Time since we last looped (tick + draw), initialized here to the current time
		long secondTime = lastTime + 1000; //Target time one second ahead of when we last updated fps/tps
		double msPerTick = 1000 / desiredTPS; //Milliseconds expected in a single tick
		
		int frames = 0, ticks = 0; //Used for counting frames and ticks while in between seconds, later used to set fps and tps
		double delta = 0; //Represents the time passed since last tick
		
		boolean needsRender = false; //True when the screen is dirty (when we have ticked)

        
        
        
        
		
		while(running) {
            if(currentTimeSong>=tiempo || vidasJuego==0){
                stop();
                Score sc = new Score(notas);
                sc.setVisible(true);
                
            }
			long currentTime = System.currentTimeMillis(); //The time when we began our game loop
			long timeDifference = currentTime - lastTime; //The difference in time since the last game loop (expressed as a negative value
			lastTime = currentTime; //Reassign lastTime since we have used it, the last time is now the current time
			
			delta += timeDifference / msPerTick; //A representation of the time passed, converted into a more manageable format
			
			while(delta >= 1) { //Tick as many times as delta is greater then one
				ticks++; //Increase temporary ticks variable, later used to set tps
				tick(delta); //Call the tick method, pass it delta so it can alter any movement accordingly
				delta--; //Decrease delta because we have used it
				
				needsRender = true; //Informs us that the screen is dirty, must be rendered
			}
			
			if(needsRender) {
				frames++; //Increase temporary frames variable, later used to set fps
				preDraw(); //Draw the screen (or at least call the method which draws the screen)
			}
			
			if(System.currentTimeMillis() >= secondTime) { //True when the current time is equal to (or greater than) one second since we last updated fps/tps
				fps = frames; //set fps to the frames variable which has been increasing over the last second
				tps = ticks; //set tps to the frames variable which has been increasing over the last second
				frames = 0; //reset frame count
				ticks = 0; //reset tick count
				
				frame.setTitle("FPS: " + fps + " TPS: " + tps);
				
				secondTime = System.currentTimeMillis() + 1000; //Set the time which we must again update fps/tps (one second from the current time)
			}
			
			//try { Thread.sleep(10); } catch(Exception e) { e.printStackTrace(); } //Attempt to sleep the thread for 10ms, not necessarry to run it nonstop even though our game will behave okay
            try{
                if(song==false)
                {
                    
                    File file = new File(audio);
                    AudioInputStream audio = AudioSystem.getAudioInputStream(file);
                    clip = AudioSystem.getClip();
                    clip.open(audio);
                    clip.setFramePosition(0);
                    clip.start();
                    song=true;
                }
            }
            catch(Exception e){
                System.out.println("eroor");
            }
		}
        frame.dispose();
        clip.stop();
	}

    @Override
    public void keyTyped(KeyEvent e) {
        if(e.getKeyChar() == configuracion[0]){
            keys[0] = true;
        }   
        if(e.getKeyChar() == configuracion[1]){
            keys[1] = true;
        }
        if(e.getKeyChar() == configuracion[2]){
            keys[2] = true;
        }
        if(e.getKeyChar() == configuracion[3]){
            keys[3] = true;
        }  
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyChar() == configuracion[0]){
            keys[0] = true;
        }   
        if(e.getKeyChar() == configuracion[1]){
            keys[1] = true;
        }
        if(e.getKeyChar() == configuracion[2]){
            keys[2] = true;
        }
        if(e.getKeyChar() == configuracion[3]){
            keys[3] = true;
        }    
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyChar() == configuracion[0]){
            keys[0] = false;
        }
        if(e.getKeyChar() == configuracion[1]){
            keys[1] = false;
        }
        if(e.getKeyChar() == configuracion[2]){
            keys[2] = false;
        }
        if(e.getKeyChar() == configuracion[3]){
            keys[3] = false;
        }
    }
}
