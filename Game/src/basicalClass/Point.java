package basicalClass;

public class Point {
		public int x,y;   //x,y坐标
		public Point(int x,int y){
			this.x = x;
			this.y = y;
		}	
		public Point(Point p) {
			this.x=p.x;
			this.x=p.y;
		}
		public Point add(Point p) {
			return new Point(this.x+p.x,this.y+p.y);
		}
		

}
