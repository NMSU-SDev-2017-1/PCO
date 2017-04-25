import java.io.*;
import java.util.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

	
@XmlRootElement	
public class Appliance {  
private double consumption;  
private double duration;  
private String Aname;  


public Appliance() {}  
public Appliance(double consumption, double duration, String Aname) {  
    super();  
    this.consumption = consumption;  
    this.duration = duration;  
    this.Aname = Aname;  
}

@XmlElement
public double getConsumption() {  
    return consumption;  
} 

public void setConsumption(double consumption) {  
    this.consumption = consumption;  
}

@XmlElement
public double getDuration() {  
    return duration;  
} 

public void setDuration(double duration) {  
    this.duration = duration;  
}

@XmlAttribute
public String getAname() {  
    return Aname;  
} 

public void setAname(String Aname) {  
    this.Aname = Aname;  
} 
	
	
	



   /* Print the Appliance details 
   public void printAppliance() {
      System.out.println("Name:"+ name );
      System.out.println("Mode:"+ mode );
      System.out.println("Duration:" + duration );
      System.out.println("Consumption:" + consumption);
   }

       
   }*/
   public void Applaince_Select(String s2){
       
  
	      System.out.println(s2);
	   
          
	      try {  
	    	   
		         File file = new File("State_Appliance.xml");  
	        JAXBContext jaxbContext = JAXBContext.newInstance(Data.class);  
		    
		         Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();  
		         Data que= (Data) jaxbUnmarshaller.unmarshal(file);  
		         
		         List<Appliance> list=que.getAnswers2();
		               
		         for(Appliance ans:list){  
			            
		         if(ans.getAname().equals(s2)){	        	  
		        	   setAname(ans.getAname());
		        	   setDuration(ans.getDuration());
		        	   setConsumption(ans.getConsumption());
		        	   System.out.println(getAname());
		           }  
		     
		         }
				
		    
		       } catch (JAXBException e) {  
		         e.printStackTrace();  
		       }
	      
	      
	      
	      
	      
	      
	      
	      
	      
	      
	      
	      
	/*      switch(s2){
         
         
          case "Dryer":
              setConsumption(1.44);      
              setDuration(0.9);
             // System.out.println("Please Enter Your mode");
              String m1 = scan3.next();
              item.Mode_Select("Dryer",m1);
              break;
          case "Washer":
              setConsumption(0.254);      
              setDuration(0.583);
            //  System.out.println("Please Enter Your mode");
              String m2 = scan3.next(); 
              item.Mode_Select("Washer",m2);
              break;
          case "Dish Washer":
              setConsumption(0.7174);      
              setDuration(1.7);
            //  System.out.println("Please Enter Your mode");
              String m3 = scan3.next(); 
              item.Mode_Select("Dish Washer",m3);
              break;
          case "Stove":
              setConsumption(0);      
              setDuration(1);
             // System.out.println("Please Enter Your mode");
              String m4 = scan3.next(); 
              item.Mode_Select("Stove",m4);
              break;
          case "Oven":
              setConsumption(0.753);//kwh      
              setDuration(0.3);
             // System.out.println("Please Enter Your mode");
              String m5 = scan3.next(); 
              item.Mode_Select("Oven",m5);
              break;
      }
         // item.printAppliance();
   }*/
   }
   
}