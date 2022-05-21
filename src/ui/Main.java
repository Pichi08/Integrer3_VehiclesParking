package ui;
import java.util.Scanner;

import model.DealerShip;

/*
To compile:  javac -cp src src/ui/Template.java -d bin
To execute:  java -cp bin ui.Template
*/

/*
Documentacion..
javadoc src/ui/Template.java -d doc/API
*/

/**
 * Description: 
 * This program has the function of simulate the system of a dealership, it can save vehicles, calculate their price and add discounts, generate reports of the vehicles, show the state of the documents of any vehicle,
 * generate a "map" of the parking lot, and generate reports of the ocupation of the parking lot.
 */

public class Main{

	private Scanner sc;
	private DealerShip dealerShip;
	
	public Main() {
		InitModel init = new InitModel();
		dealerShip = new DealerShip(init.createVehicles());
		sc= new Scanner(System.in);
	}

	public static void main(String[] args) {

		System.out.println("\n ****WELCOME TO FERRARI & LAMBORGHINI DEALERSHIP CALI-GARDEN CITY**** \n");

		Main ppal= new Main();
		
		int option=0;
		
		do{
			option= ppal.showMenu();
			ppal.executeOperation(option);
			
		}while (option!=0);
		
	}
	/**
	 * 
	 * @return showMenu int, this metod is use for printing a menu in the consol
	 */
	public int showMenu() {
		int option=0;

		System.out.println(
				"Select an option\n" +
				"(1) Register new vehicle \n" +
				"(2) Calculate total price of a vehicle \n"+
				"(3) Generate report of the data of the vehicles \n"+
				"(4) State cocuments by id \n" +  
				"(5) Show parkin lot\n" +
				"(6) Ocupation report\n"+
				"(0) Exit"
				);
		option= sc.nextInt();
		sc.nextLine();
		return option;
	}
	/**
	 * 
	 * @param operation int, this variable is use for excute the option the user choose.
	 */
	public void executeOperation(int operation) {
		
		switch(operation) {
		case 0:
			System.out.println("Adios ps");
			break;
		case 1:
			registerNewVehicle();
			break;

		case 2:
			totalPriceVehicle();
			break;
	
		case 3:
			reportDataVehicle();
			break;

		case 4:
			stateDocuments();
			break;

		case 5:
			System.out.println(dealerShip.showParkinLot());
			break;

		case 6:
			ocupationReport();
			break;
		
		default:
			System.out.println("Error, invalid option");
		
		}
	}
	/**
	 * This metod is use for asking the user the information of the vehicle
	 */
	public void registerNewVehicle(){

		double basePrice, priceSoat, priceTecno, priceProperty,coberture, levelOfGases, durationBattery, consumeBattery, tankCapacity, consumeGasoline;
    	String plate, km,  typeCombusiton, typeGasoline, id, brand, typeMotorcicle;
    	int displacement, yearSoat, yearTecno, yearProperty, numberDoors, model;
    	boolean state, typeCar, polorizeWindows, typeCharger, varSoat, varTecno, carMotorcircle;

		double sellPrice = -1;
		boolean documents = true;
		varSoat = false;
		varTecno = false;

		System.out.println("Vehicle id");
		id = sc.next();

		System.out.println("Type of vehicle (True for car, false for motorcicle)");
		carMotorcircle = sc.nextBoolean();

		System.out.println("Base price");
		basePrice = sc.nextDouble();

		System.out.println("Brand");
		brand = sc.next();

		System.out.println("Model");
		model = sc.nextInt();

		System.out.println("Displacement(cilindraje)");
		displacement = sc.nextInt();

		System.out.println("Mileage");
		km = sc.next();

		System.out.println("State (True for new, false for used)");
		state = sc.nextBoolean();
		
		if(state == true){
			plate = "000000";
		} else {
			System.out.println("Plate (example: AAA000");
			plate = sc.nextLine();
		}

		if(state==false){
			System.out.println("The vehicle has SOAT? (Type true for yes, and false for no)");
			varSoat = sc.nextBoolean();
		}

		if(varSoat==true){
			System.out.println("\n****SOAT****");
			System.out.println("Price");
			priceSoat = sc.nextDouble();
			System.out.println("Year");
			yearSoat = sc.nextInt();
			System.out.println("Coberture");
			coberture = sc.nextDouble();
		}else{
			priceSoat = -1;
			yearSoat = -1;
			coberture = -1;
		}

		if(state==false){
			System.out.println("The vehicle has Tecnico-Mecanica? (Type true for yes, and false for no)");
			varTecno = sc.nextBoolean();
		}

		if(varTecno==true || state==true){
			System.out.println("\n****Tecnico-Mecanica****");
			System.out.println("Price");
			priceTecno = sc.nextDouble();
			System.out.println("Year");
			yearTecno = sc.nextInt();
			System.out.println("Level of gases");
			levelOfGases = sc.nextDouble();
		} else {
			priceTecno = -1;
			yearTecno = -1;
			levelOfGases = -1;
			documents = false;
		}

		if(state==false){
			System.out.println("\n***Property Card***");
			System.out.println("Price");
			priceProperty = sc.nextDouble();
			System.out.println("Year");
			yearProperty = sc.nextInt();
		} else{
			priceProperty = -1;
			yearProperty = -1;
		}


		if (carMotorcircle==true){
			System.out.println("Type of car (True for sedan, false for truk)");
			typeCar = sc.nextBoolean();

			System.out.println("Does the car hava polorize windows? (True for yes, false for no)");
			polorizeWindows = sc.nextBoolean();

			System.out.println("Number of doors");
			numberDoors = sc.nextInt();

			System.out.println("Type of combustion (e: for electric. g: for gasoline. h: for hybrid)");
			typeCombusiton = sc.next();

			if(typeCombusiton.equalsIgnoreCase("e")){
				System.out.println("Type of charger (true for fast, false for normal)");
				typeCharger = sc.nextBoolean();

				System.out.println("Duration of battery");
				durationBattery = sc.nextDouble();

				System.out.println("Consumtion of battery");
				consumeBattery = sc.nextDouble();

				System.out.println(dealerShip.addElectricVehicle(brand, documents, id, basePrice, sellPrice, model, displacement, km, state, plate, priceTecno, yearTecno, levelOfGases, priceSoat, yearSoat, coberture, priceProperty,yearProperty, typeCar, numberDoors, polorizeWindows, typeCharger, durationBattery, consumeBattery));

			}else if (typeCombusiton.equalsIgnoreCase("g")){
				System.out.println("Tank capacity (in galons)");
				tankCapacity = sc.nextDouble();

				System.out.println("Type of gasoline (extra, corriente, diesel)");
				typeGasoline = sc.next();

				System.out.println("Gasoline consume(galons per km)");
				consumeGasoline = sc.nextDouble();

				System.out.println(dealerShip.addGasolineVehicle(brand, documents, id, basePrice, sellPrice, model, displacement, km, state, plate, priceTecno, yearTecno, levelOfGases, priceSoat, yearSoat, coberture, priceProperty,yearProperty, typeCar, numberDoors, polorizeWindows, tankCapacity, typeGasoline, consumeGasoline));

			} else if (typeCombusiton.equalsIgnoreCase("h")){

				System.out.println("Tank capacity (in galons)");
				tankCapacity = sc.nextDouble();

				System.out.println("Type of gasoline (extra, corriente, diesel)");
				typeGasoline = sc.next();

				System.out.println("Gasoline consume(galons per km)");
				consumeGasoline = sc.nextDouble();

				System.out.println("Type of charger (true for fast, false for normal");
				typeCharger = sc.nextBoolean();

				System.out.println("Duration of battery");
				durationBattery = sc.nextDouble();

				System.out.println("Consumtion of battery");
				consumeBattery = sc.nextDouble();

				System.out.println(dealerShip.addHybridVehicle(brand, documents, id, basePrice, sellPrice, model, displacement, km, state, plate, priceTecno, yearTecno, levelOfGases, priceSoat, yearSoat, coberture, priceProperty,yearProperty, typeCar, numberDoors, polorizeWindows, tankCapacity, typeGasoline, consumeGasoline, typeCharger, durationBattery, consumeBattery));

			} else {
				System.out.println("Wrong type of combustion");
			}
		} else {

			System.out.println("Type of motorcicle ((e) for standar, (s) for sport, (t) for scooter, (c) for croos)");
			typeMotorcicle = sc.next();

			System.out.println("Fuel capacity (per galon)");
			typeGasoline = sc.next();

			System.out.println("Fuel consume (galons per km)");
			consumeGasoline = sc.nextDouble();

			System.out.println(dealerShip.addMotorCicle(brand, documents, id, basePrice, sellPrice, model, displacement, km, state, plate, priceTecno, yearTecno, levelOfGases, priceSoat, yearSoat, coberture, priceProperty, yearProperty, typeMotorcicle, typeGasoline, consumeGasoline));
		}
		
	}
	/**
	 * This metod is use for asking the user the id of the vehicle for calculate the price of a vehicle
	 */

