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
    
    Rect rectRacket ;
    
    private List<Music> musics = new ArrayList<Music>();;
    
    public Logic() {        
        stage = 0; // Represent a map1
        resetRacket();
        musics.add(Assets.stage1Music);
        musics.add(Assets.stage2Music);
        musics.add(Assets.stage3Music);
    }
    
    public Music getMusicLevel(){
	    return musics.get(stage);
    }
    
    public List<Brick> getMap(){
    	return _maps.listMaps.get(stage);
    }
    
    private void resetRacket(){
        xRacket = 20;
        yRacket = 380;
        rectRacket = new Rect(xRacket, yRacket, xRacket+100, yRacket+20 );
    }
    
    public void setX(int x){

    	if (x > (World.RIGHT - 90)){
    		xRacket = World.RIGHT - 90;
    	}
    	else{
    		xRacket = x;
    	}

    	//xRacketBound = xRacket + 120;
    	rectRacket = new Rect(xRacket, yRacket, xRacket+100, yRacket+20 );
    }
    
    
    public void advance() {

    }
    
    public void addPoint(World w){
    	w.score += World.SCORE_INCREMENT;
    }
    
    
    public Boolean loadNextLevel(){
    	stage ++;
    	if (stage > _maps.totalMaps())
    		return false;
    	else{
    		resetRacket();
    		return true;
    	}
    }
}
