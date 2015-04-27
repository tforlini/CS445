package Entities;

import java.util.ArrayList;
import java.util.Calendar;


public class MonthlySelection {

	protected int id;
	protected ArrayList<Wine> wines;
	protected double price;
	protected int numberOfBottles;
	protected Calendar date;
	protected int created_by;
	protected String type;
	
	
	public MonthlySelection() {
		Calendar today = Calendar.getInstance();
		today.set(Calendar.DAY_OF_MONTH,15);
		this.wines = new ArrayList<Wine>();
		this.price=59.99;
		this.numberOfBottles=0;
		this.date=today;
		this.type="RW";
		this.id=IdGenerator.newID();
	}

	public MonthlySelection(ArrayList<Wine> wines, int price,int numberOfBottles,Calendar date,String type) {
		
		this.wines = wines;
		this.price=price;
		this.numberOfBottles=numberOfBottles;
		this.date=date;
		this.type=type;
		this.id=IdGenerator.newID();
	}

	public ArrayList<Wine> getWines() {
		return wines;
	}

	public int getCreated_by() {
		return created_by;
	}

	public void setCreated_by(int created_by) {
		this.created_by = created_by;
	}

	public void setWines(ArrayList<Wine> wines) {
		this.wines = wines;
	}

	public double getPrice() {
		return price;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public int getNumberOfBottles() {
		return numberOfBottles;
	}

	public void setNumberOfBottles(int numberOfBottles) {
		this.numberOfBottles = numberOfBottles;
	}
	
	public Calendar getDate() {
		return date;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}

	public void addWine(Wine wine){
		this.wines.add(wine);
		this.numberOfBottles++;
	}
	
	public void removeWine(Wine wine){
		this.wines.remove(wine);
		this.numberOfBottles--;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Wine getWineById(int id){
		ArrayList<Wine> wines = this.getWines();
		int i=0;
		
		while(i<wines.size()){
			if(wines.get(i).getID() == id){
				return wines.get(i);
			}
			i++;
		}
		return null;
	}
	
	public void updateWine(Wine newWine) {
		int newId = newWine.getID();
		ArrayList<Wine> wines = this.getWines();
		int i = 0;
		while (i < wines.size()) {
			if (wines.get(i).getID() == newId) {
				wines.set(i, newWine);
			}
			i++;
		}
		this.setWines(wines);
	}
	
}
