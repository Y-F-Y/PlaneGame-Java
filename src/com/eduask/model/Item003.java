package com.eduask.model;

import java.awt.Image;
import java.awt.Toolkit;

import com.eduask.view.MyPanel;

public class Item003 extends Item{

	public Item003(MyPanel mypanel) {
		super(mypanel);
		// TODO Auto-generated constructor stub
		width = 15;
		height = 15;
		images = new Image[]{
				Toolkit.getDefaultToolkit().getImage("images/diamond02.png")
		};
		pointer = 2000;
		attactMode = 1;
		powerTime = 0;
		speed =(int)( Math.random() * 3 + 3);
	}
}
