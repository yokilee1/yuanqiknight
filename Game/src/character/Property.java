package character;

import basicalClass.*;

public class Property {
	public double score;//分值
	public int HP;		//生命值；
	public int speed;	//速度
	public String Image;	//角色图片
	public Point pos;	//角色位置
	public int curDirection;
	public int lr=0;		//判断左右
	public Animation2D animation;
	public int maxHP;
	
	public Property(double sc,int hp,int speed,String ima,Point pos,int curDirection) {
		this.score=sc;
		this.HP=hp;
		this.maxHP=hp;
		this.speed=speed;
		this.Image=ima;
		this.pos=pos;
		this.curDirection=curDirection;
		animation=new Animation2D(Image,1,2);
		this.pos=new Point(pos.x,pos.y);
	}
}
