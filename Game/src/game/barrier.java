package game;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import basicalClass.Point;

public class barrier {
	public Image img;
	public Point pos,size;
	public boolean vi;
	public barrier(){
		pos=new Point(397,0);
		size=new Point(397,120);
		 img= new ImageIcon(getClass().getClassLoader().getResource("images/障碍.png")).getImage() ;
		 vi=true;
	}
	public void setvi(boolean a){
		vi=a;
	}

}
