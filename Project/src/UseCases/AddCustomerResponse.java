package UseCases;

public class AddCustomerResponse {
	private int id;
	private boolean status;
	private String failureDescription;
	
	public AddCustomerResponse(){
		
	}
	
	public AddCustomerResponse(int id, boolean s, String f) {
		this.id = id;
		this.status = s;
		this.failureDescription = f;
	}
	public void printResponse() {
		System.out.println("ID: " + this.id + "\tStatus: " + this.status + "\tDescription: " + this.failureDescription);
	
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getFailureDescription() {
		return failureDescription;
	}

	public void setFailureDescription(String failureDescription) {
		this.failureDescription = failureDescription;
	}
	
	
}
