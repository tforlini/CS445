package add;

public class AddReceiptRequest {
	private String name;

	public AddReceiptRequest(){
		
	}
	
	public AddReceiptRequest(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
