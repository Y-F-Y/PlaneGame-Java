package com.eduask.model;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import com.eduask.thread.BulletThread;
import com.eduask.view.BaseFrame;
import com.eduask.view.MyPanel;


public abstract class Enemy {

	public int width;
	public int height;
	public int x;
	public int y;
	public Image image;
	public MyPanel mypanel;
	public int speed;
	public int hp;
	public int pointer = 0;
	public Image[] images = new Image[]{
			Toolkit.getDefaultToolkit().getImage("images/die01.png"),
			Toolkit.getDefaultToolkit().getImage("images/die02.png"),
			Toolkit.getDefaultToolkit().getImage("images/die03.png"),
			Toolkit.getDefaultToolkit().getImage("images/die04.png")
	};
	public int imageIndex = 0;
	public Item[] items = null;
	
	public Enemy(MyPanel mypanel){
		this.mypanel = mypanel;
	}
	//敌机
	public void drawSelf(Graphics g){
		
		if( hp > 0 )
		{
			g.drawImage(image, x, y, width, height, null);
		}
		else
		{
			x = x + width/2 - 22;
			y = y + height / 2 - 22;
			width = 45;
			height = 45;
			g.drawImage(images[imageIndex], x, y, width, height, null);
			if( mypanel.timer % 10 == 0 )
			{
				imageIndex++;
				if( imageIndex >= images.length ){
					// 被打死了
					killed();
					new BulletThread("video/boom.wav").start();
				}
			}
		}
		
		if( mypanel.timer % speed == 0 ){
			y++;
			if( y > BaseFrame.FrameHeight ){
				mypanel.enemies.remove(this);
			}
		}
	}
	public void killed(){
		mypanel.player.pointer += this.pointer;
		if( items != null && items.length > 0 )
		{
			for( int i = 0 ; i <= items.length - 1; i++ )
			{
				Item item = items[i];
				item.y = this.y;
				if( i == 0 ){
					item.x = this.x + this.width / 2 - item.width/2;
				}else if(i == 1){
					item.x = this.x + this.width / 2 - item.width/2 - item.width - 10;
				}else if( i == 3){
					item.x = this.x + this.width / 2 - item.width/2 - item.width * 2 - 20;
				}else if(i == 2){
					item.x = this.x + this.width / 2 - item.width/2 + item.width + 10;
				} else if( i == 4 ){
					item.x = this.x + this.width / 2 - item.width/2+ item.width * 2 + 20;
				}
				mypanel.items.add(item);
			}
		}
		mypanel.enemies.remove(this);
		
		
	}
	public void underAttact(){
		if( hp > 0  ){hp--;}
	}
	
}
