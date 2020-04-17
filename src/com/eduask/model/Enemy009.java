package com.eduask.model;

import java.awt.Toolkit;

import com.eduask.view.BaseFrame;
import com.eduask.view.MyPanel;

public class Enemy009 extends Enemy{

	public Enemy009(MyPanel mypanel) {
		super(mypanel);
		width = 124;
		height = 100;
		x = (int)(Math.random() * (BaseFrame.FrameWidth - width) );
		y = 0 - height;
		image = Toolkit.getDefaultToolkit().getImage("images/122.jpg");
		speed = 2;
		hp = 15;
		pointer = 2000;
		this.items = new Item[]{
				new Item005(mypanel),
				new Item003(mypanel),
				new Item003(mypanel),
				new Item001(mypanel),
				new Item001(mypanel)
		};
	}

}
