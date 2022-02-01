package view;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import controller.ElectricCarHelper;
import model.ElectricCar;

/**
 * Tanner Patterson - tpatterson4
 * CIS175 or CIS152 - SPRING
 * Jan 31, 2022
 */
public class ListViewer 
{
	static Scanner in = new Scanner(System.in);
	static ElectricCarHelper ech = new ElectricCarHelper();
	
	public static void main(String[] args)
	{
		boolean again = true;
		int selection;
		
		System.out.println("--- Welcome to your Electric Car List ---");
		
		while(again)
		{
			System.out.println("1: Add electric car");
			System.out.println("2: Edit electric car");
			System.out.println("3: Delete electric car");
			System.out.println("4: View electric car list");
			System.out.println("5: Exit program");
			System.out.print("Please type in an option: ");
			
			try 
			{
				selection = in.nextInt();
			} 
			catch(InputMismatchException i) 
			{
				System.out.println("Use the input (1, 2, 3, 4, or 5) for your selection.");
				selection = 0;
				in.nextLine();
			}
			
			if(selection == 1)
			{
				addCar();
			}
			else if(selection == 2)
			{
				editCar();
			}
			else if(selection == 3)
			{
				deleteCar();
			}
			else if(selection == 4)
			{
				viewCars();
			}
			else if(selection == 5)
			{
				ech.cleanUp();
				System.out.println("Closing electric car list, goodbye!");
				again = false;
			}
			else
			{
				System.out.println("Your number was not between 1-5.");
			}
		}
		
		in.close();
	}
	
	private static void addCar() // TODO not working, error with sql syntax
	{
		in.nextLine(); //Clear scanner buffer
		System.out.print("Please type in a make: ");
		String make = in.nextLine();
		System.out.print("Please type in a model: ");
		String model = in.nextLine();
		System.out.print("Please type in a year: ");
		int year = in.nextInt();
		System.out.print("Please type in a price: ");
		double price = in.nextDouble();
		System.out.print("Please type in a range: ");
		int range = in.nextInt();
		System.out.print("Please type in a top speed: ");
		int topspeed = in.nextInt();
		System.out.print("Please type in a 0-60 acceleration: ");
		double zerosixtyacceleration = in.nextDouble();
		System.out.print("Please type in a charge speed: ");
		int chargepower = in.nextInt();
		ElectricCar toAdd = new ElectricCar(make, model, year, price, range, topspeed, zerosixtyacceleration, chargepower);
		ech.insertCar(toAdd);
	}
	
