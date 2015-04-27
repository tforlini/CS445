package display;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import Entities.Administrator;
import Entities.WineClub;

public class DisplayAdmin {
	WineClub club;
	
	public DisplayAdmin(){
		this.club=null;
	}
	
	public DisplayAdmin(WineClub club){
		this.club=club;
	}

	public WineClub getClub() {
		return club;
	}

	public void setClub(WineClub club) {
		this.club =club;
	}
	
	public DisplayAdminResponse displayAdmins() throws java.lang.NullPointerException {
		DisplayAdminResponse response = new DisplayAdminResponse();
		WineClub club = this.getClub();
		
		if(club.getAdministrators()!=null){
			ArrayList<Administrator> admins = club.getAdministrators();
			int i=0;
			while(i<admins.size()){
				response.addId(admins.get(i).getId());
				response.addName(admins.get(i).getName());
				i++;
			}
		}
		else{
			throw new java.lang.NullPointerException("Administrators not found");
		}
		return response;
		
		
	}
	
	public DisplayAdminResponse displayAdmin(int aid) throws java.lang.NullPointerException {
		SimpleDateFormat dt = new SimpleDateFormat("dd-MMM-yyyy");
		DisplayAdminResponse response = new DisplayAdminResponse();
		WineClub club = this.getClub();
		
		
		if(club.getAdministratorById(aid)!=null){
			Administrator admin = club.getAdministratorById(aid);

				response.addId(admin.getId());
				response.addName(admin.getName());
				response.addCreatedDate(dt.format(admin.getCreate_date().getTime()));
				response.addCreatedBy(admin.getCreated_by());
		}
		else{
			throw new java.lang.NullPointerException("Administrator not found");
		}
		return response;
		
		
	}
}
