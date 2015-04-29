package add.classes;

import add.response.AddAdminResponse;
import entities.Administrator;
import entities.WineClub;

public class AddAdmin {

	public WineClub club;
	
	public AddAdmin(){
		
	}
	public AddAdmin(WineClub club){
		this.club=club;
	}

	
	public WineClub getClub() {
		return club;
	}
	public void setClub(WineClub club) {
		this.club = club;
	}
	public AddAdminResponse addAdmin(String name){
		AddAdminResponse response = new AddAdminResponse(); 
		WineClub club = this.getClub();
		Administrator admin = new Administrator(name);
		club.addAdmin(admin);
		response.setId(admin.getId());
		return response;
	}
	
}
