package colliders;


import gameObject.*;
import basicalClass.*;

public class Collider extends GameObject{
	GameObject host;   
	Point center;   
	float radius;    
	
	public Collider(GameObject host){
		this.host = host;
		this.pos=host.pos;
		this.size=host.size;
		collider=host.collider;
		center = host.pos;
		if(host.getClass()==Boss.class) {
			center = host.pos.add(host.size);
		}
		if( host.size.x > host.size.y ){
			radius = host.size.x/2;
		}else{
			radius = host.size.y/2;
		}
	}
	
	public boolean collide(Collider another){
		return false;
	}
}