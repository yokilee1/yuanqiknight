package game;

public class timeex {
	public String time;
	
	public timeex(){time="";}
	public void ex(int ti){
		if(ti<=60){
			time= ti+"秒";
		}else if(ti>60&&ti<=3600){
			time=(ti/60)+"分"+(ti%60)+"秒";
		}else if(ti>3600){
			time=(ti/3600)+"时"+(ti%3600/60)+"分"+(ti%3600%60)+"秒";
		}		
	}

}
