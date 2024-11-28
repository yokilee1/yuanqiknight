package game;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import rank.retime;
import ui.Gamecontrol;

public class loseend extends JFrame implements Runnable, MouseListener{
	retime ti;//倒计时
	Thread animThread;    //代表动画线程对象	
	GameStarter gameworld;
	 JLabel bac;
	 AudioClip sound;    				//音效
	 JButton button1,button2,button3,button4; //组件
	 public loseend(GameStarter ga,String s,String bac,String sound,String b1,String b2){
		super(s);
		ti=new retime(30);
		this.gameworld=ga;
		ImageIcon img= new ImageIcon(getClass().getClassLoader().getResource("images/"+bac)) ;
		this.sound=Applet.newAudioClip(getClass().getClassLoader().getResource("sounds/"+sound));
		Font font=new Font("楷体",Font.BOLD,20);
		
		button1=new JButton(b1);
		button1.addMouseListener(this);
		button1.setForeground(Color.red);
		button1.setContentAreaFilled(false);
		button1.setBorderPainted(false);
		button1.setFocusPainted(false);
		button1.setFont(font);	
		
		
		button2=new JButton(b2);
		button2.addMouseListener(this);
		button2.setForeground(Color.red);
		button2.setContentAreaFilled(false);
		button2.setBorderPainted(false);
		button2.setFocusPainted(false);
		button2.setFont(font);	
		
		Font font1=new Font("楷体",Font.BOLD,40);
		button3=new JButton(""+ti.next());
		button3.setForeground(Color.red);
		button3.setContentAreaFilled(false);
		button3.setBorderPainted(false);
		button3.setFocusPainted(false);
		button3.setFont(font1);
		
		button4=new JButton("如果不进行选择将自动返回主页面");
		button4.setForeground(Color.red);
		button4.setContentAreaFilled(false);
		button4.setBorderPainted(false);
		button4.setFocusPainted(false);
		button4.setFont(font);
		
		this.bac=new JLabel(img);
		this.getLayeredPane().add(this.bac,Integer.valueOf(Integer.MIN_VALUE));		
		this.bac.setBounds(0,0,397,500);
		JPanel panel=(JPanel)this.getContentPane();
		panel.setOpaque(false);
		
		this.setLayout(null);
		button1.setBounds(12,400,150,100);
		button2.setBounds(237,400,150,100);
		button3.setBounds(0, 200, 397, 100);
		button4.setBounds(0, 250, 397, 100);
		this.add(button1);
		this.add(button2);
		this.add(button3);
		this.add(button4);
		

		this.setBounds(397,100,397,500);		
		this.setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	this.addMouseListener((MouseListener) this);
    	animThread = new Thread(this);   //创建线程对象
    	animThread.start();              //启动线程，即执行run函数     	
    	this.setVisible(true);
	 }
		public void run() {
			// TODO Auto-generated method stub
			while( animThread != null ){    //游戏动画循环	
				//通知游戏世界进行仿真、状态更新
				if(ti.next()>0)
				button3.setText(""+ti.next());
				else if(ti.next()<=0){
					this.gameworld.setVisible(false);
					this.setVisible(false);
					new Gamecontrol("原气骑士","背景 (2).png","弓箭攻击.wav","开始游戏","排行","退出");		
					return;
				}
				//游戏动画暂停
		    	try {
		    		//线程休眠（暂停）40毫秒，如此游戏动画就是25帧/秒
					Thread.sleep(40);  
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    	//repaint();//请求系统重画，即再次调用paint方法
			}	
		}
		//鼠标事件处理接口方法
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub			
		}
		public void mouseEntered(MouseEvent e) {
			Font font=new Font("楷体",Font.BOLD,25);
			if(e.getSource()==button1) {
				button1.setFont(font);
			}
			if(e.getSource()==button2) {
				button2.setFont(font);
			}
		}
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			Font font=new Font("楷体",Font.BOLD,20);
			if(e.getSource()==button1) {
				button1.setFont(font);
			}
			if(e.getSource()==button2) {
				button2.setFont(font);
			}

		}
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource()==button1) {
				this.animThread.stop();
				this.gameworld.setVisible(false);
				this.setVisible(false);
				new GameStarter();
			}
			if(e.getSource()==button2) {
				this.animThread.stop();
				this.gameworld.setVisible(false);
				this.setVisible(false);
				new Gamecontrol("原气骑士","背景 (2).png","弓箭攻击.wav","开始游戏","排行","退出");		
			}
		}
}
