package colliders;

import basicalClass.Point;
import gameObject.GameObject;


public class CircleCollider extends Collider{
	
	
	public CircleCollider(GameObject host) {
		super(host);		
	}
		
	public boolean collide(Collider another){
		//求中点
		center = new Point(host.pos.x+host.size.x/2,host.pos.y+host.size.y/2);
		//距离计算
		double distance = Math.sqrt((center.x-(another.pos.x+another.size.x/2))*(center.x-(another.pos.x+another.size.x/2))
				+(center.y-(another.pos.y+another.size.y/2))*(center.y-(another.pos.y+another.size.y/2)));
		if(distance <= radius+another.radius){  //判断碰撞
			return true;
		}else{
			return false;
		}
	}
	public void setRadius(float r){
		radius = r;
	}
}

