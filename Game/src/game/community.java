package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;


import javax.swing.ImageIcon;

import basicalClass.Point;


public class community {
	Image bac;
	public String talk,s1,s2,s3,s4,s5,s6;
	public Point pos,size;
	
	public community(Point a){

		Font font=new Font("楷体",Font.BOLD,35);
		talk=new String("小鹿好像有话要说");	
		pos=new Point(a);
		size=new Point(150,100);
		bac= new ImageIcon(getClass().getClassLoader().getResource("images/聊天气泡.png")).getImage() ;
		s1=new String("好心人你是来解决那只叫“祖兰”的怪物吗");
		s2=new String("        它就在路的尽头");
		s3=new String("但是你要小心，受伤的祖兰有第二种形态");
		s4=new String("而且在那时它会释放出毒雾，不能待太久");
		s5=new String("   加油！！让我也助你一臂之力吧");
		s6=new String("小鹿的祝福能治疗且让你在毒雾中存活15s");
		
	}
	public void setButton(String s){
		talk=s;
	}
	public void setpos(Point a){
		pos=a;
	}
	
}
