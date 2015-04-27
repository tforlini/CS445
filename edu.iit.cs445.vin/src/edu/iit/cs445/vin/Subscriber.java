package edu.iit.cs445.vin;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;

import search.SearchCustomerQuery;
import search.SearchCustomerQueryResponse;
import update.UpdateAdmin;
import update.UpdateAdminRequest;
import update.UpdateCustomer;
import update.UpdateCustomerResponse;
import update.UpdateDeliveryInfo;
import update.UpdateDeliveryInfoRequest;
import update.UpdateShipmentInfo;
import update.UpdateShipmentNote;
import update.UpdateShipmentNoteRequest;
import update.UpdateShipmentRequest;
import update.UpdateWineNote;
import update.UpdateWineNoteRequest;
import delete.DeleteNote;
import delete.DeleteWineNote;
import display.DisplayAdmin;
import display.DisplayAdminResponse;
import display.DisplayCustomer;
import display.DisplayCustomerResponse;
import display.DisplayDeliveries;
import display.DisplayDeliveriesResponse;
import display.DisplayDeliveryInfo;
import display.DisplayDeliveryInfoResponse;
import display.DisplayMonthlySelections;
import display.DisplayMonthlySelectionsResponse;
import display.DisplayReceiptResponse;
import display.DisplayReceipts;
import display.DisplayReceiptsResponse;
import display.DisplayRevenue;
import display.DisplayRevenueResponse;
import display.DisplayShipmentInfo;
import display.DisplayShipmentInfoResponse;
import display.DisplayShipmentNoteByIdResponse;
import display.DisplayShipmentNotes;
import display.DisplayShipmentNotesResponse;
import display.DisplayShipments;
import display.DisplayShipmentsResponse;
import display.DisplayWine;
import display.DisplayWineNotes;
import display.DisplayWineNotesResponse;
import display.DisplayWineRating;
import display.DisplayWineRatingResponse;
import display.DisplayWineResponse;
import display.DisplayWines;
import display.DisplayWinesResponse;
import add.AddAdmin;
import add.AddAdminRequest;
import add.AddAdminResponse;
import add.AddCustomer;
import add.AddCustomerRequest;
import add.AddCustomerRequestCURL;
import add.AddCustomerResponse;
import add.AddMonthlySelection;
import add.AddMonthlySelectionRequest;
import add.AddMonthlySelectionResponse;
import add.AddNote;
import add.AddNoteRequest;
import add.AddNoteResponse;
import add.AddReceipt;
import add.AddReceiptRequest;
import add.AddReceiptResponse;
import add.AddWineNote;
import add.AddWineNoteRequest;
import add.AddWineNoteResponse;
import add.AddWineRating;
import add.AddWineRatingRequest;
import Database.Database;
import Entities.Customer;
import Entities.CustomerService;
import Entities.Shipment;
import Entities.WineClub;
//Sets the path to base URL + /rest
@Path("/vin")
//@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class Subscriber {
	         
	WineClub club = new WineClub();
	CustomerService cs = new CustomerService();
  
       
@POST
@Path("/sub")
@Produces(MediaType.APPLICATION_JSON)
public AddCustomerResponse createAccount(@FormParam("name") String name,@FormParam("street") String street,
						  @FormParam("city") String city, @FormParam("state") String state,@FormParam("zip") String zip,@FormParam("email") String email,
						  @FormParam("phone") String phone,@FormParam("facebook") String facebook,@FormParam("twitter") String twitter,@Context ServletContext context) throws JsonParseException, JsonMappingException, IOException {
	  
	String filename = context.getRealPath("/WEB-INF/database.res");
	String fileWines = context.getRealPath("/WEB-INF/Wines.json");
	Database databaseWines = new Database(club,new File(fileWines));
	Database database = new Database(club,new File(filename));
	club = database.getClub();
	club.setSelection(databaseWines.getWines());
 
	      
	AddCustomerRequest a = new AddCustomer(street,city,state,zip,name,email,phone,twitter,facebook);
	AddCustomerResponse r = new AddCustomerResponse();
	r = a.addAccount(club);
	
	Customer customer = ((AddCustomer) a).getS();
	ArrayList<Shipment> shipments = customer.getShipments(); 
	int i=0;
	while(i<shipments.size()){
		club.addShipment(shipments.get(i));
		i++;
	}
	
	database.writeInFile(club);
	return r;
	   
  }

@POST
@Path("/sub")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public AddCustomerResponse createAccountCURL(AddCustomerRequestCURL newCustomer,@Context ServletContext context) throws JsonParseException, JsonMappingException, IOException {
	  
	String filename = context.getRealPath("/WEB-INF/database.res");
	String fileWines = context.getRealPath("/WEB-INF/Wines.json");
	Database databaseWines = new Database(club,new File(fileWines));
	Database database = new Database(club,new File(filename));
	club = database.getClub();
	club.setSelection(databaseWines.getWines());

	AddCustomerRequest a = new AddCustomer(newCustomer.getAddress().getStreet(),newCustomer.getAddress().getCity(),newCustomer.getAddress().getState(),newCustomer.getAddress().getZip(),newCustomer.getName(),newCustomer.getEmail(),newCustomer.getPhone(),newCustomer.getFacebook(),newCustomer.getTwitter());
	AddCustomerResponse r = new AddCustomerResponse();
	r = a.addAccount(club);
	
	Customer customer = ((AddCustomer) a).getS();
	ArrayList<Shipment> shipments = customer.getShipments(); 
	int i=0;
	while(i<shipments.size()){
		club.addShipment(shipments.get(i));
		i++;
	}
	
	database.writeInFile(club);
	return r;

	   
  }

