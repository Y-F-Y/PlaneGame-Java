package com.eduask.view;

import com.eduask.thread.BulletThread;
import com.eduask.thread.MusicThread;


public class Main {

	public static void main(String[] args) {
		
	
		new MainFrame();
		
		new MusicThread("video/bjmusic.wav").start();
		
		
	}

}
