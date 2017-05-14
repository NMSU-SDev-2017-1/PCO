# PCO
# Project: Power Consumption Optimization
The objective of our project is to optimize power consumption during peak hours.  It will help consumers to lower their electricity cost.  In our project, we used multiple states (ex: California), and common household appliances.  My team used Virginia Tech research data of power consumption for household appliances.  We also collected electric tariff of different power companies i.e. PNM, APS, Xcel Energy, and   Southern California Edison.  My team designed a java user interface to get user input and provide feedback to reduce electricity usage during peak hours.  We made it so new users would find it easy to use and review.
 
# Description
•	Users are asked to select five options in the user interface.  These options are state name, appliance name, mode, start time, and outside temperature.<br />
•	Calculation class takes care of peak and non-peak hour calculations based on user preferences.<br />
•	State class holds data for different states.  We used only four states in our project i.e. New Mexico, Arizona, Texas, and California.  Each state holds the corresponding power company data i.e. peak hours’ duration and tariff prices in KWH.<br />
•	Appliance class holds data for household appliances and HVAC system.<br />
o	In our project we used common house hold appliances i.e. electric car, oven, washer, dryer and dishwasher.  Some of the appliances have single regular modes i.e. the electric car and dishwasher and the rest of the appliances have multiple modes i.e. oven has two modes (bake and broil) and washer and dryer has three modes (regular, perm-press, delicates).<br />
o	HVAC system takes care of heating and cooling requirements of the house.  The performance of the HVAC system depends on the outside and the desired inside temperature.  We used 72℉ for the desired inside temperature to make our model simple. In the UI, we asked the user to select the outside temperature.  Our model performs all the calculation based on the outside temperature.  The HVAC system has different parameters; we will discuss these parameters in the HVAC system parameters section.
# HVAC System Parameters
rho = 0.075;  // Air Density lbm/ft^3 (From Book Table)<br />
cfm = 100;  // Ventilation Flow Rate in Cubic feet per minute (From
		// IAQ Standards), consider 4 people, 20 cfm for each person<br />
Heater/AC = 500; // Capacity
aW = 3500.00; // Wall Area Square Feet: Height 10' and Width 20'<br />
uW = .085; // Wall Conductance Btu/hr-ft^2-F (From Book Table)<br />
aWd = 500.0; // Window Area Square Feet: Assume 1 window 5' x 5'<br />
uWd = 1.04; // Window Conductance Btu/hr-ft^2-F (From Book Table)Single Pane<br />
aRf = 1000; // Roof Area Square Feet: 20' x 20'<br />
uRf = .057; // Roof Conductance Btu/hr-ft^2-F (From Book Table)<br />
cp = 0.24; // Specific Heat Btu/lbm-F (From Book)<br />
# Assumption:
insideTemerature = 72℉  // Desired Inside temperature.
# Equations:
buildingLoss = (aW * uW) + (aWd * uWd) + (aRf * uRf) + uV ;<br />
uV = cfm * 60 * rho * cp ;
Load = ULoss * Math.abs(insideTemerature - outdoorTemp);<br />

# Note
We considered that the central HVAC system contains both the ac and heater.  Heating/Cooling capacity and power consumption is the same.  We also assume that the inside temperature is equal to the outside temperature when the HVAC system is off. 
# How to run the application
Our project is not that complicated.  It is kind of prototype.  We developed this application in java by using Eclipse IDE.  Steps to run our application:
•	Download from our project repository (GitHub)<br />
•	Unzip the file in your chosen directory.<br />
•	Make folder inside of your directory<br />
•	Place the java files inside of that folder<br />
•	Make sure to NOT place the xml files inside of this folder.<br />
•	Run on any java IDE or by using command line.<br />
# Future work:
We are not able to integrate HVAC system in our final version of application. In the beginning we had problem with the architecture of the program. We solved the problem by changing the entire architecture of the program but due to time constraints and team size we were not able to integrate, although it is ready for integration.
