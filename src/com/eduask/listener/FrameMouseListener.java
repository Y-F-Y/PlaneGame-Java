package com.eduask.listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import com.eduask.view.BaseFrame;



public class FrameMouseListener implements MouseListener{

	public BaseFrame mainframe;
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
		mainframe.panel.player.x = e.getX() - mainframe.panel.player.width/2;
		mainframe.panel.player.y = e.getY() - mainframe.panel.player.height / 2 - 10;
		
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
