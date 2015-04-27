package display;

import java.util.ArrayList;

public class DisplayAdminResponse {
	
	ArrayList<Object> admins;
	
	public DisplayAdminResponse(){
		this.admins=new ArrayList<Object>();
	}
	
	public DisplayAdminResponse(ArrayList<Object> admins){
		this.admins=admins;
	}

	public ArrayList<Object> getAdmins() {
		return admins;
	}

	public void setAdmins(ArrayList<Object> admins) {
		this.admins = admins;
	}

	public void addId(int id){
		
		this.admins.add("id: "+id);
	}
	public void addName(String name){
		
		this.admins.add("name: "+name);
	}
	public void addCreatedDate(String string){
		
		this.admins.add("create_date: "+string);
	}
	public void addCreatedBy(int id){
		
		this.admins.add("created_by: "+id);
	}
}
