package character;

import gameObject.GameObject;

public class BeattackedState {
	Charactor charactor;
	String norima;
	String hurtima;
	BeattackedState(Charactor charactor,String norima,String hurtima){
		this.charactor=charactor;
		this.hurtima=hurtima;
		this.norima=norima;
	}
	void beattack(GameObject ga) {
		if(charactor.collide(ga)) {
			charactor.property.Image=hurtima;
		}else
			charactor.property.Image=norima;
	}
	
	
}
