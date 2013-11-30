package com.badlogic.androidgames.heavymetalarkanoid;

import java.util.ArrayList;
import java.util.List;

import android.graphics.Rect;

import com.badlogic.androidgames.framework.Music;

public class Logic {
    public Maps _maps = new Maps();
    public int stage;    
    public int xRacket;
    //public int xRacketBound;
    public int yRacket;
    
    private int racketWidth;
    private int racketHeight;
    
    Rect rectRacket ;

    public int getWidth(){
    	return this.racketWidth;
    }

    public int getHeigth(){
    	return this.racketHeight;
    }

    
    
    public Rect getLeftRectRacket(){
    	return new Rect(rectRacket.left, rectRacket.top,
    			rectRacket.right-70, rectRacket.bottom);
    }
    
    public Rect getRightRectRacket(){
    	return new Rect(rectRacket.left+70, rectRacket.top,
    			rectRacket.right, rectRacket.bottom);
    }
    
    public Logic() {        
    	racketWidth = 90;
    	racketHeight = 20;
        stage = 0; // Represent a map1
        resetRacket();
        
    }
    
    public Music getMusicLevel(){
	    return _maps.musics.get(stage);
    }
    
    public List<Brick> getMap(){
    	return _maps.listMaps.get(stage);
    }
    
    private void resetRacket(){
        xRacket = 20;
        yRacket = 380;
        rectRacket = new Rect(xRacket, yRacket, xRacket+racketWidth, yRacket+racketHeight );
    }
    
    public void setX(int x){

    	if (x > (World.RIGHT - 90)){
    		xRacket = World.RIGHT - 90;
    	}
    	else{
    		xRacket = x;
    	}

    	//xRacketBound = xRacket + 120;
    	rectRacket = new Rect(xRacket, yRacket, xRacket+racketWidth, yRacket+racketHeight );
    }
    
    
    public void advance() {

    }
    
    public void addPoint(World w){
    	w.score += World.SCORE_INCREMENT;
    }
    
    
    public Boolean loadNextLevel(){
    	stage ++;
    	if (stage >= _maps.totalMaps())
    		return false;
    	else{
    		resetRacket();
    		return true;
    	}
    }
}
