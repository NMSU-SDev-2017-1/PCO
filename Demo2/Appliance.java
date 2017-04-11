import java.io.*;
import java.util.*;
public class Appliance {

   String name;
   double consumption = 0;
   double duration = 0;
   String mode;

   // This is the constructor of the class Appliance
   public Appliance(String name) {
      this.name = name;
   }

   public void mode(String mo, double dur, double con) {
      mode = mo;
   }
   
   
   public double getDuration(){
	   return duration;
   }
   
   // Assign the consumption
   public void setConsumption(double con) {
      consumption = con;
   }

   // Assign the duration
   public void setDuration(double dur) {
      duration = dur;
   }

   /* Print the Appliance details */
   public void printAppliance() {
      System.out.println("Name:"+ name );
      System.out.println("Mode:"+ mode );
      System.out.println("Duration:" + duration );
      System.out.println("Consumption:" + consumption);
   }
   public void Mode_Select(String x, String y){
       
       switch(x){
       case "Dryer":
             switch(y){
                 case"mode1":
                     mode("Mode1", 0.30 , 3);
                 case"mode2":
                     mode("Mode2", 0.30 , 3);
                 case"mode3":
                     mode("Mode3", 0.30 , 3);
             }
              break;
          case "Washer":
              switch(y){
                 case"mode1":
                     mode("Mode1", 0.30 , 3);
                 case"mode2":
                     mode("Mode2", 0.30 , 3);
                 case"mode3":
                     mode("Mode3", 0.30 , 3);
                 }
              break;
          case "Dish Washer":
              switch(y){
                 case"mode1":
                     mode("Mode1", 0.30 , 3);
                 case"mode2":
                     mode("Mode2", 0.30 , 3);
                 case"mode3":
                     mode("Mode3", 0.30 , 3);
                 }
              break;
          case "Stove":
              switch(y){
                 case"mode1":
                     mode("Mode1", 0.30 , 3);
                 case"mode2":
                     mode("Mode2", 0.30 , 3);
                 case"mode3":
                     mode("Mode3", 0.30 , 3);
                 }
              break;
          case "Oven":
              switch(y){
                 case"mode1":
                     mode("Mode1", 0.30 , 3);
                 case"mode2":
                     mode("Mode2", 0.30 , 3);
                 case"mode3":
                     mode("Mode3", 0.30 , 3);
                 }
              break;
       }
       
   }
   public void Applaince_Select(String s2){
       
      /* Scanner scan2 = new Scanner(System.in);
       Scanner scan3 = new Scanner(System.in);*/
       
        
       
          System.out.println("Please Enter Your Appliance");
          //String s2 = scan2.next(); 
          Appliance item = new Appliance(s2);
          
          //controls appliance selection
          switch(s2){
          case "Dryer":
              item.setConsumption(35);      
              item.setDuration(1000);
             // System.out.println("Please Enter Your mode");
             /* String m1 = scan3.next();
              item.Mode_Select("Dryer",m1);*/
              break;
          case "Washer":
              item.setConsumption(34);      
              item.setDuration(100);
            //  System.out.println("Please Enter Your mode");
              /*String m2 = scan3.next(); 
              item.Mode_Select("Washer",m2);*/
              break;
          case "Dish Washer":
              item.setConsumption(33);      
              item.setDuration(10);
            //  System.out.println("Please Enter Your mode");
             /* String m3 = scan3.next(); 
              item.Mode_Select("Dish Washer",m3);*/
              break;
          case "Stove":
              item.setConsumption(32);      
              item.setDuration(1);
             // System.out.println("Please Enter Your mode");
              /*String m4 = scan3.next(); 
              item.Mode_Select("Stove",m4);*/
              break;
          case "Oven":
              item.setConsumption(31);      
              item.setDuration(1);
             // System.out.println("Please Enter Your mode");
              /*String m5 = scan3.next(); 
              item.Mode_Select("Oven",m5);*/
              break;
      }
          item.printAppliance();
   }
   
}