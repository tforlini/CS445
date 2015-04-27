package add;

import java.util.ArrayList;

public class AddMonthlySelectionRequest {

	private String type;
	private String selection_month;
	private ArrayList<AddSelectionWines> wines;
	
	public AddMonthlySelectionRequest(){
		
	}
	
	public AddMonthlySelectionRequest(String type, String selection_month,ArrayList<AddSelectionWines> wines) {
		this.type = type;
		this.selection_month = selection_month;
		this.wines = wines;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSelection_month() {
		return selection_month;
	}

	public void setSelection_month(String selection_month) {
		this.selection_month = selection_month;
	}

	public ArrayList<AddSelectionWines> getWines() {
		return wines;
	}

	public void setWines(ArrayList<AddSelectionWines> wines) {
		this.wines = wines;
	}
	
	
}
