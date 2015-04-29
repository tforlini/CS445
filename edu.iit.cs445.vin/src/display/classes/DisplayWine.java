package display.classes;

import java.util.ArrayList;

import display.response.DisplayWineResponse;
import entities.MonthlySelection;
import entities.Wine;
import entities.WineClub;

public class DisplayWine {
	WineClub club;

	public DisplayWine(){
		
	}
	
	public DisplayWine(WineClub club) {
		this.club = club;
	}

	public WineClub getClub() {
		return club;
	}

	public void setClub(WineClub club) {
		this.club = club;
	}
	
	public DisplayWineResponse getWine(int wid)throws java.lang.NullPointerException{
		DisplayWineResponse response = new DisplayWineResponse();
		WineClub club = this.getClub();
		if(club.getSelections()!=null){
			ArrayList<MonthlySelection> selections = club.getSelections(); 
			int i=0;
			while(i<selections.size()){
				if(selections.get(i).getWineById(wid)!=null){
					Wine wine = selections.get(i).getWineById(wid);
			response.setId(wine.getID());
			response.setVariety(wine.getWineVariety());
			response.setWine_type(wine.getWineType());
			response.setLabel_name(wine.getLabelName());
			response.setGrape(wine.getGrape());
			response.setRegion(wine.getRegion());
			response.setCountry(wine.getCountry());
			response.setMaker(wine.getMaker());
			response.setYear(wine.getYear());
			response.setRatings_count(wine.getNumberOfRatings());
			response.setRating(wine.getRating());
			}
				else{
					throw new java.lang.NullPointerException("Selections not found");
				}
				i++;
			}
			
		}
		else{
			throw new java.lang.NullPointerException("Selections not found");
		}
		return response;
		
		
	}
}
