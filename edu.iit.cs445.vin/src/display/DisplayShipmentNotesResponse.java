package display;

import java.util.ArrayList;

public class DisplayShipmentNotesResponse {

	ArrayList<Object>  notes;
	
	public DisplayShipmentNotesResponse(){
		
	}
	
	public DisplayShipmentNotesResponse(ArrayList<Object> notes){
		this.notes=notes;
	}

	public ArrayList<Object> getNotes() {
		return notes;
	}

	public void setNotes(ArrayList<Object> notes) {
		this.notes = notes;
	}
	
	
}
