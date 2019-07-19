package com.tutorial.mario.tile;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.tutorial.mario.Handler;
import com.tutorial.mario.id;

public abstract class tile {
	public int x,y;
	public int width,height;
	public boolean solid;
	public int velx,vely;
	public id ID;
	public Handler handler;
	
	public tile (int x,int y,int width,int height,boolean solid,id ID, Handler handler){
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
		this.solid=solid;
		this.ID=ID;
		this.handler=handler;
	}
	public abstract void render(Graphics g);
	public abstract void tick();
	public void die()
	{
		handler.removeTile(this);
	}
	public int getX() {
		return x;
	}
	public void setX(int x) { 
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public id getid()
	{
		return ID;
	}
	public boolean isSolid() {
		return solid;
	}
	
	public void setVelx(int velx) {
		this.velx = velx;
	}
	
	public void setVely(int vely) {
		this.vely = vely;
	}
	
	public Rectangle getBounds()
	{
		return new Rectangle(getX(),getY(),width,height);
	
	}
}
