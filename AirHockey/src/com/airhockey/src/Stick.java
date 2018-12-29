package com.airhockey.src;

import java.awt.*;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import static com.airhockey.src.Board.*;

public class Stick {
	int x, dx, y, dy;
	Image still;

	public Stick() {
		ImageIcon i = new ImageIcon("res/stick.png");
		still = i.getImage();
		x = ((800 / 2) - (still.getWidth(null) / 2)) / 2;
		y = (400 / 2) - (still.getHeight(null) / 2);
	}

	public void move() {
		x = x + dx;
		y = y + dy;
		if(!stickOutOfBounds){
		if(stickTouchingBall && dy > 0){
			hittingFromTop = true;
			hittingFromBottom = false;
		}
		if(stickTouchingBall && dy < 0){
			hittingFromBottom = true;
			hittingFromTop = false;
		}
		if(stickTouchingBall && dy == 0){
			hittingFromBottom = false;
			hittingFromTop = false;
		}
		
		if(stickTouchingBall && dx > 0){
			hittingFromLeft = true;
			hittingFromRight = false;
		}
		if(stickTouchingBall && dx < 0){
			hittingFromRight = true;
			hittingFromLeft = false;
		}
		if(stickTouchingBall && dx == 0){
			hittingFromRight = false;
			hittingFromLeft = false;
		}
		
		if(dy == 0 && dx == 0){
			stickNotMoving = true;
		}
		}
		if(x + 100 >= 800 / 2 && dx > 0){
			dx = 0;
		}
	}
	
	public Rectangle getBounds(){
		return new Rectangle(x, y, still.getWidth(null), still.getHeight(null));
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Image getImage() {
		return still;
	}

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if(!stickOutOfBounds){
		if (key == KeyEvent.VK_A){
			dx = -3;
         }	

		if (key == KeyEvent.VK_D){
			dx = 3;
		}
		
		if (key == KeyEvent.VK_W){
			dy = -3;
		}
		
		if (key == KeyEvent.VK_S){
			dy = 3;
		}
		}
	}

	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		if(!stickOutOfBounds){
		if (key == KeyEvent.VK_A){
			dx = 0;
		}
		if (key == KeyEvent.VK_D){
			dx = 0;
		}
		if (key == KeyEvent.VK_W){
			dy = 0;
		}
		if (key == KeyEvent.VK_S){
			dy = 0;
		}
		}
	}	
}
