package com.eduask.model;

import java.awt.Toolkit;

import com.eduask.view.BaseFrame;
import com.eduask.view.MyPanel;

public class Enemy006 extends Enemy {
	public Enemy006(MyPanel mypanel) {
		super(mypanel);
		width = 100;
		height = 65;
		x = (int)(Math.random() * (BaseFrame.FrameWidth - width) );
		y = 0 - height;
		image = Toolkit.getDefaultToolkit().getImage("images/enemy06.png");
		speed = 3;
		hp = 8;
		pointer = 500;
		this.items = new Item[]{
				new Item003(mypanel),
				new Item001(mypanel),
				new Item001(mypanel),
				new Item001(mypanel),
				new Item001(mypanel)
		};
	}
}
