package add.classes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import add.response.AddMonthlySelectionResponse;
import entities.IdGenerator;
import entities.MonthlySelection;
import entities.Wine;
import entities.WineClub;

public class AddMonthlySelection {
	private WineClub club;

	public AddMonthlySelection(){
		
	}
	
	public AddMonthlySelection(WineClub club) {
		this.club = club;
	}

	public WineClub getClub() {
		return club;
	}

	public void setClub(WineClub club) {
		this.club = club;
	}
	
	public AddMonthlySelectionResponse addSelection(String type, String selection_month, ArrayList<AddSelectionWines> wines ) throws java.lang.NullPointerException, ParseException{
		WineClub club = this.getClub();
		ArrayList<Wine> selectionWines = new ArrayList<Wine>();
		AddMonthlySelectionResponse response = new AddMonthlySelectionResponse();
		Wine newWine = new Wine();
		MonthlySelection selection = new MonthlySelection();
		
		int i=0;
		while(i<wines.size()){
			 newWine.setID(IdGenerator.newID());
			 newWine.setWineVariety(wines.get(i).getVariety());
			 newWine.setWineType(wines.get(i).getWine_type());
			 newWine.setLabelName(wines.get(i).getLabel_name());
			 newWine.setGrape(wines.get(i).getGrape());
			 newWine.setRegion(wines.get(i).getRegion());
			 newWine.setCountry(wines.get(i).getCountry());
			 newWine.setMaker(wines.get(i).getMaker());
			 newWine.setYear(wines.get(i).getYear());
			 
			 selectionWines.add(newWine);
			i++;
		}
		selection.setWines(selectionWines);
		selection.setType(type);
		selection.setCreated_by(IdGenerator.newID());
		Calendar date = Calendar.getInstance();
		SimpleDateFormat dt = new SimpleDateFormat("MMM/YYYY");
		Date month = dt.parse(selection_month);
		date.setTime(month);
		selection.setDate(date);
		
		club.addMonthlySelection(selection);
		
		MonthlySelection lastSelection = club.getSelections().get((club.getSelections().size()-1));
		if(lastSelection.getDate().before(selection.getDate())){
			club.setSelection(selection);
		}
		response.setId(selection.getId());
		return response;
		
	}
}
