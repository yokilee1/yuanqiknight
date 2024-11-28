package rank;


public class time {
	long begintime;//开始时间；
	long endtime;//结束时间
	long differ;

	public time(){}
	public void begin(){
		begintime=System.currentTimeMillis();
	}
	public long differ(){
		endtime=System.currentTimeMillis();
		return differ=(endtime-begintime)/1000;
	}
	}
