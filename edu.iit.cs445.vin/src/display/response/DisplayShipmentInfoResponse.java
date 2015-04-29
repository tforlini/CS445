package display.response;

import java.util.ArrayList;

import entities.ShipmentState;

public class DisplayShipmentInfoResponse {
	String selection_month;
	ShipmentState status;
	String date;
	String type;
	ArrayList<Object> wines;
	
	public DisplayShipmentInfoResponse(){
		
	}
	
	public DisplayShipmentInfoResponse(String selection_month,ShipmentState status, String date, String type, ArrayList<Object> wines){
		this.selection_month=selection_month;
		this.status=status;
		this.date=date;
		this.type=type;
		this.wines=wines;
	}

	public String getSelection_month() {
		return selection_month;
	}

	public void setSelection_month(String selection_month) {
		this.selection_month = selection_month;
	}

	public ShipmentState getStatus() {
		return status;
	}

	public void setStatus(ShipmentState status) {
		this.status = status;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getType() {
		return type;
	}

	public void setType(String string) {
		this.type = string;
	}

	public ArrayList<Object> getWines() {
		return wines;
	}

	public void setWines(ArrayList<Object> wines) {
		this.wines = wines;
	}
	
	
}
