package display;

import java.util.ArrayList;

public class DisplayWineRatingResponse {
	
	ArrayList<Object> rating;
	
	public DisplayWineRatingResponse(){
		
	}
	public DisplayWineRatingResponse(ArrayList<Object> rating){
		this.rating=rating;
	}
	public ArrayList<Object> getRating() {
		return rating;
	}
	public void setRating(ArrayList<Object> rating) {
		this.rating = rating;
	}
	
}