@POST
@Path("/sub/{uid}")
@Produces(MediaType.APPLICATION_JSON)
public UpdateCustomerResponse updateCustomer(@PathParam("uid") String userid,@FormParam("name") String name,@FormParam("street") String street,
		  @FormParam("city") String city, @FormParam("state") String state,@FormParam("zip") String zip,@FormParam("email") String email,
		  @FormParam("phone") String phone,@FormParam("facebook") String facebook,@FormParam("twitter") String twitter,@Context ServletContext context) throws JsonParseException, JsonMappingException, IOException{

	String filename = context.getRealPath("/WEB-INF/database.res");
	String fileWines = context.getRealPath("/WEB-INF/Wines.json");
	Database databaseWines = new Database(club,new File(fileWines));
	Database database = new Database(club,new File(filename));
	club = database.getClub();
	club.setSelection(databaseWines.getWines());
	
	int id = Integer.parseInt(userid);
	Customer customer = club.getCustomerById(id);
	
	UpdateCustomer a = new UpdateCustomer(customer);
	UpdateCustomerResponse t = new UpdateCustomerResponse();
	t = a.update(club);
	
	Customer newCustomer = a.update(name,email,street,city,state,zip,phone,facebook,twitter);
	club.updateCustomer(newCustomer);
	
	ArrayList<Shipment> shipments = customer.getShipments(); 
	int i=0;
	while(i<shipments.size()){
		club.updateShipment(shipments.get(i));
		i++;
	}
          
	database.writeInFile(club);
	return t;
}

@PUT
@Path("/sub/{uid}")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public UpdateCustomerResponse updateCustomerCURL(@PathParam("uid")String userid, AddCustomerRequestCURL newCustomer,@Context ServletContext context) throws JsonParseException, JsonMappingException, IOException{

	String filename = context.getRealPath("/WEB-INF/database.res");
	String fileWines = context.getRealPath("/WEB-INF/Wines.json");
	Database databaseWines = new Database(club,new File(fileWines));
	Database database = new Database(club,new File(filename));
	club = database.getClub();
	club.setSelection(databaseWines.getWines());
	
	int id = Integer.parseInt(userid);
	Customer customer = club.getCustomerById(id);
	
	UpdateCustomer a = new UpdateCustomer(customer);
	UpdateCustomerResponse t = new UpdateCustomerResponse();
	t = a.update(club);
	
	Customer finalCustomer = a.update(newCustomer.getName(),newCustomer.getEmail(),newCustomer.getAddress().getStreet(),newCustomer.getAddress().getCity(),newCustomer.getAddress().getState(),newCustomer.getAddress().getZip(),newCustomer.getPhone(),newCustomer.getFacebook(),newCustomer.getTwitter());
	club.updateCustomer(finalCustomer);
	
	ArrayList<Shipment> shipments = customer.getShipments(); 
	int i=0;
	while(i<shipments.size()){
		club.updateShipment(shipments.get(i));
		i++;
	}
          
	database.writeInFile(club);
	return t;
}

@GET
@Path("/sub/{id}")
@Produces(MediaType.APPLICATION_JSON)
public DisplayCustomerResponse getCustomer(@PathParam("id") String userid, @Context ServletContext context) throws JsonParseException, JsonMappingException, IOException{

	String filename = context.getRealPath("/WEB-INF/database.res");
	Database database = new Database(club,new File(filename));
	club = database.getClub();
	
	int id = Integer.parseInt(userid);
	
	Customer customer = club.getCustomerById(id);
	DisplayCustomer d = new DisplayCustomer(customer);
	DisplayCustomerResponse r = d.displayCustomer();
	return r;
	
	
}

@GET
@Path("/sub/{id}/search")
@Produces(MediaType.APPLICATION_JSON)
public SearchCustomerQueryResponse search(@PathParam("id") String userid, @QueryParam("q") String q,@Context ServletContext context) throws JsonParseException, JsonMappingException, IOException{

	String filename = context.getRealPath("/WEB-INF/database.res");
	Database database = new Database(club,new File(filename));
	club = database.getClub();
	
	int id = Integer.parseInt(userid);
	
	Customer customer = club.getCustomerById(id);
	SearchCustomerQueryResponse result = new SearchCustomerQuery(customer).searchQuery(q);
	
	return result;
}

@GET
@Path("/sub/{id}/shipments")
@Produces(MediaType.APPLICATION_JSON)
public DisplayShipmentsResponse getShipments(@PathParam("id") String userid,@Context ServletContext context) throws JsonParseException, JsonMappingException, IOException{

	String filename = context.getRealPath("/WEB-INF/database.res");
	Database database = new Database(club,new File(filename));
	club = database.getClub();
	
	int id = Integer.parseInt(userid);
	
	Customer customer = club.getCustomerById(id);
	DisplayShipments d = new DisplayShipments(customer);
	DisplayShipmentsResponse r = d.displayShipments();
	return r;
	
}

