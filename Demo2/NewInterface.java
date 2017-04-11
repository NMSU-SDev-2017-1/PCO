import javax.swing.*;

import java.awt.*;
import java.awt.event.*;


public class NewInterface {
	String [] ST = {"New Mexico", "Texas", "Arizona", "California"};
	String [] APP = {"Washer", "Dryer", "Oven", "Electric Car"};
    String [] MD = {"Regular", "Perm Press", "Delicates"};
	int [] STime = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24};
    //int [] ETime = {2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24};
	
    JComboBox st = new  JComboBox(ST);
	JComboBox app = new  JComboBox(APP);
    JComboBox md = new  JComboBox(MD);
    JComboBox stime = new JComboBox();
    //JComboBox etime = new JComboBox();
    
    JButton B = new JButton("Click Here to See Result");
    JLabel L = new JLabel ("Show Power Consumption Optimization");
    JLabel x = new JLabel ("Please enter your state and device");/*add this to top*/
    JLabel space = new JLabel ("\n");
	public NewInterface(){
		frame ();
	}//end NewInterface Constructor
	
	public void frame(){
		JFrame f = new JFrame();
		f.setVisible(true);
		f.setSize(400,400);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel p = new JPanel();
		p.add(x);
		p.add(space);
		p.add(st);
		p.add(app);
        p.add(md);
        p.add(stime);
        //p.add(stime);
        p.add(B);
        p.add(L);
        
		f.add(p);
        
        B.addActionListener(new ActionListener(){//I believe you need to call your function here
            public void actionPerformed(ActionEvent E){
                 
            	String Stat = st.getSelectedItem().toString();
            	String App = app.getSelectedItem().toString();
            	Calculation calc1 = new Calculation();//state object
                
            	calc1.Calc(15, Stat, App);
            	
            	
            	
            	
            	
            	/*if(Stat.equals("New Mexico"))
                	place1.SelectState(Stat);*/
            
               // L.setText(calc1.printState());
            }//end actionPerformed
        });
	}//end frame
	public static void main(String[] args) {
		new NewInterface();

	}//NewInterface
}//end //NewInterface class