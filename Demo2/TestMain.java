import java.util.*;
import java.io.*;
public class TestMain {

   public static void main(String args[]) {
      /* Create one objects using constructor */
	   String s1 = null;
	  // Calculation place1 = new Calculation();
	   
	   State place2 = new State();
	   
	  /* String s2 = null;
	   Appliance Item = new Appliance(s2);*/
	   
	   
	   place2.SelectState("New Mexico",52.210);
	  /* Item.Applaince_Select(s2);*/
	   //place1.setPeekHour(15);

	   System.out.println(place2.getStartTime());
	   
	  

   }
}