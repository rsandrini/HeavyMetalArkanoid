package com.badlogic.androidgames.heavymetalarkanoid;

import java.util.List;

import android.graphics.Color;
import android.graphics.Rect;

import com.badlogic.androidgames.framework.Game;
import com.badlogic.androidgames.framework.Graphics;
import com.badlogic.androidgames.framework.Input.TouchEvent;
import com.badlogic.androidgames.framework.Screen;

public class GameScreen extends Screen {
    enum GameState {
        Ready,
        Running,
        Paused,
        GameOver
    }
    
    GameState state = GameState.Ready;
    World world;
    int oldScore = 0;
    String score = "0";
    
    public GameScreen(Game game) {
        super(game);
        world = new World();
    }

    @Override
    public void update(float deltaTime) {
        List<TouchEvent> touchEvents = game.getInput().getTouchEvents();
        game.getInput().getKeyEvents();
        
        if(state == GameState.Ready)
            updateReady(touchEvents);
        if(state == GameState.Running)
            updateRunning(touchEvents, deltaTime);
        if(state == GameState.Paused)
            updatePaused(touchEvents);
        if(state == GameState.GameOver)
            updateGameOver(touchEvents);        
    }
    
    private void updateReady(List<TouchEvent> touchEvents) {
        //if(touchEvents.size() < 350)
    	int len = touchEvents.size();
        for(int i = 0; i < len; i++) {
	    	TouchEvent event = touchEvents.get(i);
	    	if(event.type == TouchEvent.TOUCH_UP) {
	    		if(event.y < 350){
	    			state = GameState.Running;
	    			break;
	    		}
	    	}
        }
    	
        //state = GameState.Running;
    }
    
    private void updateRunning(List<TouchEvent> touchEvents, float deltaTime) {        
        int len = touchEvents.size();
        for(int i = 0; i < len; i++) {
            TouchEvent event = touchEvents.get(i);
            if(event.type == TouchEvent.TOUCH_UP) {
                if(event.x < 64 && event.y < 64) {
                    if(Settings.soundEnabled){
                        Assets.click.play(1);
                        world.musicPause();
                    }
                    state = GameState.Paused;
                    return;
                }
            }
            
            if(event.type == TouchEvent.TOUCH_DRAGGED) {
            	if(event.y > 400) {
                    world.logic.setX(event.x);
                }
            } 
        }
        
        world.update(deltaTime);
        if (world.totalBrick() <= 0){
        	state = GameState.Ready;
        	if (!world.loadNextLevel())
        		state = GameState.GameOver;
        } 		
        		
        if(world.gameOver) {
            if(Settings.soundEnabled){
            	world.musicStop();
            	Assets.gameOverMusic.play(1);
                
            }
            state = GameState.GameOver;
        }
        if(oldScore != world.score) {
            oldScore = world.score;
            score = "" + oldScore;
            if(Settings.soundEnabled)
                Assets.eat.play(1);
        }
    }
    
    private void updatePaused(List<TouchEvent> touchEvents) {
        int len = touchEvents.size();
        for(int i = 0; i < len; i++) {
            TouchEvent event = touchEvents.get(i);
            if(event.type == TouchEvent.TOUCH_UP) {
                if(event.x > 80 && event.x <= 240) {
                    if(event.y > 100 && event.y <= 148) {
                        if(Settings.soundEnabled){
                            Assets.click.play(1);
                            world.musicPause();
                        }
                        state = GameState.Running;
                        return;
                    }                    
                    if(event.y > 148 && event.y < 196) {
                    	world.musicStop();
                        if(Settings.soundEnabled)
                            Assets.click.play(1);
                        game.setScreen(new MainMenuScreen(game));                        
                        return;
                    }
                }
            }
        }
    }
    
    private void updateGameOver(List<TouchEvent> touchEvents) {
        int len = touchEvents.size();
        for(int i = 0; i < len; i++) {
            TouchEvent event = touchEvents.get(i);
            if(event.type == TouchEvent.TOUCH_UP) {
                if(event.x >= 128 && event.x <= 192 &&
                   event.y >= 200 && event.y <= 264) {
                    if(Settings.soundEnabled)
                        Assets.click.play(1);
                    game.setScreen(new MainMenuScreen(game));
                    return;
                }
            }
        }
    }
    

    @Override
    public void present(float deltaTime) {
        Graphics g = game.getGraphics();
        
        g.drawPixmap(Assets.background, 0, 0);
        drawWorld(world);
        if(state == GameState.Ready) 
            drawReadyUI();
        if(state == GameState.Running)
            drawRunningUI();
        if(state == GameState.Paused)
            drawPausedUI();
        if(state == GameState.GameOver)
            drawGameOverUI();
        
        drawText(g, score, g.getWidth() / 2 - score.length()*20 / 2, g.getHeight() - 42);                
    }
    
