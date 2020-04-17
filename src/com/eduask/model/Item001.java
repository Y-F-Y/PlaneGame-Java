package com.eduask.model;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import com.eduask.view.MyPanel;

public class Item001 extends Item{

	public Item001(MyPanel mypanel) {
		super(mypanel);
		// TODO Auto-generated constructor stub
		width = 15;
		height = 15;
		images = new Image[]{
				Toolkit.getDefaultToolkit().getImage("images/star01.png"),
				Toolkit.getDefaultToolkit().getImage("images/star02.png"),
				Toolkit.getDefaultToolkit().getImage("images/star03.png"),
				Toolkit.getDefaultToolkit().getImage("images/star04.png"),
				Toolkit.getDefaultToolkit().getImage("images/star05.png"),
				Toolkit.getDefaultToolkit().getImage("images/star06.png"),
				Toolkit.getDefaultToolkit().getImage("images/star07.png"),
				Toolkit.getDefaultToolkit().getImage("images/star08.png"),
				Toolkit.getDefaultToolkit().getImage("images/star09.png")
		};
		pointer = 100;
		attactMode = 1;
		powerTime = 0;
		speed =(int)( Math.random() * 3 + 3);
	}

}