@GET
@Path("/sub/{uid}/shipments/{sid}")
@Produces(MediaType.APPLICATION_JSON)
public DisplayShipmentInfoResponse getShipmentsById(@PathParam("uid") String uid, @PathParam("sid") String sid,@Context ServletContext context) throws JsonParseException, JsonMappingException, IOException{

	String filename = context.getRealPath("/WEB-INF/database.res");
	Database database = new Database(club,new File(filename));
	club = database.getClub();
	
	int userid = Integer.parseInt(uid);
	int shipid = Integer.parseInt(sid);
	
	Customer customer = club.getCustomerById(userid);
	DisplayShipmentInfo d = new DisplayShipmentInfo(customer);
	DisplayShipmentInfoResponse r = d.displayInfo(shipid);
	
	return r;
}

@PUT
@Path("/sub/{uid}/shipments/{sid}")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public void updateShipmentCURL(@PathParam("uid") String uid, @PathParam("sid") String sid,UpdateShipmentRequest request,@Context ServletContext context) throws JsonParseException, JsonMappingException, IOException{
	
	String filename = context.getRealPath("/WEB-INF/database.res");
	Database database = new Database(club,new File(filename));
	club = database.getClub();
	
	int id = Integer.parseInt(uid);
	int shipId = Integer.parseInt(sid);
	int deliveryNumber = request.getNumber_of_selections();
	Customer customer = club.getCustomerById(id);
	UpdateShipmentInfo updateEngine = new UpdateShipmentInfo(customer);
	Shipment shipment = updateEngine.updateShipment(shipId,request.getDelivery_day(),request.getTime_of_day(),deliveryNumber);
	
	customer.updateShipment(shipment);
	club.updateShipment(shipment);
	database.writeInFile(club);

}

@POST
@Path("/sub/{uid}/shipments/{sid}")
@Produces(MediaType.APPLICATION_JSON)
public void updateShipment(@PathParam("uid") String uid, @PathParam("sid") String sid,@FormParam("day") String day,@FormParam("time") String time,@FormParam("number") String number,@Context ServletContext context) throws JsonParseException, JsonMappingException, IOException{
	
	String filename = context.getRealPath("/WEB-INF/database.res");
	Database database = new Database(club,new File(filename));
	club = database.getClub();
	
	int id = Integer.parseInt(uid);
	int shipId = Integer.parseInt(sid);
	int deliveryNumber = Integer.parseInt(number);
	Customer customer = club.getCustomerById(id);
	UpdateShipmentInfo updateEngine = new UpdateShipmentInfo(customer);
	Shipment shipment = updateEngine.updateShipment(shipId,day,time,deliveryNumber);
	
	customer.updateShipment(shipment);
	club.updateShipment(shipment);
	database.writeInFile(club);

}

@GET
@Path("/sub/{uid}/shipments/{sid}/notes")
@Produces(MediaType.APPLICATION_JSON)
public DisplayShipmentNotesResponse getNotes(@PathParam("uid") String uid, @PathParam("sid") String sid,@Context ServletContext context) throws JsonParseException, JsonMappingException, IOException{

	String filename = context.getRealPath("/WEB-INF/database.res");
	Database database = new Database(club,new File(filename));
	club = database.getClub();
	
	int userid = Integer.parseInt(uid);
	int shipid = Integer.parseInt(sid);
	
	Customer customer = club.getCustomerById(userid);
	DisplayShipmentNotes d = new DisplayShipmentNotes(customer);
	DisplayShipmentNotesResponse r = d.displayNotes(shipid);
	
	return r;
	
}
     
@POST
@Path("/sub/{uid}/shipments/{sid}/notes")
@Produces(MediaType.APPLICATION_JSON)
public AddNoteResponse addNote(@PathParam("uid") String uid, @PathParam("sid") String sid,@FormParam("content") String content,@Context ServletContext context) throws JsonParseException, JsonMappingException, IOException{
	
	String filename = context.getRealPath("/WEB-INF/database.res");
	Database database = new Database(club,new File(filename));
	club = database.getClub();
	
	int userid = Integer.parseInt(uid);
	int shipid = Integer.parseInt(sid);
	
	Customer customer = club.getCustomerById(userid);
	AddNote addEngine = new AddNote(customer);
	int nid = addEngine.addNote(shipid, content);
	Shipment shipment = customer.getShipmentById(shipid);
	customer.updateShipment(shipment);
	club.updateShipment(shipment);
	
	AddNoteResponse response = addEngine.response(shipment, nid);

	database.writeInFile(club);
	
	return response;
	
}

@POST
@Path("/sub/{uid}/shipments/{sid}/notes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public AddNoteResponse addNoteCURL(@PathParam("uid") String uid, @PathParam("sid") String sid,AddNoteRequest request,@Context ServletContext context) throws JsonParseException, JsonMappingException, IOException{
	
	String filename = context.getRealPath("/WEB-INF/database.res");
	Database database = new Database(club,new File(filename));
	club = database.getClub();
	
	int userid = Integer.parseInt(uid);
	int shipid = Integer.parseInt(sid);
	
	Customer customer = club.getCustomerById(userid);
	AddNote addEngine = new AddNote(customer);
	int nid = addEngine.addNote(shipid, request.getContent());
	Shipment shipment = customer.getShipmentById(shipid);
	customer.updateShipment(shipment);
	club.updateShipment(shipment);
	
	AddNoteResponse response = addEngine.response(shipment, nid);

	database.writeInFile(club);
	
	return response;
	
}

