package com.airhockey.src;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Board extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	
	Stick stick;
	Stick2 stick2;
	Ball ball;
	Net netRight;
	Net2 netLeft;
	public Image img;
	Timer time;
	public static boolean stickTouchingBall = false;
	public static boolean stickTouchingBall2 = false;
	
	public static boolean hittingFromTop = false;
	public static boolean hittingFromBottom = false;
	public static boolean hittingFromLeft = false;
	public static boolean hittingFromRight = false;
	public static boolean hittingFromTop2 = false;
	public static boolean hittingFromBottom2 = false;
	public static boolean hittingFromLeft2 = false;
	public static boolean hittingFromRight2 = false;
	
	public static boolean stickNotMoving = true;
	public static boolean stickNotMoving2 = true;
	
	public static boolean stickOutOfBounds = false;
	public static boolean stickOutOfBounds2 = false;;
	
	public static boolean ballTouchingNet = false;
	public static boolean ballTouchingNet2 = false;
	public int point1 = 0;
	public int point2 = 0;

	static Font font = new Font("SanSerif", Font.PLAIN, 50);

	public Board() {
		stick = new Stick();
		stick2 = new Stick2();
		ball = new Ball();
		netRight = new Net();
		netLeft = new Net2();
		addKeyListener(new AL());
		setFocusable(true);
		ImageIcon i = new ImageIcon("res/bg.png");
		img = i.getImage();
		time = new Timer(5, this);
		time.start();
	}

	public void actionPerformed(ActionEvent e) {
		checkCollisions();
		stick.move();
		stick2.move();
		ball.move();
		repaint();
	}
	
	public void checkCollisions(){
		Rectangle p = new Rectangle(stick.getBounds());
		Rectangle p2 = new Rectangle(stick2.getBounds());
		Rectangle b = new Rectangle(ball.getBounds());
		Rectangle n = new Rectangle(netRight.getBounds());
		Rectangle n2 = new Rectangle(netLeft.getBounds());
		
		if(p.intersects(b)){
			stickTouchingBall = true;
		}
		if(!p.intersects(b)){
			stickTouchingBall = false;
		}
		if(p2.intersects(b)){
			stickTouchingBall2 = true;
		}
		if(!p2.intersects(b)){
			stickTouchingBall2 = false;
		}
		
		if(b.intersects(n)){
			point1 += 1;
			ballTouchingNet = true;
		}
		if(!b.intersects(n)){
			point1 += 0;
			ballTouchingNet = false;;
		}
		if(b.intersects(n2)){
			point2 += 1;
			ballTouchingNet2 = true;
		}
		if(!b.intersects(n2)){
			point2 += 0;
			ballTouchingNet2 = false;;
		}
	}

	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;

		g2d.setFont(font);
		g2d.setColor(Color.WHITE);
		g2d.drawImage(img, 0, 0, null);
		g2d.drawImage(netRight.getImage(), netRight.getX(), netRight.getY(), null);
		g2d.drawImage(netLeft.getImage(), netLeft.getX(), netLeft.getY(), null);
		g2d.drawImage(stick.getImage(), stick.getX(), stick.getY(), null);
		g2d.drawImage(stick2.getImage(), stick2.getX(), stick2.getY(), null);
		g2d.drawImage(ball.getImage(), ball.getX(), ball.getY(), null);
		g2d.drawString(point1 + " - " + point2 , (800 / 2) - 60, 50);
	}

	private class AL extends KeyAdapter {
		public void keyReleased(KeyEvent e) {
			stick.keyReleased(e);
			stick2.keyReleased(e);
		}
		
		public void keyPressed(KeyEvent e) {
			stick.keyPressed(e);
			stick2.keyPressed(e);
		}
	}
}
