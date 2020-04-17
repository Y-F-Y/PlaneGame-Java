package com.eduask.model;

import java.awt.Graphics;
import java.awt.Image;

import com.eduask.view.BaseFrame;
import com.eduask.view.MyPanel;

public abstract class Item {

	public int width;
	public int height;
	public int x;
	public int y;
	public Image[] images;
	public int imageIndex = 0;
	public MyPanel mypanel;
	public int pointer;
	public int attactMode = 1;
	public int powerTime = 0;
	public int speed;
	public int imageSpeed;
	
	public Item(MyPanel mypanel){
		this.mypanel = mypanel;
		imageSpeed = (int)(Math.random() * 20 + 20);
	}
	
	public void drawSelf(Graphics g){
		g.drawImage(images[imageIndex], x, y, width, height, null);
		if( mypanel.timer % imageSpeed == 0 )
		{
			imageIndex++;
			if( imageIndex >= images.length ){
				imageIndex = 0;
			}
		}
		if( mypanel.timer % speed == 0 ){
			y++;
			if( y > BaseFrame.FrameHeight ){
				mypanel.enemies.remove(this);
			}
		}
	}
	
	public void eated(){
		
		mypanel.player.pointer += this.pointer;
		
		if( this.attactMode >= mypanel.player.attactMode ){
			mypanel.player.attactMode = this.attactMode;
			mypanel.player.powerTime = this.powerTime;
		}
		
		mypanel.items.remove(this);
		System.gc();
	}
	
}