@GET
@Path("/sub/{uid}/shipments/{sid}/notes/{nid}")
@Produces(MediaType.APPLICATION_JSON)
public DisplayShipmentNoteByIdResponse getShipmentNoteById(@PathParam("uid") String uid, @PathParam("sid") String sid,@PathParam("nid") String nid,@Context ServletContext context) throws JsonParseException, JsonMappingException, IOException{
	
	String filename = context.getRealPath("/WEB-INF/database.res");
	Database database = new Database(club,new File(filename));
	club = database.getClub();
	
	int userid = Integer.parseInt(uid);
	int shipid = Integer.parseInt(sid);
	int noteid = Integer.parseInt(nid);
	
	Customer customer = club.getCustomerById(userid);
	DisplayShipmentNotes d = new DisplayShipmentNotes(customer);
	DisplayShipmentNoteByIdResponse r = d.displayNotes(shipid, noteid);
	
	return r;
	
}

@POST
@Path("/sub/{uid}/shipments/{sid}/notes/{nid}")
@Produces(MediaType.APPLICATION_JSON)
public void updateNote(@PathParam("uid") String uid, @PathParam("sid") String sid,@PathParam("nid") String nid,@FormParam("content") String content,@Context ServletContext context) throws JsonParseException, JsonMappingException, IOException{
	
	String filename = context.getRealPath("/WEB-INF/database.res");
	Database database = new Database(club,new File(filename));
	club = database.getClub();
	
	int userid = Integer.parseInt(uid);
	int shipid = Integer.parseInt(sid);
	int noteid = Integer.parseInt(nid);
	
	Customer customer = club.getCustomerById(userid);
	UpdateShipmentNote updateEngine = new UpdateShipmentNote(customer);
	Shipment shipment = updateEngine.update(content, shipid,noteid);
	
	customer.updateShipment(shipment);
	club.updateShipment(shipment);
	database.writeInFile(club);
	
}

@PUT
@Path("/sub/{uid}/shipments/{sid}/notes/{nid}")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public void updateNoteCURL(@PathParam("uid") String uid, @PathParam("sid") String sid,@PathParam("nid") String nid,UpdateShipmentNoteRequest request,@Context ServletContext context) throws JsonParseException, JsonMappingException, IOException{
	
	String filename = context.getRealPath("/WEB-INF/database.res");
	Database database = new Database(club,new File(filename));
	club = database.getClub();
	
	int userid = Integer.parseInt(uid);
	int shipid = Integer.parseInt(sid);
	int noteid = Integer.parseInt(nid);
	
	Customer customer = club.getCustomerById(userid);
	UpdateShipmentNote updateEngine = new UpdateShipmentNote(customer);
	Shipment shipment = updateEngine.update(request.getContent(), shipid,noteid);
	
	customer.updateShipment(shipment);
	club.updateShipment(shipment);
	database.writeInFile(club);
	
}

@DELETE
@Path("/sub/{uid}/shipments/{sid}/notes/{nid}")
@Produces(MediaType.APPLICATION_JSON)
public void deleteNote(@PathParam("uid") String uid, @PathParam("sid") String sid,@PathParam("nid") String nid,@Context ServletContext context) throws JsonParseException, JsonMappingException, IOException{
	
	String filename = context.getRealPath("/WEB-INF/database.res");
	Database database = new Database(club,new File(filename));
	club = database.getClub();
	
	int userid = Integer.parseInt(uid);
	int shipid = Integer.parseInt(sid);
	int noteid = Integer.parseInt(nid);
	
	Customer customer = club.getCustomerById(userid);
	DeleteNote deleteEngine = new DeleteNote(customer);
	Shipment shipment = deleteEngine.delete(shipid, noteid);
	
	customer.updateShipment(shipment);
	club.updateShipment(shipment);
	
	database.writeInFile(club);
	
}

@GET
@Path("/sub/{uid}/wines")
@Produces(MediaType.APPLICATION_JSON)
public DisplayWinesResponse getWines(@PathParam("uid") String uid,@Context ServletContext context) throws JsonParseException, JsonMappingException, IOException{
	
	String filename = context.getRealPath("/WEB-INF/database.res");
	Database database = new Database(club,new File(filename));
	club = database.getClub();
	
	int userid = Integer.parseInt(uid);
	
	Customer customer = club.getCustomerById(userid);
	
	DisplayWines d = new DisplayWines(customer);
	DisplayWinesResponse r = d.displayWines();
	
	return r;
	
}

@GET
@Path("/sub/{uid}/wines/{wid}")
@Produces(MediaType.APPLICATION_JSON)
public DisplayWinesResponse getWine(@PathParam("uid") String uid,@PathParam("wid") String wid,@Context ServletContext context)throws JsonParseException, JsonMappingException, IOException{

	String filename = context.getRealPath("/WEB-INF/database.res");
	Database database = new Database(club,new File(filename));
	club = database.getClub();
	
	int userid = Integer.parseInt(uid);
	int wineid = Integer.parseInt(wid);
	
	Customer customer = club.getCustomerById(userid);
	DisplayWines d = new DisplayWines(customer);
	DisplayWinesResponse r = d.displayWineById(wineid);
	
	return r;
}

@GET
@Path("/sub/{uid}/wines/{wid}/notes")
@Produces(MediaType.APPLICATION_JSON)
public DisplayWineNotesResponse getWineNotes(@PathParam("uid") String uid,@PathParam("wid") String wid,@Context ServletContext context)throws JsonParseException, JsonMappingException, IOException{

	String filename = context.getRealPath("/WEB-INF/database.res");
	Database database = new Database(club,new File(filename));
	club = database.getClub();
	
	int userid = Integer.parseInt(uid);
	int wineid = Integer.parseInt(wid);
	
	Customer customer = club.getCustomerById(userid);
	DisplayWineNotes d = new DisplayWineNotes(customer);
	DisplayWineNotesResponse r = d.displayNotes(wineid);
	
	return r;
}

