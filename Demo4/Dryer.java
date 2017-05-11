import javax.swing.*;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;




public class Dryer extends JPanel{
		
	 JLabel Mode = new JLabel("Please Select Mode ");//labels for Combo box
	 JLabel Space1 = new JLabel(" ");//labels for spacing
	 JLabel Space2 = new JLabel(" ");//labels for spacing
	 String [] MD = {"Regular", "Perm Press", "Timed"};
	 JComboBox md = new JComboBox(MD);
	 
	 JLabel L = new JLabel ("Show Power Consumption Optimization");
	 
	 public Dryer(){
		 super(new BorderLayout());
		 
		  	JPanel labelPanel = new JPanel(new GridLayout(5, 1)); // 2 rows 1 column
	        add(labelPanel, BorderLayout.WEST);
	        
	        JPanel fieldPanel = new JPanel(new GridLayout(5, 1)); // 2 rows 1 column
	        add(fieldPanel, BorderLayout.CENTER);
	        
	        JPanel output = new JPanel(new GridLayout(5,1));
	        add(output, BorderLayout.SOUTH);
		 
	        labelPanel.add(Space1);
	        labelPanel.add(Mode);
	       
	        fieldPanel.add(Space2);
	        fieldPanel.add(md);
	        
	        output.add(L);
	 }
	 
	 
	 
	   public void DMode_Select(String s3){
		   
		   
		   Appliance x = new Appliance();
		      try {  
		    	
			         File file1 = new File("Adata.xml");  
		        JAXBContext jaxbContext = JAXBContext.newInstance(Data.class);  
		    	
			         Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();  
			         Data que1= (Data) jaxbUnmarshaller.unmarshal(file1);  
			    
			         List<Appliance> list1=que1.getAnswers3();
			       
			        
			     	for(Appliance ans:list1){  
			        		    
			       
			        		if(ans.getMode().equals(s3)){	 
			        		
			        	   x.setMode(ans.getMode());
			        	   x.setDuration(ans.getDuration());
			        	   x.setConsumption(ans.getConsumption());
			        	   
			        	   
			        	  
			        	  
			           }  
			     
			         }
					
			    
			       } catch (JAXBException e) {  
			         e.printStackTrace();  
			       }
		      
		      
		            
		      

	   }
	 
	 public static void Amode(){
		 
		 Appliance newM = new Appliance();
		 
		 final Dryer formx = new Dryer();
	        // Frame for our test
		        JButton button = new JButton("Submit");
		        button.addActionListener(new ActionListener() {
		            @Override
		           public void actionPerformed(ActionEvent e) {
		            	
		            	JLabel output = new JLabel(); 
		                String Mode = formx.md.getSelectedItem().toString();
		            	
		                newM.setMode(Mode);  
		                Appliance p1 =new Appliance();
		                State p2 = new State();
		                Calculation calc1 = new Calculation();//state object
		               
				
								try {
									p1.DMode_Select(Mode);
								} catch (Exception e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
						
								formx.L.setText(calc1.usage(Mode));

		            }
		        });

		         
		        
		   
	        	
 
		        // Frame for our test
		        JFrame PANEL = new JFrame("Dryer");
		    	
		    	
		        PANEL.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		        PANEL.getContentPane().add(formx, BorderLayout.NORTH);

		        // Panel with the button
		        JPanel p = new JPanel();
		        p.add(button);
		        PANEL.getContentPane().add(p, BorderLayout.SOUTH);
		       
		        PANEL.setSize(600, 210);
		        // Show the frame
		    	//PANEL.pack();  	      
		        PANEL.setVisible(true);
		        
		     
		
	 }
}//end of class
