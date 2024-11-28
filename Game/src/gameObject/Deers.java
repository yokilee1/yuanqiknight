package gameObject;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import basicalClass.Animation2D;
import basicalClass.Point;
import character.Charactor;
import character.Property;
import game.GameWorld;

public class Deers extends Charactor{

	public Deers(GameWorld gameWorld, Property property) {
		super(gameWorld, property);
		// TODO Auto-generated constructor stub
	}
	public void onCollision(GameObject go){
		/*if(go.getClass() != knight.class&&go.getClass()!=Ammo.class){   
			NPCAmmo a = (NPCAmmo)go;*/
			
		//}
	}
	public void update(){
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
		

		//g.setFont(new Font("黑体",Font.BOLD,20));
		//g.drawString("按F键回复生命", property.pos.x, property.pos.y-20);
		curState.render(g);
		
    }  
	
	public void keyPressed(int key) {
		if(key == KeyEvent.VK_F) {
			ArrayList<GameObject> allGameObjects = gameWorld.getAllGameObjects();
			for(GameObject go: allGameObjects){
				if(  go.getClass() == knight.class ){		
					knight k=(knight)go;
					k.getProperty().HP+=3;
					return;
				}	
			}
		}
	}		
	public void mouseReleased(MouseEvent e) {
		
	}
	
}
