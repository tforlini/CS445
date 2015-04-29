package display.response;

import java.util.ArrayList;

public class DisplayReceiptsResponse {

	ArrayList<Object> receipts;

	public DisplayReceiptsResponse(){
		
	}
	
	public DisplayReceiptsResponse(ArrayList<Object> receipts) {
		this.receipts = receipts;
	}

	public ArrayList<Object> getReceipts() {
		return receipts;
	}

	public void setReceipts(ArrayList<Object> receipts) {
		this.receipts = receipts;
	}
	
	
}
