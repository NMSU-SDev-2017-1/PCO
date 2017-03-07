
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Currency;
import java.util.Scanner;

public class Cooling {
	//Parameters for Cooling
	static double temperatureZone = 72; //F
	static double temperatureHeating = 10;
	static double temperatureCooling = 87;
	static double wallWidth = 50; // ft
	static double wallDepth = 40; // ft
	static double wallHeight = 8; // ft
	static double windowWidth = 6; // ft
	static double windowHeight = 3; // ft
	static double uWindow = 0.55; // Window Conductance Btu/hr-ft^2-F (From Book
	// Table)
	static double SC = 0.25; // Solar Heat Gain Factor

	static double energyDensity = 0.9; // from table
	static double qPeopleSensible = 324; // People sensible gain, consider 4
	// people. 245 for each person.
	static double qEquipment = 475; // Equipment sensible gain, consider 4
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
	static double qPeopleLatent = 139;
	static double AC = 14000;
	static double qPeople = 463;//BTU/Hr
	static double oven = 4250; //BTU/Hr
	static double devices[] = {qPeople, qEquipment, oven};
	static double powerConsumptionHeater = 1.5 ; //KWH

	public final static double aW = 3500.00; // Wall Area Square Feet: Height 10' and Width 20'
	public final static double uW = .085; // Wall Conductance Btu/hr-ft^2-F (From Book Table)
	public final static double aWd = 500.0; // Window Area Square Feet: Assume 1 window 5' x 5'
	public final static double uWd = 1.04; // Window Conductance Btu/hr-ft^2-F (From Book Table)					// Single Pane
	public final static double aRf = 4000; // Roof Area Square Feet: 20' x 20'
	public final static double uRf = .057; // Roof Conductance Btu/hr-ft^2-F (From Book Table)
	public final static double cp = 0.24; // Specific Heat Btu/lbm-F (From Book)
	public final static double mass = 800; //mass of air: Assume 6400 cubic feet air in the room
	//			public final static double heater = 14000;// Btu/hr
	public final static int housInMins = 60; //mins
	public final static int intervalUnit = 15; //mins
	public final static double ratio = intervalUnit * 1.0 / housInMins;


	public static void main(String[] args)throws IOException {
		double activeDevices[] = readDevicesFromUserInput();
		double outsideTemp = 87;
		double targetTemp = 72;
		double totalDifference = outsideTemp - targetTemp;
		double timeACRunning = totalDifference/-deltaT_AC_Running(activeDevices); //mins
		double timeAC_NotRunning = totalDifference/deltaT_AC_Not_Running(activeDevices); //mins

		System.out.println("Time for cooling down: " + timeACRunning*15);
		System.out.println("Time for heating up (AC not running): " + timeAC_NotRunning*15);
		//cooling(outsideTemp, targetTemp);
		//totalHeat();
		//			System.out.println(totalHeat());
		System.out.println("temp diff: " + totalDifference);
		System.out.println(deltaT_AC_Running(activeDevices));
		System.out.println(deltaT_AC_Not_Running(activeDevices));

	}

	//15 mins?
	public static double deltaT_AC_Running(double devices[]) {
		double ac = 3500;
		double finalPowerAC_Devices = ac - totalDevicePower(devices); 
		return -(finalPowerAC_Devices / (mass * cp * 4));
	}

	public static double deltaT_AC_Not_Running(double devices[]) {
		return (totalHeat() + totalDevicePower(devices)) / (mass * cp * 4);
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
	public static double totalDevicePower(double[] activeDevicesList) {
		double sum = 0;
		for (double device:activeDevicesList) {
			sum += device;
		}
		return sum;
	}


	public static double totalHeat() {
		double windowArea, 
		qWindowConduction, // window conduction heat gain
		qWindowSolar, // window solar heat gain
		qWindowTotal, // Window total heat gain
		totalWallArea,
		wallConductiveGain,
		totalHeat;
		//calculation for walls
		totalWallArea = (wallWidth*wallHeight)- 4*(windowWidth*windowHeight);
		wallConductiveGain = ((temperatureCooling-temperatureZone)/1.84)*totalWallArea;

		// calculations for window
		windowArea = 4*(windowWidth * windowHeight);
		qWindowConduction = uWindow * windowArea * (temperatureCooling - temperatureZone);
		qWindowSolar = windowArea * G * SC;
		qWindowTotal = qWindowConduction + qWindowSolar;

		totalHeat =  (0.37 *qWindowTotal) + wallConductiveGain;
		return totalHeat;
	}
	public static void cooling(double temperatureCooling, double temperatureZone) {
		double windowArea, floorArea, loadVentSensible, loadVentLatent, latentLoad, sensibleLoad, totalLoad, timeRequired,
		qWindowConduction, // window conduction heat gain
		qWindowSolar, // window solar heat gain
		qWindowTotal, // Window total heat gain
		qLights, // Illumination gain
		massFlow, // Ventilation Flow Rate in terms of mass
		totalWallArea,
		wallConductiveGain,
		wallRadiativeGain,
		totalHeat,
		qTotalPeople,
		totalHeatGain;
		//calculation for walls
		totalWallArea = (wallWidth*wallHeight)- 4*(windowWidth*windowHeight);
		wallConductiveGain = ((temperatureCooling-temperatureZone)/1.84)*totalWallArea;
		wallRadiativeGain = ((temperatureCooling-temperatureZone)/1.08)*totalWallArea;
		totalHeatGain = wallConductiveGain + wallRadiativeGain;

		// calculations for window
		windowArea = 4*(windowWidth * windowHeight);
		qWindowConduction = uWindow * windowArea * (temperatureCooling - temperatureZone);
		qWindowSolar = windowArea * G * SC;
		qWindowTotal = qWindowConduction + qWindowSolar;

		// Illumination gain
		floorArea = wallWidth * wallDepth;
		qLights = 0.33 * energyDensity * floorArea * 3.41; // conversion from watts to
		// BTU/hr

		// Vent Sensible Load
		massFlow = cfm * 60 * rho;
		loadVentSensible = massFlow * (hX - hZ);

		sensibleLoad = totalHeatGain + qLights + qWindowTotal + qPeopleSensible + qEquipment + loadVentSensible;

		// latent ventilation load
		loadVentLatent = massFlow * (hA - hX);
		latentLoad = loadVentLatent + qPeopleLatent;
		//			totalHeat =  (0.37 *qWindowTotal) + wallConductiveGain;
		qTotalPeople = qPeopleSensible + qPeopleLatent;
		totalLoad = latentLoad + sensibleLoad;
		System.out.println("Cooling Load is: " + totalLoad);
		timeRequired = (totalLoad / AC) ;
		System.out.println("Time required for Cooling the room: ");
		System.out.format("%.2f%n", +timeRequired);
	}

}


