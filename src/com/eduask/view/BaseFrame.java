package com.eduask.view;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JFrame;

import com.eduask.listener.FrameMouseListener;
import com.eduask.listener.FrameMouseMotionListener;
import com.eduask.thread.MusicThread;



public class BaseFrame extends JFrame{
	public static boolean hasPlayer = false;
	public static boolean hasItem = false;
	public static boolean hasCount = false;
	public static boolean hasListener = false;
	public static ArrayList<Class> enemiesType = new ArrayList<Class>();
	public void setTouchListener(){
		hasListener = true;
	
		
		
		if( hasListener ){
		mouselistener = new FrameMouseListener();
		mouselistener.mainframe = this;
		this.addMouseListener(mouselistener);
		
		mousemotionlistener = new FrameMouseMotionListener();
		mousemotionlistener.mainframe = this;
		this.addMouseMotionListener(mousemotionlistener);
		}
		
	
	}
	public  void addEnemyType(Class c){
		enemiesType.add(c);
	}
	public  void createPlayer(){
		hasPlayer = true;
	}
	public  void setCount(){
		hasCount = true;
	}
	public  void setEnemyHasItem(){
		hasItem = true;
	}
	
	public void setPlayerPowerLevel(int level){
		this.panel.player.attactMode = level;
	}
	
	
	private static final long serialVersionUID = 1L;
	
	public static int FrameWidth = 512;
	public static int FrameHeight = 768;
	
	public BaseFrame(){
		super("YFY的飞机大战");
		//获得屏幕分辨率
		Dimension screenSize =Toolkit.getDefaultToolkit().getScreenSize();
		//设置窗口的大小位置
		setBounds( ((int)screenSize.getWidth() - FrameWidth) / 2, 0, FrameWidth, FrameHeight);
		//设置布局方式
		setLayout(null);
		this.panel = new MyPanel();
		//panel位置大小
		this.panel.setBounds(0, 0, this.getWidth(), this.getHeight());
		//把东西添加达到窗口中
		this.add(this.panel);
		setVisible(true);//显示窗口
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭窗口
	}

	
	public MyPanel panel;
	public FrameMouseListener mouselistener;
	public FrameMouseMotionListener mousemotionlistener;
}
