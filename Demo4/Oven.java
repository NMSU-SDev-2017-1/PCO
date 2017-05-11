import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Oven extends JPanel{
		
	 JLabel Mode = new JLabel("Please Select Mode ");//labels for Combo box
	 JLabel Space1 = new JLabel(" ");//labels for spacing
	 JLabel Space2 = new JLabel(" ");//labels for spacing
	 String [] MD = {"Broil","Bake"};
	 JComboBox md = new JComboBox(MD);
	 
	 JLabel L = new JLabel ("Show Power Consumption Optimization");
	 
	 public Oven(){
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
	 
	 
	 public static void Omode(){
		 
		 Appliance newM = new Appliance();
		 
		 final Oven formx = new Oven();
	        // Frame for our test
		        JButton button = new JButton("Submit");
		        button.addActionListener(new ActionListener() {
		            @Override
		           public void actionPerformed(ActionEvent e) {
		            	
		            	JLabel output = new JLabel(); 
		                String Mode = formx.md.getSelectedItem().toString();
		                Calculation calc1 = new Calculation();//state object
		                newM.setMode(Mode);  
		                Appliance p1 =new Appliance();
		                try {
							p1.OMode_Select(Mode);
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
		                formx.L.setText(calc1.usage(Mode));

		            }
		        });

		         
		        
		   
	        	
 
		        // Frame for our test
		        JFrame PANEL = new JFrame("Oven");
		    	
		    	
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