	private static void editCar() //untested because addCar and viewCar don't work
	{
		int search = 0;
		
		while(search == 0)
		{
			System.out.println("How would you like to search?");
			System.out.println("1: Search by Make");
			System.out.println("2: Search by Model");
			System.out.println("3: Search by Year");
			System.out.println("4: Search by Price");
			System.out.println("5: Search by Range");
			System.out.println("6: Search by Top Speed");
			System.out.println("7: Search by 0-60 Acceleration");
			System.out.println("8: Search by Charge Speed");
			System.out.println("9: Search by ID");
			System.out.print("Please type in a selection: ");
			
			try 
			{
				search = in.nextInt();
				if(search < 1 || search > 9)
				{
					search = 0;
				}
			}
			catch(InputMismatchException i) 
			{
				System.out.println("Use the input (1, 2, 3, 4, 5, 6, 7, or 8) for your selection.");
				search = 0;
			}
		}
		
		List<ElectricCar> foundItems;
		if (search == 1) 
		{
			System.out.print("Please type in the make: ");
			String make = in.nextLine();
			foundItems = ech.searchForElectricCarByMake(make);
		}
		else if(search == 2)
		{
			System.out.print("Please type in the model: ");
			String model = in.nextLine();
			foundItems = ech.searchForElectricCarByModel(model);
		}
		else if(search == 3)
		{
			System.out.print("Please type in the year: ");
			int year = in.nextInt();
			foundItems = ech.searchForElectricCarByYear(year);
		}
		else if(search == 4)
		{
			System.out.print("Please type in the price: ");
			double price = in.nextDouble();
			foundItems = ech.searchForElectricCarByPrice(price);
		}
		else if(search == 5)
		{
			System.out.print("Please type in the range: ");
			int range = in.nextInt();
			foundItems = ech.searchForElectricCarByRange(range);
		}
		else if(search == 6)
		{
			System.out.print("Please type in the top speed: ");
			int topspeed = in.nextInt();
			foundItems = ech.searchForElectricCarByTopSpeed(topspeed);
		}
		else if(search == 7)
		{
			System.out.print("Please type in the 0-60 acceleration: ");
			double zerosixtyacceleration = in.nextDouble();
			foundItems = ech.searchForElectricCarByZeroSixtyAcceleration(zerosixtyacceleration);
		}
		else if(search == 8)
		{
			System.out.print("Please type in the charge speed: ");
			int chargepower = in.nextInt();
			foundItems = ech.searchForElectricCarByChargePower(chargepower);
		}
		else
		{
			foundItems = ech.showAllCars();
		}

		if (!foundItems.isEmpty()) {
			System.out.println("Found Results.");
			for (ElectricCar ec : foundItems) {
				System.out.println("[ " + ec.getId() + " ] " + ec.getCarDetails());
			}
			System.out.print("Which electric car ID would you like to edit: ");
			int idToEdit = in.nextInt();

			ElectricCar toEdit = ech.searchForElectricCarById(idToEdit);
			System.out.println("Retrieved " + toEdit.getCarDetails());
			System.out.println("1: Update Make");
			System.out.println("2: Update Model");
			System.out.println("3: Update Year");
			System.out.println("4: Update Price");
			System.out.println("5: Update Range");
			System.out.println("6: Update Top Speed");
			System.out.println("7: Update 0-60 Acceleration");
			System.out.println("8: Update Charge Speed");
			System.out.print("Please type in a selection: ");
			int update = in.nextInt();
			in.nextLine();

			if (update == 1) 
			{
				System.out.print("Please type in new make: ");
				String newMake = in.nextLine();
				toEdit.setMake(newMake);
			} 
			else if (update == 2) 
			{
				System.out.print("Please type in new model: ");
				String newModel = in.nextLine();
				toEdit.setModel(newModel);
			}
			else if (update == 3) 
			{
				System.out.print("Please type in new year: ");
				int newYear = in.nextInt();
				toEdit.setYear(newYear);
			}
			else if (update == 4) 
			{
				System.out.print("Please type in new price: ");
				double newPrice = in.nextDouble();
				toEdit.setPrice(newPrice);
			}
			else if (update == 5) 
			{
				System.out.print("Please type in new range: ");
				int newRange = in.nextInt();
				toEdit.setRange(newRange);
			}
			else if (update == 6) 
			{
				System.out.print("Please type in new top speed: ");
				int newTopspeed = in.nextInt();
				toEdit.setTopspeed(newTopspeed);
			}
			else if (update == 7) 
			{
				System.out.print("Please type in new 0-60 acceleration: ");
				double newZerosixtyacceleration = in.nextDouble();
				toEdit.setZerosixtyacceleration(newZerosixtyacceleration);
			}
			else
			{
				System.out.print("Please type in new charge speed: ");
				int newChargepower = in.nextInt();
				toEdit.setChargepower(newChargepower);
			}
			ech.updateCar(toEdit);
		} 
		else 
		{
			System.out.println("-----> No results were found in your search");
		}
	}
	
	private static void deleteCar() //untested because addCar and viewCar don't work
	{
		System.out.println("1: Search for car by ID");
		System.out.println("2: Search for car by characteristics");
		System.out.print("Please type in a selection: ");
		int decision = in.nextInt();
		
		if(decision == 1)
		{
			System.out.println("List of all electric cars:");
			viewCars();
			System.out.print("Please type in ID of car you would like to delete: ");
			int idToDelete = in.nextInt();
			ElectricCar toDelete = ech.searchForElectricCarById(idToDelete);
			ech.deleteCar(toDelete);
		}
		else
		{
			System.out.print("Please type in the make: ");
			String make = in.nextLine();
			System.out.print("Please type in the model: ");
			String model = in.nextLine();
			System.out.print("Please type in the year: ");
			int year = in.nextInt();
			System.out.print("Please type in the price: ");
			double price = in.nextDouble();
			System.out.print("Please type in the range: ");
			int range = in.nextInt();
			System.out.print("Please type in the top speed: ");
			int topspeed = in.nextInt();
			System.out.print("Please type in the 0-60 acceleration: ");
			double zerosixtyacceleration = in.nextDouble();
			System.out.print("Please type in the charge speed: ");
			int chargepower = in.nextInt();
			ElectricCar toDelete = new ElectricCar(make, model, year, price, range, topspeed, zerosixtyacceleration, chargepower);
			ech.deleteCar(toDelete);
		}
	}
	
	private static void viewCars() // TODO not working, error with sql syntax
	{
		List<ElectricCar> allCars = ech.showAllCars();
		
		for(ElectricCar singleCar : allCars) {
			System.out.println("[ " + singleCar.getId() + " ] " + singleCar.getCarDetails());
		}

	}
}
