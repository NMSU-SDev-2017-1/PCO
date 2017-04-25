import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class NewInterface extends JPanel{
	//Labels
	JLabel State = new JLabel("Please Select State");//labels for Combo box
    JLabel Appliance = new JLabel("Please Select Appliance");//labels for Combo box
    JLabel Mode = new JLabel("Please Select Mode");//labels for Combo box
    JLabel StartTime = new JLabel("Please Select Start Time");//labels for Combo box
    JLabel outdoorTemp = new JLabel("Please Enter Indoor Temperature: ");//labels for text field
    //Arrays for Slection Objects
	String [] ST = {"Select","New Mexico", "Texas", "Arizona", "California"};
	String [] APP = {"Select","Washer", "Dryer", "Oven", "Electric Car"};
    String [] MD = {"Select","Regular", "Perm Press", "Delicates"};
	String [] STime = {"Select","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24"};
	//comboboxes
	JComboBox st = new JComboBox(ST);
	JComboBox app = new JComboBox(APP);
	JComboBox md = new JComboBox(MD);
	JComboBox stime= new JComboBox(STime);
	JTextField outtemp = new JTextField();//initialized text field
	
	//JButton Button = new JButton("Submit");
    JLabel L = new JLabel ("Show Power Consumption Optimization");
	
	public NewInterface(){
		super(new BorderLayout());
        // Panel for the labels
        JPanel labelPanel = new JPanel(new GridLayout(5, 1)); // 2 rows 1 column
        add(labelPanel, BorderLayout.WEST);

        // Panel for the fields
        JPanel fieldPanel = new JPanel(new GridLayout(5, 1)); // 2 rows 1 column
        add(fieldPanel, BorderLayout.CENTER);
      
     // Add labels to panel
        labelPanel.add(State);
        labelPanel.add(Appliance);
        labelPanel.add(Mode);
        labelPanel.add(StartTime);
        labelPanel.add(outdoorTemp);

        // Add fields to panel
        fieldPanel.add(st);
        fieldPanel.add(app);
        fieldPanel.add(md);
        fieldPanel.add(stime);
        fieldPanel.add(outtemp);
       

	
}//end InterfaceNew Constructor
	
	public static void main(String[] args) {
		 final NewInterface form = new NewInterface();
        // Frame for our test
	        JButton button = new JButton("Submit");
	        button.addActionListener(new ActionListener() {
	            @Override
	           public void actionPerformed(ActionEvent e) {
	            	
	                String Stat = ST.getSelectedItem().toString();
	            	String App = app.getSelectedItem().toString();
	            	Calculation calc1 = new Calculation();//state object
	                
	            	State p1 = new State();//state object
	            	
	            	calc1.Calc(15, Stat, App);
	            	
	            	
	            	
	            	
	            	
	            
	                L.setText(calc1.Calc(15,Stat,App));
	            }
	            
	        });

	        // Frame for our test
	        JFrame frame = new JFrame("Power Consumption Optimization");
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.getContentPane().add(form, BorderLayout.NORTH);

	        // Panel with the button
	        JPanel p = new JPanel();
	        p.add(button);
	        frame.getContentPane().add(p, BorderLayout.SOUTH);

	        // Show the frame
	        frame.pack();
	        frame.setVisible(true);
	    }
	
		

	}