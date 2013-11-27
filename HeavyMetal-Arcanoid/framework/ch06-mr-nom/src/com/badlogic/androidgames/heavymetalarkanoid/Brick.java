package com.badlogic.androidgames.heavymetalarkanoid;

import com.badlogic.androidgames.framework.Pixmap;

public class Brick {
    public int x, y;
    public Pixmap image; 
    
    public Brick(int x, int y, Pixmap image) {
        this.x = x;
        this.y = y;
        this.image = image;
    }
}       

