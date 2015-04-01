package WineClub;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.json.simple.parser.ParseException;

public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws IOException, ParseException,
			java.text.ParseException {
		int option = 0;

		WineClub club = new WineClub();
		Database databaseUsers = new Database(club, new File("file.json"));
		Database databaseWines = new Database(club, new File("Wines.json"));
		Database databaseShipments = new Database(club, new File("Shipments.json"));
		Subscription subscription = new Subscription();
		Preview preview = new Preview();
		
		while (option != 9) {

			club.setCustomers(databaseUsers.getCustomers(databaseUsers.getFile()));
			club.setShipments(databaseShipments.getShipments());
			club.setSelection(databaseWines.getWines(databaseWines.getFile()));

			System.out.println("****************************\n"
					+ "*******  WINE CLUB  ********\n"
					+ "****************************\n" + "\n"
					+ "1) Create account\n" 
					+ "2) Sign In\n"
					+ "9) Quit" 
					+ "\n" + "***************************\n");

			// int option = Integer.parseInt(args[0]);
			@SuppressWarnings("resource")
			Scanner input = new Scanner(System.in);
			System.out.println("Select your option \n");
			String optionString = input.nextLine();
			option = Integer.parseInt(optionString);
			
			switch (option) {

			case 1:
				System.out.println("Create Account:\n");
				
				Customer customer = subscription.createAccount(club);
				if(club.addCustomer(customer)){
				databaseUsers.writeInFile(club.getCustomers());
				System.out.println("User added successfully !");
				}
				break;
			case 2:
				System.out.println("Sign In:\n");
				Customer customerSignedIn = subscription.signIn(club, databaseUsers);
				if(customerSignedIn != null){
				
				System.out.println("Email : " + customerSignedIn.getEmail() +"\n");
				
				while(option !=9){
					
					
				System.out.println("****************************\n"
						+ "*******  WINE CLUB  ********\n"
						+ "****************************\n" + "\n"
						+ "3) Preview Selection\n" 
						+ "4) Set Delivery Type\n"
						+ "5) Add a note\n"
						+ "6) Rate a wine\n" 
						+ "7) Preview wine information\n"
						+ "9) Quit" 
						+ "\n" + "***************************\n");
				
				
				
				System.out.println("Select your option \n");
				String opt = input.nextLine();
				option = Integer.parseInt(opt);
				
				switch (option){
				case 3:
					System.out.println("Preview Selection:\n");
					preview.selection(club);

					break;
				case 4:
					System.out.println("Set delivery:\n");
					club.setDelivery(customerSignedIn);
					databaseShipments.writeInFile(club.getShipments());
					databaseUsers.writeInFile(club.getCustomers());
					break;
				case 5:
					System.out.println("Add a note:\n");
					club.updateShipment(customerSignedIn.addNote());
					databaseShipments.writeInFile(club.getShipments());
					databaseUsers.writeInFile(club.getCustomers());
					break;
				case 6:
					System.out.println("Rate a wine:\n");
					club.updateWine(customerSignedIn.rateWine());
					databaseShipments.writeInFile(club.getShipments());
					databaseUsers.writeInFile(club.getCustomers());
					break;

				default:
					break;
				}
				}
				break;
			
			}
			}
			
		}
	}

}
