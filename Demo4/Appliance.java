import java.io.*;
import java.util.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


	
@XmlRootElement	
public class Appliance {  
private double consumption;  
private double duration;  
private String Aname; 
private String Amode;




public Appliance() {}  
public Appliance(double consumption, double duration,  String Amode) {  
    super();  
    this.consumption = consumption;  
    this.duration = duration;  
    this.Aname = Aname;  
    this.Amode = Amode;
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
@XmlAttribute
public String getMode(){
	return Amode;
}

public void setMode(String Amode){	
	this.Amode = Amode;
}
	



   public void Appliance_Select(String s2){
       
  
	      System.out.println(s2);
	     Appliance x = new Appliance();
          
	      try {  
	    	   
		         File file = new File("State_Appliance.xml");  
	        JAXBContext jaxbContext = JAXBContext.newInstance(Data.class);  
		    
		         Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();  
		         Data que= (Data) jaxbUnmarshaller.unmarshal(file);  
		         
		         List<Appliance> list=que.getAnswers2();
		               
		         for(Appliance ans:list){  
			            
		         if(ans.getAname().equals(s2)){	        	  
		        	   x.setAname(ans.getAname());
		        	
		        	   System.out.println(x.getAname());
		           }  
		     
		         }
				
		    
		       } catch (JAXBException e) {  
		         e.printStackTrace();  
		       }
	      
   }
   
   public void DMode_Select(String s3) throws Exception{
	   
	   Appliance x = new Appliance();
	      try {  
	    	
		         File file1 = new File("Washer.xml");  
	        JAXBContext jaxbContext = JAXBContext.newInstance(Data.class);  
	    	
		         Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();  
		         Data que1= (Data) jaxbUnmarshaller.unmarshal(file1);  
		    
		         List<Appliance> list1=que1.getAnswers3();
		       
		        
		     	for(Appliance ans:list1){  
		        		    		       
		        		if(ans.getMode().equals(s3)){	 
		        		
		        	   System.out.println("I am here");
		        	   setMode(ans.getMode());
		        	   setDuration(ans.getDuration());
		        	   setConsumption(ans.getConsumption());
		        		System.out.println("I am here");
		        	  
		           }  
		     
		         }
				
		    
		       } catch (JAXBException e) {  
		         e.printStackTrace();  
		       }
	      
	      
	      aData(getDuration(),getConsumption(),getMode());
   }
   
   
   public void WMode_Select(String s3) throws Exception{
	   
	   Appliance x = new Appliance();
	      try {  
	    	
		         File file1 = new File("Washer.xml");  
	        JAXBContext jaxbContext = JAXBContext.newInstance(Data.class);  
	    	
		         Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();  
		         Data que1= (Data) jaxbUnmarshaller.unmarshal(file1);  
		    
		         List<Appliance> list1=que1.getAnswers3();
		       
		        
		     	for(Appliance ans:list1){  
		        		    		       
		        		if(ans.getMode().equals(s3)){	 
		        		
		        	   System.out.println("I am here");
		        	   setMode(ans.getMode());
		        	   setDuration(ans.getDuration());
		        	   setConsumption(ans.getConsumption());
		        		System.out.println("I am here");
		        	  
		           }  
		     
		         }
				
		    
		       } catch (JAXBException e) {  
		         e.printStackTrace();  
		       }
	      
	      
	      aData(getDuration(),getConsumption(),getMode());
   }
	      public void DWMode_Select(String s3)throws Exception{
	    	  Appliance x = new Appliance();
		      try {  
		    	
			         File file1 = new File("Dishwasher.xml");  
		        JAXBContext jaxbContext = JAXBContext.newInstance(Data.class);  
		    	
			         Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();  
			         Data que1= (Data) jaxbUnmarshaller.unmarshal(file1);  
			    
			         List<Appliance> list1=que1.getAnswers3();
			       
			        
			     	for(Appliance ans:list1){  
			        		    
			       
			        		if(ans.getMode().equals(s3)){	 
			        		System.out.println("I am here");
			        	   setMode(ans.getMode());
			        	   setDuration(ans.getDuration());
			        	   setConsumption(ans.getConsumption());
			        		System.out.println("I am here");
			        	  
			           }  
			     
			         }
					
			    
			       } catch (JAXBException e) {  
			         e.printStackTrace();  
			       }
	            
	      
		      aData(getDuration(),getConsumption(),getMode());
	      }
   
	      public void OMode_Select(String s3)throws Exception{
	    	  Appliance x = new Appliance();
		      try {  
		    	
			         File file1 = new File("Oven.xml");  
		        JAXBContext jaxbContext = JAXBContext.newInstance(Data.class);  
		    	
			         Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();  
			         Data que1= (Data) jaxbUnmarshaller.unmarshal(file1);  
			    
			         List<Appliance> list1=que1.getAnswers3();
			       
			        
			     	for(Appliance ans:list1){  
			        		    
			       
			        		if(ans.getMode().equals(s3)){	 
			        		System.out.println("I am here");
			        	  setMode(ans.getMode());
			        	  setDuration(ans.getDuration());
			        	  setConsumption(ans.getConsumption());
			        	   
			        	  
			        	   
			        		System.out.println("I am here");
			        	  
			           }  
			     
			         }
					
			    
			       } catch (JAXBException e) {  
			         e.printStackTrace();  
			       }
	            
	      
		      aData(getDuration(),getConsumption(),getMode());
	      }
	      
	      public void CMode_Select(String s3)throws Exception{
	    	  Appliance x = new Appliance(); 
		      try {  
		    	
			         File file1 = new File("ElectricCar.xml");  
		        JAXBContext jaxbContext = JAXBContext.newInstance(Data.class);  
		    	
			         Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();  
			         Data que1= (Data) jaxbUnmarshaller.unmarshal(file1);  
			    
			         List<Appliance> list1=que1.getAnswers3();
			       
			        
			     	for(Appliance ans:list1){  
			        		    
			       
			        		if(ans.getMode().equals(s3)){	 
			        		System.out.println("I am here");
			        	   setMode(ans.getMode());
			        	  setDuration(ans.getDuration());
			        	   setConsumption(ans.getConsumption());
			        		System.out.println("I am here");
			        	  
			           }  
			     
			         }
					
			    
			       } catch (JAXBException e) {  
			         e.printStackTrace();  
			       }
	            
		      aData(getDuration(),getConsumption(),getMode());

	      }
	      
	      
	      
	      public void aData(double x, double y, String z) throws Exception{
		      JAXBContext contextObj = JAXBContext.newInstance(Data.class); 
		      Marshaller marshallerObj = contextObj.createMarshaller();  
	     	    marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);  
	     	  
	     	    Appliance ans1=new Appliance(x,y,z);  
	     	  	     	   	     	    		       	      		       	    	     	    
	     	    
	     	    ArrayList<Appliance> list2=new ArrayList<Appliance>(); 
	     	    list2.add(ans1);
	     	   
	     	    

	     	    Data que=new Data(1,"Data",list2);
	     	    marshallerObj.marshal(que, new FileOutputStream("Adata.xml"));
	      }
}