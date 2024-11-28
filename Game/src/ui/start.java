package ui;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import game.GameStarter;

public class start extends JFrame implements MouseListener{		
		JLabel bac;
		AudioClip sound;    				//音效
		JButton button1,button2,button3; //组件
	
	public start(String s,String bac,String sound,String b1,String b2,String b3) {
		super(s);
		ImageIcon img= new ImageIcon(getClass().getClassLoader().getResource("images/"+bac)) ;
		this.sound=Applet.newAudioClip(getClass().getClassLoader().getResource("sounds/"+sound));
		Font font=new Font("楷体",Font.BOLD,35);
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
		
		
		button3=new JButton(b3);
		button3.addMouseListener(this);
		button3.setForeground(Color.getColor("e0b781"));
		button3.setContentAreaFilled(false);
		button3.setBorderPainted(false);
		button3.setFont(font);	
		button3.setFocusPainted(false);	
		
		
		this.bac=new JLabel(img);
		this.getLayeredPane().add(this.bac,Integer.valueOf(Integer.MIN_VALUE));		
		this.bac.setBounds(0,0,800,450);
		JPanel panel=(JPanel)this.getContentPane();
		panel.setOpaque(false);
		this.setLayout(null);
		button1.setBounds(475, 125, 240, 135);
		button2.setBounds(475, 225, 240, 135);
		button3.setBounds(475, 325, 240, 135);
		this.add(button1);
		this.add(button2);
		this.add(button3);
		
		
		this.setBounds(100,100, 800, 450);		
		this.setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	this.addMouseListener(this);
		this.setVisible(true);
		
		
	}
	
	//鼠标事件处理接口方法
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub			
		}
		public void mouseEntered(MouseEvent e) {
			Font font=new Font("楷体",Font.BOLD,40);
			if(e.getSource()==button1) {
				button1.setFont(font);
			}
			if(e.getSource()==button2) {
				button2.setFont(font);
			}
			if(e.getSource()==button3) {
				button3.setFont(font);
			}
		}
		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			Font font=new Font("楷体",Font.BOLD,35);
			if(e.getSource()==button1) {
				button1.setFont(font);
			}
			if(e.getSource()==button2) {
				button2.setFont(font);
			}
			if(e.getSource()==button3) {
				button3.setFont(font);
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
				this.setVisible(false);
				new GameStarter();
			}
			if(e.getSource()==button2) {
				this.setVisible(false);
				new seerank("原气骑士","弓箭攻击.wav","返回主页面");
			}
			if(e.getSource()==button3) {
				System.exit(0);
			}
		}
}
