package com.eduask.model;

import java.awt.Image;
import java.awt.Toolkit;

import com.eduask.view.MyPanel;

public class Item004 extends Item{

	public Item004(MyPanel mypanel) {
		super(mypanel);
		// TODO Auto-generated constructor stub
		width = 15;
		height = 15;
		images = new Image[]{
				Toolkit.getDefaultToolkit().getImage("images/power.png")
		};
		pointer = 0;
		attactMode = 2;
		powerTime = 10000;
		speed =(int)( Math.random() * 3 + 3);
	}
}