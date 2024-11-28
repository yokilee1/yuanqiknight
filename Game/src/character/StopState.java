package character;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

import basicalClass.*;
import colliders.*;
import gameObject.*;

public class StopState extends ActorState{
	
	
	
	public StopState(Charactor ch, float maxLifeTime,Property pro) {
			super(ch,maxLifeTime,pro);
		// TODO Auto-generated constructor stub
	}
	//更新
	public void update(){
		
	}
	
	@Override
	public void keyPressed(int key) {
		//使用awsd键
		if( key == KeyEvent.VK_W ){  //按w键
			super.setCurDirection(0);  //设为上		
			charactor.switchState(MoveState.class);       //行走模式			
		}else if( key == KeyEvent.VK_S ){
			this.setCurDirection(1);  //����״̬�ĵ�ǰ����
			charactor.switchState(MoveState.class);       //行走模式
		}else if( key == KeyEvent.VK_A ){
			this.setCurDirection(2);  //����״̬�ĵ�ǰ����
			charactor.switchState(MoveState.class);       //行走模式
		}else if( key == KeyEvent.VK_D ){
			this.setCurDirection(3);  //����״̬�ĵ�ǰ����	
			charactor.switchState(MoveState.class);       //行走模式
		}

	}
	
}
