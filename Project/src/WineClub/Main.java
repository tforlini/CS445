package WineClub;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

import org.json.simple.parser.ParseException;

public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws IOException, ParseException {
		int option=0;
		while (option!=9){
		
		WineClub club = new WineClub();
		Database databaseUsers = new Database(club,new File("file.json"));
		Database databaseWines = new Database(club,new File("Wines.json"));
		club.setCustomers(databaseUsers.getCustomers(databaseUsers.getFile()));
		club.setSelection(databaseWines.getWines(databaseWines.getFile()));
		
		System.out.println("****************************\n" +
						   "*******  WINE CLUB  ********\n" +
						   "****************************\n" +
						   "\n" +
						   "1) Create account\n" +
						   "2) Sign In\n" +
						   "3) Preview Selection\n" +
						   "4) Set Delivery Type\n" +
						   "5) Set delivery Date\n" +
						   "6) Add a note\n" +
						   "7) Rate a wine\n" +
						   "8) Preview wine information\n" +
						   "9) Quit" +
						   "\n" +
						   "***************************\n");
		
		//int option = Integer.parseInt(args[0]);
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.println("Select your option \n");
		String optionString = input.nextLine();
		option = Integer.parseInt(optionString);
		
		switch (option){
		
		case 1:	System.out.println("Create Account:\n");

				Customer customer = createAccount(club);
				club.addCustomer(customer);
				databaseUsers.writeInFile(club.getCustomers());
				System.out.println("User added successfully !");
				
			break;
		case 2:	System.out.println("Sign In:\n");
		
				signIn(club,databaseUsers);
		
			break;
		case 3:	System.out.println("Preview Selection:\n");
		
				previewSelection(club);
		
			break;
		case 4:	System.out.println("Set delivery type:\n");
		
				Customer customer2 = new Customer();
				setDelivery(club,customer2);
		
			break;
		case 5:	System.out.println("Set delivery date:\n");
			break;
		case 6:	System.out.println("Add a note:\n");
			break;
			
		default: break;
		}
		}

	}
		public static Customer createAccount(WineClub club){
			
			@SuppressWarnings("resource")
			Scanner input = new Scanner(System.in);
			System.out.println("What is Your first name ?\n");
			String firstName = input.nextLine();
			Customer newCustomer = new Customer();
			newCustomer.setFirstName(firstName);
			System.out.println("What is Your last name ?\n");
			String lastName = input.nextLine();
			newCustomer.setLastName(lastName);
			System.out.println("What is Your address ?\n");
			String address = input.nextLine();
			newCustomer.setAddress(address);
			System.out.println("What is Your email address ?\n");
			String email = input.nextLine();
			newCustomer.setEmail(email);
			System.out.println("What is Your phone number ?\n");
			String phone = input.nextLine();
			newCustomer.setPhone(phone);
			System.out.println("What is Your Facebook Id ?\n");
			String facebookId = input.nextLine();
			newCustomer.setFacebookId(facebookId);
			System.out.println("What is Your Twitter Id ?\n");
			String twitterId = input.nextLine();
			newCustomer.setTwitterId(twitterId);
			System.out.println("What is Your Password ?\n");
			String password = input.nextLine();
			newCustomer.setPassword(password);
			Date date = new Date();
			newCustomer.setInscriptionDate(date);
			
			return newCustomer;
			
}
		public static void signIn(WineClub club,Database database){
			
			@SuppressWarnings("resource")
			Scanner input = new Scanner(System.in);
			System.out.println("What is Your Email address ?\n");
			String email = input.nextLine();
			System.out.println("What is Your password ?\n");
			String password = input.nextLine();
			Customer customer = database.getCustomerByEmail(club.getCustomers(),email);
			
			if(customer != null){
				
				if(customer.getPassword().equals(password)){
					System.out.println("User signed in successfully !");
					// ESTABLISH SESSION //
				}
				else{
					System.out.println("Wrong password");
				}
				
			}
			else{
				System.out.println("Wrong email");
			}
		}
		
		public static void previewSelection(WineClub club){
			
			MonthlySelection selection = club.getSelection();
			int i=0;
			while(i<selection.wines.size()){
				System.out.println("****************************************");
				System.out.println("Wine n°"+ selection.wines.get(i).getId() );
				System.out.println("Name:"  + selection.wines.get(i).getName());
				System.out.println("Type:"  + selection.wines.get(i).getType());
				System.out.println("Price:" + selection.wines.get(i).getPrice()+ "$");
				System.out.println("Rating:"+ selection.wines.get(i).getRating()+"/5");
				System.out.println("****************************************");
				i++;
			}
		}

		
		public static void setDelivery(WineClub club, Customer customer){
			
			
			Shipment shipment = new Shipment();
			MonthlySelection selection = club.getSelection();
			shipment.addSelection(selection);
			customer.addShipment(shipment);
			
			@SuppressWarnings("resource")
			Scanner input = new Scanner(System.in);
			System.out.println("How many Selection box do you want for this month ?\n");
			String numberOfSelections = input.nextLine();
			int number = Integer.parseInt(numberOfSelections);
			customer.setNumberOfSelections(number);
			System.out.println("Your number of monthly package is set to: " + customer.getNumberOfSelections());
			
			System.out.println("What delivery Type do you want ?\n");
			System.out.println("(Type AR for all reds, AW for all whites and RW for a mix of 3 reds and 3 whites )");
			String type = input.nextLine();
			customer.getShipments().get(customer.getShipments().size()-1).setType(type);
			System.out.println("Your type of monthly package is set to: " + customer.getShipments().get(customer.getShipments().size()-1).getType());
			
		}
}