@POST
@Path("/sub/{uid}/wines/{wid}/notes")
@Produces(MediaType.APPLICATION_JSON)
public AddWineNoteResponse addWineNote(@PathParam("uid") String uid,@PathParam("wid") String wid,@FormParam("content") String content,@Context ServletContext context)throws JsonParseException, JsonMappingException, IOException{

	String filename = context.getRealPath("/WEB-INF/database.res");
	Database database = new Database(club,new File(filename));
	club = database.getClub();
	
	int userid = Integer.parseInt(uid);
	int wineid = Integer.parseInt(wid);
	
	Customer customer = club.getCustomerById(userid);
	AddWineNote a = new AddWineNote(customer);
	int nid = a.addNote(wineid,content);
	AddWineNoteResponse r = a.getResponse(wineid, nid);
	club.updateWine(wineid);
	club.updateCustomer(customer);
	ArrayList<Shipment> shipments = customer.getShipments(); 
	int i=0;
	while(i<shipments.size()){
		club.updateShipment(shipments.get(i));
		i++;
	}

	database.writeInFile(club);
	return r;
}

@POST
@Path("/sub/{uid}/wines/{wid}/notes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public AddWineNoteResponse addWineNoteCURL(@PathParam("uid") String uid,@PathParam("wid") String wid,AddWineNoteRequest request,@Context ServletContext context)throws JsonParseException, JsonMappingException, IOException{

	String filename = context.getRealPath("/WEB-INF/database.res");
	Database database = new Database(club,new File(filename));
	club = database.getClub();
	
	int userid = Integer.parseInt(uid);
	int wineid = Integer.parseInt(wid);
	
	Customer customer = club.getCustomerById(userid);
	AddWineNote a = new AddWineNote(customer);
	int nid = a.addNote(wineid,request.getContent());
	AddWineNoteResponse r = a.getResponse(wineid, nid);
	club.updateWine(wineid);
	club.updateCustomer(customer);
	ArrayList<Shipment> shipments = customer.getShipments(); 
	int i=0;
	while(i<shipments.size()){
		club.updateShipment(shipments.get(i));
		i++;
	}

	database.writeInFile(club);
	return r;
}

@GET
@Path("/sub/{uid}/wines/{wid}/notes/{nid}")
@Produces(MediaType.APPLICATION_JSON)
public DisplayWineNotesResponse getWineNote(@PathParam("uid") String uid,@PathParam("wid") String wid,@PathParam("nid") String nid,@Context ServletContext context)throws JsonParseException, JsonMappingException, IOException{

	String filename = context.getRealPath("/WEB-INF/database.res");
	Database database = new Database(club,new File(filename));
	club = database.getClub();
	
	int userid = Integer.parseInt(uid);
	int wineid = Integer.parseInt(wid);
	int noteid = Integer.parseInt(nid);
	
	Customer customer = club.getCustomerById(userid);
	DisplayWineNotes d = new DisplayWineNotes(customer);
	DisplayWineNotesResponse r = d.displayNoteById(wineid, noteid);
	
	return r;
}

@POST
@Path("/sub/{uid}/wines/{wid}/notes/{nid}")
@Produces(MediaType.APPLICATION_JSON)
public void updateWineNote(@PathParam("uid") String uid,@PathParam("wid") String wid,@PathParam("nid") String nid,@FormParam("content") String content,@Context ServletContext context)throws JsonParseException, JsonMappingException, IOException{
	
	String filename = context.getRealPath("/WEB-INF/database.res");
	Database database = new Database(club,new File(filename));
	club = database.getClub();
	
	int userid = Integer.parseInt(uid);
	int wineid = Integer.parseInt(wid);
	int noteid = Integer.parseInt(nid);
	
	Customer customer = club.getCustomerById(userid);
	UpdateWineNote d = new UpdateWineNote(customer);
	d.updateWineNote(content, wineid, noteid);
	club.updateWine(wineid);
	club.updateCustomer(customer);
	ArrayList<Shipment> shipments = customer.getShipments(); 
	int i=0;
	while(i<shipments.size()){
		club.updateShipment(shipments.get(i));
		i++;
	}

	database.writeInFile(club);  
	
} 

@PUT
@Path("/sub/{uid}/wines/{wid}/notes/{nid}")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public void updateWineNoteCURL(@PathParam("uid") String uid,@PathParam("wid") String wid,@PathParam("nid") String nid,UpdateWineNoteRequest request,@Context ServletContext context)throws JsonParseException, JsonMappingException, IOException{
	
	String filename = context.getRealPath("/WEB-INF/database.res");
	Database database = new Database(club,new File(filename));
	club = database.getClub();
	
	int userid = Integer.parseInt(uid);
	int wineid = Integer.parseInt(wid);
	int noteid = Integer.parseInt(nid);
	
	Customer customer = club.getCustomerById(userid);
	UpdateWineNote d = new UpdateWineNote(customer);
	d.updateWineNote(request.getContent(), wineid, noteid);
	club.updateWine(wineid);
	club.updateCustomer(customer);
	ArrayList<Shipment> shipments = customer.getShipments(); 
	int i=0;
	while(i<shipments.size()){
		club.updateShipment(shipments.get(i));
		i++;
	}

	database.writeInFile(club);  
	
} 

