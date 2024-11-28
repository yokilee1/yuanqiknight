package game;

import rank.time;

public class boss {
	public String warning[];
	time t;
	public boolean isstart=false;
	public boolean isemgage=false;
	public boolean isargue=false;
	public boss(){
		warning=new String[4];
		t=new time();
		warning[0]="Boss  Warning";
		warning[1]="     3";
		warning[2]="     2";
		warning[3]="     1";
	}
	public void start(){
		t.begin();
		isstart=true;
	}
}
