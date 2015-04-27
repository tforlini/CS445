package add;

public class AddAdminRequest {

	private String name;

	public AddAdminRequest(){
		
	}
	
	public AddAdminRequest(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
