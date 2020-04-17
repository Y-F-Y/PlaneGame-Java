package com.eduask.model;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import com.eduask.thread.BulletThread;
import com.eduask.view.BaseFrame;
import com.eduask.view.MyPanel;




public class Bullet {
	public int width;
	public int height;
	public int x;
	public int y;
	//×Óµ¯Í¼Æ¬
	public Image[] images = new Image[]{
			Toolkit.getDefaultToolkit().getImage("images/bullet01.png"),
			Toolkit.getDefaultToolkit().getImage("images/bullet02.png"),
			Toolkit.getDefaultToolkit().getImage("images/bullet03.png"),
			Toolkit.getDefaultToolkit().getImage("images/bullet04.png"),
			Toolkit.getDefaultToolkit().getImage("images/bullet05.png"),
			Toolkit.getDefaultToolkit().getImage("images/bullet06.png")
	};
	public int imageIndex = 0;
	public MyPanel mypanel;
	
	public Bullet(MyPanel mypanel){
		
		this.mypanel = mypanel;
		width = 8;
		height = 8;
		
	}
	
	public void drawSelf(Graphics g){
		
		g.drawImage(images[imageIndex], x, y, width, height, null);
		if( mypanel.timer % 1 == 0 )
		{
			imageIndex++;
			y--;
			if( imageIndex >= images.length ){
				imageIndex = 0;
			}
			if(y<0){
				mypanel.bullets.remove(this);
				
			}
		}
		
		// ÅÐ¶Ï×Óµ¯ÊÇ·ñ»÷ÖÐµÐÈË
		for( int i = 0 ; i <= mypanel.enemies.size() - 1; i++ )
		{
			Enemy e = mypanel.enemies.get(i);
			if( e.hp <= 0 ){continue;}
			if( x >= e.x - width && x <= e.x + e.width && y >= e.y - height && y <= e.y + e.height ){
				mypanel.bullets.remove(this);
				e.underAttact();
				
			}
			
		}
		
	}
	
}
