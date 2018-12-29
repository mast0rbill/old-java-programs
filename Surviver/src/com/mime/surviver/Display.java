package com.mime.surviver;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import com.mime.surviver.graphics.Screen;
import com.mime.surviver.gui.Launcher;
import com.mime.surviver.input.Controller;
import com.mime.surviver.input.InputHandler;

public class Display extends Canvas implements Runnable{

	private static final long serialVersionUID = 1L;
	
	public static int width = 800;
	public static int height = 600;
	
	public static String TITLE = "Survivoaaaaaaaaaaaar";
	public static String VERSION = "Pre-Alpha 0.0.7";
	
	private Thread thread;
	private Game game;
	private boolean running = false;
	private Screen screen;
	private BufferedImage img;
	private int[] pixels;
	private InputHandler input;
	private int newX = 0;
	private int oldX = 0;
	private int fps;
	public static int selection = 0;
	
	public static int MouseSpeed;
	
	
	public Display(){
		Dimension size = new Dimension(WIDTH, HEIGHT);
		setPreferredSize(size);
		setMinimumSize(size);
		setMaximumSize(size);
		screen = new Screen(getGameWidth(), getGameHeight());
		img = new BufferedImage(getGameWidth(), getGameHeight(), BufferedImage.TYPE_INT_RGB);
		pixels = ((DataBufferInt)img.getRaster().getDataBuffer()).getData();
		game = new Game();
		
		input = new InputHandler();
		addKeyListener(input);
		addFocusListener(input);
		addMouseListener(input);
		addMouseMotionListener(input);
		
	}
	
	public static int getGameWidth(){
		if(selection == 0){
			width = 640;
		}
		
		if(selection == 1 || selection == -1){
			width = 800;
		}
		
		if(selection == 2){
			width = 1024;
		}
		return width;
	}
	
	public static int getGameHeight(){
		if(selection == 0){
			height = 480;
		}
		
		if(selection == 1 || selection == -1){
			height = 600;
		}
		
		if(selection == 2){
			height = 768;
		}
		return height;
	}
	
	public synchronized void start(){
		if(running) {
			return;
		}
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public synchronized void stop(){
		if(!running){
			return;
		}
		running = false;
		try{
		thread.join();
		}catch(Exception e){
			e.printStackTrace();
			System.exit(0);
		}
	}
	
	public void run(){
		int frames = 0;
		double unprocessedSeconds = 0;
		long previousTime = System.nanoTime();
		double secondsPerTick = 1 / 60.0;
		int tickCount = 0;
		boolean ticked = false;
		
		while (running) { 
			 requestFocus();
			 long currentTime = System.nanoTime();
			 long passedTime = currentTime - previousTime;
			 previousTime = currentTime;
			 unprocessedSeconds += passedTime / 1000000000.0;
			 
			 while(unprocessedSeconds > secondsPerTick){
				 tick();
				 unprocessedSeconds -= secondsPerTick;
				 ticked = true;
				 tickCount++;
				 if(tickCount % 60 == 0){
					 fps = frames;
					 previousTime += 1000;
					 frames = 0;
				 }
			 }
			 if(ticked){
				 render();
				 frames++;
			 }
			 render();
			 frames++;
			 
			 newX = InputHandler.MouseX;
			 if(newX > oldX){
				 Controller.turnRight = true;			
			 }
			 if(newX < oldX){
				 Controller.turnLeft = true;
			 }
			 if(newX == oldX){
				 Controller.turnRight = false;
				 Controller.turnLeft = false;
			 }
			 MouseSpeed = Math.abs(newX - oldX);
			 oldX = newX;
		}
	}
	
	private void tick(){
		game.tick(input.key);
	}
	
	private void render(){
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null){
			createBufferStrategy(3);
			return;
		}
		screen.render(game);
		for(int i = 0; i < getGameWidth() * getGameHeight(); i++){
			pixels[i] = screen.pixels[i]; 
		}
		Graphics g = bs.getDrawGraphics();
		g.drawImage(img, 0, 0, getGameWidth() + 10, getGameHeight() + 10, null);
		g.setFont(new Font("Verdana", 0, 30));
		g.setColor(Color.WHITE);
		g.drawString("FPS: " + fps, 20, 60);
		g.drawString(TITLE + " " + VERSION, 20, 30);
		g.dispose();
		bs.show();
	}
	
	public static void main(String[] args){
		new Launcher(0);
	}
	
}
