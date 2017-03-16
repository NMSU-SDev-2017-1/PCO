import java.io.*;
public class Appliance {

   String name;
   double consumption;
   double duration;
   String mode;

   // This is the constructor of the class Appliance
   public Appliance(String name) {
      this.name = name;
   }

   public void mode(String mo) {
      mode = mo;
   }

   // Assign the consumption
   public void consumption(double con) {
      consumption = con;
   }

   // Assign the duration
   public void duration(double dur) {
      duration = dur;
   }

   /* Print the Appliance details */
   public void printAppliance() {
      System.out.println("Name:"+ name );
      System.out.println("Mode:"+ mode );
      System.out.println("Duration:" + duration );
      System.out.println("Consumption:" + consumption);
   }

   
   
}