	public void totalPriceVehicle(){
		double discount = 0;

		System.out.println("Id of the vehicle you want to know the sell price");
		String id = sc.next();

		System.out.println(dealerShip.showTotalPrice(id, discount));

		System.out.println("Do you want to add a discount?((true) for yes, (false) for no)");
		boolean var = sc.nextBoolean();

		if(var == true){
			System.out.println("Amount of discount (Example: if you want to add 15% discount write 0.15)");
			discount = sc.nextDouble();

			System.out.println(dealerShip.showTotalPrice(id, discount));
		}
	}
	/**
	 * This metod is use for showing the user the parameters to search a vehicle
	 */
	public void reportDataVehicle(){
		int var =0;
		int varVehicle =0;
		int varFuel = 0;
		int varState = 0;

		System.out.println("\nSearch data vehicles by:\n" +
							"1) Type of vehicle\n"+
							"2) Type of fuel\n"+
							"3) State vehicle");
		var = sc.nextInt();

		if(var==1){

			System.out.println("\nWhich vehicle?\n"+
							"1) Gasoline\n"+
							"2) Electric\n"+
							"3) Hybrid\n"+
							"4) Motorcicle");
			varVehicle = sc.nextInt();
			//falta poner que tipo de motocicleta es

		} else if (var==2){

			System.out.println("\nWhich fuel?\n"+
							"1) Corriente\n"+
							"2) Extra\n"+
							"3) Diesel");
			varFuel = sc.nextInt();

		} else if (var==3){

			System.out.println("\nWhich state?\n"+
							"1) New\n"+
							"2) Used");
			varState = sc.nextInt();

		} 

		System.out.println(dealerShip.reportDataVehicles(var, varVehicle, varFuel, varState));

		//System.out.println(dealerShip.reportDataVehicles());
	}
	/**
	 * This metod is used for showing the state of tdocuments by id
	 */

