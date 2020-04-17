package com.eduask.model;

import java.awt.Toolkit;

import com.eduask.view.BaseFrame;
import com.eduask.view.MyPanel;

public class Enemy008 extends Enemy{

	public Enemy008(MyPanel mypanel) {
		super(mypanel);
		width = 60;
		height = 40;
		x = (int)(Math.random() * (BaseFrame.FrameWidth - width) );
		y = 0 - height;
		image = Toolkit.getDefaultToolkit().getImage("images/enemy08.png");
		speed = 2;
		hp = 8;
		pointer = 500;
		this.items = new Item[]{
				new Item004(mypanel),
				new Item002(mypanel),
				new Item002(mypanel)
		};
	}

}
