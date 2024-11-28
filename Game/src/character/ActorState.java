package character;

import java.awt.Graphics;

import basicalClass.*;
import colliders.*;
import gameObject.*;


public abstract class ActorState {
	Charactor charactor;             //角色
	String name;               //名字
	long startTime;          //开始时间
	float maxLifeTime;         //最大存活时间
	int speed;                 //速度
	Property property;
	Animation2D animation;    //动画
	 					
	
	public ActorState(Charactor ch,float maxLifeTime,Property pro){
		this.charactor = ch;		
		this.maxLifeTime = maxLifeTime;
		this.property=pro;
		this.speed=property.speed;
		animation=new Animation2D(pro.Image,1,2);

	}	
	


	public void start(){
		setStartTime(System.currentTimeMillis());   //获取当前时间
		
	}
	public void stop(){
		
	}
	public void update(){   	            	
		move();         		
	}
	
	public void moveTarget(GameObject target){
		
	}
	
	void move(){
		if(charactor.bor.isout(charactor.getPos(), property.curDirection))
			return;//触碰边界
    	if( property.curDirection == 0 ){   //上
    		charactor.setPos(new Point(charactor.getPos().x,charactor.getPos().y-speed));    		    		
    	}else if( property.curDirection == 1 ){  //下
    		charactor.setPos(new Point(charactor.getPos().x,charactor.getPos().y+speed));     		
    	}else if( property.curDirection == 2 ){  //左
    		charactor.setPos(new Point(charactor.getPos().x-speed,charactor.getPos().y)); 
    		property.lr=1;
    	}else if( property.curDirection == 3 ){  //右
    		charactor.setPos(new Point(charactor.getPos().x+speed,charactor.getPos().y)); 
    		property.lr=0;
    	}
    }
	
	public void setStartTime(long time){
  		startTime = time;
  	}

	protected void setCurDirection(int i) {
		property.curDirection=i;// TODO Auto-generated method stub
	}
	
	public int getCurDirection() {
		return property.curDirection;// TODO Auto-generated method stub

	}
	
	
	abstract public void keyPressed(int key);

	public void render(Graphics g){		
      	g.drawImage( animation.animImg,
      			     charactor.getPos().x,charactor.getPos().y, 
      			     charactor.getPos().x+animation.aw,charactor.getPos().y+animation.ah,
      			     0,animation.aw*property.lr,animation.aw,animation.ah+animation.aw*property.lr,
      			      null);
    }    

}
