package gameObject;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import character.ActorState;
import character.Charactor;
import character.MoveState;
import character.Property;
import character.StopState;
import character.border;
import colliders.CircleCollider;
import game.*;
import basicalClass.*;

public class knight extends Charactor{

	  AudioClip shoot; 
	  AudioClip sound; 
		
	public knight(GameWorld gameWorld,Property property) {
		super(gameWorld, property);
		collider = new CircleCollider(this);	
		
		
		ClassLoader classLoader = this.getClass().getClassLoader(); 
		shoot = Applet.newAudioClip(classLoader.getResource("sounds/machinegun.wav")); 
		sound = Applet.newAudioClip(classLoader.getResource("sounds/走路声.wav")); 
		
		
		// TODO Auto-generated constructor stub
	}
	public void onCollision(GameObject go){
		/*if(go.getClass() != knight.class&&go.getClass()!=Ammo.class){   
			NPCAmmo a = (NPCAmmo)go;*/
			super.property.HP -= go.getDamage();   
			if( super.property.HP <= 0 ){
				dead();   
			}
		//}
	}
	@SuppressWarnings("deprecation")
	public void update(){
		
		if(this.getProperty().HP<=0)
			this.dead();
		super.update();
		ArrayList<GameObject> allGameObjects = gameWorld.getAllGameObjects();
		for(GameObject go: allGameObjects){
			if(go.getClass() != knight.class&&go.getClass()!=Ammo.class 
					&&this.collide(go)&&go.getClass()!=Boss.class){		
				onCollision(go);
				return;
			}
			}
		}
	public void render(Graphics g){	
		g.setColor(Color.red);	
		g.drawRect(property.pos.x, property.pos.y+10, property.animation.aw, 10);
		 //设置颜色
		g.fillRect(property.pos.x, property.pos.y+10, property.animation.aw*property.HP/property.maxHP, 10);
		super.render(g);
		
    }  
	public void dead(){
		System.out.println(this+"死了");
		gameWorld.removeGameObject(this);
	}
	public void keyPressed(int key) {
		if(curState.getClass()==MoveState.class) {
			sound.play();
		}
		super.keyPressed(key);		
		}		
	public void mouseReleased(MouseEvent e) {
		if( e.getButton()==MouseEvent.BUTTON3  ){  //�������Ҽ�����			
			shoot(new Point(e.getX(),e.getY()));  //�����������λ�ÿ���
		}
	}
	void shoot(Point target){
		Ammo a = new Ammo(this,new Point(super.pos.x,super.pos.y),new Point(18,18),15,2000,5,target,
				          new Animation2D("宝石.png",1,1));
		shoot.play();;
		a.fire();      		
	}
}
