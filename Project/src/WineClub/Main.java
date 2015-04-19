package WineClub;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.parser.ParseException;

import UseCases.AddCustomer;
import UseCases.AddCustomerRequest;
import UseCases.AddCustomerResponse;
import UseCases.DeleteNote;
import UseCases.DisplayCustomer;
import UseCases.DisplayShipmentInfo;
import UseCases.DisplayShipmentNotes;
import UseCases.DisplayShipments;
import UseCases.DisplayWines;
import UseCases.Search;
import UseCases.UpdateCustomer;
import UseCases.UpdateNote;
import UseCases.UpdateShipmentInfo;
import Database.Database;
import Entities.Customer;
import Entities.Shipment;
import Subscription.Subscription;

public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws IOException, ParseException,java.text.ParseException {
		

		WineClub club = new WineClub();
	//	CustomerService cs = new CustomerService();
		Database databaseUsers = new Database(club, new File("file.json"));
		Database databaseWines = new Database(club, new File("Wines.json"));
		Database databaseShipments = new Database(club, new File("Shipments.json"));
		Database output = new Database(club,new File("output.json"));
		Subscription subscription = new Subscription();
//		Preview preview = new Preview(club);
		
		

			club.setCustomers(databaseUsers.getCustomers());
			club.setShipments(databaseShipments.getShipments());
			club.setSelection(databaseWines.getWines());
		
			if (args[0].equals("subscriber") && args[1].equals("add") && args[2].equals("-n") && !args[3].isEmpty() && args[4].equals("-e") 
					&& !args[5].isEmpty() && args[6].equals("-a") && !args[7].isEmpty() && args[8].equals("-c") && !args[9].isEmpty() 
					&& args[10].equals("-s") && !args[11].isEmpty() && args[12].equals("-z") && !args[13].isEmpty() && args[14].equals("-h") 
					&& !args[15].isEmpty() && args.length>0 && args.length<21){
				
				System.out.println("Create Account:\n");
				if(args.length>16 &&!args[16].equals("-f") && !args[17].isEmpty() && !args[18].equals("-t") && !args[19].isEmpty()){
				AddCustomerRequest a = new AddCustomer(args[7],args[9],args[11],args[13],args[3],args[5],args[15],args[17],args[19]);
				AddCustomerResponse r = new AddCustomerResponse();
				r = a.addAccount(club);
				r.printResponse(); 
				output.writeInFile(r);
				}
				else{
				AddCustomerRequest a = new AddCustomer(args[7],args[9],args[11],args[13],args[3],args[5],args[15],"","");	
				AddCustomerResponse r = new AddCustomerResponse();
				r = a.addAccount(club);
				r.printResponse(); 
				output.writeInFile(r);
				}
								
				databaseUsers.writeInFile(club.getCustomers());

			}
			
			else if(args[0].equals("sub") && !args[1].isEmpty() && args[2].isEmpty() && args.length>0 && args.length<4){
				System.out.println("Update Customer:\n");
				Customer customer = club.getCustomerById(Integer.parseInt(args[1]));
				if(customer != null){
				System.out.println("Hello " + customer.getName()+"\n");
				UpdateCustomer updateEngine = new UpdateCustomer(customer);
				Customer newCustomer = updateEngine.update();
				club.updateCustomer(newCustomer);
				
				ArrayList<Shipment> shipments = newCustomer.getShipments(); 
				int i=0;
				while(i<shipments.size()){
					club.updateShipment(shipments.get(i));
					i++;
				}
				databaseUsers.writeInFile(club.getCustomers());
				databaseShipments.writeInFile(club.getShipments());
				}
				
		}
			else if(args[0].equals("sub") && !args[1].isEmpty() && args[2].equals("get") && args.length>0 && args.length<3){
					System.out.println("Get Customer information:\n");
					Customer customer = club.getCustomerById(Integer.parseInt(args[1]));
					if(customer != null){
					DisplayCustomer displayEngine = new DisplayCustomer(customer);
					displayEngine.displayInfo();
				}
			}

			else if(args[0].equals("sub") && !args[1].isEmpty() && args[2].equals("search") && args.length>0 && args.length<4){
					System.out.println("Search:\n");
					Customer customer = club.getCustomerById(Integer.parseInt(args[1]));
					Search search = new Search(customer);
					ArrayList<Object> result = search.searchQuery(args[3]);
					System.out.println(result);
			}
			
			else if(args[0].equals("sub") && !args[1].isEmpty() && args[2].equals("setShipment") && args.length>0 && args.length<4){
					System.out.println("Set delivery:\n");
					Customer customer = club.getCustomerById(Integer.parseInt(args[1]));
					club.setDelivery(customer);
					databaseShipments.writeInFile(club.getShipments());
					databaseUsers.writeInFile(club.getCustomers());
			}
			
			else if(args[0].equals("sub") && !args[1].isEmpty() && args[2].equals("note") && !args[3].isEmpty() && args.length>0 && args.length<5){
					System.out.println("Add a note:\n");
					Customer customer = club.getCustomerById(Integer.parseInt(args[1]));
					int id = Integer.parseInt(args[3]);
					club.updateShipment(customer.addNote(id));
					databaseShipments.writeInFile(club.getShipments());
					databaseUsers.writeInFile(club.getCustomers());
			}
			
			else if(args[0].equals("sub") && !args[1].isEmpty() && args[2].equals("shipments") && args.length>0 && args.length<4){
					System.out.println("Display Shipments:\n");
					Customer customer = club.getCustomerById(Integer.parseInt(args[1]));
					DisplayShipments displayEngine = new DisplayShipments(customer);
					displayEngine.displayShipments();
					
			}
			else if(args[0].equals("sub") && !args[1].isEmpty() && args[2].equals("shipments") && !args[3].isEmpty() && args.length>0 && args.length<5){
					System.out.println("Display Shipment n°"+args[3]+":\n");
					Customer customer = club.getCustomerById(Integer.parseInt(args[1]));
					int id = Integer.parseInt(args[3]);
					DisplayShipmentInfo displayEngine = new DisplayShipmentInfo(customer);
					displayEngine.displayInfo(id);
			}
			else if(args[0].equals("sub") && !args[1].isEmpty() && args[2].equals("shipments") && !args[3].isEmpty() && args[4].equals("update") && args.length>0 && args.length<6){
					System.out.println("Update Shipment n°"+args[3]+" information: \n");
					Customer customer = club.getCustomerById(Integer.parseInt(args[1]));
					int id = Integer.parseInt(args[3]);
					UpdateShipmentInfo updateEngine = new UpdateShipmentInfo(customer);
					Shipment shipment = updateEngine.updateShipment(id);
					customer.updateShipment(shipment);
					club.updateShipment(shipment);
					databaseShipments.writeInFile(club.getShipments());
					databaseUsers.writeInFile(club.getCustomers());
			}
			else if(args[0].equals("sub") && !args[1].isEmpty() && args[2].equals("shipments") && !args[3].isEmpty() && args[4].equals("notes") && args.length>0 && args.length<6){
					System.out.println("Display Shipment n°"+args[3]+" notes: \n");
					Customer customer = club.getCustomerById(Integer.parseInt(args[1]));
					int id = Integer.parseInt(args[3]);
					DisplayShipmentNotes displayEngine = new DisplayShipmentNotes(customer);
					displayEngine.displayNotes(id);
			}
			else if(args[0].equals("sub") && !args[1].isEmpty() && args[2].equals("shipments") && !args[3].isEmpty() && args[4].equals("notes")&& !args[5].isEmpty() && args.length>0 && args.length<7){
					System.out.println("Display Shipment n°"+args[3]+" note n°"+args[5]+": \n");
					Customer customer = club.getCustomerById(Integer.parseInt(args[1]));
					int id = Integer.parseInt(args[3]);
					int nid = Integer.parseInt(args[5]);
					DisplayShipmentNotes displayEngine = new DisplayShipmentNotes(customer);
					displayEngine.displayNotes(id,nid);
			}
			else if(args[0].equals("sub") && !args[1].isEmpty() && args[2].equals("shipments") && !args[3].isEmpty() && args[4].equals("notes")&& !args[5].isEmpty() &&args[6].equals("update") && args.length>0 && args.length<8){
					System.out.println("Update Shipment n°"+args[3]+" note n°"+args[5]+": \n");
					Customer customer = club.getCustomerById(Integer.parseInt(args[1]));
					int id = Integer.parseInt(args[3]);
					int nid = Integer.parseInt(args[5]);
					UpdateNote updateEngine = new UpdateNote(customer);
					Shipment shipment = updateEngine.update(id, nid);
					customer.updateShipment(shipment);
					club.updateShipment(shipment);
					databaseShipments.writeInFile(club.getShipments());
					databaseUsers.writeInFile(club.getCustomers());
			}
			else if(args[0].equals("sub") && !args[1].isEmpty() && args[2].equals("shipments") && !args[3].isEmpty() && args[4].equals("notes")&& !args[5].isEmpty() &&args[6].equals("delete") && args.length>0 && args.length<8){
					System.out.println("Delete Shipment n°"+args[3]+" note n°"+args[5]+": \n");
					Customer customer = club.getCustomerById(Integer.parseInt(args[1]));
					int id = Integer.parseInt(args[3]);
					int nid = Integer.parseInt(args[5]);
					DeleteNote deleteEngine = new DeleteNote(customer);
					Shipment shipment = deleteEngine.delete(id, nid);
					customer.updateShipment(shipment);
					club.updateShipment(shipment);
					databaseShipments.writeInFile(club.getShipments());
					databaseUsers.writeInFile(club.getCustomers());
					
			}
			else if(args[0].equals("sub") && !args[1].isEmpty() && args[2].equals("wines") && args.length>0 && args.length<4){
					System.out.println("Display wines: \n");
					Customer customer = club.getCustomerById(Integer.parseInt(args[1]));
					DisplayWines displayEngine = new DisplayWines(customer);
					displayEngine.displayWines();
			}
			else if(args[0].equals("sub") && !args[1].isEmpty() && args[2].equals("wines") && !args[3].isEmpty() && args.length>0 && args.length<5){
					System.out.println("Display wine n°"+args[3]+": \n");
					Customer customer = club.getCustomerById(Integer.parseInt(args[1]));
					int wid = Integer.parseInt(args[3]);
					DisplayWines displayEngine = new DisplayWines(customer);
					displayEngine.displayWines(wid);
			}
}
					
}
