package update;

import Entities.Administrator;
import Entities.WineClub;

public class UpdateAdmin {
	
	WineClub club;
	
	public UpdateAdmin(){
		
	}
	public UpdateAdmin(WineClub club){
		this.club=club;
	}
	public WineClub getClub() {
		return club;
	}
	public void setClub(WineClub club) {
		this.club = club;
	}
	
	public void updateAdmin(int aid,String name) throws java.lang.NullPointerException{
		
		WineClub club = this.getClub();
		if(club.getAdministratorById(aid)!=null){
			Administrator admin = club.getAdministratorById(aid);
			admin.setName(name);
			
			club.updateAdministrator(admin);
		}
		else{
			throw new java.lang.NullPointerException("Administrator not found");
		}
		
	}
}
