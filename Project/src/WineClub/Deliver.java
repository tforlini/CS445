package WineClub;

import java.text.ParseException;

import Entities.Customer;

public interface Deliver {

	public void setDelivery(Customer customer) throws ParseException;
}
