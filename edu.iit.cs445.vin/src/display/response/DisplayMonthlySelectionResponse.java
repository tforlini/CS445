package display.response;

import java.util.ArrayList;

public class DisplayMonthlySelectionResponse {
	private int id;
	private String selection_month;
	private String type;
	private String create_date;
	private int created_by;
	private ArrayList<Object> wines;
	
	public DisplayMonthlySelectionResponse(){
		
	}
	
	public DisplayMonthlySelectionResponse(int id, String selection_month,String type, String create_date, int created_by,ArrayList<Object> wines) {
		this.id = id;
		this.selection_month = selection_month;
		this.type = type;
		this.create_date = create_date;
		this.created_by = created_by;
		this.wines = wines;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSelection_month() {
		return selection_month;
	}

	public void setSelection_month(String selection_month) {
		this.selection_month = selection_month;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCreate_date() {
		return create_date;
	}

	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}

	public int getCreated_by() {
		return created_by;
	}

	public void setCreated_by(int created_by) {
		this.created_by = created_by;
	}

	public ArrayList<Object> getWines() {
		return wines;
	}

	public void setWines(ArrayList<Object> wines) {
		this.wines = wines;
	}
	
	
}
