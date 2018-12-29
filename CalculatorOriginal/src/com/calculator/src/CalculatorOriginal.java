package com.calculator.src;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class CalculatorOriginal{

JFrame frame;
JPanel panel;
long result = 0;
long x = 0;
long y = 0;
int operation = 0;
int button_size = 50;
int step = 1;
String newInputX = "0";
String newInputY = "0";
String oldInputX = "0";
String oldInputY = "0";
String inputX = "0";
String inputY = "0";

	
	public CalculatorOriginal(){
		try{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch(Exception e){
			e.printStackTrace();
		}
		frame = new JFrame("Calculator");
		panel = new JPanel();
		frame.getContentPane().add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(260, 370);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		panel.setLayout(null);
		
		buttons();
		panel.repaint();
	}
	
	public void calculate(){
		if(operation == 1){
			result = x + y;
		}
		if(operation == 2){
			result = x - y;
		}
		if(operation == 3){
			result = x * y;
		}
		if(operation == 4){
			result = x / y;
		}
		if(operation == 0){
			result = 0;
		}
	}
	
	public void buttons(){
		JButton one, two, three, four, five, six, seven, eight, nine, zero, add, sub, mul, div, equal, c, sqrt, negative;
		Rectangle r1, r2, r3, r4, r5, r6, r7, r8, r9, r0, rA, rS, rM, rD, requal, rC, rTP, rsqrt, rN;
		final JTextField textpane;
		
		r7 = new Rectangle(10, 100, button_size, button_size);
		r8 = new Rectangle(70, 100, button_size, button_size);
		r9 = new Rectangle(130, 100, button_size, button_size);
		r4 = new Rectangle(10, 160, button_size, button_size);
		r5 = new Rectangle(70, 160, button_size, button_size);
		r6 = new Rectangle(130, 160, button_size, button_size);
		r1 = new Rectangle(10, 220, button_size, button_size);
		r2 = new Rectangle(70, 220, button_size, button_size);
		r3 = new Rectangle(130, 220, button_size, button_size);
		r0 = new Rectangle(10, 280, button_size, button_size);
		
		rsqrt = new Rectangle(10, 40, button_size * 2 + 10, button_size);
		rN = new Rectangle(130, 40, button_size, button_size);
		
		textpane = new JTextField(100);
		rTP = new Rectangle(20, 10, 220, 20);
		textpane.setBounds(rTP);
		textpane.setBackground(Color.YELLOW);
		panel.add(textpane);
		
		one = new JButton("1");
		one.setBounds(r1);
		one.setBackground(Color.BLUE);
		panel.add(one);
		one.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(step == 1){
					newInputX = "1";
					oldInputX = textpane.getText();
					inputX = oldInputX + newInputX;
					x = Long.valueOf(inputX);
					textpane.setText(String.valueOf(x));
				}
				if(step == 3){
					newInputY = "1";
					oldInputY = textpane.getText();
					inputY = oldInputY + newInputY;
					y = Long.valueOf(inputY);
					textpane.setText(String.valueOf(y));
				}
			}
		});
		
		two = new JButton("2");
		two.setBounds(r2);
		two.setBackground(Color.BLUE);
		panel.add(two);
		two.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(step == 1){
					newInputX = "2";
					oldInputX = textpane.getText();
					inputX = oldInputX + newInputX;
					x = Long.valueOf(inputX);
					textpane.setText(String.valueOf(x));
				}
				if(step == 3){
					newInputY = "2";
					oldInputY = textpane.getText();
					inputY = oldInputY + newInputY;
					y = Long.valueOf(inputY);
					textpane.setText(String.valueOf(y));
				}
			}
		});
		
		three = new JButton("3");
		three.setBounds(r3);
		three.setBackground(Color.BLUE);
		panel.add(three);
		three.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(step == 1){
					newInputX = "3";
					oldInputX = textpane.getText();
					inputX = oldInputX + newInputX;
					x = Long.valueOf(inputX);
					textpane.setText(String.valueOf(x));
				}
				if(step == 3){
					newInputY = "3";
					oldInputY = textpane.getText();
					inputY = oldInputY + newInputY;
					y = Long.valueOf(inputY);
					textpane.setText(String.valueOf(y));
				}
			}
		});
		
		four = new JButton("4");
		four.setBounds(r4);
		four.setBackground(Color.BLUE);
		panel.add(four);
		four.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(step == 1){
					newInputX = "4";
					oldInputX = textpane.getText();
					inputX = oldInputX + newInputX;
					x = Long.valueOf(inputX);
					textpane.setText(String.valueOf(x));
				}
				if(step == 3){
					newInputY = "4";
					oldInputY = textpane.getText();
					inputY = oldInputY + newInputY;
					y = Long.valueOf(inputY);
					textpane.setText(String.valueOf(y));
				}
			}
		});
		
		five = new JButton("5");
		five.setBounds(r5);
		five.setBackground(Color.BLUE);
		panel.add(five);
		five.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(step == 1){
					newInputX = "5";
					oldInputX = textpane.getText();
					inputX = oldInputX + newInputX;
					x = Long.valueOf(inputX);
					textpane.setText(String.valueOf(x));
				}
				if(step == 3){
					newInputY = "5";
					oldInputY = textpane.getText();
					inputY = oldInputY + newInputY;
					y = Long.valueOf(inputY);
					textpane.setText(String.valueOf(y));
				}
			}
		});
		
		six = new JButton("6");
		six.setBounds(r6);
		six.setBackground(Color.BLUE);
		panel.add(six);
		six.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(step == 1){
					newInputX = "6";
					oldInputX = textpane.getText();
					inputX = oldInputX + newInputX;
					x = Long.valueOf(inputX);
					textpane.setText(String.valueOf(x));
				}
				if(step == 3){
					newInputY = "6";
					oldInputY = textpane.getText();
					inputY = oldInputY + newInputY;
					y = Long.valueOf(inputY);
					textpane.setText(String.valueOf(y));
				}
			}
		});
		
		seven = new JButton("7");
		seven.setBounds(r7);
		seven.setBackground(Color.BLUE);
		panel.add(seven);
		seven.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(step == 1){
					newInputX = "7";
					oldInputX = textpane.getText();
					inputX = oldInputX + newInputX;
					x = Long.valueOf(inputX);
					textpane.setText(String.valueOf(x));
				}
				if(step == 3){
					newInputY = "7";
					oldInputY = textpane.getText();
					inputY = oldInputY + newInputY;
					y = Long.valueOf(inputY);
					textpane.setText(String.valueOf(y));
				}
			}
		});
		
		eight = new JButton("8");
		eight.setBounds(r8);
		eight.setBackground(Color.BLUE);
		panel.add(eight);
		eight.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(step == 1){
					newInputX = "8";
					oldInputX = textpane.getText();
					inputX = oldInputX + newInputX;
					x = Long.valueOf(inputX);
					textpane.setText(String.valueOf(x));
				}
				if(step == 3){
					newInputY = "8";
					oldInputY = textpane.getText();
					inputY = oldInputY + newInputY;
					y = Long.valueOf(inputY);
					textpane.setText(String.valueOf(y));
				}
			}
		});
		
		nine = new JButton("9");
		nine.setBounds(r9);
		nine.setBackground(Color.BLUE);
		panel.add(nine);
		nine.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(step == 1){
					newInputX = "9";
					oldInputX = textpane.getText();
					inputX = oldInputX + newInputX;
					x = Long.valueOf(inputX);
					textpane.setText(String.valueOf(x));
				}
				if(step == 3){
					newInputY = "9";
					oldInputY = textpane.getText();
					inputY = oldInputY + newInputY;
					y = Long.valueOf(inputY);
					textpane.setText(String.valueOf(y));
				}
			}
		});
		
		zero = new JButton("0");
		zero.setBounds(r0);
		zero.setBackground(Color.BLUE);
		panel.add(zero);
		zero.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(step == 1){
					newInputX = "0";
					oldInputX = textpane.getText();
					inputX = oldInputX + newInputX;
					x = Long.valueOf(inputX);
					textpane.setText(String.valueOf(x));
				}
				if(step == 3){
					newInputY = "0";
					oldInputY = textpane.getText();
					inputY = oldInputY + newInputY;
					y = Long.valueOf(inputY);
					textpane.setText(String.valueOf(y));
				}
			}
		});
		
		equal = new JButton("=");
		requal = new Rectangle(130, 280, button_size, button_size);
		equal.setBounds(requal);
		equal.setBackground(Color.GREEN);
		panel.add(equal);
		equal.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(step == 3){
					step = 4;
					calculate();
					textpane.setText(String.valueOf(result));
					step = 1;
					x = result;
				}
			}
		});
		
		add = new JButton("+");
		rA = new Rectangle(190, 100, button_size, button_size);
		add.setBounds(rA);
		add.setBackground(Color.RED);
		panel.add(add);
		add.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(step == 1){
					step = 2;
					operation = 1;
					step = 3;
					textpane.setText("");
				}
				if(step == 2){
					operation = 1;
					step = 3;
					textpane.setText("");
				}
			}
		});
		
		sub = new JButton("-");
		rS = new Rectangle(190, 160, button_size, button_size);
		sub.setBounds(rS);
		sub.setBackground(Color.RED);
		panel.add(sub);
		sub.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(step == 1){
					step = 2;
					operation = 2;
					step = 3;
					textpane.setText("");
				}
				if(step == 2){
					operation = 2;
					step = 3;
					textpane.setText("");
				}
			}
		});
		
		mul = new JButton("*");
		rM = new Rectangle(190, 220, button_size, button_size);
		mul.setBounds(rM);
		mul.setBackground(Color.RED);
		panel.add(mul);
		mul.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
					if(step == 1){
						step = 2;
						operation = 3;
						step = 3;
						textpane.setText("");
					}
					if(step == 2){
						operation = 3;
						step = 3;
						textpane.setText("");
					}
			}
		});
		
		div = new JButton("/");
		rD = new Rectangle(190, 280, button_size, button_size);
		div.setBounds(rD);
		div.setBackground(Color.RED);
		panel.add(div);
		div.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(step == 1){
					step = 2;
					operation = 4;
					step = 3;
					textpane.setText("");
				}
				if(step == 2){
					operation = 4;
					step = 3;
					textpane.setText("");
				}
			}
		});
		
		c = new JButton("C");
		rC = new Rectangle(70, 280, button_size, button_size);
		c.setBounds(rC);
		c.setBackground(Color.GREEN);
		panel.add(c);
		c.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				x = 0;
				y = 0;
				result = 0;
				operation = 0;
				step = 1;
				textpane.setText("");
			}
		});
		
		sqrt = new JButton("~ sqrt");
		sqrt.setBounds(rsqrt);
		sqrt.setBackground(Color.RED);
		panel.add(sqrt);
		sqrt.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
					if(step == 1){
						step = 2;
						result = (long) Math.sqrt(Double.valueOf(textpane.getText()));
						textpane.setText(String.valueOf(result));
						x = result;
					}
					if(step == 3){
						step = 4;
						result = (long) Math.sqrt(Double.valueOf(textpane.getText()));
						textpane.setText(String.valueOf(result));
						step = 1;
						y = result;
					}
			}
		});
		
		negative = new JButton("+/-");
		negative.setBounds(rN);
		negative.setBackground(Color.RED);
		panel.add(negative);
		negative.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
					if(step == 1){
						x = 0 - Long.valueOf(textpane.getText());
						textpane.setText(String.valueOf(x));
					}
					if(step == 3){
						y = 0 - Long.valueOf(textpane.getText());
						textpane.setText(String.valueOf(y));
					}
			}
		});
		
	}
	
	public static void main(String[] args){
		new CalculatorOriginal();
	}	
}