@DELETE
@Path("/sub/{uid}/wines/{wid}/notes/{nid}")
@Produces(MediaType.APPLICATION_JSON)
public void deleteWineNote(@PathParam("uid") String uid,@PathParam("wid") String wid,@PathParam("nid") String nid,@Context ServletContext context)throws JsonParseException, JsonMappingException, IOException{
	
	String filename = context.getRealPath("/WEB-INF/database.res");
	Database database = new Database(club,new File(filename));
	club = database.getClub();
	
	int userid = Integer.parseInt(uid);
	int wineid = Integer.parseInt(wid);
	int noteid = Integer.parseInt(nid);
	
	Customer customer = club.getCustomerById(userid);
	DeleteWineNote d = new DeleteWineNote(customer);
	d.deleteWineNote(wineid, noteid);
	
	club.updateWine(wineid);
	club.updateCustomer(customer);
	ArrayList<Shipment> shipments = customer.getShipments(); 
	int i=0;
	while(i<shipments.size()){
		club.updateShipment(shipments.get(i));
		i++;
	}

	database.writeInFile(club);
}

@GET
@Path("/sub/{uid}/wines/{wid}/rating")
@Produces(MediaType.APPLICATION_JSON)
public DisplayWineRatingResponse getWineRating(@PathParam("uid") String uid,@PathParam("wid") String wid,@Context ServletContext context)throws JsonParseException, JsonMappingException, IOException{
	
	String filename = context.getRealPath("/WEB-INF/database.res");
	Database database = new Database(club,new File(filename));
	club = database.getClub();
	
	int userid = Integer.parseInt(uid);
	int wineid = Integer.parseInt(wid);
	
	DisplayWineRating d = new DisplayWineRating(club);
	DisplayWineRatingResponse r = d.displayWineRating(userid, wineid);
	
	return r;
}

@POST
@Path("/sub/{uid}/wines/{wid}/rating")
@Produces(MediaType.APPLICATION_JSON)
public void addWineRating(@PathParam("uid") String uid,@PathParam("wid") String wid,@FormParam("rating") int rating,@Context ServletContext context)throws JsonParseException, JsonMappingException, IOException{
	
	String filename = context.getRealPath("/WEB-INF/database.res");
	Database database = new Database(club,new File(filename));
	club = database.getClub();
	
	int userid = Integer.parseInt(uid);
	int wineid = Integer.parseInt(wid);
	
	Customer customer = club.getCustomerById(userid); 
	AddWineRating a = new AddWineRating(club);
	a.addWineRating(userid, wineid, rating);
	
	club.updateWine(wineid);
	club.updateCustomer(customer);
	ArrayList<Shipment> shipments = customer.getShipments(); 
	int i=0;
	while(i<shipments.size()){
		club.updateShipment(shipments.get(i));
		i++;
	}

	database.writeInFile(club);
	 
}

@POST
@Path("/sub/{uid}/wines/{wid}/rating")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public void addWineRatingCURL(@PathParam("uid") String uid,@PathParam("wid") String wid,AddWineRatingRequest request,@Context ServletContext context)throws JsonParseException, JsonMappingException, IOException{
	
	String filename = context.getRealPath("/WEB-INF/database.res");
	Database database = new Database(club,new File(filename));
	club = database.getClub();
	
	int userid = Integer.parseInt(uid);
	int wineid = Integer.parseInt(wid);
	
	Customer customer = club.getCustomerById(userid); 
	AddWineRating a = new AddWineRating(club);
	a.addWineRating(userid, wineid, request.getRating());
	
	club.updateWine(wineid);
	club.updateCustomer(customer);
	ArrayList<Shipment> shipments = customer.getShipments(); 
	int i=0;
	while(i<shipments.size()){
		club.updateShipment(shipments.get(i));
		i++;
	}

	database.writeInFile(club);
	 
}

@POST
@Path("/sub/{uid}/delivery")
@Produces(MediaType.APPLICATION_JSON)
public void setDelivery(@PathParam("uid") String uid,@FormParam("dow") String dow,@FormParam("tod") String tod,@Context ServletContext context)throws JsonParseException, JsonMappingException, IOException{
	
	String filename = context.getRealPath("/WEB-INF/database.res");
	Database database = new Database(club,new File(filename));
	club = database.getClub();
	
	int userid = Integer.parseInt(uid);
	
	Customer customer = club.getCustomerById(userid);
	UpdateDeliveryInfo d = new UpdateDeliveryInfo(customer);
	Customer newCustomer = d.updateDeliveryInfo(dow, tod);
	
	club.updateCustomer(newCustomer);
	
	ArrayList<Shipment> shipments = customer.getShipments(); 
	int i=0;
	while(i<shipments.size()){
		club.updateShipment(shipments.get(i));
		i++;
	}

	database.writeInFile(club);
	
}

