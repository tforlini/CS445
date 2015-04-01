package WineClub;

public abstract class Wine {

	protected String name;
	protected int price;
	
	
	public Wine() {

		this.name="";
		this.price=0;
		
	}

	public Wine(String name,int price) {

		this.name=name;
		this.price=price;
		
	}

	
}
