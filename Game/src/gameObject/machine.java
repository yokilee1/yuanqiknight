package gameObject;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import basicalClass.Animation2D;
import basicalClass.Point;
import character.Charactor;
import character.NPCmoveState;
import character.Property;
import colliders.CircleCollider;
import game.GameWorld;

public class machine extends Charactor{

	int count=0;
	
	public machine(GameWorld gameWorld, Property property) {
		super(gameWorld, property);
		collider = new CircleCollider(this);	
		// TODO Auto-generated constructor stub
	}

	public void NPCshoot(Point target) {
		
		NPCAmmo a = new NPCAmmo(this,new Point(super.pos.x,super.pos.y),new Point(18,18),2,3500,1,target,
				new Animation2D("雷电宝石.png",1,1));
		//NPCAmmo b = new NPCAmmo(this,new Point(super.pos.x+super.size.x,super.pos.y),new Point(18,18),2,5000,2,target,
				//new Animation2D("熔岩宝石.png",1,1));
		a.fire();
		//b.fire();
	
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
					if(count==30) {
						NPCshoot(go.pos);
						count=0;
					}else {
						count++;
					}
					
					return;
				
				}
			}
		}	
	public void render(Graphics g){		
		g.drawRect(property.pos.x, property.pos.y+10, property.animation.aw, 10);
		g.setColor(Color.red); //设置颜色
		g.fillRect(property.pos.x, property.pos.y+10, property.animation.aw*property.HP/property.maxHP, 10);
		super.render(g);
		
    } 
	public void dead(){	
		System.out.println("子弹击中了"+this+"死了");		
		gameWorld.removeGameObject(this);
		}	
				
}
