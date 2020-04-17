package com.eduask.model;

import java.awt.Toolkit;

import com.eduask.view.BaseFrame;
import com.eduask.view.MyPanel;

public class Enemy005 extends Enemy {
	public Enemy005(MyPanel mypanel) {
		super(mypanel);
		width = 50;
		height = 36;
		x = (int)(Math.random() * (BaseFrame.FrameWidth - width) );
		y = 0 - height;
		image = Toolkit.getDefaultToolkit().getImage("images/121.jpg");
		speed = 3;
		hp = 3;
		pointer = 100;
		this.items = new Item[]{
				new Item001(mypanel),
				new Item001(mypanel),
				new Item001(mypanel)
		};
	}
}
