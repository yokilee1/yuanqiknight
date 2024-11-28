package gameObject;

import java.awt.Graphics;
import java.util.ArrayList;

import basicalClass.Animation2D;
import basicalClass.Point;
import character.Charactor;
import colliders.CircleCollider;
import game.GameWorld;

public class NPCAmmo extends GameObject{
	Charactor shooter;   
	int speed;    
	int lifeTime;  
	int damage;
	public long startTime;   
	Point target;   
	double targetAngle;  
	int direction;	
	GameWorld gameWorld;
	Animation2D animation;   

	
	
	public NPCAmmo(Charactor shooter,Point pos,
			Point size,int speed,int lifeTime,
			int damage,Point target,Animation2D animation
			){
		this.shooter = shooter;
		gameWorld = shooter.gameWorld;
		this.pos = pos;
		this.size = size;
		this.speed = speed;
		this.lifeTime = lifeTime;
		this.damage = damage;
		this.target = target;
		this.animation = animation;
		collider = new CircleCollider(this);		
		
	}
	
	public void update(){
		if( System.currentTimeMillis() - startTime >= lifeTime ){
			dead();			
		}else{
			ArrayList<GameObject> allGameObjects = gameWorld.getAllGameObjects();
			for(GameObject go: allGameObjects){
				if(target != null ){
					moveTarget();
					if(  go.getClass() == knight.class && this.collide(go)){		
					go.onCollision(this); 
					gameWorld.removeGameObject(this); 			
					return;
				}	
				}
				
			}
					
		}				
	}

	public void render(Graphics g){
		g.drawImage( animation.animImg,
				     pos.x,pos.y,
 			         null);
	}
	public void fire(){
		startTime = System.currentTimeMillis();  
		if(target != null){
			int dx = target.x - pos.x;
		    int dy = target.y - pos.y;
		    targetAngle = Math.atan2(dy, dx);  
		}
		direction = shooter.getCurState().getCurDirection();
		gameWorld.addGameObject(this);  	
	}
	public void dead(){
		gameWorld.removeGameObject(this);
	}
	
	void moveTarget(){		    	    
	    int vx = (int)(speed*Math.cos(targetAngle));
	    int vy = (int)(speed*Math.sin(targetAngle));
	    
	    pos.x = pos.x + vx;
	    pos.y = pos.y + vy;	     
	}

    
    public int getDamage(){
    	return damage;
    }
}
