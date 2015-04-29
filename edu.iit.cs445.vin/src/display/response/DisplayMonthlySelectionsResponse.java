package display.response;

import java.util.ArrayList;

public class DisplayMonthlySelectionsResponse {
	private ArrayList<Object> monthly_selection;

	public DisplayMonthlySelectionsResponse(){
		
	}
	
	public DisplayMonthlySelectionsResponse(ArrayList<Object> monthly_selection) {
		this.monthly_selection = monthly_selection;
	}

	public ArrayList<Object> getMonthly_selection() {
		return monthly_selection;
	}

	public void setMonthly_selection(ArrayList<Object> monthly_selection) {
		this.monthly_selection = monthly_selection;
	}
	
	
}
