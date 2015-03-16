package WineClub;

public class Wine {

	protected int id;
	protected String name;
	protected int price;
	protected String type;
	protected int rating;
	
	
	public Wine() {

		this.id=0;
		this.name="";
		this.price=0;
		this.type="";
		this.rating=0;
		
	}

	public Wine(int id, String name, int price, String type, int rating) {

		this.id=id;
		this.name=name;
		this.price=price;
		this.type=type;
		this.rating=rating;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	
}
