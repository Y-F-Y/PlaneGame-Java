package com.eduask.model;

import java.awt.Toolkit;

import com.eduask.view.BaseFrame;
import com.eduask.view.MyPanel;

public class Enemy004 extends Enemy {
	public Enemy004(MyPanel mypanel) {
		super(mypanel);
		width = 50;
		height = 36;
		x = (int)(Math.random() * (BaseFrame.FrameWidth - width) );
		y = 0 - height;
		image = Toolkit.getDefaultToolkit().getImage("images/enemy04.png");
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
