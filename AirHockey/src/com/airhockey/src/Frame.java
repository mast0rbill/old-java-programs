package com.airhockey.src;

import javax.swing.*;

public class Frame {

	public Frame(){
		JFrame frame = new JFrame();
		frame.add(new Board());
		frame.setTitle("Air Hockey");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(815, 439);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}
}
