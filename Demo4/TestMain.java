import java.io.File;  
import javax.xml.parsers.*;
import java.io.FileOutputStream;  
import java.util.*;  
import org.w3c.dom.Document;
  
import javax.xml.bind.JAXBContext;  
import javax.xml.bind.JAXBException;  
import javax.xml.bind.Unmarshaller;  
import javax.xml.bind.Marshaller;
   
public class TestMain {  
	

	
	public static void main(String[] args) throws Exception{  
		State n = new State();
		
		Appliance m = new Appliance();
		Dryer x = new  Dryer();
		Scanner scan = new Scanner(System.in);
		String name;
		
		//System.out.println("please enter a Appliance");
		//name = scan.nextLine(); 
		
		//m.Appliance_Select("x");
			//System.out.println(m.getAname());
		//n.SelectState("New Mexico", 2.0);
	    m.WMode_Select("Regular");
		
		/*System.out.println(n.getName());
		System.out.println(n.getTime());
		
		  System.out.println(m.getMode());*/
		
		  
		//x.Amode();
		//System.out.println(m.getDuration());
		
		/*These two pieces of code read a xml file and write a xml file to store state and appliace */  
		  
		  
		  
		  
/*		State n = new State();
		
	     try {  
	    	   
	         File file = new File("State_Appliance.xml");  
        JAXBContext jaxbContext = JAXBContext.newInstance(Data.class);  
	    
	         Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();  
	         Data que= (Data) jaxbUnmarshaller.unmarshal(file);  
	           
	         System.out.println(que.getId()+" "+que.getQuestionname());  
	         System.out.println("Data:");  
	         List<State> list=que.getAnswers();
	         List<Appliance> list2=que.getAnswers2();
	         for(State ans:list) { 
	           System.out.println(ans.getName()+" "+ ans.getTime() +" "+ans.getPeekHourS()+"  "+ans.getPeekHourE());
	           
	           if(ans.getName().equals("New Mexico")){
	        	   System.out.println(ans.getName());
	        	   n.setName(ans.getName());
	        	   System.out.println(n.getName());
	           }
	         }
	         for(Appliance ans:list2)  
		           System.out.println(ans.getAname()+" "+ ans.getDuration() +" "+ans.getConsumption()); 
	                  
	     
       
			
	    
	       } catch (JAXBException e) {  
	         e.printStackTrace();  
	       } */
	    
	     
	
	
		
		
		JAXBContext contextObj = JAXBContext.newInstance(Data.class);  
	  
	    Marshaller marshallerObj = contextObj.createMarshaller();  
	    marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);  
	  
	    Appliance ans1=new Appliance(1.44,0.9,"Regular");  
	  
	    Appliance ans3=new Appliance(0.7174,1.7,"Timed");
	
	    Appliance ans5=new Appliance(0.753,0.3,"Perm Press");
	    
	    State que1=new State(0,8,20,"New Mexico");
	    State que2=new State(0,12,19,"Arizona"); 
	    State que3=new State(0,8,20,"Texas");
	    State que4=new State(0,8,20,"California");   
	    
	    
	    ArrayList<State> list=new ArrayList<State>();  
	    list.add(que1);  
	    list.add(que2);  
	    list.add(que3);
	    list.add(que4);
	    
	    ArrayList<Appliance> list2=new ArrayList<Appliance>(); 
	    list2.add(ans1);
	   
	    list2.add(ans3);
	  
	    list2.add(ans5);

	    Data que=new Data(1,"Dryer",list2);
	    marshallerObj.marshal(que, new FileOutputStream("Dryer.xml"));    
	       
	    
	    
	    
	}   
}