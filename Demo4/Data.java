import java.io.*;
import javax.swing.*;
import java.util.*;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement 
public class Data {

	private int id;  
	private String questionname;  
	private List<State> answers; 
	private List<Appliance> answers2; 
	private List<Appliance> answers3; 
	public Data() {}  
	public Data(int id, String questionname, List<Appliance> answers3) {  
	    super();  
	    this.id = id;  
	    this.questionname = questionname;  
	    this.answers = answers;  
	    this.answers2 = answers2;
	    this.answers3 = answers3;
	}  
	@XmlAttribute  
	public int getId() {  
	    return id;  
	}  
	public void setId(int id) {  
	    this.id = id;  
	}  
	@XmlElement  
	public String getQuestionname() {  
	    return questionname;  
	}  
	public void setQuestionname(String questionname) {  
	    this.questionname = questionname;  
	}  
	@XmlElement  
	public List<State> getAnswers() {  
	    return answers;  
	}  
	public void setAnswers(List<State> answers) {  
	    this.answers = answers;  
	}  
	
	@XmlElement  
	public List<Appliance> getAnswers2() {  
	    return answers2;  
	}  
	public void setAnswers2(List<Appliance> answers2) {  
	    this.answers2 = answers2;  
	}  
//Dryer modes
	@XmlElement  
	public List<Appliance> getAnswers3() {  
	    return answers3;  
	}  
	public void setAnswers3(List<Appliance> answers3) {  
	    this.answers3 = answers3;  
	}  
}
