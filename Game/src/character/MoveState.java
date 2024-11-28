package character;

import java.awt.event.KeyEvent;

import basicalClass.*;
import colliders.*;
import gameObject.*;


public class MoveState extends ActorState{
	public MoveState(Charactor ch, float maxLifeTime, Property pro) {
		super(ch,maxLifeTime,pro);
		// TODO Auto-generated constructor stub
	}
	
	public void update(){
		if( System.currentTimeMillis() - startTime >= maxLifeTime ){ //运行时间		
			charactor.switchState(StopState.class);       //静止模式
    	}else{
    		super.update();
    	}		
	}
	
	@Override
	public void keyPressed(int key) {
		if( key == KeyEvent.VK_W ){  
			this.setCurDirection(0);  
			charactor.switchState(MoveState.class);       			
		}else if( key == KeyEvent.VK_S ){
			this.setCurDirection(1); 
			charactor.switchState(MoveState.class);      
		}else if( key == KeyEvent.VK_A ){
			this.setCurDirection(2);  
			charactor.switchState(MoveState.class);       
		}else if( key == KeyEvent.VK_D ){
			this.setCurDirection(3);  
			charactor.switchState(MoveState.class);      
		}
	}

}
