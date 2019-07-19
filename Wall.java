package com.tutorial.mario.tile;

import java.awt.Color;
import java.awt.Graphics;

import com.tutorial.mario.Game;
import com.tutorial.mario.Handler;
import com.tutorial.mario.id;

public class Wall extends tile{

	public Wall(int x, int y, int width, int height, boolean solid, id ID, Handler handler) {
		super(x, y, width, height, solid, ID, handler);
		
	}

	
	public void render(Graphics g) {
		g.drawImage(Game.grass.getBufferedImage(),x,y,width,height,null);
	}

	
	public void tick() {
	
		
	}

}
