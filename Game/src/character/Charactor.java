package character;



import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import basicalClass.*;
import colliders.*;
import gameObject.*;
import game.GameWorld;



        
public class Charactor extends GameObject {  
	protected Property property;     //������������Դ�ļ�����	
	protected ActorState curState;
	public GameWorld gameWorld;
	public border bor;//边界
	BeattackedState beattack;//判断是否被攻击
	
	public Charactor(GameWorld gameWorld,Property property) {
		bor=new border();
		this.gameWorld=gameWorld;
		this.property=property;	
		pos=property.pos;
		size = new Point(property.animation.aw,property.animation.ah);
		collider = new CircleCollider(this);	
	    curState = new StopState(this, 10000,property );    	
	    beattack=new BeattackedState(this,property.Image,"hurt"+property.Image);
	    super.score=this.property.score;
		}	
	    public void update(){
	    	curState.update();    	
	    }    
	    
	    @Override
	    public void render(Graphics g){		
			curState.render(g);		
	    }  
	    
		public void keyPressed(int key) {
			curState.keyPressed(key);		
			}			
		public void mouseReleased(MouseEvent e) {
			
		}
		public void switchState(Class nextState){
			ActorState next;
			if(nextState == MoveState.class){
				next = new MoveState(this,1500,property );
			}else if( nextState == StopState.class ){
				next = new StopState(this, 1000000000,property );
			}
			else{
				next = null;
			}
			
			next.setCurDirection(curState.getCurDirection());
			curState.stop();  
			curState = next;   
			curState.start();       		
		}

	
		public Point getPos(){
			return pos;
		}
		public void setPos(Point p){
			property.pos = p;
			pos=p;
		}

		public void setCurState(ActorState next){
			curState = next;
		}
		public ActorState getCurState(){
			return curState;
		}
		public Property getProperty(){
			return property;
		}
	}

