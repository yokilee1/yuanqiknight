package rank;

public class retime {
	long starttime;
	long curtime;
	time ti;
	public retime(int time){
		ti=new time();
		ti.begin();
		this.starttime=time;
		this.curtime=0;
	}
	public long next(){
		return this.curtime=this.starttime-ti.differ();
	}

		

}
