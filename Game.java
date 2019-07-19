package com.tutorial.mario;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

import com.tutorial.mario.entity.Player;
import com.tutorial.mario.gfx.Sprite;
import com.tutorial.mario.gfx.SpriteSheet;
import com.tutorial.mario.input.KeyInput;

public class Game extends Canvas implements Runnable {
	public static final int WIDTH = 300;
	public static final int HEIGHT = WIDTH/14*8;
	public static final int SCALE = 4;
	public static final String TITLE="MARIO";
	private Thread thread;
	private boolean running =false;
	public static Handler handler;
	public static SpriteSheet sheet;
	public static Sprite grass;
	public static Sprite player[]=new Sprite[10];
	
	public Game()
	{
		Dimension size = new Dimension(WIDTH*SCALE,HEIGHT*SCALE);
		setPreferredSize(size);
		setMaximumSize(size);
		setMinimumSize(size);
	}
    private void init()
    {
    	handler =new Handler();
    	sheet=new SpriteSheet("/spriteSheet.png");
    	addKeyListener(new KeyInput());
    	grass=new Sprite(sheet,2,1);
    	for(int i=0;i<player.length;i++)
    	{
    		player[i]=new Sprite(sheet,i+1,16);
    	}
        handler.addEntity(new Player(200,400,64,64,true,id.player,handler));
     
    }
	
	public synchronized void start()
	{
		if(running)
			return;
		running =true;
		thread=new Thread(this,"Thread");
		thread.start();
	}
	public synchronized void stop()
	{
		if(running)return;
		running=false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}	
	public void run()
	{
		init();
		requestFocus();
		long lastTime=System.nanoTime();//gets current time in nanoseconds
		long timer=System.currentTimeMillis();//time in milliseconds
		double delta=0.0;
		double ns=1000000000.0/60.0;
		int frames=0;
		int ticks=0;
		
		while(running)
		{
			long now=System.nanoTime();
			delta+=(now-lastTime)/ns;
			lastTime=now;
			while(delta>=1)
			{
				tick();
				ticks++;
				delta--;
			}
			render();
			frames++;
			if(System.currentTimeMillis()-timer>1000)
			{
					timer+=1000;
					System.out.println(frames+" Frames per Second "+ticks+" Updates per Second ");
					frames=0;
					ticks=0; 
			}
		}
		stop();		
	}
	
	
	
	public void render()//show the whole screen
	{
		BufferStrategy bs=getBufferStrategy();
		if(bs==null)
		{
			createBufferStrategy(3);
			return;
		}
		Graphics g=bs.getDrawGraphics();
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, getWidth(), getHeight());
		handler.render(g);
		g.dispose();
		bs.show();
		
	}
	public void tick()//update
	{
		handler.tick();
	}
	public static void main(String[] args)
	{
		Game game=new Game();
		JFrame frame=new JFrame(TITLE);
		frame.add(game);
		frame.pack();
		frame.setResizable(true);
	 	frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		game.start();
	}
}
