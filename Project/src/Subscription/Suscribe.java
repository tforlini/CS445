package Subscription;

import Database.Database;
import Entities.Customer;
import WineClub.WineClub;

public interface Suscribe {
	
	public Customer createAccount(WineClub club);
	
	public Customer signIn(WineClub club,Database database);
}
