package display;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import Entities.Receipt;
import Entities.WineClub;

public class DisplayReceipts {
	
	private WineClub club;

	public DisplayReceipts(){
		
	}
	
	public DisplayReceipts(WineClub club) {
		this.club = club;
	}

	public WineClub getClub() {
		return club;
	}

	public void setClub(WineClub club) {
		this.club = club;
	}
	
	public DisplayReceiptsResponse displayReceipts() throws java.lang.NullPointerException{
		SimpleDateFormat dt = new SimpleDateFormat("MMM-dd-YYYY"); 
		DisplayReceiptsResponse response = new DisplayReceiptsResponse();
		ArrayList<Object> Receipts = new ArrayList<Object>();
		WineClub club = this.getClub();
		if(club.getReceipts()!=null){
			ArrayList<Receipt> receipts = club.getReceipts();
			int i=0;
			while(i<receipts.size()){
				Receipts.add("id: "+receipts.get(i).getId());
				Receipts.add("date: "+dt.format(receipts.get(i).getDate().getTime()));
				Receipts.add("subscriber: "+receipts.get(i).getSubscriber());
				Receipts.add("name: "+receipts.get(i).getReceived_by());
				i++;
			}
		}
		else{
			throw new java.lang.NullPointerException("Receipts not found");
		}
		response.setReceipts(Receipts);
		return response;
		
	}
	
	public DisplayReceiptResponse displayReceipt(int rid) throws java.lang.NullPointerException{
		SimpleDateFormat dt = new SimpleDateFormat("MMM-dd-YYYY"); 
		SimpleDateFormat dt2 = new SimpleDateFormat("hh:mm aa");
		DisplayReceiptResponse response = new DisplayReceiptResponse();
		WineClub club = this.getClub();
		if(club.getReceiptById(rid)!=null){
			Receipt receipt = club.getReceiptById(rid);
			
				response.setId(receipt.getId());
				response.setDate(dt.format(receipt.getDate().getTime()));
				response.setTime(dt2.format(receipt.getTime().getTime()));
				response.setSubscriber(receipt.getSubscriber());
				response.setName(receipt.getName());
				response.setReceived_by(receipt.getReceived_by());
			
		}
		else{
			throw new java.lang.NullPointerException("Receipts not found");
		}
		return response;
		
	}
	
}
