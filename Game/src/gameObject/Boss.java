package gameObject;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import basicalClass.Animation2D;
import basicalClass.Point;
import character.Charactor;
import character.NPCmoveState;
import character.Property;
import character.StopState;
import colliders.CircleCollider;
import colliders.Collider;
import game.GameWorld;

public class Boss extends Charactor{
	int count;
	public Boss(GameWorld gameWorld, Property property) {
		super(gameWorld, property);
		collider = new Collider(this);
		// TODO Auto-generated constructor stub
	}

	public void NPCshoot(GameObject target) {
		
		ArrayList<NPCAmmo> allAmmo=new ArrayList<NPCAmmo>(); 
		allAmmo.add(new NPCAmmo(this,new Point(super.pos.x,super.pos.y),new Point(18,18),2,5000,1,new Point(0,0),
				new Animation2D("雷电宝石.png",1,1)));
		allAmmo.add(new NPCAmmo(this,new Point(super.pos.x+super.size.x,super.pos.y),new Point(18,18),2,5000,1,new Point(2000,-800),
				new Animation2D("熔岩宝石.png",1,1)));
		allAmmo.add(new NPCAmmo(this,new Point(super.pos.x+super.size.x,super.pos.y+super.size.y),new Point(18,18),2,5000,1,new Point(2000,2000),
				new Animation2D("剧毒宝石.png",1,1)));
		allAmmo.add(new NPCAmmo(this,new Point(super.pos.x,super.pos.y+super.size.y),new Point(18,18),2,5000,1,new Point(-800,2000),
				new Animation2D("能量宝石.png",1,1)));
		for(NPCAmmo ammo:allAmmo) {
			ammo.fire();
		}
		
	}
	
	public void Bossshoot(GameObject target) {
		ArrayList<NPCAmmo> allAmmo=new ArrayList<NPCAmmo>(); 
		allAmmo.add(new NPCAmmo(this,new Point(super.pos.x,super.pos.y),new Point(18,18),2,5000,1,new Point(0,0),
				new Animation2D("雷电宝石.png",1,1)));
		allAmmo.add(new NPCAmmo(this,new Point(super.pos.x+super.size.x,super.pos.y),new Point(18,18),2,5000,1,new Point(2000,-800),
				new Animation2D("熔岩宝石.png",1,1)));
		allAmmo.add(new NPCAmmo(this,new Point(super.pos.x+super.size.x,super.pos.y+super.size.y),new Point(18,18),2,5000,1,new Point(2000,2000),
				new Animation2D("剧毒宝石.png",1,1)));
		allAmmo.add(new NPCAmmo(this,new Point(super.pos.x,super.pos.y+super.size.y),new Point(18,18),2,5000,1,new Point(-800,2000),
				new Animation2D("能量宝石.png",1,1)));
		allAmmo.add(new NPCAmmo(this,new Point(super.pos.x+super.size.x/2,super.pos.y),new Point(18,18),2,5000,1,new Point(800,0),
				new Animation2D("雷电宝石.png",1,1)));
		allAmmo.add(new NPCAmmo(this,new Point(super.pos.x+super.size.x,super.pos.y+super.size.y/2),new Point(18,18),2,5000,1,new Point(2000,0),
				new Animation2D("熔岩宝石.png",1,1)));
		allAmmo.add(new NPCAmmo(this,new Point(super.pos.x,super.pos.y+super.size.y/2),new Point(18,18),2,5000,1,new Point(-2000,2000),
				new Animation2D("剧毒宝石.png",1,1)));
		allAmmo.add(new NPCAmmo(this,new Point(super.pos.x+super.size.x/2,super.pos.y+super.size.y),new Point(18,18),2,5000,1,new Point(100,2000),
				new Animation2D("能量宝石.png",1,1)));
		for(NPCAmmo ammo:allAmmo) {
			ammo.fire();
		}
	}
	
	public void onCollision(GameObject go){
		if(go.getClass() == Ammo.class){   
			Ammo a = (Ammo)go;
			super.property.HP -= a.getDamage();   
			if( super.property.HP <= 0 ){
				dead();   
			}
		}
	}
	
	public void update(){
		
		ArrayList<GameObject> allGameObjects = gameWorld.getAllGameObjects();
		for(GameObject go: allGameObjects){
			if(  go.getClass() == knight.class){		
				if(count==30&&property.HP>=property.maxHP/2) {
					NPCshoot(go);
					count=0;
				}else if(count==30&&property.HP<property.maxHP/2){
					super.property.Image="祖兰2.png";
					curState = new StopState(this, 10000,property );  
					Bossshoot(go);
					count=0;
				}
				else {
					count++;
				}
				
				return;
			
			}
		}
			
		}		
	
	public void dead(){
		System.out.println("子弹击中了"+this+"死了");
		gameWorld.removeGameObject(this);
	}
	
	public void render(Graphics g){		
		g.drawRect(property.pos.x, property.pos.y+10, property.animation.aw, 10);
		g.setColor(Color.red); //设置颜色
		g.fillRect(property.pos.x, property.pos.y+10, property.animation.aw*property.HP/property.maxHP, 10);
		super.render(g);
		
    }  
	
	public int getDamage() {
		// TODO Auto-generated method stub
		if(count==10) {
			return 2;
		}else {
			count++;
			return 0;
		}
	}
}
