package com.tutorial.mario.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.tutorial.mario.Game;
import com.tutorial.mario.entity.entity;

public class KeyInput  implements KeyListener{

	
	public void keyPressed(KeyEvent e) {
		int key=e.getKeyCode();
		for(entity en:Game.handler.Entity)
		{
			switch(key)
			{
			case KeyEvent.VK_W:
				if(!en.jumping){
					en.jumping=true;
					en.gravity=9.0;
					
					}
				
				break;
			
			case KeyEvent.VK_A:
				en.setVelx(-5);
				en.facing=0;
				break;
			case KeyEvent.VK_D:
				en.setVelx(5);
				en.facing=1;
				break;
					
			}
		}
	}

	
	public void keyReleased(KeyEvent e) {
		int key=e.getKeyCode();
		
	}

	
	public void keyTyped(KeyEvent arg0) {
	
		
	}

}
