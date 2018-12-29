package com.airhockey.src;

import java.awt.*;

import javax.swing.ImageIcon;

public class Net2 {
	int x, y;
	Image still;

	public Net2() {
		ImageIcon i = new ImageIcon("res/netleft.png");
		still = i.getImage();
		x = 3;
		y = (400 / 2) - (still.getHeight(null) / 2) - 10;
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
}
