import java.util.Scanner;
public class MasterProgram {
	public static void main(String args[]) {
		
		Scanner scan = new Scanner(System.in);
		
		String stateList [] = {"nm","tx", "az", "ca" }; 
		
		System.out.println("Please enter state");
		String stateName = scan.next();
		
		for(int i = 0; i < stateList.length; i++) {
		   if(stateName.equals(stateList[i]))
			  //call peak hours
				System.out.println("retreving hours");
		   else
				System.out.println("Please enter correct state");
		}//end for loop for statename
		
		System.out.println("Please enter appliance you want to use");
		String appList [] = {"washer","dryer", "ecar", "dishwasher", "oven", "stove", "heater", "ac" };
		String appName = scan.next();
		
		for(int j = 0; j < appList.length; j++) {
		   if(stateName.equals(appList[j]))
			  //call peak hours
				System.out.println("retreving appiance data");
		   else
				System.out.println("Please enter correct appliance");
		}//end for loop for applianceName
		
		System.out.println("Please enter time");
		int startTime [] = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23};
		int time = scan.nextInt();
		
		for(int k = 0; k < appList.length; k++) {
		   if(startTime[k] == time)
			  //call peak hours
				System.out.println("retreving time");
		   else
				System.out.println("Please enter correct time");
		}//end for loop for startTime
		
			
	}//end main
}//end MasterProgram

