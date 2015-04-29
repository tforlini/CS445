package update.request;

public class UpdateDeliveryInfoRequest {
	private String dow;
	private String tod;
	
	public UpdateDeliveryInfoRequest(){
		
	}
	
	public UpdateDeliveryInfoRequest(String dow, String tod) {
		this.dow = dow;
		this.tod = tod;
	}

	public String getDow() {
		return dow;
	}

	public void setDow(String dow) {
		this.dow = dow;
	}

	public String getTod() {
		return tod;
	}

	public void setTod(String tod) {
		this.tod = tod;
	}
	
	
}
