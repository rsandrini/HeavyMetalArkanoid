package com.badlogic.androidgames.heavymetalarkanoid;

import android.graphics.Color;
import android.graphics.Rect;

public class Brick {
    public Rect rect;
    public int color; 
    private int brickWidth;
    private int brickHeigth;
    
    public Brick(int x, int y, int color) {
    	brickWidth = 45;
    	brickHeigth = 15;
        this.rect = new Rect(x, y, x+brickWidth, y+brickHeigth);
        this.color = color;
    }

    public int getWidth(){
    	return this.brickWidth;
    }
    
    public int getHeight(){
    	return this.brickHeigth;
    }
    
    public Rect getTopRect(){
    	return new Rect(rect.left, rect.top,
					rect.right, rect.bottom-5);
    }

    public Rect getRightRect(){
    	return new Rect(rect.left+40, rect.top,
				rect.right, rect.bottom);
    }
    
    public Rect getBottomRect(){
    	return new Rect(rect.left, rect.top+5,
				rect.right, rect.bottom);
    	
    }
    
    public Rect getLeftRect(){
    	return new Rect(rect.left, rect.top,
				rect.right-40, rect.bottom);
    }
    
    
}       

