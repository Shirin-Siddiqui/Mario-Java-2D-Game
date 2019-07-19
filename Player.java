package com.tutorial.mario.entity;

import java.awt.Color;
import java.awt.Graphics;

import com.tutorial.mario.Game;
import com.tutorial.mario.Handler;
import com.tutorial.mario.id;
import com.tutorial.mario.tile.tile;

public class Player extends entity {
	private int frame=0;
	private int frameDelay=0;
	private boolean animate=false;
	public Player(int x, int y, int width, int height, boolean solid, id ID, Handler handler)
	{
		super(x, y, width, height, solid, ID, handler);
		
	}

	
	public void render(Graphics g) {
		if(facing ==0)
		{
			g.drawImage(Game.player[frame+5].getBufferedImage(),x,y,width,height,null);
		}
		else if(facing==1)
		{
			g.drawImage(Game.player[frame].getBufferedImage(),x,y,width,height,null);
		}
	}

	public void tick() {
		x+=velx;
		y+=vely;
		if(x<=0)x=0;
		
		if(x+width>=1200) x=1200-width;
		if(y+height>=686) y=686-height;
		if(velx!=0)animate=true;
		else animate=false;
		for(tile t:handler.Tile){
			if(!t.solid)break;
			if(t.getid()==id.wall){
				if(getBoundsTop().intersects(t.getBounds()))
				{
					setVely(0);
					if(jumping){
						jumping=false;
						gravity=0.10;
						falling=true;
					}
				}
				if(getBoundsBottom().intersects(t.getBounds()))
				{
					setVely(0);
					if(falling)falling=false;
				}else{
						if(!falling&&!jumping)
						{
							gravity=0.10;
							falling=true;
						}
					}
				
				if(getBoundsLeft().intersects(t.getBounds()))
				{
					setVelx(0);
					x=t.getX()+t.width;
				}
				if(getBoundsRight().intersects(t.getBounds()))
				{
					setVelx(0);
					x=t.getX()-t.width;
				}
				}
			}
		if(jumping){
			gravity-=0.1;
			setVely((int)-gravity);
			if(gravity<=0.0){
				jumping =false;
				falling=true;
			}
		}
		if(falling){
			gravity+=0.1;
			setVely((int)gravity);
		}
		if(animate)
		{
			frameDelay++;
			if(frameDelay>=3)
			{
				frame++;
				if(frame>=5){
					frame=0;
				}
				frameDelay=0;
			}
				
		}
		
		}
	}
	

