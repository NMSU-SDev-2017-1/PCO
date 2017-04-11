import java.io.*;

import javax.swing.*;

import java.util.*;
public class State {

   String name;
   double peekHour;
   double time;

   // This is the constructor of the class State
   public State() {
      
   }
   
   public double getStartTime(){
	   return time;
   }
   
   public void setStartTime(double stime){
	   this.time = stime;
   }
   
   //gets peek hour
   public double getPeekHour(){
	   return peekHour;
   }
   
   // Assign the peek hour
   public void setPeekHour(double peek) {
      this.peekHour = peek;
   }


   /* Print the State details */
   public String printState() {
	 // System.out.println("Name:"+ name.toString() );
    /*  System.out.println("peekHour:" + peekHour.toString() );
      System.out.println("nonPeekHour:" + nonPeekHour.toString());
      */
      String.valueOf(peekHour);
      
      return ("Name:"+ name.toString() + "peekHour: "+ String.valueOf(peekHour)+"\n"   );
   }

  public void SelectState(String x,double y){
	   
	  /* Scanner scan1 = new Scanner(System.in);
	   //asks for user input
	   System.out.println("Please Enter Your State");
		  String s1 = scan1.next(); */
	  State place = new State();
	      //String y = x;
	      System.out.println(x);
		  //controls state selection
	     
	      
	      switch(x){
	    	  case "New Mexico":
	    		  setStartTime(y);  
	    		  System.out.println(getStartTime());	
	    		  for(double z = 8; z<=20; z++){//based of military time
	    				if(z == getStartTime() ){
	    					System.out.println("Suggest new time: ");
	    					
	    				}		
	    			}//loop end
	    	      break;
	    	  case "Texas":
	    		  setStartTime(y);      
	    	      
	    	      break;
	    	  case "AZ":
	    		  setStartTime(y);      
	    	      
	    	      break;
	    	  case "CA":
	    		  setStartTime(y);      
	    	      
	    	      break;
	      }
	   
	     // place1.printState();

   }
   
}