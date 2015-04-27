package add;

import Entities.Receipt;
import Entities.WineClub;

public class AddReceipt {

	private WineClub club;

	public AddReceipt(){
		
	}
	
	public AddReceipt(WineClub club) {
		this.club = club;
	}

	public WineClub getClub() {
		return club;
	}

	public void setClub(WineClub club) {
		this.club = club;
	}
	
	public AddReceiptResponse addReceipt(String name){
		AddReceiptResponse response = new AddReceiptResponse();
		WineClub club = this.getClub();
		Receipt receipt = new Receipt();
		receipt.setReceived_by(name);
		club.addReceipt(receipt);
		response.setId(receipt.getId());
		return response;
		
		
	}
}
