package com.eduask.listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import com.eduask.view.BaseFrame;



public class FrameMouseMotionListener implements MouseMotionListener {

	public BaseFrame mainframe;
	
	@Override
	public void mouseDragged(MouseEvent e) {
		mainframe.panel.player.x = e.getX() - mainframe.panel.player.width/2;
		mainframe.panel.player.y = e.getY() - mainframe.panel.player.height / 2 - 10;
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
