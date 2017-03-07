

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Currency;
import java.util.Scanner;

public class Heating {
	//Parameters for Cooling
	static double temperatureZone = 72; //F
	static double temperatureHeating = 10;
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
	static double AC = 24000;
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
	public static void main(String[] args) throws IOException {
		double activeDevices[] = readDevicesFromUserInput();
		double target = 70;
		double initialInsideTemp = 70;
		//readOutsideTempAndRunHeater("TempData.txt", target, activeDevices);
		turnOffHeater(initialInsideTemp, activeDevices);
	}

	public static void turnOffHeater(double currentInsideTemp, double[] deviceList) {
		int timeStep = 5;
		for (int ts=1; ts<=timeStep; ts++) {
			//				currentInsideTemp = currentInsideTemp + heaterNotRunning();
			double room = deltaT_Room_HeatNotRunning();
			double device = delta_T_HeatNotRunning(425);
			currentInsideTemp = currentInsideTemp + room + device;
			System.out.println("Room delta T: " + room);
			System.out.println("Device " + device);
			System.out.println("Current inside temp with heater off: " + currentInsideTemp);
		}
	}

	public static void readOutsideTempAndRunHeater(String inputFile, double targetTemp, double[] deviceList) throws IOException {
		BufferedReader br;
		double heater = 3500;
		try {br = new BufferedReader(new FileReader(System.getProperty("user.dir") + '/' + inputFile));
		double oldDeltaT  = 0;
		String sCurrentLine = br.readLine();//currentTimeStep \t currentOutsideTemperature 
		double currentOutsideTemp = Double.parseDouble(sCurrentLine.split(", ")[1]);
		double firstTemp = currentOutsideTemp;

		while (sCurrentLine != null) {
			int currentTS = Integer.parseInt(sCurrentLine.split(", ")[0]);
			double outsideTemp = Double.parseDouble(sCurrentLine.split(", ")[1]);

			oldDeltaT += heaterRunning(outsideTemp, targetTemp, deviceList, oldDeltaT, firstTemp, heater);
			double currentTemp = firstTemp + oldDeltaT;
			System.out.println("Current TS:\t" + currentTS + "\thas inside temp\t" + currentTemp);
			if (currentTemp >= targetTemp) break;
			sCurrentLine = br.readLine();
			//					heater = heater + 3500;
		}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static double[] readDevicesFromUserInput() {
		double activeDevices[] = new double[devices.length];
		int count  = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the devices id or Quit to stop: ");
		String input;
		while ((input = sc.next()).equals("Quit") == false) {
			System.out.println(input);
			activeDevices[count] = devices[Integer.parseInt(input)];
			count++;
		}
		sc.close();
		System.out.println("List of devices: " + Arrays.toString(activeDevices));
		return activeDevices;
	}

	public static double heatGainFromActiveDevices(double[] activeDevicesList) {
		double sum = 0;
		for (double device:activeDevicesList) {
			sum += device;
		}
		return sum;
	}

	//assume that initially, inside = outsideTemp
	public static double heaterRunning(double outsideTemp, double targetTemp, double[] deviceList, double oldDeltaT, double firstTemp, double heater) {
		double ULoss, uV, heatingLoad, timeRequired, tIndoor, deltaT, deltaT_withoutHeatingRunning;
		double temperatureRoom;

		// Calculate Ventilation Conductance
		uV = cfm * 60 * rho * cp; // I converted cubic feet per mintue to cubic
		// feet per hour
		// Calculate Building loss coefficient
		ULoss = +(aW * uW) + (aWd * uWd) + (aRf * uRf) + uV ;
		double deltaTforAppliences = (heatGainFromActiveDevices(deviceList)/mass * cp);
		System.out.format("DeltaT Device : "+"%.2f%n", deltaTforAppliences);
		heatingLoad = ULoss * (targetTemp - outsideTemp);	
		tIndoor = (heatingLoad-heater-heatGainFromActiveDevices(deviceList))*(1/ULoss) + outsideTemp;
		deltaT = targetTemp - tIndoor; //per 15 mins
		temperatureRoom = firstTemp + deltaT + oldDeltaT;
		timeRequired = (heatingLoad / ((heater + heatGainFromActiveDevices(deviceList)) * 4)) * 60;
		int hour = (int) timeRequired / 60; //-> hours
		int min = (int) timeRequired - 60 * hour;
		System.out.println("Time required for Heating the room: "+hour+ " hrs : "+min + " min" );
		System.out.print("DeltaT is ");
		System.out.format("%.2f%n", deltaT);
		System.out.println("----------------------------------------------");
		return deltaT;
	}

	public static double heaterNotRunning(double[] deviceList) {
		double ULoss, uV, deltaT_withoutHeatingRunning;

		// Calculate Ventilation Conductance
		uV = cfm * 60 * rho * cp; // I converted cubic feet per mintue to cubic
		// feet per hour
		// Calculate Building loss coefficient		
		ULoss = (aW * uW) + (aWd * uWd) + (aRf * uRf) + uV;
		deltaT_withoutHeatingRunning = (ULoss/(mass*cp)*ratio);
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		return -deltaT_withoutHeatingRunning;
	}

	public static double deltaT_Room_HeatNotRunning() {
		double ULoss, uV, deltaT_withoutHeatingRunning;
		// Calculate Ventilation Conductance
		uV = cfm * 60 * rho * cp; // I converted cubic feet per mintue to cubic feet per hour
		// Calculate Building loss coefficient		
		ULoss = (aW * uW) + (aWd * uWd) + (aRf * uRf) + uV;
		deltaT_withoutHeatingRunning = (ULoss/(mass*cp)*ratio);
		return -deltaT_withoutHeatingRunning;
	}

	public static double delta_T_HeatNotRunning(double device) {

		double ULoss, uV, deltaT_withoutHeatingRunning;
		uV = cfm * 60 * rho * cp; 
		ULoss = device;
		deltaT_withoutHeatingRunning = (ULoss/(mass*cp)*ratio);
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		return deltaT_withoutHeatingRunning;
	}

}

