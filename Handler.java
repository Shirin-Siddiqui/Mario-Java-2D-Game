package com.tutorial.mario;

import java.awt.Graphics;
import java.util.LinkedList;

import com.tutorial.mario.entity.entity;
import com.tutorial.mario.tile.Wall;
import com.tutorial.mario.tile.tile;

public class Handler {
	public LinkedList<entity> Entity=new LinkedList<entity>();
	public LinkedList<tile> Tile=new LinkedList<tile>();
	public Handler()
	{
		createlevel();
	}
	public void render(Graphics g)
	{
		for(entity en:Entity)
		{
			en.render(g);
		}
		for(tile t:Tile)
		{
			t.render(g);
		}
	}
	public void tick()
	{
		for(entity en:Entity)
		{
			en.tick();
		}
		for(tile t:Tile)
		{
			t.tick();
		}
		
	}
	public void addEntity(entity en)
	{
		Entity.add(en);
	}
	public void removeEntity(entity en)
	{
		Entity.remove(en);
	}
	public void addTile(tile t)
	{
		Tile.add(t);
	}
	public void removeTile(tile t)
	{
		Tile.remove(t);
	}
	public void createlevel()
	{
		for(int i=0;i<Game.WIDTH*Game.SCALE/64+1;i++)
		{
			addTile(new Wall(i*64,Game.HEIGHT*Game.SCALE-64,64,64,true,id.wall,this));
			if(i!=0&&i!=1&&i!=15&&i!=16&&i!=17) addTile(new Wall(i*64,300,64,64,true,id.wall,this));
		}
	}

}
