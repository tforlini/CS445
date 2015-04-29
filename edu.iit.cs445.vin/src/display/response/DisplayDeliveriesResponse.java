package display.response;

import java.util.ArrayList;

public class DisplayDeliveriesResponse {

	private ArrayList<Object> deliver_to;

	public DisplayDeliveriesResponse(){
		
	}
	
	public DisplayDeliveriesResponse(ArrayList<Object> deliver_to) {
		this.deliver_to = deliver_to;
	}

	public ArrayList<Object> getDeliver_to() {
		return deliver_to;
	}

	public void setDeliver_to(ArrayList<Object> deliver_to) {
		this.deliver_to = deliver_to;
	}
	
	
}
