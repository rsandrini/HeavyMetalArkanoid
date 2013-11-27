package com.badlogic.androidgames.heavymetalarkanoid;
import java.util.List;
import java.util.Random;

import android.graphics.Rect;

import com.badlogic.androidgames.framework.Pixmap;

public class Ball {
	
	// Normalized motion vector.
    private float dirX;
    private float dirY;
    
    public int x;
    public int y;
    
    public Rect rectBall;
    
    private int mSpeed;
    public Pixmap ballMap;
    
    public Ball() {
    	this.ballMap = Assets.ball;
    	reset();
    }
	
    /**
     * Reset position
     */
    public void reset(){
    	this.x = 150;
    	this.y = 300;
    	mSpeed = 4;
    	int d1;
    	int d2;
    	
    	Random generator = new Random();
    	if (generator.nextInt(10) + 1 > 5)
    		d1 = 1;
    	else
    		d1 = -1;
    	
    	if (generator.nextInt(10) + 1 > 5)
    		d2 = 1;
    	else
    		d2 = -1;
    	
    	rectBall = new Rect(x, y, x+24, y+24); 
    	setDirection(d1, d2);
    }
    
    /**
     * Gets the motion vector X component.
     */
    public float getXDirection() {
        return dirX;
    }

    /**
     * Gets the motion vector Y component.
     */
    public float getYDirection() {
        return dirY;
    }

    /**
     * Sets the motion vector.  Input values will be normalized.
     */
    public void setDirection(float deltaX, float deltaY) {
        float mag = (float) Math.sqrt(deltaX * deltaX + deltaY * deltaY);
        dirX = deltaX / mag;
        dirY = deltaY / mag;
    }

    /**
     * Gets the speed, in arena-units per second.
     */
    public int getSpeed() {
        return mSpeed;
    }

    /**
     * Sets the speed, in arena-units per second.
     */
    public void setSpeed(int speed) {
        if (speed <= 0) {
            throw new RuntimeException("speed must be positive (" + speed + ")");
        }
        mSpeed = speed;
    }

    public void colision(World w, Logic l){
    	// Ball out of map
    	if (y >= 390){
        	w.gameOver = true;
    	}
		  	  
		if (x <= 0) {
		    collideLeft();
		}
		
		if (x >= World.RIGHT-24) {
			collideRight();
		}
		
		if (y <= 0) {
			collideTop();
		}
  	  
    	if (l.rectRacket.intersect(rectBall)){
    		collideBottom();
    	}
		
    	for (int i=0; i < w.map.size(); i++){
	 		Brick b = w.map.get(i);
	 		Rect brickRect = new Rect(b.x, b.y, b.x+45, b.y+15);
	 		if (rectBall.intersect(brickRect)){
	 			
	 			Rect testRectTop= new Rect(b.x, b.y, b.x+45, b.y+7);
	 			Rect testRectRight= new Rect(b.x+35, b.y, b.x+45, b.y+15);
	 			Rect testRectBottom= new Rect(b.x, b.y+7, b.x+45, b.y+15);
	 			Rect testRectLeft= new Rect(b.x, b.y, b.x+10, b.y+15);
	 			
	 			if (rectBall.intersect(testRectTop)){
	 				collideBottom();
	 			}
	 			else if (rectBall.intersect(testRectRight)){
	 				collideLeft();
	 			}
	 			else if (rectBall.intersect(testRectBottom)){
	 				collideTop();
	 			}
	 			else if (rectBall.intersect(testRectLeft)){
	 				collideRight();
	 			}
	 			else
	 				collideTop();
	 			//w.map.remove(i);
	 		}
    	}
    }
    
    
    
    
    public void move(List<Brick> map, Logic logic, World world)
    {
	  x += dirX * mSpeed;
	  y += dirY * mSpeed;
    	
	  rectBall = new Rect(x, y, x+24, y+24); 
      colision(world, logic);
    }
    

    public void collideTop(){
    	dirY = 1;
    }
	
    public void collideLeft(){
    	dirX = 1;
    }
    
    public void collideRight(){
    	dirX = -1;
    }
    
    public void collideBottom(){
    	dirY = -1;
    }
}