    private void drawWorld(World world) {
        Graphics g = game.getGraphics();
        
    	for (int i = 0; i < world.map.size(); i++){
    		Brick b = world.map.get(i);
    		//g.drawPixmap(b.image, b.x, b.y);
    		// BriCK
    		g.drawRect(b.rect.left, b.rect.top, b.getWidth(), b.getHeight(), b.color);
    		
    		/* DEBUG 
    		g.drawRect(b.getTopRect().left, b.getTopRect().top, 
    				b.getTopRect().right - b.getTopRect().left, b.getTopRect().bottom - b.getTopRect().top, 
    				Color.BLUE);
    		
    		g.drawRect(b.getBottomRect().left, b.getBottomRect().top, 
    				b.getBottomRect().right - b.getBottomRect().left, b.getBottomRect().bottom - b.getBottomRect().top, 
    				Color.GREEN);
    		
    		g.drawRect(b.getRightRect().left, b.getRightRect().top, 
    				b.getRightRect().right - b.getRightRect().left, b.getRightRect().bottom - b.getRightRect().top, 
    				Color.DKGRAY);
    		
    		g.drawRect(b.getLeftRect().left, b.getLeftRect().top, 
    				b.getLeftRect().right - b.getLeftRect().left, b.getLeftRect().bottom - b.getLeftRect().top, 
    				Color.MAGENTA);
    		*/
    	}
        
    	// Racket
    	g.drawPixmap(Assets.racket, world.logic.xRacket, world.logic.yRacket);
    	//Ball
    	g.drawPixmap(world.ball.ballMap, world.ball.x, world.ball.y);
    	
    	/* DEBUG
    	g.drawRect(world.logic.rectRacket.left, world.logic.rectRacket.top, 
    			world.logic.getWidth() ,world.logic.getHeigth(), Color.GRAY);
    	
    	g.drawRect(world.logic.getLeftRectRacket().left, world.logic.getLeftRectRacket().top, 
    			world.logic.getLeftRectRacket().right - world.logic.getLeftRectRacket().left,
    			world.logic.getLeftRectRacket().bottom - world.logic.getLeftRectRacket().top, 
				Color.RED);
    	
    	g.drawRect(world.logic.getRightRectRacket().left, world.logic.getRightRectRacket().top, 
    			world.logic.getRightRectRacket().right - world.logic.getRightRectRacket().left,
				world.logic.getRightRectRacket().bottom - world.logic.getRightRectRacket().top, 
				Color.RED);
    	
    	g.drawRect(world.ball.rectBall.left, world.ball.rectBall.top,
    			world.ball.getWidth(), world.ball.getHeight(), Color.YELLOW);
    	*/
    		
    }
    
    private void drawReadyUI() {
        Graphics g = game.getGraphics();
        
        g.drawPixmap(Assets.ready, 47, 100);
        g.drawLine(0, 416, 480, 416, Color.BLACK);
    }
    
    private void drawRunningUI() {
        Graphics g = game.getGraphics();

        g.drawPixmap(Assets.buttons, 0, 0, 64, 128, 64, 64);
        g.drawLine(0, 416, 480, 416, Color.BLACK);

    }
    
    private void drawPausedUI() {
        Graphics g = game.getGraphics();
        
        g.drawPixmap(Assets.pause, 80, 100);
        g.drawLine(0, 416, 480, 416, Color.BLACK);
    }

    private void drawGameOverUI() {
        Graphics g = game.getGraphics();
        
        g.drawPixmap(Assets.gameOver, 62, 100);
        g.drawPixmap(Assets.buttons, 128, 200, 0, 128, 64, 64);
        g.drawLine(0, 416, 480, 416, Color.BLACK);
    }
    
    public void drawText(Graphics g, String line, int x, int y) {
        int len = line.length();
        for (int i = 0; i < len; i++) {
            char character = line.charAt(i);

            if (character == ' ') {
                x += 20;
                continue;
            }

            int srcX = 0;
            int srcWidth = 0;
            if (character == '.') {
                srcX = 200;
                srcWidth = 10;
            } else {
                srcX = (character - '0') * 20;
                srcWidth = 20;
            }

            g.drawPixmap(Assets.numbers, x, y, srcX, 0, srcWidth, 32);
            x += srcWidth;
        }
    }
    
    @Override
    public void pause() {
        if(state == GameState.Running)
            state = GameState.Paused;
        
        if(world.gameOver) {
            Settings.addScore(world.score);
            Settings.save(game.getFileIO());
        }
    }

    @Override
    public void resume() {
        
    }

    @Override
    public void dispose() {
    	//state = GameState.Paused;
    	//world.musicStop();
    }
}