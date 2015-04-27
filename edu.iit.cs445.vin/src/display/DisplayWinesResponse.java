package display;

import java.util.ArrayList;

public class DisplayWinesResponse {

	ArrayList<Object> wines;
	
	public DisplayWinesResponse(){
		
	}
	
	public DisplayWinesResponse(ArrayList<Object> wines){
		this.wines=wines;
		
	}

	public ArrayList<Object> getWines() {
		return wines;
	}

	public void setWines(ArrayList<Object> wines) {
		this.wines = wines;
	}
	
	
	
}
