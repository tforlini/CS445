package WineClub;

public class Shipment {

	protected int price;
	protected int numberOfMonthlySelections;
	protected MonthlySelection[] monthlySelection;
	
	
	public Shipment() {
		this.price=0;
		this.numberOfMonthlySelections=0;
		this.monthlySelection= new MonthlySelection[this.numberOfMonthlySelections];
		
	}
	
	public Shipment(int price,int numberOfMonthlySelections, MonthlySelection[] monthlySelection) {
		this.price=price;
		this.numberOfMonthlySelections=numberOfMonthlySelections;
		this.monthlySelection=monthlySelection;
		
	}
	
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getNumberOfMonthlySelections() {
		return numberOfMonthlySelections;
	}

	public void setNumberOfMonthlySelections(int numberOfMonthlySelections) {
		this.numberOfMonthlySelections = numberOfMonthlySelections;
	}

	public MonthlySelection[] getMonthlySelection() {
		return monthlySelection;
	}

	public void setMonthlySelection(MonthlySelection[] monthlySelection) {
		this.monthlySelection = monthlySelection;
	}


	
}
