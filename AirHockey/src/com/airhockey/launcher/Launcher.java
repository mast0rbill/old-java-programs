package com.airhockey.launcher;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.airhockey.src.Frame;

public class Launcher {

	public Launcher(){
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		JButton play2, play1;
		Rectangle rplay2, rplay1;
		frame.getContentPane().add(panel);
		frame.setTitle("Air Hockey - Launcher");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(280, 320);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		panel.setLayout(null);
		
		play2 = new JButton("2 Players");
		rplay2 = new Rectangle((280 / 2) - (100 / 2), 200, 100, 50);
		play2.setBounds(rplay2);
		panel.add(play2);
		play2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				new Frame();
			}
			
		});
		
		play1 = new JButton("1 Player");
		rplay1 = new Rectangle((280 / 2) - (100 / 2), 130, 100, 50);
		play1.setBounds(rplay1);
		panel.add(play1);
		play1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
			}
			
		});
	}
	public static void main(String[] args){
		new Launcher();
	}
}
