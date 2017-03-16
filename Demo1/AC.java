import java.util.Scanner;
public class AC {
	//Parameters for Cooling
	static double temperatureCooling = 87;
	static double wallWidth = 40; // ft
	static double wallDepth = 20; // ft
	static double wallHeight = 8; // ft
	static double windowWidth = 6; // ft
	static double windowHeight = 3; // ft
	static double uWindow = 0.55; // Window Conductance Btu/hr-ft^2-F (From Book
	
	// Table)
	static double SC = 0.25; // Solar Heat Gain Factor

	static double energyDensity = 0.9; // from table
	static double qPeopleSensible = 980; // People sensible gain, consider 4
	// people. 245 for each person.
	static double qEquipment = 800; // Equipment sensible gain, consider 4
	// computer
	static double rho = 0.075; // AirDensity lbm/ft^3 (From Book Table)
	static double cfm = 100; // Ventilation Flow Rate in Cubic feet per mintue (From
	// IAQ Standards), consider 4 people, 20 cfm for
	// each person
	static double relativeHumidity = 0.5;
	static double hA = 35.61;// At ambient temperature and atmospheric pressure
	static double hZ = 25.3; // At room temperature and atmospheric pressure
	static double hX = 29.42;
	static double G = 0.8;
	static double qPeopleLatent = 420;
	static double AC = 500;
	static double oven = 425;//BTU/Hr
	static double qPeople = 463;//BTU/Hr
	static double devices[] = {oven, qPeople, qEquipment};
	static double powerConsumptionHeater = 1.5 ; //KWH

	//Parameter for Heating
	public final static double aW = 3500.00; // Wall Area Square Feet: Height 10' and Width 20'
	public final static double uW = .085; // Wall Conductance Btu/hr-ft^2-F (From Book Table)
	public final static double aWd = 500.0; // Window Area Square Feet: Assume 1 window 5' x 5'
	public final static double uWd = 1.04; // Window Conductance Btu/hr-ft^2-F (From Book Table)
	// Single Pane
	public final static double aRf = 1000; // Roof Area Square Feet: 20' x 20'
	public final static double uRf = .057; // Roof Conductance Btu/hr-ft^2-F (From Book Table)

	public final static double cp = 0.24; // Specific Heat Btu/lbm-F (From Book)
	public final static double mass = 475; //mass of air: Assume 6400 cubic feet air in the room
	//		public final static double heater = 14000;// Btu/hr
	public final static int housInMins = 60; //mins
	public final static int intervalUnit = 15; //mins
	public final static double ratio = intervalUnit * 1.0 / housInMins;


	// Sensible Load: The sensible cooling load refers to the dry bulb
	// temperature of the building
	// Latent Load: Latent cooling load refers to the wet bulb temperature of
	// the building.
	public static void main(String[] args) {
		double ULoss, uV, heatingLoad, timeRequired,temperatureCooling, temperatureZone;

		Scanner scan = new Scanner (System.in);
		System.out.println("Please enter outdoor temperature: ");
		temperatureCooling = scan.nextInt();
		System.out.println("Please enter desired indoor temperature: ");
		temperatureZone = scan.nextInt();
		// Calculate Ventilation Conductance
		uV = cfm * 60 * rho * cp; // I converted cubic feet per mintue to cubic
		// feet per hour
		// Calculate Building loss coefficient
		ULoss = +(aW * uW) + (aWd * uWd) + (aRf * uRf) + uV ;
		//System.out.format("DeltaT Device : "+"%.2f%n", deltaTforAppliences);
		heatingLoad = ULoss * (temperatureCooling - temperatureZone);	
		System.out.println("Required load to cool down the house: "+ heatingLoad);
		System.out.println("----------------------------------------------");
		timeRequired = heatingLoad / AC;
		int hour = (int) timeRequired / 60; //-> hours
		int min = (int) timeRequired - 60 * hour;
		System.out.println("Time required for Heating the room: "+hour+ " hrs : "+min + " min" );
		System.out.println("----------------------------------------------");

	}

}