	public void stateDocuments(){
		System.out.println("Id of the vehicule.");
		String id = sc.next();

		System.out.println(dealerShip.stateVehiculeDocument(id));
	}
	/**
	 * This metod is use for showing the user various options
	 */

	public void ocupationReport(){
		int option;
		System.out.println("\nWhat do you want to know");

		System.out.println("1) List of vehicles given a range\n"+
						"2) Data of the oldest vehicle and newest\n"+
						"3) Occupation parking lot porcentage");
		option=sc.nextInt();

		if(option == 1){
			int year1,year2 =0;
			System.out.println("NOTE: In the parking lot there are only used vehicles from 2014 or lower");
			System.out.println("First year (example: 2014)");
			year1 = sc.nextInt();
			System.out.println("Second year (example: 2009)");
			year2 = sc.nextInt();
			while(year1>2014 || year2>2014){
				System.out.println("NOTE: In the parking lot there are only used vehicles from 2014 or lower\n"+
									"Please check the years you submited");
				System.out.println("First year (example: 2014)");
				year1 = sc.nextInt();
				System.out.println("Second year (example: 2009");
				year2 = sc.nextInt();
				sc.nextLine();
			}
			System.out.println(dealerShip.listVehiclesRange(year1, year2));
		}
		if(option == 2){
			System.out.println(dealerShip.oldNewestVehicleData());
		}
		if(option == 3){
			System.out.println(dealerShip.occupationParking());
		}

	}
	
	
}