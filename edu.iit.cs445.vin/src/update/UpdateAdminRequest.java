package update;

public class UpdateAdminRequest {

	private String name;

	public UpdateAdminRequest(){
		
	}
	
	public UpdateAdminRequest(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
