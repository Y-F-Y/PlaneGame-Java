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
		super("YFY�ķɻ���ս");
		//�����Ļ�ֱ���
		Dimension screenSize =Toolkit.getDefaultToolkit().getScreenSize();
		//���ô��ڵĴ�Сλ��
		setBounds( ((int)screenSize.getWidth() - FrameWidth) / 2, 0, FrameWidth, FrameHeight);
		//���ò��ַ�ʽ
		setLayout(null);
		this.panel = new MyPanel();
		//panelλ�ô�С
		this.panel.setBounds(0, 0, this.getWidth(), this.getHeight());
		//�Ѷ�����Ӵﵽ������
		this.add(this.panel);
		setVisible(true);//��ʾ����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�رմ���
	}

	
	public MyPanel panel;
	public FrameMouseListener mouselistener;
	public FrameMouseMotionListener mousemotionlistener;
}
