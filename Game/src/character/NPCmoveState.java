package character;

import basicalClass.Point;
import gameObject.GameObject;

public class NPCmoveState extends ActorState{
  
	double targetAngle;  
	int direction;	
	Point pos;
	
	public NPCmoveState(Charactor ch, float maxLifeTime, Property pro) {
		super(ch, maxLifeTime, pro);
		this.pos=ch.pos;
		// TODO Auto-generated constructor stub
	}

	public void moveTarget(GameObject target){
		if(target != null){
			int dx = target.pos.x - pos.x;
		    int dy = target.pos.y - pos.y;
		    targetAngle = Math.atan2(dy, dx);  
		}
		
	    int vx = (int)(speed*Math.cos(targetAngle));
	    int vy = (int)(speed*Math.sin(targetAngle));
	    
	    pos.x = pos.x + vx;
	    pos.y = pos.y + vy;	   
	    
	    if( vx<0 ){  //左
    		
    		property.lr=1;
    	}else if( vx>0 ){  //右
    		
    		property.lr=0;
    	}
	}

	
	@Override
	public void keyPressed(int key) {
		// TODO Auto-generated method stub
		
	}

}
