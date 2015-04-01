package WineClub;

import java.util.Date;
import java.util.Scanner;

public class Subscription implements Suscribe{

	public Subscription() {

	}

	@Override
	public Customer createAccount(WineClub club) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.println("What is Your first name ?\n");
		String firstName = input.nextLine();
		Customer newCustomer = new Customer();
		newCustomer.setFirstName(firstName);
		System.out.println("What is Your last name ?\n");
		String lastName = input.nextLine();
		newCustomer.setLastName(lastName);
		System.out.println("What is Your Street name ?\n");
		String street = input.nextLine();
		System.out.println("What is Your City name ?\n");
		String city = input.nextLine();
		System.out.println("What is Your State name ?\n");
		String state = input.nextLine();
		System.out.println("What is Your Zip code ?\n");
		String zip = input.nextLine();
		Address address = new Address(street,city,state,zip);
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

	
	public Customer signIn(WineClub club, Database database) {
		
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.println("What is Your Email address ?\n");
		String email = input.nextLine();
		System.out.println("What is Your password ?\n");
		String password = input.nextLine();
		Customer customer = database.getCustomerByEmail(club.getCustomers(),
				email);

		if (customer != null) {

			if (customer.getPassword().equals(password)) {
				System.out.println("User signed in successfully !");
				// ESTABLISH SESSION //
				
				return customer;
			} else {
				System.out.println("Wrong password");
				return null;
			}

		} else {
			System.out.println("Wrong email");
			return null;
		}
		
	}


}

