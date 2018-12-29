package com.mime.surviver.crashed;

import javax.swing.*;

public class CrashedScreen {

	public CrashedScreen(){
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		JLabel crash = new JLabel("Surviver has crashed!");
		
		frame.setSize(100, 50);
		frame.getContentPane().add(panel);
		panel.add(crash);
		frame.setTitle("Surviver has crashed!");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}
	
}
