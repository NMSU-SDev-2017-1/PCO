
public class Calculation {
	
	public String Calc(double time, String Sname, String Aname){
		//grabs the state and appliance for calc
		String place;
	
		State p1 = new State();		
		Appliance item = new Appliance();	
		
		
		
		if(p1.SelectState(Sname,time) == 1){
			double x = p1.getPeekHourS();
			double y = item.getDuration();
			double z = x - y;
			return  p1.getName()  + " starts peek hours at \n " + p1.getPeekHourS() + " and ends at  " + p1.getPeekHourE() 
			+ " please start task " + item.getDuration() + " prior or wait till end of peek hours" ; 
		}
		//item.Applaince_Select(Aname);needed time 
		System.out.println( p1.getTime());
		
		
	     return "";
		
	
	}
	

	

}