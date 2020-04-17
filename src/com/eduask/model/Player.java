package com.eduask.model;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import com.eduask.view.BaseFrame;
import com.eduask.view.MyPanel;

public class Player {
	//玩家的设置
	public int width;
	public int height;
	public int x;
	public int y;
	   //火力等级
	public Image[] images = new Image[]{
			Toolkit.getDefaultToolkit().getImage("images/player01.png"),
			Toolkit.getDefaultToolkit().getImage("images/player02.png"),
			Toolkit.getDefaultToolkit().getImage("images/player04.png"),
			Toolkit.getDefaultToolkit().getImage("images/player05.png"),
			Toolkit.getDefaultToolkit().getImage("images/player06.png"),
			Toolkit.getDefaultToolkit().getImage("images/player08.png"),
			Toolkit.getDefaultToolkit().getImage("images/player09.png")
	};
	  //玩家的位置
	public int imageIndex = 0;
	public MyPanel mypanel;
	public int pointer = 0;
	public int attactMode = 0;
	public int powerTime = 0;
	
	public Player(MyPanel mypanel){
		this.mypanel = mypanel;
		width = 100;
		height = 100;
		x = ( BaseFrame.FrameWidth - width ) / 2;
		y = BaseFrame.FrameHeight - height * 2;
	}
	//俺的机机
	public void drawSelf(Graphics g){
		g.drawImage(images[imageIndex], x, y, width, height, null);
		
		if( mypanel.timer % 50 == 0 )
		{
			imageIndex++;
			if( imageIndex >= images.length ){
				imageIndex = 0;
			}
		}
		
		// 攻击时间
		if( this.attactMode > 1 ){
			if( this.powerTime > 0 ){
				this.powerTime--;
				if( this.powerTime <= 0 ){
					this.attactMode = 1;
				}
			}
		}
		
		// 判断是否吃到道具
		for( int i = 0 ; i <= mypanel.items.size() - 1; i++ )
		{
			Item item = mypanel.items.get(i);
			if( this.x >= item.x - this.width && this.x <= item.x + item.width && this.y >= item.y - this.height && this.y <= item.y + item.height )
			{
				item.eated();
			}
		}
		
	}
	
}
