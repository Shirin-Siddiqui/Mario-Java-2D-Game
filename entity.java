package com.tutorial.mario.entity;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.tutorial.mario.Handler;
import com.tutorial.mario.id;

public abstract class entity {
	public int x,y;
	public int width,height;
	public int facing=0;  //0-Left  1-Right
	public boolean jumping =false;
	public boolean falling=true;
	public boolean solid;
	public int velx,vely;
	
	public id ID;
	public double gravity=0.0;
	public Handler handler;
	public entity(int x,int y,int width,int height,boolean solid, id ID, Handler handler){
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
		handler.removeEntity(this);
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
	public Rectangle getBoundsTop()
	{
		return new Rectangle(getX()+10,getY(),width-20,5);
	}
	public Rectangle getBoundsBottom()
	{
		return new Rectangle(getX()+10,getY()+height-5,width-20,5);
	}
	public Rectangle getBoundsLeft()
	{
		return new Rectangle(getX(),getY()+10,5,height-20);
	}
	public Rectangle getBoundsRight()
	{
		return new Rectangle(getX()+width-5,getY()+10,5,height-20);
	}
}  
