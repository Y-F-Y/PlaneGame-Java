package com.eduask.model;

import java.awt.Toolkit;

import com.eduask.view.BaseFrame;
import com.eduask.view.MyPanel;

public class Enemy007 extends Enemy{

	public Enemy007(MyPanel mypanel) {
		super(mypanel);
		width = 90;
		height = 60;
		x = (int)(Math.random() * (BaseFrame.FrameWidth - width) );
		y = 0 - height;
		image = Toolkit.getDefaultToolkit().getImage("images/enemy07.png");
		speed = 2;
		hp = 6;
		pointer = 500;
		this.items = new Item[]{
				new Item004(mypanel),
				new Item001(mypanel),
				new Item001(mypanel),
				new Item001(mypanel),
				new Item001(mypanel)
		};
	}

}
