package rank;

public class score {
	public double sc;
	public score(){}
	public void start(){
		sc=0;
	}
	public void getscore(double a){
		sc+=a;
	}
	public void gettisc(int ti){

			if(ti<=52)
				sc+=50.0;
			else if(ti>52&&ti<=112){
			sc+=(112-ti)*1.0/60*50.0 ;	
			}
	}
}
