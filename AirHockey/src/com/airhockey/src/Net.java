package com.airhockey.src;

import java.awt.*;

import javax.swing.ImageIcon;

public class Net {
	int x, y;
	Image still;

	public Net() {
		ImageIcon i = new ImageIcon("res/netright.png");
		still = i.getImage();
		x = 800 - 150;
		y = (400 / 2) - (still.getHeight(null) / 2);
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
