package add.request;

public class AddWineRatingRequest {

	private int rating;

	public AddWineRatingRequest(){
		
	}
	
	public AddWineRatingRequest(int rating) {
		this.rating = rating;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
	
	
}
