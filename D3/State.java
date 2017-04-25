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

  public int SelectState(String x,double y){
	 
     
	  
	  
	  try {  
   	   
	         File file = new File("State_Appliance.xml");  
	         JAXBContext jaxbContext = JAXBContext.newInstance(Data.class);  
	    
	         Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();  
	         Data que= (Data) jaxbUnmarshaller.unmarshal(file);  
	           	       
	         List<State> list=que.getAnswers();
	     
	         for(State ans:list) { 
	           	           
	           if(ans.getName().equals(x) ){
	        	   
	        	   setName(ans.getName());
	        	   setTime(ans.getTime());
	        	   setPeekHourS(ans.getPeekHourS());
	        	   setPeekHourE(ans.getPeekHourE());
	        	  // System.out.println(getName());
	        	   
	        	   
	        	   if(getName().equals("New Mexico"))
	        	   for(double z = 8; z<=20; z++){//based of military time
	    				if(z == getTime() ){
	    					//System.out.println("Suggest new time: ");
	    					return 0;
	    					
	    				}//end of if		
	    			}//loop end
	        	   
	        	   if(getName().equals("Texas"))
	        	   for(double z = 8; z<=20; z++){//based of military time
	    				if(z == getTime() ){
	    					System.out.println("Suggest new time: ");
	    					return 0;
	    					
	    				}		
	    			}//loop end
	        	   
	        	   if(getName().equals("Arizona"))
	        	   for(double z = 12; z<=19; z++){//based of military time
	    				if(z == getTime() ){
	    					System.out.println("Suggest new time: ");
	    					return 0;
	    					
	    				}		
	    			}//loop end
	        	   if(getName().equals("California"))
	        	   for(double z = 12; z<=19; z++){//based of military time
	    				if(z == getTime() ){
	    					System.out.println("Suggest new time: ");
	    					return 0;
	    					
	    				}		
	    			}//loop end
	           }//end of first if
	           
	           
	         }
	    
   
	       } catch (JAXBException e) {  
	         e.printStackTrace();  
	       } 
	    
	      return 1;
  }
  
}
  


  
	      
	      
	      
  
	    	 /* case "Texas":    put real peak hours 
	    		  setPeekHourS(8);
	    		  setPeekHourE(20);
	    		  setStartTime(y);  
	    		  System.out.println(getStartTime());	
	    		  for(double z = 8; z<=20; z++){//based of military time
	    				if(z == getStartTime() ){
	    					System.out.println("Suggest new time: ");
	    					return 0;
	    					
	    				}		
	    			}//loop end
	    	      break;
	    	  case "Arizona":	
	    		  setPeekHourS(12);
	    		  setPeekHourE(19);
	    		  setStartTime(y);  
	    		  System.out.println(getStartTime());	
	    		  for(double z = 12; z<=19; z++){//based of military time
	    				if(z == getStartTime() ){
	    					System.out.println("Suggest new time: ");
	    					return 0;
	    					
	    				}		
	    			}//loop end
	    	      break;
	    	  case "California": put real peak hours 
	    		  setPeekHourS(8);
	    		  setPeekHourE(20);
	    		  setStartTime(y);      
	    		  System.out.println(getStartTime());	
	    		  for(double z = 12; z<=19; z++){//based of military time
	    				if(z == getStartTime() ){
	    					System.out.println("Suggest new time: ");
	    					return 0;
	    					
	    				}		
	    			}//loop end
	    	      break;
	      }
	   
	     return 1;

   }*/
   
