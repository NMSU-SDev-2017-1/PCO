import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class Calculation {
	
	
	public String SelectState(String x,double y){
		State p1 = new State();			  
		  try {  
	   	   
		         File file = new File("State_Appliance.xml");  
		         JAXBContext jaxbContext = JAXBContext.newInstance(Data.class);  
		    
		         Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();  
		         Data que= (Data) jaxbUnmarshaller.unmarshal(file);  
		           	       
		         List<State> list=que.getAnswers();
		     
		         for(State ans:list) { 
		           	           
		           if(ans.getName().equals(x) ){
		        	   
		        	  
		        	  // System.out.println(getName());
		        	   p1.setName(ans.getName());
		        	   p1.setPeekHourS(ans.getPeekHourS());
		        	   p1.setPeekHourE(ans.getPeekHourE());
		        	   
		        	   if(ans.getName().equals("New Mexico"))
		        	   for(double z = 8; z<=20; z++){//based of military time
		    				if(z == y ){
		    					System.out.println("Suggest new time: ");
		    					return  p1.getName()  + " starts peek hours at \n " + p1.getPeekHourS() + " and ends at  " + p1.getPeekHourE() 
		    					+ " please  start task prior to peek hours or wait till end of peek hours" ; 
		    					
		    				}//end of if		
		    			}//loop end
		        	   
		        	   if(ans.getName().equals("Texas"))
		        	   for(double z = 7; z<=21; z++){//based of military time
		    				if(z == y ){
		    					System.out.println("Suggest new time: ");
		    					return  p1.getName()  + " starts peek hours at \n " + p1.getPeekHourS() + " and ends at  " + p1.getPeekHourE() 
		    					+ " please  start task prior to peek hours or wait till end of peek hours" ; 
		    					
		    				}		
		    			}//loop end
		        	   
		        	   if(ans.getName().equals("Arizona"))
		        	   for(double z = 12; z<=19; z++){//based of military time
		    				if(z == y ){
		    					System.out.println("Suggest new time: ");
		    					return  p1.getName()  + " starts peek hours at \n " + p1.getPeekHourS() + " and ends at  " + p1.getPeekHourE() 
		    					+ " please  start task prior to peek hours or wait till end of peek hours" ;  
		    					
		    				}		
		    			}//loop end
		        	   if(ans.getName().equals("California"))
		        	   for(double z = 12; z<=18; z++){//based of military time
		    				if(z == y){
		    					System.out.println("Suggest new time: ");
		    					return  p1.getName()  + " starts peek hours at \n " + p1.getPeekHourS() + " and ends at  " + p1.getPeekHourE() 
		    					+ " please  start task prior to peek hours or wait till end of peek hours" ; 
		    					
		    				}		
		    			}//loop end
		           }//end of first if
		           
		           
		         }
		    
	   
		       } catch (JAXBException e) {  
		         e.printStackTrace();  
		       } 
		    
		      return "Good to start task";
	  }
	
	/*public String Calc(double time, String Sname, String Aname){//output one
		//grabs the state and appliance for calc
		String place;
	
		State p1 = new State();		
		Appliance item = new Appliance();	
		
		
		
		if(p1.SelectState(Sname,time) == 1){
			double x = p1.getPeekHourS();
			double y = item.getDuration();
			double z = x - y;
			return  p1.getName()  + " starts peek hours at \n " + p1.getPeekHourS() + " and ends at  " + p1.getPeekHourE() 
			+ " please start task " + item.getDuration() + " prior or wait till end of peek hours" ; 
		}
		//item.Applaince_Select(Aname);needed time 
		System.out.println( p1.getTime());
		
		
	     return "";
		
	
	}*/
	
	public String usage(String s3){//output two
		
		
		
		
	    	  Appliance x = new Appliance();
		      try {  
		    	
			         File file1 = new File("Adata.xml");  
		        JAXBContext jaxbContext = JAXBContext.newInstance(Data.class);  
		    	
			         Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();  
			         Data que1= (Data) jaxbUnmarshaller.unmarshal(file1);  
			    
			         List<Appliance> list1=que1.getAnswers3();
			       
			        
			     	for(Appliance ans:list1){  
			        		    
			       
			        		if(ans.getMode().equals(s3)){
			        			
			        			return "you will consume " + ans.getConsumption() + " and it will take aproximatly" + ans.getDuration() ;
			        		}
			        	
			        	  
			           }  
			    
			         
					
			    
			       } catch (JAXBException e) {  
			         e.printStackTrace();  
			       }
		
		
		      return "Error";
		}
	



}