@PUT
@Path("/sub/{uid}/delivery")
@Produces(MediaType.APPLICATION_JSON)
public void setDeliveryCURL(@PathParam("uid") String uid,UpdateDeliveryInfoRequest request,@Context ServletContext context)throws JsonParseException, JsonMappingException, IOException{
	
	String filename = context.getRealPath("/WEB-INF/database.res");
	Database database = new Database(club,new File(filename));
	club = database.getClub();
	
	int userid = Integer.parseInt(uid);
	
	Customer customer = club.getCustomerById(userid);
	UpdateDeliveryInfo d = new UpdateDeliveryInfo(customer);
	Customer newCustomer = d.updateDeliveryInfo(request.getDow(), request.getTod());
	
	club.updateCustomer(newCustomer);
	
	ArrayList<Shipment> shipments = customer.getShipments(); 
	int i=0;
	while(i<shipments.size()){
		club.updateShipment(shipments.get(i));
		i++;
	}

	database.writeInFile(club);
	
}

@GET
@Path("/sub/{uid}/delivery")
@Produces(MediaType.APPLICATION_JSON)
public DisplayDeliveryInfoResponse updateDelivery(@PathParam("uid") String uid,@Context ServletContext context)throws JsonParseException, JsonMappingException, IOException{
	
	String filename = context.getRealPath("/WEB-INF/database.res");
	Database database = new Database(club,new File(filename));
	club = database.getClub();
	
	int userid = Integer.parseInt(uid);
	  
	Customer customer = club.getCustomerById(userid);
	DisplayDeliveryInfo d = new DisplayDeliveryInfo(customer);
	DisplayDeliveryInfoResponse r = d.displayInfo();
	
	return r;
}
                     
@POST
@Path("/admin")
@Produces(MediaType.APPLICATION_JSON)
public AddAdminResponse createAdminAccount(@FormParam("name") String name,@Context ServletContext context) throws JsonParseException, JsonMappingException, IOException {
	
	String filename = context.getRealPath("/WEB-INF/database.res");
	String fileWines = context.getRealPath("/WEB-INF/Wines.json");
	Database databaseWines = new Database(club,new File(fileWines));
	Database database = new Database(club,new File(filename));
	club = database.getClub();
	club.setSelection(databaseWines.getWines());
		
	AddAdmin a = new AddAdmin(club);
	AddAdminResponse r = a.addAdmin(name);
	
	   
	database.writeInFile(club); 
	 
	return r;
}
	
@POST
@Path("/admin")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public AddAdminResponse createAdminAccountCURL(AddAdminRequest request,@Context ServletContext context) throws JsonParseException, JsonMappingException, IOException {
	
	String filename = context.getRealPath("/WEB-INF/database.res");
	String fileWines = context.getRealPath("/WEB-INF/Wines.json");
	Database databaseWines = new Database(club,new File(fileWines));
	Database database = new Database(club,new File(filename));
	club = database.getClub();
	club.setSelection(databaseWines.getWines());
		
	AddAdmin a = new AddAdmin(club);
	AddAdminResponse r = a.addAdmin(request.getName());
	
	   
	database.writeInFile(club); 
	 
	return r;
}

@GET
@Path("/admin")
@Produces(MediaType.APPLICATION_JSON)
public DisplayAdminResponse getAdmins(@Context ServletContext context) throws JsonParseException, JsonMappingException, IOException {
	
	String filename = context.getRealPath("/WEB-INF/database.res");
	Database database = new Database(club,new File(filename));
	club = database.getClub();
		  
	DisplayAdmin d = new DisplayAdmin(club);
	DisplayAdminResponse r = d.displayAdmins();
	return r;
	
}

@POST
@Path("/admin/{aid}")
@Produces(MediaType.APPLICATION_JSON)
public void updateAdminAccount(@PathParam("aid") String aid,@FormParam("name") String name,@Context ServletContext context) throws JsonParseException, JsonMappingException, IOException {
	
	String filename = context.getRealPath("/WEB-INF/database.res");
	String fileWines = context.getRealPath("/WEB-INF/Wines.json");
	Database databaseWines = new Database(club,new File(fileWines));
	Database database = new Database(club,new File(filename));
	club = database.getClub();
	club.setSelection(databaseWines.getWines());
		
	int adminid = Integer.parseInt(aid);
	
	UpdateAdmin d = new UpdateAdmin(club);
	d.updateAdmin(adminid,name);
		   
	database.writeInFile(club); 
}

@PUT
@Path("/admin/{aid}")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public void updateAdminAccountCURL(@PathParam("aid") String aid,UpdateAdminRequest request,@Context ServletContext context) throws JsonParseException, JsonMappingException, IOException {
	
	String filename = context.getRealPath("/WEB-INF/database.res");
	String fileWines = context.getRealPath("/WEB-INF/Wines.json");
	Database databaseWines = new Database(club,new File(fileWines));
	Database database = new Database(club,new File(filename));
	club = database.getClub();
	club.setSelection(databaseWines.getWines());
		
	int adminid = Integer.parseInt(aid);
	
	UpdateAdmin d = new UpdateAdmin(club);
	d.updateAdmin(adminid,request.getName());
		   
	database.writeInFile(club); 
}

@GET
@Path("/admin/{aid}")
@Produces(MediaType.APPLICATION_JSON)
public DisplayAdminResponse getAdmin(@PathParam("aid") String aid,@Context ServletContext context) throws JsonParseException, JsonMappingException, IOException {
	
	String filename = context.getRealPath("/WEB-INF/database.res");
	Database database = new Database(club,new File(filename));
	club = database.getClub();
	
	int adminid = Integer.parseInt(aid);
	DisplayAdmin d = new DisplayAdmin(club);
	DisplayAdminResponse r = d.displayAdmin(adminid);
	return r;
}

