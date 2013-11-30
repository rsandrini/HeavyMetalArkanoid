package com.badlogic.androidgames.heavymetalarkanoid;

import java.util.List;

import com.badlogic.androidgames.framework.Game;
import com.badlogic.androidgames.framework.Graphics;
import com.badlogic.androidgames.framework.Screen;
import com.badlogic.androidgames.framework.Input.TouchEvent;

public class HelpScreen2 extends Screen {

    public HelpScreen2(Game game) {
        super(game);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void update(float deltaTime) {
    	if (Settings.soundEnabled && !Assets.help2Music.isPlaying())
    		Assets.help2Music.play();
    	
        List<TouchEvent> touchEvents = game.getInput().getTouchEvents();
        game.getInput().getKeyEvents();
        
        Graphics g = game.getGraphics();
        int len = touchEvents.size();
        for(int i = 0; i < len; i++) {
            TouchEvent event = touchEvents.get(i);
            if(event.type == TouchEvent.TOUCH_UP) {
                if(event.x > g.getWidth() - 64 && event.y > g.getHeight() - 64 ) {
                	if (Assets.help2Music.isPlaying())
                		Assets.help2Music.stop();
                    game.setScreen(new HelpScreen3(game));
                    if(Settings.soundEnabled)
                        Assets.click.play(1);
                    return;
                }
            }
        }
    }

    @Override
    public void present(float deltaTime) {
        Graphics g = game.getGraphics();      
        g.drawPixmap(Assets.background, 0, 0);
        g.drawPixmap(Assets.help2, 32, 100);
        g.drawPixmap(Assets.buttons, 256, 416, 64, 64, 64, 64);
    }

    @Override
    public void pause() {
        // TODO Auto-generated method stub

    }

    @Override
    public void resume() {
        // TODO Auto-generated method stub

    }

    @Override
    public void dispose() {
    	if (Assets.help2Music.isPlaying())
    		Assets.help2Music.stop();

    }

}