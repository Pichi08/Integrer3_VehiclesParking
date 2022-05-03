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
	
	public int showMenu() {
		int option=0;

		System.out.println(
				"Select an option to start\n" +
				"(1) Register new vehicle \n" +
				"(2) Calculate total price of a vehicle \n"+
				"(3) Generate report of the data of the vehicles \n"+
				/* "(4) \n" +  
				"(5) \n" +
				"(6) \n"+
				 */"(0) Exit"
				);
		option= sc.nextInt();
		sc.nextLine();
		return option;
	}
	
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
			
			break;

		case 5:
			
			break;

		case 6:
			
			break;
		
		default:
			System.out.println("Error, invalid option");
		
		}
	}

	public void registerNewVehicle(){

		double basePrice, priceSoat, priceTecno, coberture, levelOfGases, durationBattery, consumeBattery, tankCapacity, consumeGasoline;
    	String plate, km,  typeCombusiton, typeGasoline, id, brand, typeMotorcicle;
    	int displacement, yearSoat, yearTecno, numberDoors, model;
    	boolean state, typeCar, polorizeWindows, typeCharger, var, carMotorcircle;

		double sellPrice = -1;
		boolean documents = true;

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

		System.out.println("The vehicle has documentation? (Type true for yes, and false for no)");
		var = sc.nextBoolean();

		if(var==true){
			System.out.println("\n****SOAT****");
			System.out.println("Price");
			priceSoat = sc.nextDouble();
			System.out.println("Year");
			yearSoat = sc.nextInt();
			System.out.println("Coberture");
			coberture = sc.nextDouble();

			System.out.println("\n****Tecnico-Mecanica****");
			System.out.println("Price");
			priceTecno = sc.nextDouble();
			System.out.println("Year");
			yearTecno = sc.nextInt();
			System.out.println("Level of gases");
			levelOfGases = sc.nextDouble();
		}else{
			priceSoat = -1;
			yearSoat = -1;
			coberture = -1;
			priceTecno = -1;
			yearTecno = -1;
			levelOfGases = -1;
			documents = false;
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

				System.out.println(dealerShip.addElectricVehicle(brand, documents, id, basePrice, sellPrice, model, displacement, km, state, plate, priceTecno, yearTecno, levelOfGases, priceSoat, yearSoat, coberture, typeCar, numberDoors, polorizeWindows, typeCharger, durationBattery, consumeBattery));

			}else if (typeCombusiton.equalsIgnoreCase("g")){
				System.out.println("Tank capacity (in galons)");
				tankCapacity = sc.nextDouble();

				System.out.println("Type of gasoline (extra, corriente, diesel)");
				typeGasoline = sc.next();

				System.out.println("Gasoline consume(galons per km)");
				consumeGasoline = sc.nextDouble();

				System.out.println(dealerShip.addGasolineVehicle(brand, documents, id, basePrice, sellPrice, model, displacement, km, state, plate, priceTecno, yearTecno, levelOfGases, priceSoat, yearSoat, coberture, typeCar, numberDoors, polorizeWindows, tankCapacity, typeGasoline, consumeGasoline));

			} else if (typeCombusiton.equalsIgnoreCase("h")){

				System.out.println("Tank capacity (in galons)");
				tankCapacity = sc.nextDouble();

				System.out.println("Type of gasoline");
				typeGasoline = sc.next();

				System.out.println("Gasoline consume(galons per km)");
				consumeGasoline = sc.nextDouble();

				System.out.println("Type of charger (true for fast, false for normal");
				typeCharger = sc.nextBoolean();

				System.out.println("Duration of battery");
				durationBattery = sc.nextDouble();

				System.out.println("Consumtion of battery");
				consumeBattery = sc.nextDouble();

				System.out.println(dealerShip.addHybridVehicle(brand, documents, id, basePrice, sellPrice, model, displacement, km, state, plate, priceTecno, yearTecno, levelOfGases, priceSoat, yearSoat, coberture, typeCar, numberDoors, polorizeWindows, tankCapacity, typeGasoline, consumeGasoline, typeCharger, durationBattery, consumeBattery));

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

			System.out.println(dealerShip.addMotorCicle(brand, documents, id, basePrice, sellPrice, model, displacement, km, state, plate, priceTecno, yearTecno, levelOfGases, priceSoat, yearSoat, coberture, typeMotorcicle, typeGasoline, consumeGasoline));
		}
		
	}

	public void totalPriceVehicle(){
		double discount = 0;

		System.out.println("Id of the vehicle you want to know the sell price");
		String id = sc.next();

		System.out.println(dealerShip.showTotalPrice(id, discount));

		System.out.println("Do you want to add a discount?((true) for yes, (false) for no)");
		boolean var = sc.nextBoolean();

		if(var == true){
			System.out.println("Amount of discount (Example: if you want to add 15% discount write 0.15");
			discount = sc.nextDouble();

			System.out.println(dealerShip.showTotalPrice(id, discount));
		}
	}

	public void reportDataVehicle(){
		System.out.println(dealerShip.reportDataVehicles());
	}
	
}