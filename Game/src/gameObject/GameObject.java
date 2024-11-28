package gameObject;

import java.awt.Graphics;

import basicalClass.*;
import colliders.CircleCollider;
import colliders.Collider;



public class GameObject {
	

	public Point pos;              
	public Point size; 
	public double score;//分值
	public Collider collider;  
	
	public void update(){
	  	
	}  
	public void render(Graphics g) {
		
	}
	public boolean collide(GameObject go){	
		return collider.collide(go.getCollider());
	}
	public void onCollision(GameObject go){
		
	}
	
	public Collider getCollider(){
		return collider;
	}
	public void setCollider(Collider c){
		collider = c;
	}
	public int getDamage() {
		// TODO Auto-generated method stub
		return 0;
	}
}
