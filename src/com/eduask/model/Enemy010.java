package com.eduask.model;

import java.awt.Toolkit;

import com.eduask.view.BaseFrame;
import com.eduask.view.MyPanel;

public class Enemy010 extends Enemy{

	public Enemy010(MyPanel mypanel) {
		super(mypanel);
		width = 130;
		height = 100;
		x = (int)(Math.random() * (BaseFrame.FrameWidth - width) );
		y = 0 - height;
		image = Toolkit.getDefaultToolkit().getImage("images/2.jpg");
		speed = 3;
		hp = 18;
		pointer = 2000;
		this.items = new Item[]{
				new Item005(mypanel),
				new Item002(mypanel),
				new Item002(mypanel),
				new Item002(mypanel),
				new Item002(mypanel)
		};
	}

}
