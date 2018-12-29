package com.mime.surviver.gui;

import java.awt.Choice;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.mime.surviver.Configuration;
import com.mime.surviver.Display;
import com.mime.surviver.graphics.Render3D;
import com.mime.surviver.graphics.Texture;

public class Options extends Launcher {
	private static final long serialVersionUID = 1L;
	
	private int width = 550;
	private int height = 450;
	
	private JButton OK;
	private Rectangle rOK, rresolution, rtextures, rTex1, rTex2, rTex3;
	
	private Choice resolution = new Choice();
	private Choice textures = new Choice();
	
	private JTextField texturePackHelp1 = new JTextField("To create a texture pack, edit the picture in /res/", 51);
	private JTextField texturePackHelp2 = new JTextField("textures/texturePack/textureCustom.png. First", 39);
	private JTextField texturePackHelp3 = new JTextField("picture is the floor / ceiling, second is the walls.");
	
	public Options(){
		super(1);
		setTitle("Options - Surviver Launcher");
		setSize(new Dimension(width, height));
		setLocationRelativeTo(null);
		
		drawButtons();
	}
	
	private void drawButtons(){
		OK = new JButton("OK");
		rOK = new Rectangle((width - 100), (height - 70), button_width, button_height - 10);
		OK.setBounds(rOK);
		window.add(OK);
		
		rresolution = new Rectangle(50, 80, 150, 25);
		resolution.setBounds(rresolution);
		resolution.add("Resolution: 640, 480");
		resolution.add("Resolution: 800, 600");
		resolution.add("Resolution: 1024, 768");
		resolution.select(0);
		window.add(resolution);
		
		rtextures = new Rectangle(50, 100,150, 25);
		textures.setBounds(rtextures);
		textures.add("Textures: Default");
		textures.add("Textures: Abstract");
		textures.add("Textures: Whiteout");
		textures.add("Textures: Custom");
		textures.select(0);
		window.add(textures);
		
		rTex1 = new Rectangle(275, 80,245, 25);
		rTex2 = new Rectangle(275, 100,245, 25);
		rTex3 = new Rectangle(275, 120,245, 25);
		texturePackHelp1.setBounds(rTex1);
		texturePackHelp2.setBounds(rTex2);
		texturePackHelp3.setBounds(rTex3);
		window.add(texturePackHelp1);
		window.add(texturePackHelp2);
		window.add(texturePackHelp3);
		
		
		
		OK.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				int selection = resolution.getSelectedIndex();
				int w = 0;
				int h = 0;
				if(selection == 0){
					w = 640;
					h = 480;
				}
				if(selection == 1 || selection == -1){
					w = 800;
					h = 600;
				}
				if(selection == 2){
					w = 1024;
					h = 768;
				}
				config.saveConfig("width", w);
				config.saveConfig("height", h);
				
				Render3D.texSelect = textures.getSelectedIndex();
				dispose();
				new Launcher(0);
			}
		});
		
	}

}
