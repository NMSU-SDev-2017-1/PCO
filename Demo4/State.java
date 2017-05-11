import java.io.*;
import javax.swing.*;
import java.util.*;
import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;



@XmlRootElement
public class State {

	
	
	private double time;  
	private String name;
	private double peekHourS;
	private double peekHourE;
/*	private List<State> answers; */ 
	
	  // This is the constructor of the class State
	
	public State() {}  
	
	public State(double time, double peekHourS, double peekHourE, String name/*, List<State> answers*/) {  
	    super();  
	    this.time = time;  
	    this.peekHourS = peekHourS;  
	    this.peekHourE = peekHourE;
	    this.name =  name;
	    /*this.answers = answers; */
	}  
	@XmlAttribute  
	public String getName() {  
	    return name;  
	}  
	public void setName(String name) {  
	    this.name = name;  
	}  
	@XmlElement   
	public double getTime() {  
	    return time;  
	}  
	public void setTime(double time) {  
	    this.time = time;  
	}  
	
	@XmlElement  
	 //gets peek hour START
	public double getPeekHourS(){
	   return peekHourS;
    }
	   
	 // Assign the peek hour START
	public void setPeekHourS(double peek) {
	    this.peekHourS = peek;
	}

	
	@XmlElement  
     //gets peek hour END
	 public double getPeekHourE(){
		 return peekHourE;
     }
	   
	 // Assign the peek hour END
	 public void setPeekHourE(double peek) {
	     this.peekHourE = peek;
	  }
	   	

   
     

   // Print the State details 
   public String printState() {
	
      String.valueOf(peekHourS);
      
      return ("Name:"+ name.toString() + "peekHour: "+ String.valueOf(peekHourS)+"\n"   );
   }

}