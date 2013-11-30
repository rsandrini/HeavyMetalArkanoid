package com.badlogic.androidgames.heavymetalarkanoid;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.badlogic.androidgames.framework.Music;

public class World {
    public static final int RIGHT = 320;
    
    static final int SCORE_INCREMENT = 10;
    static final float TICK_INITIAL = 0.01f;
    static final float TICK_DECREMENT = 0.01f;

    public List<Brick> map = new ArrayList<Brick>();
    public Logic logic;
    public boolean gameOver = false;
    public int score = 0;
    public Ball ball;
    private Music music;
    
    //boolean fields[][] = new boolean[WORLD_WIDTH][WORLD_HEIGHT];
    Random random = new Random();
    float tickTime = 0;
    static float tick = TICK_INITIAL;

    public World() {
        logic = new Logic();
        map = logic.getMap();
        ball = new Ball();
        music = logic.getMusicLevel();
        music.stop();
        music.setLooping(true);
    }

    public void sumScore(){
    	score += SCORE_INCREMENT;
    }
    
    public void musicPause(){
    	if (Settings.soundEnabled){
    		if (!music.isPlaying())
    			music.play();
    		else
    			music.pause();
    	}
    }
    
    public void music()
    {
    	if (Settings.soundEnabled && !music.isPlaying())
    		music.play();
    }

    public void musicStop(){
    	music.stop();
    }
    
    public void update(float deltaTime) {
    	music();
    	
        if (gameOver){
        	return;
        }

        tickTime += deltaTime;
        ball.move(map, logic, this); 
    }
    
    public int totalBrick(){
    	return map.size();
    }
    
    public Boolean loadNextLevel(){
    	musicStop();
    	if (logic.loadNextLevel()){
    		music = logic.getMusicLevel();
    		music.setLooping(true);
    		map = logic.getMap();
    		ball.reset();
    		return true;
    	}
    	else		
    		return false; 
    }
}
