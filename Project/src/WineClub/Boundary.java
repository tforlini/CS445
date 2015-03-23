package WineClub;

import java.text.ParseException;

public interface Boundary {

	public Customer createAccount(WineClub club);
	
	public void signIn(WineClub club,Database database);
	
	public void previewSelection(WineClub club);
	
	public void setDelivery(WineClub club, Customer customer, Database databaseShipments) throws ParseException;
	
	
}
