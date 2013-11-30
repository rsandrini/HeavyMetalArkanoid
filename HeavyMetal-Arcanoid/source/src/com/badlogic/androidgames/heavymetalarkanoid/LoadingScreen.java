package com.badlogic.androidgames.heavymetalarkanoid;

import com.badlogic.androidgames.framework.Game;
import com.badlogic.androidgames.framework.Graphics;
import com.badlogic.androidgames.framework.Screen;
import com.badlogic.androidgames.framework.Graphics.PixmapFormat;

public class LoadingScreen extends Screen {
    public LoadingScreen(Game game) {
        super(game);
    }

    @Override
    public void update(float deltaTime) {
        Graphics g = game.getGraphics();
        Assets.background = g.newPixmap("background.png", PixmapFormat.RGB565);
        Assets.logo = g.newPixmap("logo.png", PixmapFormat.ARGB4444);
        Assets.mainMenu = g.newPixmap("mainmenu.png", PixmapFormat.ARGB4444);
        Assets.buttons = g.newPixmap("buttons.png", PixmapFormat.ARGB4444);
        Assets.help1 = g.newPixmap("help1.png", PixmapFormat.ARGB4444);
        Assets.help2 = g.newPixmap("help2.png", PixmapFormat.ARGB4444);
        Assets.help3 = g.newPixmap("help3.png", PixmapFormat.ARGB4444);
        Assets.numbers = g.newPixmap("numbers.png", PixmapFormat.ARGB4444);
        Assets.ready = g.newPixmap("ready.png", PixmapFormat.ARGB4444);
        Assets.pause = g.newPixmap("pausemenu.png", PixmapFormat.ARGB4444);
        Assets.gameOver = g.newPixmap("gameover.png", PixmapFormat.ARGB4444);
        Assets.racket = g.newPixmap("racket.png", PixmapFormat.ARGB4444);
        Assets.ball = g.newPixmap("ball.png", PixmapFormat.ARGB4444);
        
        Assets.click = game.getAudio().newSound("sounds/click.mp3");
        Assets.eat = game.getAudio().newSound("sounds/eat.mp3");
        
        Assets.gameOverMusic = game.getAudio().newSound("sounds/gameover.mp3");
        
        Assets.introMusic = game.getAudio().newMusic("sounds/intro.mp3");
        Assets.stage1Music = game.getAudio().newMusic("sounds/fase1.mp3");
        Assets.stage2Music = game.getAudio().newMusic("sounds/fase2.mp3");
        Assets.stage3Music  = game.getAudio().newMusic("sounds/fase3.mp3");
        Assets.help1Music = game.getAudio().newMusic("sounds/help1.mp3");
        Assets.help2Music = game.getAudio().newMusic("sounds/help2.mp3");
        Assets.help3Music = game.getAudio().newMusic("sounds/help3.mp3");
        Assets.rankingMusic = game.getAudio().newMusic("sounds/ranking.mp3");
        Assets.AboutMusic = game.getAudio().newMusic("sounds/sobre.mp3");
        
        Settings.load(game.getFileIO());
        game.setScreen(new MainMenuScreen(game));
    }

    @Override
    public void present(float deltaTime) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }
}