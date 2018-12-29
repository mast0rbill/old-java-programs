package com.airhockey.src;

import java.awt.*;
import java.util.Random;
import static com.airhockey.src.Board.*;

import javax.swing.ImageIcon;

public class Ball {
	int x, dx, y, dy;
	Image still;
	Random speed;

	public Ball() {
		ImageIcon i = new ImageIcon("res/ball.png");
		speed = new Random(3);
		still = i.getImage();
		x = (800 / 2) - (still.getWidth(null) / 2);
		y = (400 / 2) - (still.getHeight(null) / 2);
	}

	public void move() {
		x = x + dx;
		y = y + dy;
		
		if(stickTouchingBall){
			if(hittingFromTop){
				if(hittingFromLeft){
					dx = 3;
					dy = 3;
				}
				if(hittingFromRight){
					dx = -3;
					dy = 3;
				}
			}
			if(hittingFromBottom){
				if(hittingFromLeft){
					dx = 3;
					dy = -3;
				}
				if(hittingFromRight){
					dx = -3;
					dy = -3;
				}
			}
			if(!hittingFromBottom && !hittingFromTop){
				if(hittingFromLeft){
					dx = 3;
					dy = 0;
				}
				if(hittingFromRight){
					dx = -3;
					dy = 0;
				}
			}
			if(!hittingFromLeft && !hittingFromRight){
				if(hittingFromTop){
					dx = 0;
					dy = 3;
				}
				if(hittingFromBottom){
					dx = 0;
					dy = -3;
				}
			}
		}
		
		if(stickTouchingBall2){
			if(hittingFromTop2){
				if(hittingFromLeft2){
					dx = 3;
					dy = 3;
				}
				if(hittingFromRight2){
					dx = -3;
					dy = 3;
				}
			}
			if(hittingFromBottom2){
				if(hittingFromLeft2){
					dx = 3;
					dy = -3;
				}
				if(hittingFromRight2){
					dx = -3;
					dy = -3;
				}
			}
			if(!hittingFromBottom2 && !hittingFromTop2){
				if(hittingFromLeft2){
					dx = 3;
					dy = 0;
				}
				if(hittingFromRight2){
					dx = -3;
					dy = 0;
				}
			}
			if(!hittingFromLeft2 && !hittingFromRight2){
				if(hittingFromTop2){
					dx = 0;
					dy = 3;
				}
				if(hittingFromBottom2){
					dx = 0;
					dy = -3;
				}
			}
		}
		
		if(stickTouchingBall && dx > 0 && stickNotMoving){
			hittingFromRight = true;
			hittingFromLeft = false;
		} else if(stickTouchingBall && dx < 0 && stickNotMoving){
			hittingFromLeft = true;
			hittingFromRight = false;
		} else if(stickTouchingBall && dx == 0 && stickNotMoving){
			hittingFromLeft = false;
			hittingFromRight = false;
		}
		if(stickTouchingBall && dy > 0 && stickNotMoving){
			hittingFromBottom = true;
			hittingFromTop = false;
		} else if(stickTouchingBall && dy < 0 && stickNotMoving){
			hittingFromTop = true;
			hittingFromBottom = true;
		} else if(stickTouchingBall && dy == 0 && stickNotMoving){
			hittingFromTop = false;
			hittingFromBottom = false;
		}
		
		if(stickTouchingBall2 && dx > 0 && stickNotMoving2){
			hittingFromRight2 = true;
			hittingFromLeft2 = false;
		} else if(stickTouchingBall2 && dx < 0 && stickNotMoving2){
			hittingFromLeft2 = true;
			hittingFromRight2 = false;
		} else if(stickTouchingBall2 && dx == 0 && stickNotMoving2){
			hittingFromLeft2 = false;
			hittingFromRight2 = false;
		}
		if(stickTouchingBall2 && dy > 0 && stickNotMoving2){
			hittingFromBottom2 = true;
			hittingFromTop2 = false;
		} else if(stickTouchingBall2 && dy < 0 && stickNotMoving2){
			hittingFromTop2 = true;
			hittingFromBottom2 = true;
		} else if(stickTouchingBall2 && dy == 0 && stickNotMoving2){
			hittingFromTop2 = false;
			hittingFromBottom2 = false;
		}
		
		if(ballTouchingNet){
			dx = -3;
		}
		if(ballTouchingNet2){
			dx = 3;
		}
		
		if(y >= 400 - 115){
			dy = -3;
		}
		if(y <= 10){
			dy = 3;
		}
		if(x >= 800 - 115){
			dx = -3;
		}
		if(x <= 10){
			dx = 3;
		}
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