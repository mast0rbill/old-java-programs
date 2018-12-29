package com.mime.surviver.input;

import com.mime.surviver.Display;

public class Controller {

	public double x, y, z, rotation, xa, za, rotationa;
	public static boolean turnLeft = false;
	public static boolean turnRight = false;
	public static boolean walk = false;
	public static boolean sprint = false;
	public static boolean crouchWalk = false;
	
	public void tick(boolean forward, boolean back, boolean left, boolean right, boolean jump, boolean crouch, boolean run){
		double rotationSpeed = 0.001 * Display.MouseSpeed;
		double walkSpeed = 0.80;
		double jumpHeight = 0.80;
		double crouchHeight = 0.15;
		double xMove = 0;
		double zMove = 0;
		
		if(forward){
			zMove++;
			walk = true;
		}
		if(back){
			zMove--;
			walk = true;
		}
		if(left){
			xMove--;
			walk = true;
		}
		if(right){
			xMove++;
			walk = true;
		}
		
		if(turnLeft){
			rotationa -= rotationSpeed;
		}
		if(turnRight){
			rotationa += rotationSpeed;
		}
		
		if(jump){
			y += jumpHeight;
			walk = false;
			run = false;
		}
		if(crouch){
			y -= crouchHeight;
			if(walk){
			walkSpeed = 0.40;
			run = false;
			crouchWalk = true;
			}
		}
		if(run){
			if(walk){
			walkSpeed = 1.20;
			sprint = true;
			}
		}
		
		if(!forward && !back && !left && !right){
			walk = false;
		}
		if(!run){
			sprint = false;
		}
		if(!crouch){
			crouchWalk = false;
		}
		
		xa += (xMove * Math.cos(rotation) + zMove * Math.sin(rotation)) * walkSpeed;
		za += (zMove * Math.cos(rotation) - xMove * Math.sin(rotation)) * walkSpeed;
		
		x += xa;
		y *= 0.9;
		z += za;
		xa *= 0.1;
		za *= 0.1;
		
		rotation += rotationa;
		rotationa *= 0.5;
	}
	
}
