package com.badlogic.androidgames.heavymetalarkanoid;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.badlogic.androidgames.framework.Music;

import android.graphics.Color;

public class Maps {
	private int levelMax;
	
	public List<List> listMaps = new ArrayList<List>();
	public List<Music> musics = new ArrayList<Music>();
	
	private List<Brick> map1 = new ArrayList<Brick>();
    private List<Brick> map2 = new ArrayList<Brick>();
    private List<Brick> map3 = new ArrayList<Brick>();
    private List<Brick> map4 = new ArrayList<Brick>();
    
    private List<Integer> colors = new ArrayList<Integer>();
    
    public Maps(){
    	loadColors();
    	
    	Random generator = new Random();
    	/* MAP1*/
    	map1.add(new Brick(10, 100, colors.get(generator.nextInt(colors.size()))));
    	map1.add(new Brick(60, 100, colors.get(generator.nextInt(colors.size()))));
    	map1.add(new Brick(110, 100, colors.get(generator.nextInt(colors.size()))));
    	map1.add(new Brick(160, 100, colors.get(generator.nextInt(colors.size()))));
    	map1.add(new Brick(210, 100, colors.get(generator.nextInt(colors.size()))));
    	map1.add(new Brick(260, 100, colors.get(generator.nextInt(colors.size()))));
    	
    	map1.add(new Brick(60, 130, colors.get(generator.nextInt(colors.size()))));
    	map1.add(new Brick(110, 130, colors.get(generator.nextInt(colors.size()))));
    	map1.add(new Brick(160, 130, colors.get(generator.nextInt(colors.size()))));
    	map1.add(new Brick(210, 130, colors.get(generator.nextInt(colors.size()))));
    	
    	map1.add(new Brick(110, 160, colors.get(generator.nextInt(colors.size()))));
    	map1.add(new Brick(160, 160, colors.get(generator.nextInt(colors.size()))));
    	
    	map1.add(new Brick(10, 190, colors.get(generator.nextInt(colors.size()))));
    	map1.add(new Brick(260, 190, colors.get(generator.nextInt(colors.size()))));

    	// MAP2 
    	map2.add(new Brick(10, 10, colors.get(generator.nextInt(colors.size()))));
    	map2.add(new Brick(60, 10, colors.get(generator.nextInt(colors.size()))));
    	//map2.add(new Brick(110, 10, colors.get(generator.nextInt(colors.size()))));
    	//map2.add(new Brick(160, 10, colors.get(generator.nextInt(colors.size()))));
    	map2.add(new Brick(210, 10, colors.get(generator.nextInt(colors.size()))));
    	map2.add(new Brick(260, 10, colors.get(generator.nextInt(colors.size()))));
    	map2.add(new Brick(10, 50, colors.get(generator.nextInt(colors.size()))));
    	map2.add(new Brick(60, 50, colors.get(generator.nextInt(colors.size()))));
    	//map2.add(new Brick(110, 50, colors.get(generator.nextInt(colors.size()))));
    	//map2.add(new Brick(160, 50, colors.get(generator.nextInt(colors.size()))));
    	map2.add(new Brick(210, 50, colors.get(generator.nextInt(colors.size()))));
    	map2.add(new Brick(260, 50, colors.get(generator.nextInt(colors.size()))));
    	map2.add(new Brick(10, 90, colors.get(generator.nextInt(colors.size()))));
    	map2.add(new Brick(60, 90, colors.get(generator.nextInt(colors.size()))));
    	//map2.add(new Brick(110, 90, colors.get(generator.nextInt(colors.size()))));
    	//map2.add(new Brick(160, 90, colors.get(generator.nextInt(colors.size()))));
    	map2.add(new Brick(210, 90, colors.get(generator.nextInt(colors.size()))));
    	map2.add(new Brick(260, 90, colors.get(generator.nextInt(colors.size()))));
    	map2.add(new Brick(10, 140, colors.get(generator.nextInt(colors.size()))));
    	map2.add(new Brick(60, 140, colors.get(generator.nextInt(colors.size()))));
    	//map2.add(new Brick(110, 90, colors.get(generator.nextInt(colors.size()))));
    	//map2.add(new Brick(160, 90, colors.get(generator.nextInt(colors.size()))));
    	map2.add(new Brick(210, 140, colors.get(generator.nextInt(colors.size()))));
    	map2.add(new Brick(260, 140, colors.get(generator.nextInt(colors.size()))));
    	//  MAP3
    
    	map3.add(new Brick(210, 10, colors.get(generator.nextInt(colors.size()))));
    	map3.add(new Brick(60, 30, colors.get(generator.nextInt(colors.size()))));
    	map3.add(new Brick(210, 30, colors.get(generator.nextInt(colors.size()))));
    	
    	map3.add(new Brick(60, 60, colors.get(generator.nextInt(colors.size()))));
    	map3.add(new Brick(210, 60, colors.get(generator.nextInt(colors.size()))));
    	
    	map3.add(new Brick(60, 90, colors.get(generator.nextInt(colors.size()))));
    	map3.add(new Brick(110, 90, colors.get(generator.nextInt(colors.size()))));
    	map3.add(new Brick(160, 90, colors.get(generator.nextInt(colors.size()))));
    	map3.add(new Brick(210, 90, colors.get(generator.nextInt(colors.size()))));
    	map3.add(new Brick(260, 90, colors.get(generator.nextInt(colors.size()))));
    	
    	map3.add(new Brick(60, 120, colors.get(generator.nextInt(colors.size()))));
    	map3.add(new Brick(110, 120, colors.get(generator.nextInt(colors.size()))));
    	map3.add(new Brick(160, 120, colors.get(generator.nextInt(colors.size()))));
    	map3.add(new Brick(210, 120, colors.get(generator.nextInt(colors.size()))));
    	map3.add(new Brick(260, 120, colors.get(generator.nextInt(colors.size()))));
    	
    	map3.add(new Brick(60, 150, colors.get(generator.nextInt(colors.size()))));
    	map3.add(new Brick(110, 150, colors.get(generator.nextInt(colors.size()))));
    	map3.add(new Brick(160, 150, colors.get(generator.nextInt(colors.size()))));
    	map3.add(new Brick(210, 150, colors.get(generator.nextInt(colors.size()))));
    	map3.add(new Brick(260, 150, colors.get(generator.nextInt(colors.size()))));
    	
    	map3.add(new Brick(110, 180, colors.get(generator.nextInt(colors.size()))));
    	map3.add(new Brick(160, 180, colors.get(generator.nextInt(colors.size()))));
    	map3.add(new Brick(210, 180, colors.get(generator.nextInt(colors.size()))));
    	
    	map3.add(new Brick(110, 210, colors.get(generator.nextInt(colors.size()))));
    	map3.add(new Brick(160, 210, colors.get(generator.nextInt(colors.size()))));
    	map3.add(new Brick(210, 210, colors.get(generator.nextInt(colors.size()))));
    	
    	// MAP4 
    	
    	map4.add(new Brick(10, 10, colors.get(generator.nextInt(colors.size()))));
    	map4.add(new Brick(60, 10, colors.get(generator.nextInt(colors.size()))));
    	map4.add(new Brick(110, 10, colors.get(generator.nextInt(colors.size()))));
    	map4.add(new Brick(160, 10, colors.get(generator.nextInt(colors.size()))));
    	map4.add(new Brick(210, 10, colors.get(generator.nextInt(colors.size()))));
    	map4.add(new Brick(260, 10, colors.get(generator.nextInt(colors.size()))));
    	map4.add(new Brick(1, 60, colors.get(generator.nextInt(colors.size()))));
    	map4.add(new Brick(60, 60, colors.get(generator.nextInt(colors.size()))));
    	map4.add(new Brick(110, 60, colors.get(generator.nextInt(colors.size()))));
    	map4.add(new Brick(160, 60, colors.get(generator.nextInt(colors.size()))));
    	map4.add(new Brick(210, 60, colors.get(generator.nextInt(colors.size()))));
    	map4.add(new Brick(260, 60, colors.get(generator.nextInt(colors.size()))));
    	map4.add(new Brick(10, 110, colors.get(generator.nextInt(colors.size()))));
    	map4.add(new Brick(60, 110, colors.get(generator.nextInt(colors.size()))));
    	map4.add(new Brick(110, 110, colors.get(generator.nextInt(colors.size()))));
    	map4.add(new Brick(160, 110, colors.get(generator.nextInt(colors.size()))));
    	map4.add(new Brick(210, 110, colors.get(generator.nextInt(colors.size()))));
    	map4.add(new Brick(260, 110, colors.get(generator.nextInt(colors.size()))));
    	map4.add(new Brick(10, 160, colors.get(generator.nextInt(colors.size()))));
    	map4.add(new Brick(60, 160, colors.get(generator.nextInt(colors.size()))));
    	map4.add(new Brick(110, 160, colors.get(generator.nextInt(colors.size()))));
    	map4.add(new Brick(160, 160, colors.get(generator.nextInt(colors.size()))));
    	map4.add(new Brick(210, 160, colors.get(generator.nextInt(colors.size()))));
    	map4.add(new Brick(260, 160, colors.get(generator.nextInt(colors.size()))));
    	map4.add(new Brick(10, 210, colors.get(generator.nextInt(colors.size()))));
    	map4.add(new Brick(60, 210, colors.get(generator.nextInt(colors.size()))));
    	map4.add(new Brick(110, 210, colors.get(generator.nextInt(colors.size()))));
    	map4.add(new Brick(160, 210, colors.get(generator.nextInt(colors.size()))));
    	map4.add(new Brick(210, 210, colors.get(generator.nextInt(colors.size()))));
    	map4.add(new Brick(260, 210, colors.get(generator.nextInt(colors.size()))));
    	map4.add(new Brick(10, 260, colors.get(generator.nextInt(colors.size()))));
    	map4.add(new Brick(60, 260, colors.get(generator.nextInt(colors.size()))));
    	map4.add(new Brick(110, 260, colors.get(generator.nextInt(colors.size()))));
    	map4.add(new Brick(160, 260, colors.get(generator.nextInt(colors.size()))));
    	map4.add(new Brick(210, 260, colors.get(generator.nextInt(colors.size()))));
    	map4.add(new Brick(260, 260, colors.get(generator.nextInt(colors.size()))));
    	map4.add(new Brick(10, 310, colors.get(generator.nextInt(colors.size()))));
    	map4.add(new Brick(60, 310, colors.get(generator.nextInt(colors.size()))));
    	map4.add(new Brick(110, 310, colors.get(generator.nextInt(colors.size()))));
    	map4.add(new Brick(160, 310, colors.get(generator.nextInt(colors.size()))));
    	map4.add(new Brick(210, 310, colors.get(generator.nextInt(colors.size()))));
    	map4.add(new Brick(260, 310, colors.get(generator.nextInt(colors.size()))));

    	listMaps.add(map1);
    	listMaps.add(map2);
    	listMaps.add(map3);
    	listMaps.add(map4);
    	
    	musics.add(Assets.stage1Music);
        musics.add(Assets.stage2Music);
        musics.add(Assets.stage3Music);
        musics.add(Assets.stage3Music);
    	
    	levelMax = listMaps.size();
    }
    
    public void loadColors(){
    	colors.add(Color.WHITE);
    	colors.add(Color.BLACK);
    	colors.add(Color.BLUE);
    	colors.add(Color.CYAN);
    	colors.add(Color.GRAY);
    	colors.add(Color.LTGRAY);
    	colors.add(Color.MAGENTA);
    	colors.add(Color.RED);
    	colors.add(Color.WHITE);
    	colors.add(Color.YELLOW);
    }
    
    public int totalMaps(){
    	return levelMax;
    }
}
