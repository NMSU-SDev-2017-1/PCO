
public class Calculation {
	
	public int Calc(double time, String Sname, String Aname){
		/*grabs the state and appliance for calc*/
		String place;
	
		State p1 = new State();		
		Appliance item = new Appliance(Aname);	
		
		
		
		p1.SelectState(Sname,time);/*sets peek hour*/
		//item.Applaince_Select(Aname);/*needed time */
		System.out.println( p1.getStartTime());
		
		
	     return 0;
		
	
	}
	

	

}