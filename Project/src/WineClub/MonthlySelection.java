package WineClub;

public class MonthlySelection {

	protected Wine[] wines;
	protected RedWine[] redWines;
	protected WhiteWine[] whiteWines;
	protected int price;
	protected int numberOfBottles;
	
	public MonthlySelection() {
		
		this.wines = null;
		this.redWines=null;
		this.whiteWines=null;
		this.price=0;
		this.numberOfBottles=6;
	}

	public MonthlySelection(Wine[] wines,RedWine[] redWines, WhiteWine[] whiteWines, int price,int numberOfBottles) {
		
		this.wines = wines;
		this.redWines=redWines;
		this.whiteWines=whiteWines;
		this.price=price;
		this.numberOfBottles=numberOfBottles;
	}
	
}
