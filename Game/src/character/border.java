package character;

import basicalClass.Point;

public class border {
	public Point lr,ud;//左右、上下边界
	public border(){
		lr=new Point(120,1030);
		ud=new Point(120,900);
	}
	public void setbor(Point a,Point b){
		lr=a;
		ud=b;
	}
	public boolean  isout(Point a,int dir){
		if((a.x<=lr.x&&dir==2)||(a.x>=lr.y&&dir==3)||(a.y<=ud.x&&dir==0)||(a.y>=ud.y&&dir==1))
			return true;
		else
			return false;
	}
}
