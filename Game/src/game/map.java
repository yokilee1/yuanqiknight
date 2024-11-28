package game;

import java.awt.Image;

import javax.swing.ImageIcon;

import basicalClass.Point;
import character.ActorState;
import character.Charactor;
import character.Property;
import character.StopState;
import character.border;
import gameObject.knight;

public class map {
	public Image bac,bac1;
	public Point pos;
	public Point size;
	public Charactor kn;
	barrier bar;
	public boolean npcem=false; 
	public boolean vi2=true;
	public map(Charactor a){
		bar=new barrier();	
		bac = new ImageIcon(getClass().getClassLoader().getResource("images/背景.png")).getImage();
		bac1= new ImageIcon(getClass().getClassLoader().getResource("images/毒雾.png")).getImage();
		kn=a;		
		pos=new Point(0,-1450);
		size=new Point(1200,2515);
		
	}
	public void update(){
		if(kn==null)
			return;
		if(!bar.vi){
			if(kn.getPos().y<=kn.bor.ud.x+100&&kn.getProperty().curDirection==0&&kn.getCurState().getClass()!=StopState.class&&pos.y<=0){
				pos.y+=kn.getProperty().speed;
				kn.getPos().y+=kn.getProperty().speed;				
			}
			if(pos.y>=-1287){
				kn.bor.lr.x=bar.pos.x;
				kn.bor.lr.y=bar.pos.x+bar.size.x-50;
			}
			if(pos.y>=-650){
				
				kn.bor.lr.x=120;
				kn.bor.lr.y=1030;
				bar.setvi(true);
				bar.pos.y=pos.y+900;
				kn.bor.ud.y=bar.pos.y-12;
			}
		}
		if(pos.y>=-650&&bar.vi){
			if(kn.getPos().y<=kn.bor.ud.x+100&&kn.getProperty().curDirection==0&&kn.getCurState().getClass()!=StopState.class&&pos.y<=0){
				pos.y+=kn.getProperty().speed;
				bar.pos.y+=kn.getProperty().speed;
				kn.bor.ud.y=bar.pos.y-12;
				kn.getPos().y+=kn.getProperty().speed;	
								
			}
		}
		if(bar.pos.y>=800){
			vi2=false;
			kn.bor.ud.y=900;
		}
		
	}
	public void setaw(Charactor a){
		kn=a;
	}
	public void setbar(barrier a){
		bar=a;
	}
	
}
