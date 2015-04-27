package display;

import java.util.ArrayList;

public class DisplayWineNotesResponse {
	ArrayList<Object>  notes;
	
	public DisplayWineNotesResponse(){
		
	}
	
	public DisplayWineNotesResponse(ArrayList<Object> notes){
		this.notes=notes;
	}

	public ArrayList<Object> getNotes() {
		return notes;
	}

	public void setNotes(ArrayList<Object> notes) {
		this.notes = notes;
	}
}
