package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;


import basicalClass.*;
import character.*;
import gameObject.*;
import rank.score;
import rank.time;	
	public class GameWorld {
		GameStarter game;    //反向引用游戏主类对象		
		map m; //游戏地图
	    barrier b;//障碍
	    time t,t1;//计时器
	    boss bo;//boss
	    score s1,s2;//计分器
	    timeex ti;//时间转换器
	   public community c;//对话 
	   public boolean comisem=false;
		//存储着游戏世界中的所有的游戏对象
		ArrayList<GameObject> gameObjects = new ArrayList<GameObject>(); 		
		public GameWorld(GameStarter game){
			this.game = game;
			for(int i=1;i<=4;i++) {
				this.addGameObject(new protecter(this,new Property(2.5,50,2,"遗迹守卫.png",new Point(200,i*200),0)));
			}
			for(int i=1;i<=4;i++) {
				this.addGameObject(new guard(this,new Property(2.5,20,3,"遗迹卫兵(1).png",new Point(i*200,200),0)));
			}
			this.addGameObject(new machine(this,new Property(10,20,2,"遗迹机关.png",new Point(1000,300),0)));
			this.addGameObject(new machine(this,new Property(10,20,2,"遗迹机关.png",new Point(150,300),0)));
			this.addGameObject(new knight(this,new Property(0,20,3,"刺客.png",new Point(750,500) ,0)));
			b=new barrier();
			m=new map(this.getknight());
			t=new time();
			t.begin();
			t1=new time();
			bo=new boss();
			s1=new score();
			s2=new score();
			s1.start();
			ti=new timeex();		
			
		}
		//游戏世界的渲染方法
		public void render(Graphics g){
			t.differ();
	    	g.drawImage(m.bac,m.pos.x,m.pos.y,m.size.x,m.size.y,null); 
	    	if(bo.isemgage&&this.bossargue()){
	    		g.drawImage(m.bac1,m.pos.x,m.pos.y,m.size.x,m.size.y,null); 

	    	}
	    	if(b.vi){
	    	g.drawImage(b.img,b.pos.x,b.pos.y, b.size.x,b.size.y,null);}
			for(GameObject i : gameObjects){
				i.render(g);
			}
			
			g.setFont(new Font("楷体",Font.BOLD,20));
			ti.ex((int)t.differ());
			g.drawString("已经用时："+ti.time, 1000,100 );
			g.drawString("打怪得分："+s1.sc, 1000, 125);
			if(bo.isstart&&!bo.isemgage){
				g.setFont(new Font("楷体",Font.BOLD,40));
				if(bo.t.differ()<4)
				g.drawString(bo.warning[(int)bo.t.differ()], 500, 375);
			}
			if(this.npcem()&&this.comisem){
				g.drawImage(c.bac, c.pos.x, c.pos.y,c.size.x,c.size.y,null);
				g.setFont(new Font("楷体",Font.BOLD,20));
				g.setColor(Color.red);
				g.drawString(c.talk, c.pos.x, c.pos.y+50);
					g.drawString(c.s1, 600, 175);
					g.drawString(c.s2, 600, 225);
					g.drawString(c.s3, 600, 275);
					g.drawString(c.s4, 600, 325);
					g.drawString(c.s5, 600, 375);
					g.drawString(c.s6, 600, 425);
					this.getknight().getProperty().HP=this.getknight().getProperty().maxHP;
				
			}
			
		}
		//游戏世界的状态更新函数，或者说是游戏仿真函数
		//规定着游戏中的对象经过一帧后的状态变化，比如空间坐标。
		public void update(){
			if(bo.isargue&&t1.differ()>=15)
				this.getknight().getProperty().HP-=20;	
			if(this.isdead())
				return;				
			for(int i = 0; i < gameObjects.size(); i++){
				gameObjects.get(i).update();
			}

			b.setvi(!this.isclear());	
			m.setbar(b);
			m.setaw(this.getknight());
			m.update();
			if(this.npcem()){
			c.pos.y	=this.b.pos.y-150;
			this.getnpc().getProperty().pos.y=this.b.pos.y-75;;
			}
			if(m.pos.y>=-650&&!m.npcem){
				this.addGameObject(new Deers(this,new Property(0,20,0,"npc.png",new Point(b.pos.x-25,b.pos.y),0)));
				m.npcem=true;
				c=new community(new Point(0,400));
				this.comisem=true;
			}
			if(!m.vi2&&this.npcem()){
				this.removeGameObject(this.getnpc());
			}
			if(m.pos.y==-100&&!bo.isstart){
				bo.start();
			}
			if(this.bossargue()&&!bo.isargue){
				t1.begin();
				bo.isargue=true;
			}
			if(bo.isstart&&bo.t.differ()>=4&&!bo.isemgage){
				this.addGameObject(new Boss(this,new Property(20,500,3,"boss祖兰.png",new Point(600,400),0)));
				bo.isemgage=true;
				bo.isstart=false;
			}
		}
		public void keyPressed(int key) {
			if(!this.isdead())
			getknight().keyPressed(key);
		}
		
		public void mouseReleased(MouseEvent e) {
			if(!this.isdead())
			getknight().mouseReleased(e);
		}
		
		public void addGameObject(GameObject g){
			gameObjects.add(g);
		}

		public void removeGameObject(GameObject g){
			gameObjects.remove(g);
			s1.getscore(this.getscore(g));
		}

		public ArrayList<GameObject> getAllGameObjects(){
			return gameObjects;
		}

		public knight getknight(){
			for(int i = 0; i < gameObjects.size(); i++){
				if(gameObjects.get(i).getClass() == knight.class){
					return (knight)gameObjects.get(i);
				}
			}
			return null;
		}	
		public Deers getnpc(){
			for(int i = 0; i < gameObjects.size(); i++){
				if(gameObjects.get(i).getClass() == Deers.class){
					return (Deers)gameObjects.get(i);
				}
			}
			return null;
		}
	    public boolean isclear() {
			for(int i = 0; i < gameObjects.size(); i++){
				if(gameObjects.get(i).getClass() != knight.class&&gameObjects.get(i).getClass()!=Ammo.class&&gameObjects.get(i).getClass() !=NPCAmmo.class&&gameObjects.get(i).getClass() !=null)
					return false;			
				if(i==gameObjects.size()-1)
					return true;
	    }
			return false;
	    }
	    public boolean isdead(){
	    	if(this.getknight()==null){
	    		return true;
	    	}else{
	    		return false;
	    	}
	    }
	    public double getscore(GameObject g){
	    		return g.score;
	    }
	    public Boss getboss(){
			for(int i = 0; i < gameObjects.size(); i++){
				if(gameObjects.get(i).getClass() ==Boss.class)
					return (Boss)gameObjects.get(i);			
	    }
			return null;
	    }
	    public boolean bossdead(){
	    	if(this.getboss()!=null)
			return false;
	    	else
	    	return true;
	    }
	    public boolean isend(){
	    	if(this.bossdead()){
	    		s2.gettisc((int)t.differ());
	    		return true;
	    	}
	    	else 
	    		return false;
	    }
	    public boolean npcem(){
	    	if(this.getnpc()==null){
	    		return false;
	    	}
	    	else 
	    		return true;
	    }
	    public boolean bossargue(){
	    	if(!this.bossdead()){
	    		if(this.getboss().getProperty().HP<this.getboss().getProperty().maxHP/2){
	    			return true;
	    		}
	    	}
			return false;
	    }
}