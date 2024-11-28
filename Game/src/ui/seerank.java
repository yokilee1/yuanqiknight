package ui;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import game.GameStarter;


class Triple implements Comparable<Triple>{
	String date;
	String time;
	double score;
	
	public Triple(String name, String code, double value) {
        this.date = name;
        this.time = code;
        this.score = value;
    }

    public String toString() {
        return date + "\t" + time + "\t" + score;
    }

    public int compareTo(Triple other) {
        return Double.compare(this.score, other.score);
    }
}


public class seerank extends JFrame implements MouseListener {
	AudioClip sound;    				//音效
	JButton button1; 					//组件
	JTextArea text;
	JScrollPane js;
	public seerank(String s,String sound,String b1){
		super(s);	
		this.sound=Applet.newAudioClip(getClass().getClassLoader().getResource("sounds/"+sound));
		Font font=new Font("楷体",Font.BOLD,20);
		button1=new JButton(b1);
		button1.addMouseListener(this);
		button1.setForeground(Color.getColor("e0b781"));
		button1.setContentAreaFilled(false);//设置按钮透明无边框及字体
		button1.setBorderPainted(false);
		button1.setFont(font);
		button1.setFocusPainted(false);
			
		text=new JTextArea(100,50);
		text.setEditable(false);
		text.setLineWrap(true);
		text.setBorder(null);
		text.setForeground(Color.RED);
		text.append("\t\t排行榜\n");
		text.append("\t通关日期\t\t\t通关耗时\t评分\n");
		text.setFont(font);
		read(text);
		js=new JScrollPane();
		js.setViewportView(text);
		button1.setBounds(250,300,240,135);
		
		this.getLayeredPane().setLayout(null);
		this.add(button1);
		this.add(js);
				
		this.setBounds(100,100, 800, 450);		
		this.setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	this.addMouseListener(this);
		this.setVisible(true);
	}
	@SuppressWarnings("unchecked")
	public void  read(JTextArea a){
		StringBuilder all;
		Calendar cal=Calendar.getInstance();
		int y=cal.get(Calendar.YEAR);
		int m=cal.get(Calendar.MONTH);
		int d=cal.get(Calendar.DATE);
		int h=cal.get(Calendar.HOUR_OF_DAY);
		int mi=cal.get(Calendar.MINUTE);
		int s=cal.get(Calendar.SECOND);

		ArrayList<Triple> array = new ArrayList<Triple>();
		try{
			File f=new File("src//images//排行榜");
	    	   if(!f.exists())
	    		   f.createNewFile();
	    	   BufferedReader reader=new BufferedReader(new FileReader(f));
	    	   String line = null;
	    	   while ((line = reader.readLine()) != null) {
	    		   String[] parts = line.split(" ");
	    		   array.add(new Triple(parts[0],parts[1],Double.parseDouble(parts[2])));
	               }
	    	   Collections.sort(array);
	    	   for (Triple triple : array){
	    		   a.append(triple.toString()+"\n");
	    	   }
	    	   reader.close();

	    	}catch(FileNotFoundException e1) {
	    	   System.err.println("File not found!");
	       }catch(IOException e2) {
	    	   e2.printStackTrace();
	       }
		

}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
			new Gamecontrol("原气骑士","背景 (2).png","弓箭攻击.wav","开始游戏","排行","退出");
		}

	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		Font font=new Font("楷体",Font.BOLD,25);
		if(e.getSource()==button1) {
			button1.setFont(font);
		}
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		Font font=new Font("楷体",Font.BOLD,20);
		if(e.getSource()==button1) {
			button1.setFont(font);
		}
	}
}