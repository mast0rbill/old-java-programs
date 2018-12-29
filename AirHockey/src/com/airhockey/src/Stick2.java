package com.airhockey.src;

import java.awt.*;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import static com.airhockey.src.Board.*;

public class Stick2 {
	int x, dx, y, dy;
	Image still;

	public Stick2() {
		ImageIcon i = new ImageIcon("res/stick.png");
		still = i.getImage();
		x = ((800 / 2) - (still.getWidth(null) / 2)) + (((800 / 2) - (still.getWidth(null) / 2)) / 2);
		y = (400 / 2) - (still.getHeight(null) / 2);
	}

	public void move() {
		x = x + dx;
		y = y + dy;
		if(!stickOutOfBounds2){
		if(stickTouchingBall2 && dy > 0){
			hittingFromTop2 = true;
			hittingFromBottom2 = false;
		}
		if(stickTouchingBall2 && dy < 0){
			hittingFromBottom2 = true;
			hittingFromTop2 = false;
		}
		if(stickTouchingBall2 && dy == 0){
			hittingFromBottom2 = false;
			hittingFromTop2 = false;
		}
		
		if(stickTouchingBall2 && dx < 0){
			hittingFromLeft2 = false;
			hittingFromRight2 = true;
		}
		if(stickTouchingBall2 && dx > 0){
			hittingFromRight2 = false;
			hittingFromLeft2 = true;
		}
		if(stickTouchingBall2 && dx == 0){
			hittingFromRight2 = false;
			hittingFromLeft2 = false;
		}
		
		if(dy == 0 && dx == 0){
			stickNotMoving2 = true;
		}
		}
		if(x <= 800 / 2 && dx < 0){
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
		if(!stickOutOfBounds2){
		if (key == KeyEvent.VK_LEFT){
			dx = -3;
         }	

		if (key == KeyEvent.VK_RIGHT){
			dx = 3;
		}
		
		if (key == KeyEvent.VK_UP){
			dy = -3;
		}
		
		if (key == KeyEvent.VK_DOWN){
			dy = 3;
		}
		}
	}

	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		if(!stickOutOfBounds2){
		if (key == KeyEvent.VK_LEFT){
			dx = 0;
		}
		if (key == KeyEvent.VK_RIGHT){
			dx = 0;
		}
		if (key == KeyEvent.VK_UP){
			dy = 0;
		}
		if (key == KeyEvent.VK_DOWN){
			dy = 0;
		}
		}
	}	
}
