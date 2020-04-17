package com.eduask.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.JPanel;

import com.eduask.model.Bullet;
import com.eduask.model.Enemy;
import com.eduask.model.Enemy001;
import com.eduask.model.Enemy002;
import com.eduask.model.Enemy003;
import com.eduask.model.Enemy004;
import com.eduask.model.Enemy005;
import com.eduask.model.Enemy006;
import com.eduask.model.Enemy007;
import com.eduask.model.Enemy008;
import com.eduask.model.Enemy009;
import com.eduask.model.Enemy010;
import com.eduask.model.Item;
import com.eduask.model.Player;
import com.eduask.thread.BulletThread;
import com.eduask.thread.DrawableThread;


//����һ�����panel
public class MyPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	//��ű���ͼ
	public DrawableThread thread;
	public Player player;
	//���ӵ�
	public ArrayList<Bullet> bullets = new ArrayList<Bullet>();
	  //�ŵл�
	public ArrayList<Enemy> enemies = new ArrayList<Enemy>();
	 //�л�������
	public ArrayList<Item> items = new ArrayList<Item>();
	
	public MyPanel(){
		this.bg = Toolkit.getDefaultToolkit().getImage("images/bg01.jpg");
		 //�ð��̸߳���������
		this.player = new Player(this);
		this.thread = new DrawableThread(this);
		this.thread.start();
	}
	
	public int timer = 0;
	public Image bg;
	public int top = 0;
	public int enemyFlag;
	//�������Ķ���
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		timer++;
		if( timer >= 10000 ){
			timer = 0;
		}
		// ������
		g.drawImage(bg, 0, top-bg.getHeight(this), bg.getWidth(this), bg.getHeight(this), null);
		g.drawImage(bg, 0, top, bg.getWidth(this), bg.getHeight(this), null);
		if( timer % 10 == 0 )
		{
			this.top+= 1;
			if( top > bg.getHeight(this) ){
				top = 0;
			}
		}
		
		// ���ɻ�
		if(BaseFrame.hasPlayer)
		player.drawSelf(g);		
		
		
		// �������ӵ�
		if( timer % 100 == 0 ){
			
			if( player.attactMode == 1 ){
				// ����ӵ�
				Bullet b = new Bullet(this);
				b.x = player.x + player.width / 2 - b.width/2;
				b.y = player.y;
				bullets.add(b);
			}
			else if( player.attactMode == 2 ){
				Bullet b1 = new Bullet(this);
				b1.x = player.x + player.width / 2 - b1.width/2;
				b1.y = player.y - 15;
				bullets.add(b1);
				
				Bullet b2 = new Bullet(this);
				b2.x = player.x + player.width / 2 - b2.width/2 - b2.width - 5;
				b2.y = player.y;
				bullets.add(b2);
				
				Bullet b3 = new Bullet(this);
				b3.x = player.x + player.width / 2 - b3.width/2 + b3.width + 5;
				b3.y = player.y;
				bullets.add(b3);
				
			}
			else if( player.attactMode == 3 )
			{
				Bullet b1 = new Bullet(this);
				b1.x = player.x + player.width / 2 - b1.width/2;
				b1.y = player.y - 30;
				bullets.add(b1);
				
				Bullet b2 = new Bullet(this);
				b2.x = player.x + player.width / 2 - b2.width/2 - b2.width - 5;
				b2.y = player.y - 15;
				bullets.add(b2);
				
				Bullet b3 = new Bullet(this);
				b3.x = player.x + player.width / 2 - b3.width/2 + b3.width + 5;
				b3.y = player.y - 15;
				bullets.add(b3);
				
				Bullet b4 = new Bullet(this);
				b4.x = player.x + player.width / 2 - b4.width/2 - 2*b4.width - 10;
				b4.y = player.y;
				bullets.add(b4);
				
				Bullet b5 = new Bullet(this);
				b5.x = player.x + player.width / 2 - b5.width/2 + 2*b5.width +10;
				b5.y = player.y;
				bullets.add(b5);
			}
			new BulletThread("video/bullet.wav").start();
		}
		
		// �������ӵ�
		
		for( int i = 0 ; i <= bullets.size() - 1; i++ ){
			bullets.get(i).drawSelf(g);
		}
		
		// ��������
		if( timer % 200 == 0 ){
			// ��������
			Enemy enemy;
			if( BaseFrame.enemiesType.size() != 0 ){
			enemyFlag = (int)(Math.random() * BaseFrame.enemiesType.size());
			try{
			enemy =(Enemy) BaseFrame.enemiesType.get(enemyFlag).getConstructors()[0].newInstance(new Object[]{this});
			
			enemies.add(enemy);
			}catch(Exception e){
				e.printStackTrace();
			}
			}
		}
		
		// �����е���
		for( int i = 0 ; i <= enemies.size() - 1; i++ ){
			enemies.get(i).drawSelf(g);
		}
		
		// �����е���
		if( BaseFrame.hasItem )
		for( int i = 0 ; i <= items.size() - 1; i++ ){
			items.get(i).drawSelf(g);
		}
		
		// ������
		if( BaseFrame.hasCount ){
		g.setColor(Color.WHITE);
		g.drawString(""+player.pointer, BaseFrame.FrameWidth - 140, 15);
		}
		
	}
	
}
