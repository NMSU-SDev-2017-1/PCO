import java.util.*;
import java.io.*;
public class TestMain {

   public static void main(String args[]) {
      /* Create one objects using constructor */
	   
	  Scanner scan1 = new Scanner(System.in);
	  Scanner scan2 = new Scanner(System.in);
	  Scanner scan3 = new Scanner(System.in);
	 
	  System.out.println("Please Enter Your State");
	  String s1 = scan1.next(); 
      State place1 = new State(s1);
      
      System.out.println("Please Enter Your Appliance");
	  String s2 = scan2.next(); 
	  Appliance item = new Appliance(s2);
      
	  //controls state selection
      switch(s1){
    	  case "NM":
    		  place1.peekHour(26);      
    	      place1.nonPeekHour(1000);
    	      break;
    	  case "TX":
    		  place1.peekHour(25);      
    	      place1.nonPeekHour(100);
    	      break;
    	  case "AZ":
    		  place1.peekHour(24);      
    	      place1.nonPeekHour(10);
    	      break;
    	  case "CA":
    		  place1.peekHour(23);      
    	      place1.nonPeekHour(1);
    	      break;
      }
      
      //controls appliance selection
      switch(s2){
	  case "Dryer":
		  item.consumption(35);      
		  item.duration(1000);
		  System.out.println("Please Enter Your mode");
		  String m1 = scan3.next();
		  item.mode(m1);
	      break;
	  case "Washer":
		  item.consumption(34);      
		  item.duration(100);
		  System.out.println("Please Enter Your mode");
		  String m2 = scan3.next(); 
		  item.mode(m2);
	      break;
	  case "Dish Washer":
		  item.consumption(33);      
		  item.duration(10);
		  System.out.println("Please Enter Your mode");
		  String m3 = scan3.next(); 
		  item.mode(m3);
	      break;
	  case "Stove":
		  item.consumption(32);      
		  item.duration(1);
		  System.out.println("Please Enter Your mode");
		  String m4 = scan3.next(); 
		  item.mode(m4);
	      break;
	  case "Oven":
		  item.consumption(31);      
		  item.duration(1);
		  System.out.println("Please Enter Your mode");
		  String m5 = scan3.next(); 
		  item.mode(m5);
	      break;
  }
      
      place1.printState();
      item.printAppliance();

   }
}