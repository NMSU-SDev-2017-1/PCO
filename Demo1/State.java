import java.io.*;
public class State {

   String name;
   double peekHour;
   double nonPeekHour;

   // This is the constructor of the class State
   public State(String name) {
      this.name = name;
   }

   // Assign the peek hour
   public void peekHour(double peek) {
      peekHour = peek;
   }

   // Assign the non peek
   public void nonPeekHour(double non) {
      nonPeekHour = non;
   }

   /* Print the State details */
   public void printState() {
      System.out.println("Name:"+ name );
      System.out.println("peekHour:" + peekHour );
      System.out.println("nonPeekHour:" + nonPeekHour);
   }

   
   
}