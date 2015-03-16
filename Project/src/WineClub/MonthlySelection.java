package WineClub;

import java.util.ArrayList;
import java.util.Date;

public class MonthlySelection {

	protected ArrayList<Wine> wines;
	protected int price;
	protected int numberOfBottles;
	protected Date date;
	protected String type;
	
	public MonthlySelection() {
		
		this.wines = new ArrayList<Wine>();
		this.price=0;
		this.numberOfBottles=6;
		this.date=new Date();
		this.type="RW";
	}

	public MonthlySelection(ArrayList<Wine> wines, int price,int numberOfBottles,Date date,String type) {
		
		this.wines = wines;
		this.price=price;
		this.numberOfBottles=numberOfBottles;
		this.date=date;
		this.type=type;
	}

	public ArrayList<Wine> getWines() {
		return wines;
	}

	public void setWines(ArrayList<Wine> wines) {
		this.wines = wines;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getNumberOfBottles() {
		return numberOfBottles;
	}

	public void setNumberOfBottles(int numberOfBottles) {
		this.numberOfBottles = numberOfBottles;
	}
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
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
}
