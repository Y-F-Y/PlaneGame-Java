package com.eduask.model;

import java.awt.Image;
import java.awt.Toolkit;

import com.eduask.view.MyPanel;

public class Item002 extends Item{

	public Item002(MyPanel mypanel) {
		super(mypanel);
		// TODO Auto-generated constructor stub
		width = 15;
		height = 15;
		images = new Image[]{
				Toolkit.getDefaultToolkit().getImage("images/diamond01.png")
		};
		pointer = 500;
		attactMode = 1;
		powerTime = 0;
		speed =(int)( Math.random() * 3 + 3);
	}
}