@GET
@Path("/admin/revenue")
@Produces(MediaType.APPLICATION_JSON)
public DisplayRevenueResponse getRevenue(@QueryParam("start") String start,@QueryParam("end") String end,@Context ServletContext context) throws JsonParseException, JsonMappingException, IOException, NullPointerException, ParseException {
	
	String filename = context.getRealPath("/WEB-INF/database.res");
	Database database = new Database(club,new File(filename));
	club = database.getClub();
	if(start==null){
		start="";
	}
	if(end==null){
		end="";
	}
	
	DisplayRevenue d = new DisplayRevenue(club);
	DisplayRevenueResponse r = d.getRevenue(start, end);
	return r;
	
	
}

@POST
@Path("/admin/monthly_selection")
@Produces(MediaType.APPLICATION_JSON)
public AddMonthlySelectionResponse addMonthlSelectionCURL(AddMonthlySelectionRequest request,@Context ServletContext context) throws JsonParseException, JsonMappingException, IOException, NullPointerException, ParseException {
	
	String filename = context.getRealPath("/WEB-INF/database.res");
	Database database = new Database(club,new File(filename));
	club = database.getClub();
	
	AddMonthlySelection a = new AddMonthlySelection(club);
	AddMonthlySelectionResponse r = a.addSelection(request.getType(),request.getSelection_month(),request.getWines());
	
	database.writeInFile(club); 
	
	return r;
	
	
}

@GET
@Path("/admin/monthly_selection")
@Produces(MediaType.APPLICATION_JSON)
public DisplayMonthlySelectionsResponse getMonthlySelections(@Context ServletContext context) throws JsonParseException, JsonMappingException, IOException{
	
	String filename = context.getRealPath("/WEB-INF/database.res");
	Database database = new Database(club,new File(filename));
	club = database.getClub();
	
	DisplayMonthlySelections d = new DisplayMonthlySelections(club);
	DisplayMonthlySelectionsResponse r = d.displaySelections();
	
	return r;
}

@GET
@Path("/admin/monthly_selection/{mid}")
@Produces(MediaType.APPLICATION_JSON)
public DisplayMonthlySelectionsResponse getMonthlySelection(@PathParam("mid") String mid,@Context ServletContext context) throws JsonParseException, JsonMappingException, IOException{
	
	String filename = context.getRealPath("/WEB-INF/database.res");
	Database database = new Database(club,new File(filename));
	club = database.getClub();
	
	int monthId = Integer.parseInt(mid);
	
	DisplayMonthlySelections d = new DisplayMonthlySelections(club);
	DisplayMonthlySelectionsResponse r = d.displaySelectionsById(monthId);
	
	return r;
}

@GET
@Path("/partner")
@Produces(MediaType.APPLICATION_JSON)
public DisplayDeliveriesResponse getCustomersToDeliver(@Context ServletContext context) throws JsonParseException, JsonMappingException, IOException{
	
	
	String filename = context.getRealPath("/WEB-INF/database.res");
	Database database = new Database(club,new File(filename));
	club = database.getClub();
	
	DisplayDeliveries d = new DisplayDeliveries(club);
	DisplayDeliveriesResponse r = d.displayDeliveries();
	return r;
	     
}

@POST
@Path("/receipt")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public AddReceiptResponse addReceipt(AddReceiptRequest request,@Context ServletContext context) throws JsonParseException, JsonMappingException, IOException{
	
	String filename = context.getRealPath("/WEB-INF/database.res");
	Database database = new Database(club,new File(filename));
	club = database.getClub();
	
	AddReceipt a = new AddReceipt(club);
	AddReceiptResponse r = a.addReceipt(request.getName());
	
	database.writeInFile(club); 
	
	return r;
	
	
}

@GET
@Path("/receipt")
@Produces(MediaType.APPLICATION_JSON)
public DisplayReceiptsResponse getReceipts(@Context ServletContext context) throws JsonParseException, JsonMappingException, IOException{
	
	String filename = context.getRealPath("/WEB-INF/database.res");
	Database database = new Database(club,new File(filename));
	club = database.getClub();
	
	DisplayReceipts d = new DisplayReceipts(club);
	DisplayReceiptsResponse r = d.displayReceipts();
	return r;
	
	
}

@GET
@Path("/receipt/{rid}")
@Produces(MediaType.APPLICATION_JSON)
public DisplayReceiptResponse getReceipt(@PathParam("rid") String rid,@Context ServletContext context) throws JsonParseException, JsonMappingException, IOException{
	
	String filename = context.getRealPath("/WEB-INF/database.res");
	Database database = new Database(club,new File(filename));
	club = database.getClub();
	
	int receiptid = Integer.parseInt(rid);
	
	DisplayReceipts d = new DisplayReceipts(club);
	DisplayReceiptResponse r = d.displayReceipt(receiptid);
	return r;
	
	
}

@GET
@Path("/wines/{wid}")
@Produces(MediaType.APPLICATION_JSON)
public DisplayWineResponse getWine(@PathParam("wid") String wid,@Context ServletContext context) throws JsonParseException, JsonMappingException, IOException{
	
	
	String filename = context.getRealPath("/WEB-INF/database.res");
	Database database = new Database(club,new File(filename));
	club = database.getClub();
	
	int wineid = Integer.parseInt(wid);
	
	DisplayWine d = new DisplayWine(club);
	DisplayWineResponse r = d.getWine(wineid);
	return r;
	
	
	
}

}