package com.mime.surviver;

import java.awt.event.KeyEvent;

import com.mime.surviver.input.Controller;
import com.mime.surviver.level.Level;

public class Game {
	public int time;
	public Controller controls;
	public Level level;
	
	public Game(){
		controls = new Controller();
		level = new Level(80, 80);
	}
	
	public void tick(boolean[] key){
		time++;
		boolean forward = key[KeyEvent.VK_W];
		boolean back = key[KeyEvent.VK_S];
		boolean left = key[KeyEvent.VK_A];
		boolean right = key[KeyEvent.VK_D];
		boolean jump = key[KeyEvent.VK_SPACE];
		boolean crouch = key[KeyEvent.VK_SHIFT];
		boolean run = key[KeyEvent.VK_CONTROL];
		
		controls.tick(forward, back, left, right, jump, crouch, run);
	}
}
