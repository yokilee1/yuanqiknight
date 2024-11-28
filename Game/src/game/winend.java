package game;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ui.Gamecontrol;
import ui.work;

public class winend extends JFrame implements MouseListener{
	GameStarter gameworld;
	public timeex time;
	 JLabel bac;
	 AudioClip sound;    				//音效
	 JButton button1,button2,button3,button4,button5; //组件
	public winend(GameStarter ga,String s,String bac,String sound,String b1,String b2,timeex ti,double sc1,double sc2){ 
		super(s);
		this.gameworld=ga;
		ImageIcon img= new ImageIcon(getClass().getClassLoader().getResource("images/"+bac)) ;
		this.sound=Applet.newAudioClip(getClass().getClassLoader().getResource("sounds/"+sound));
		Font font=new Font("楷体",Font.BOLD,20);
		button1=new JButton(b1);
		button1.addMouseListener(this);
		button1.setForeground(Color.getColor("e0b781"));
		button1.setContentAreaFilled(false);//设置按钮透明无边框及字体
		button1.setBorderPainted(false);
		button1.setFont(font);
		button1.setFocusPainted(false);
		
		button2=new JButton(b2);
		button2.addMouseListener(this);
		button2.setForeground(Color.getColor("e0b781"));
		button2.setContentAreaFilled(false);
		button2.setBorderPainted(false);
		button2.setFont(font);
		button2.setFocusPainted(false);
		
		
		button3=new JButton("你的最终用时："+ti.time);
		button3.setForeground(Color.red);
		button3.setContentAreaFilled(false);
		button3.setBorderPainted(false);
		button3.setFocusPainted(false);
		button3.setFont(font);	
		button4=new JButton("\n击杀怪物得分："+sc1);
		button4.setForeground(Color.red);
		button4.setContentAreaFilled(false);
		button4.setBorderPainted(false);
		button4.setFocusPainted(false);
		button4.setFont(font);	
		button5=new JButton("你的最终得分："+String.format("%.1f", sc1+sc2));
		button5.setForeground(Color.red);
		button5.setContentAreaFilled(false);
		button5.setBorderPainted(false);
		button5.setFocusPainted(false);
		button5.setFont(font);	

		this.bac=new JLabel(img);
		this.getLayeredPane().add(this.bac,Integer.valueOf(Integer.MIN_VALUE));		
		this.bac.setBounds(0,0,397,500);
		JPanel panel=(JPanel)this.getContentPane();
		panel.setOpaque(false);
		
		this.setLayout(null);
		button1.setBounds(12,400,150,100);
		button2.setBounds(237,400,150,100);
		button3.setBounds(0, 200, 397, 50);
		button4.setBounds(0, 250, 397, 50);
		button5.setBounds(0, 300, 397, 50);
		this.add(button1);
		this.add(button2);
		this.add(button3);
		this.add(button4);
		this.add(button5);
		
		
		this.setBounds(397,100,397,500);		
		this.setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	this.addMouseListener(this);
		this.setVisible(true);
		this.rank(ti.time, String.format("%.1f", sc1+sc2));
	}

	//鼠标事件处理接口方法
	@Override
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
	@Override
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
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==button1) {
			this.gameworld.setVisible(false);
			this.setVisible(false);
			new GameStarter();
		}
		if(e.getSource()==button2) {
			this.gameworld.setVisible(false);
			this.setVisible(false);
			new Gamecontrol("原气骑士","背景 (2).png","弓箭攻击.wav","开始游戏","排行","退出");		
		}
	}
	public void rank(String a,String b){
		Calendar cal=Calendar.getInstance();
		int y=cal.get(Calendar.YEAR);
		int m=cal.get(Calendar.MONTH);
		int d=cal.get(Calendar.DATE);
		int h=cal.get(Calendar.HOUR_OF_DAY);
		int mi=cal.get(Calendar.MINUTE);
		int s=cal.get(Calendar.SECOND);
		try{
			File f=new File("src//images//排行榜");
	    	   if(!f.exists())
	    		   f.createNewFile();
	    	   BufferedWriter br=new BufferedWriter(new FileWriter(f,true));
	    	   br.append(y+"年"+m+"月"+d+"日"+h+"时"+mi+"分"+s+"秒 ");
	    	   br.append(a+" "+b+" \n");
	    	   br.flush();
	    	   br.close();
		}catch(FileNotFoundException e1) {
	    	   System.err.println("File not found!");
	       }catch(IOException e2) {
	    	   e2.printStackTrace();
	       }
	}
}
