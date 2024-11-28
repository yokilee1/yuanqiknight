package gameObject;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import character.*;
import colliders.CircleCollider;
import game.GameWorld;

public class guard extends Charactor{
	int count=0;
	public guard(GameWorld gameWorld, Property property) {
		super(gameWorld, property);
		collider = new CircleCollider(this);	
		curState=new NPCmoveState(this,1000,property);
		// TODO Auto-generated constructor stub
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
					curState.moveTarget(go);		
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
			count=0;
			return 2;
		}else {
			count++;
			return 0;
		}
	}
}

