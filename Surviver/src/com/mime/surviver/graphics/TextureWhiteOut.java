package com.mime.surviver.graphics;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import com.mime.surviver.crashed.CrashedScreen;

public class TextureWhiteOut {
	
	public static Render textureRender = loadBitmap("/textures/textureWhiteOut.png");
	
	public static Render loadBitmap(String fileName){
		try{
			BufferedImage image = ImageIO.read(Texture.class.getResource(fileName));
			int width = image.getWidth();
			int height = image.getHeight();
			Render result = new Render(width, height);
			image.getRGB(0, 0, width, height, result.pixels, 0, width);
			return result;
		} catch(Exception e) {
			System.out.println("CRASH!");
			new CrashedScreen();
			throw new RuntimeException();
		}
	}
	
}