package d3test;

import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import org.xml.sax.SAXException;
import org.w3c.dom.Document;



public class Parameters {
	static double rho = 0.075; // AirDensity lbm/ft^3 (From Book Table)
	static double cfm = 100; // Ventilation Flow Rate in Cubic feet per mintue (From
	// IAQ Standards), consider 4 people, 20 cfm for
	// each person
	static double Heater = 500;
	//Parameter for Heating
	public final static double aW = 3500.00; // Wall Area Square Feet: Height 10' and Width 20'
	public final static double uW = .085; // Wall Conductance Btu/hr-ft^2-F (From Book Table)
	public final static double aWd = 500.0; // Window Area Square Feet: Assume 1 window 5' x 5'
	public final static double uWd = 1.04; // Window Conductance Btu/hr-ft^2-F (From Book Table)
	// Single Pane
	public final static double aRf = 1000; // Roof Area Square Feet: 20' x 20'
	public final static double uRf = .057; // Roof Conductance Btu/hr-ft^2-F (From Book Table)

	public final static double cp = 0.24; // Specific Heat Btu/lbm-F (From Book)
	//		public final static double heater = 14000;// Btu/hr
	//public final static int housInMins = 60; //mins
	//public final static int intervalUnit = 15; //mins
	//public final static double ratio = intervalUnit * 1.0 / housInMins;
	public static int temperatureZone= 72;
//	public static void main(String[] args) {
//		/*InputStream inputStream = getClass().getClassLoader().getResourceAsStream("HvacData.xml");
//		
//		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//		DocumentBuilder builder = factory.newDocumentBuilder();
//		Document document = builder.parse(inputStream);*/
//		HVAC();
//	
//	}
	public static void HVAC (int temperatureHeating){
		double ULoss, uV, heatingLoad, timeRequired;//temperatureHeating;
//		Scanner scan = new Scanner (System.in);
//		System.out.println("Please enter outdoor temperature: ");
//		temperatureHeating = scan.nextInt();
		uV = cfm * 60 * rho * cp; // I converted cubic feet per mintue to cubic
		// feet per hour
		// Calculate Building loss coefficient
		ULoss = +(aW * uW) + (aWd * uWd) + (aRf * uRf) + uV ;
		//System.out.println(uV);
		heatingLoad = ULoss * Math.abs(temperatureZone - temperatureHeating);	
		System.out.println("Required load for the house: " + heatingLoad);
		System.out.println("----------------------------------------------");
		timeRequired = heatingLoad / Heater;
		int hour = (int) timeRequired / 60; //-> hours
		int min = (int) timeRequired - 60 * hour;
		System.out.println("Time required to achieve zone temperature : "+hour+ " hrs : "+min + " min" );
		System.out.println("----------------------------------------------");
		System.out.println("Off-peak Hour New Mexico Cost: $.65/KWH");
		System.out.println("Peak Hour New Mexico Cost: $1.3/KWH");
		
	}
	
}
