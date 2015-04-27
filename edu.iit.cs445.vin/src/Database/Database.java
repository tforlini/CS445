package Database;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.codehaus.jackson.map.DeserializationConfig;

import Entities.Customer;
import Entities.MonthlySelection;
import Entities.Shipment;
import Entities.Wine;
import Entities.WineClub;

public class Database {

	protected WineClub wineClub;
	protected File file;

	public Database() {
		this.wineClub = new WineClub();
		this.file = new File("");
	}

	public Database(WineClub wineClub, File file) {
		this.wineClub = wineClub;
		this.file = file;
	}

	public WineClub getWineClub() {
		return wineClub;
	}

	public void setWineClub(WineClub wineClub) {
		this.wineClub = wineClub;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public void writeInFile(Object object) throws JsonGenerationException,
	JsonMappingException, IOException {

		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(this.file, object);
	}

	public ArrayList<Customer> getCustomers(File file)
			throws JsonParseException, JsonMappingException, IOException {
		ArrayList<Customer> customers = new ArrayList<Customer>();
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(
				DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY,
				true);
		try {
			customers = mapper.readValue(file,
					new TypeReference<ArrayList<Customer>>() {
			});
		} catch (java.io.EOFException e) {
		}
		return customers;

	}

	// MOVE TO WINE CLUB
	public Customer getCustomerById(int id)
			throws JsonParseException, JsonMappingException, IOException {
		Customer customer = new Customer();
		ArrayList<Customer> customers = new ArrayList<Customer>();
		ObjectMapper mapper = new ObjectMapper();
		try {
			customers = mapper.readValue(this.file,
					new TypeReference<ArrayList<Customer>>() {
			});
		} catch (java.io.EOFException e) {
		}
		customer = customers.get(id);
		return customer;
	}

	// MOVE TO WINE CLUB
	public Customer getCustomerByEmail(ArrayList<Customer> customers,
			String email) {

		int i = 0;
		while (i < customers.size()) {
			if (customers.get(i).getEmail().equals(email)) {
				return customers.get(i);
			}
			i++;
		}
		return null;

	}

	public MonthlySelection getWines() throws JsonParseException,
	JsonMappingException, IOException {
		MonthlySelection selection = new MonthlySelection();
		ArrayList<Wine> wines = new ArrayList<Wine>();
		ObjectMapper mapper = new ObjectMapper();

		mapper.configure(
				DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY,
				true);

		try {
			wines = mapper.readValue(this.file,new TypeReference<ArrayList<Wine>>() {});
		} 
		catch (java.io.EOFException e) {
		}
		
		int i = 0;
		while (i < wines.size()) {
			selection.addWine(wines.get(i));
			i++;
		}

		return selection;

	}

	public WineClub getClub() throws JsonParseException,JsonMappingException, IOException {
		WineClub club = new WineClub();
		ObjectMapper mapper = new ObjectMapper();

		mapper.configure(
				DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY,
				true);

		try {
			club = mapper.readValue(this.file,new TypeReference<WineClub>() {});
		} 
		catch (java.io.EOFException e) {
		}
		
		return club;

	}
	
	
	public ArrayList<Shipment> getShipments() throws JsonParseException,
	JsonMappingException, IOException {

		ArrayList<Shipment> shipments = new ArrayList<Shipment>();
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(
				DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY,
				true);
		try {
			shipments = mapper.readValue(this.file,
					new TypeReference<ArrayList<Shipment>>() {
			});
		} catch (java.io.EOFException e) {
		}
		return shipments;

	}

}