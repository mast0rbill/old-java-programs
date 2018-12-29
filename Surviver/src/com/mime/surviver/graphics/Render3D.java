package com.mime.surviver.graphics;

import com.mime.surviver.Game;
import com.mime.surviver.input.Controller;
import com.mime.surviver.level.Block;
import com.mime.surviver.level.Level;

public class Render3D extends Render{
	
	public static int texSelect = 0;

	public double[] zBuffer;
	public double[] zBufferWall;
	private double renderDistance = 5000;
	private double forward, right, cosine, sine, up, walking;
	
	public Render3D(int width, int height) {
		super(width, height);
		zBuffer = new double[width * height];
		zBufferWall = new double[width];
	}
	
	public void floor(Game game){
		
		for(int x = 0; x < width; x++){
			zBufferWall[x] = 0;
		}
		
		double floorPosition = 8;
		double ceilingPosition = 8;
		
		forward = game.controls.z;
		right = game.controls.x;
		up = game.controls.y;
		walking = 0;
		double rotation = game.controls.rotation;
		
		cosine = Math.cos(rotation);
		sine = Math.sin(rotation);
		
		
		for(int y = 0; y < height; y++){
			double ceiling = (y + - height / 2.0) / height;
			
			double z = (floorPosition + up) / ceiling;
			
			if(Controller.walk){
				walking = Math.sin(game.time / 6.0) * 0.50;
				z = (floorPosition + up + walking) / ceiling;
			}
			if(Controller.sprint && Controller.walk){
				walking = Math.sin(game.time / 5.0) * 0.55;
				z = (floorPosition + up + walking) / ceiling;
			}
			if(Controller.crouchWalk && Controller.walk){
				walking = Math.sin(game.time / 8.0) * 0.20;
				z = (floorPosition + up + walking) / ceiling;
			}
			if(ceiling < 0){
				z = (ceilingPosition - up) / - ceiling;
				if(Controller.walk){
					z = (ceilingPosition - up - walking) / - ceiling;
				}
			}
			
			for(int x = 0; x < width; x++){
				double depth = (x - width / 2.0) / height;
				depth *= z;
				double xx = depth * cosine + z * sine;
				double yy = z * cosine - depth * sine;
				int xPix = (int) (xx + right);
				int yPix = (int) (yy + forward);
				zBuffer[x + y * width] = z;
				
				if(texSelect == 0){
					pixels[x + y * width] = Texture.textureRender.pixels[(xPix & 7) + (yPix & 7) * 16];
				} else if(texSelect == 1){
					pixels[x + y * width] = TextureAbstract.textureRender.pixels[(xPix & 7) + (yPix & 7) * 16];
				} else if(texSelect == 2){
					pixels[x + y * width] = TextureWhiteOut.textureRender.pixels[(xPix & 7) + (yPix & 7) * 16];
				} else if(texSelect == 3){
					pixels[x + y * width] = TextureCustom.textureRender.pixels[(xPix & 7) + (yPix & 7) * 16];
				}
				
				if(z > 500){
					pixels[x + y * width] = 0;
				}
				
			}
		}
		
		Level level = game.level;
		int size = 50;
		for(int xBlock = -size; xBlock <= size; xBlock++){
			for(int zBlock = -size; zBlock <= size; zBlock++){
				Block block = level.create(xBlock, zBlock);
				Block east = level.create(xBlock + 1, zBlock);
				Block south = level.create(xBlock, zBlock + 1);
				
				if(block.solid){
					if(!east.solid){
						renderWall(xBlock + 1, xBlock + 1, zBlock, zBlock + 1, 0);
					}
					if(!south.solid){
						renderWall(xBlock + 1, xBlock, zBlock + 1, zBlock + 1, 0);
					}
				} else{
					if(east.solid){
						renderWall(xBlock + 1, xBlock + 1, zBlock + 1, zBlock, 0);
					}
					if(south.solid){
						renderWall(xBlock, xBlock + 1, zBlock + 1, zBlock + 1, 0);
					}
				}
			}
		}
		for(int xBlock = -size; xBlock <= size; xBlock++){
			for(int zBlock = -size; zBlock <= size; zBlock++){
				Block block = level.create(xBlock, zBlock);
				Block east = level.create(xBlock + 1, zBlock);
				Block south = level.create(xBlock, zBlock + 1);
				
				if(block.solid){
					if(!east.solid){
						renderWall(xBlock + 1, xBlock + 1, zBlock, zBlock + 1, 0.5);
					}
					if(!south.solid){
						renderWall(xBlock + 1, xBlock, zBlock + 1, zBlock + 1, 0.5);
					}
				} else{
					if(east.solid){
						renderWall(xBlock + 1, xBlock + 1, zBlock + 1, zBlock, 0.5);
					}
					if(south.solid){
						renderWall(xBlock, xBlock + 1, zBlock + 1, zBlock + 1, 0.5);
					}
				}
			}
		}
	}
	
	
	public void renderWall(double xLeft, double xRight, double zDistanceLeft,double zDistanceRight, double yHeight){
		//Setting speed
		double upCorrect = 0.0625;
		double rightCorrect = 0.0625;
		double forwardCorrect = 0.0625;
		double walkCorrect = -0.0625;
		//Left side
		double xcLeft = ((xLeft / 2) - (right * rightCorrect)) * 2;
		double zcLeft = ((zDistanceLeft / 2) - (forward * forwardCorrect)) * 2;
		double rotLeftSideX = xcLeft * cosine - zcLeft * sine;
		double yCornerTL = ((-yHeight) - (-up * upCorrect + (walking * walkCorrect))) * 2;
		double yCornerBL = ((+0.5 - yHeight) - (-up * upCorrect + (walking * walkCorrect))) * 2;
		double rotLeftSideZ = zcLeft * cosine + xcLeft * sine;
		//Right side
		double xcRight = ((xRight / 2) - (right * rightCorrect)) * 2;
		double zcRight = ((zDistanceRight / 2) - (forward * forwardCorrect)) * 2;
		double rotRightSideX = xcRight * cosine - zcRight * sine;
		double yCornerTR = ((-yHeight) - (-up * upCorrect + (walking * walkCorrect))) * 2;
		double yCornerBR = ((+0.5 - yHeight) - (-up * upCorrect + (walking * walkCorrect))) * 2;
		double rotRightSideZ = zcRight * cosine + xcRight * sine;
		//Clipping
		double tex30 = 0;
		double tex40 = 8;
		double clip = 0.5;
		if(rotLeftSideZ < clip && rotRightSideZ < clip){
			return;
		}
		if(rotLeftSideZ < clip){
			double clip0 = (clip - rotLeftSideZ) / (rotRightSideZ - rotLeftSideZ);
			rotLeftSideZ = rotLeftSideZ + (rotRightSideZ - rotLeftSideZ) * clip0;
			rotLeftSideX = rotLeftSideX + (rotRightSideX - rotLeftSideX) * clip0;
			tex30 = tex30 + (tex40 - tex30) * clip0;
		}
		if(rotRightSideZ < clip){
			double clip0 = (clip - rotLeftSideZ) / (rotRightSideZ - rotLeftSideZ);
			rotRightSideZ = rotLeftSideZ + (rotRightSideZ - rotLeftSideZ) * clip0;
			rotRightSideX = rotLeftSideX + (rotRightSideX - rotLeftSideX) * clip0;
			tex40 = tex30 + (tex40 - tex30) * clip0;
		}
		double xPixelLeft = (rotLeftSideX / rotLeftSideZ * height + width / 2);
		double xPixelRight = (rotRightSideX / rotRightSideZ * height + width / 2);
		if(xPixelLeft >= xPixelRight){
			return;
		}
		int xPixelLeftInt = (int) (xPixelLeft);
		int xPixelRightInt = (int) (xPixelRight);
		if(xPixelLeftInt < 0){
			xPixelLeftInt = 0;
		}
		if(xPixelRightInt > width){
			xPixelRightInt = width;
		}
		double yPixelLeftTop = yCornerTL / rotLeftSideZ * height + height / 2.0;
		double yPixelLeftBottom = yCornerBL / rotLeftSideZ * height + height / 2.0;
		double yPixelRightTop = yCornerTR / rotRightSideZ * height + height / 2.0;
		double yPixelRightBottom = yCornerBR / rotRightSideZ * height + height / 2.0;
		
		double tex1 = 1 / rotLeftSideZ;
		double tex2 = 1 / rotRightSideZ;
		double tex3 = tex30 / rotLeftSideZ;
		double tex4 = tex40 / rotRightSideZ - tex3;
		//Rendering
		for(int x = xPixelLeftInt; x < xPixelRightInt; x++){
			double pixelRotation = (x - xPixelLeft) / (xPixelRight - xPixelLeft);
			double zWall = (tex1 + (tex2 - tex1) * pixelRotation);
			if(zBufferWall[x] > zWall){
				continue;
			}
			zBufferWall[x] = zWall;
			int xTexture = (int) ((tex3 + tex4 * pixelRotation) / zWall);
			double yPixelTop = yPixelLeftTop + (yPixelRightTop - yPixelLeftTop) * pixelRotation;
			double yPixelBottom = yPixelLeftBottom + (yPixelRightBottom - yPixelLeftBottom) * pixelRotation;
			int yPixelTopInt = (int) (yPixelTop);
			int yPixelBottomInt = (int) (yPixelBottom);
			if(yPixelTopInt < 0){
				yPixelTopInt = 0;
			}
			if(yPixelBottomInt > height){
				yPixelBottomInt = height;
			}
			for(int y = yPixelTopInt; y < yPixelBottomInt; y++){
				double pixelRotationY = (y - yPixelTop ) / (yPixelBottom - yPixelTop);
				int yTexture = (int) (8 * pixelRotationY);
				//pixels[x + y * width] = xTexture * 100 + yTexture * 100 * 256;
				
				if(texSelect == 0){
					pixels[x + y * width] = Texture.textureRender.pixels[((xTexture & 7) + 8) + (yTexture & 7) * 16];
				} else if(texSelect == 1){
					pixels[x + y * width] = TextureAbstract.textureRender.pixels[((xTexture & 7) + 8) + (yTexture & 7) * 16];
				} else if(texSelect == 2){
					pixels[x + y * width] = TextureWhiteOut.textureRender.pixels[((xTexture & 7) + 8) + (yTexture & 7) * 16];
				} else if(texSelect == 3){
					pixels[x + y * width] = TextureCustom.textureRender.pixels[((xTexture & 7) + 8) + (yTexture & 7) * 16];
				}
				
				zBuffer[x + y * width] = 1 / (tex1 + (tex2 - tex1) * pixelRotation) * 8;
			}
		}
		
	}
	
	
	public void renderDistanceLimiter(){
		for(int i = 0; i < width * height; i++){
			int colour = pixels[i];
			int brightness = (int) (renderDistance / (zBuffer[i]));
			
			if(brightness < 0){
				brightness = 0;
			}
			if(brightness > 255){
				brightness = 255;
			}
			
			int r = (colour >> 16) & 0xff;
			int g = (colour >> 8) & 0xff;
			int b = (colour) & 0xff;
			
			r = r * brightness / 255;
			g = g * brightness / 255;
			b = b * brightness / 255;
			
			pixels[i] = r << 16 | g << 8 | b;
		}
	}
	
}
