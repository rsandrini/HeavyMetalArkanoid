package com.badlogic.androidgames.heavymetalarkanoid;

import java.util.ArrayList;
import java.util.List;

public class Maps {
	private int levelMax;
	
	public List<List> listMaps = new ArrayList<List>();
	private List<Brick> map1 = new ArrayList<Brick>();
    private List<Brick> map2 = new ArrayList<Brick>();
    private List<Brick> map3 = new ArrayList<Brick>();
    
    public Maps(){
    	
    	/* MAP1*/
    	map1.add(new Brick(60, 50, Assets.brick));
    	map1.add(new Brick(110, 50, Assets.brick));
    	map1.add(new Brick(160, 50, Assets.brick));
    	map1.add(new Brick(210, 50, Assets.brick));
    	map1.add(new Brick(260, 50, Assets.brick));
    	map1.add(new Brick(10, 100, Assets.brick));
    	map1.add(new Brick(60, 100, Assets.brick));
    	map1.add(new Brick(210, 100, Assets.brick));
    	map1.add(new Brick(260, 100, Assets.brick));
    	
    	map1.add(new Brick(210, 160, Assets.brick));
    	map1.add(new Brick(210, 160, Assets.brick));
    	map1.add(new Brick(210, 160, Assets.brick));
    	map1.add(new Brick(210, 160, Assets.brick));
    	
    	/* MAP2*/
    	map2.add(new Brick(10, 10, Assets.brick));
    	map2.add(new Brick(60, 100, Assets.brick));
    	map2.add(new Brick(210, 10, Assets.brick));
    	map2.add(new Brick(260, 100, Assets.brick));
    	map2.add(new Brick(60, 10, Assets.brick));
    	map2.add(new Brick(210, 100, Assets.brick));
    	map2.add(new Brick(110, 10, Assets.brick));
    	map2.add(new Brick(160, 100, Assets.brick));
    	
    	map2.add(new Brick(110, 200, Assets.brick));
    	map2.add(new Brick(160, 200, Assets.brick));
    	map2.add(new Brick(210, 200, Assets.brick));
    	
    	/* MAP3*/
    	map3.add(new Brick(210, 10, Assets.brick));
    	
    	map3.add(new Brick(60, 30, Assets.brick));
    	map3.add(new Brick(210, 30, Assets.brick));
    	
    	map3.add(new Brick(60, 60, Assets.brick));
    	map3.add(new Brick(210, 60, Assets.brick));
    	
    	map3.add(new Brick(60, 90, Assets.brick));
    	map3.add(new Brick(110, 90, Assets.brick));
    	map3.add(new Brick(160, 90, Assets.brick));
    	map3.add(new Brick(210, 90, Assets.brick));
    	map3.add(new Brick(260, 90, Assets.brick));
    	
    	map3.add(new Brick(60, 120, Assets.brick));
    	map3.add(new Brick(110, 120, Assets.brick));
    	map3.add(new Brick(160, 120, Assets.brick));
    	map3.add(new Brick(210, 120, Assets.brick));
    	map3.add(new Brick(260, 120, Assets.brick));
    	
    	map3.add(new Brick(60, 150, Assets.brick));
    	map3.add(new Brick(110, 150, Assets.brick));
    	map3.add(new Brick(160, 150, Assets.brick));
    	map3.add(new Brick(210, 150, Assets.brick));
    	map3.add(new Brick(260, 150, Assets.brick));
    	
    	map3.add(new Brick(110, 180, Assets.brick));
    	map3.add(new Brick(160, 180, Assets.brick));
    	map3.add(new Brick(210, 180, Assets.brick));
    	
    	map3.add(new Brick(110, 210, Assets.brick));
    	map3.add(new Brick(160, 210, Assets.brick));
    	map3.add(new Brick(210, 210, Assets.brick));
    	
    	listMaps.add(map1);
    	listMaps.add(map2);
    	listMaps.add(map3);
    	
    	levelMax = listMaps.size();
    }
    
    public int totalMaps(){
    	return levelMax;
    }
}
