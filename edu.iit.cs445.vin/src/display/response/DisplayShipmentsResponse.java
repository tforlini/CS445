package display.response;

import java.util.ArrayList;

public class DisplayShipmentsResponse {

	ArrayList<Object> shipments;

	
	public DisplayShipmentsResponse(){
		this.shipments=new ArrayList<Object>();

	}
	public DisplayShipmentsResponse(ArrayList<Object> shipments){
		this.shipments=shipments;

	}
	public ArrayList<Object> getShipments() {
		return shipments;
	}
	public void setShipments(ArrayList<Object> shipments) {
		this.shipments = shipments;
	}

	
	
}
