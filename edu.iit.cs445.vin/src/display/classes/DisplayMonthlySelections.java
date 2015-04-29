package display.classes;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import display.response.DisplayMonthlySelectionsResponse;
import entities.MonthlySelection;
import entities.Wine;
import entities.WineClub;

public class DisplayMonthlySelections {

	private WineClub club;

	public DisplayMonthlySelections(){
		
	}
	
	public DisplayMonthlySelections(WineClub club) {
		this.club = club;
	}

	public WineClub getClub() {
		return club;
	}

	public void setClub(WineClub club) {
		this.club = club;
	}
	
	public DisplayMonthlySelectionsResponse displaySelections() throws java.lang.NullPointerException{
		DisplayMonthlySelectionsResponse response = new DisplayMonthlySelectionsResponse();
		SimpleDateFormat dt = new SimpleDateFormat("MMM/YYYY");
		ArrayList<Object> Selections = new ArrayList<Object>();
		WineClub club = this.getClub();
		if(club.getSelections()!=null){
			ArrayList<MonthlySelection> selections = club.getSelections(); 
			int i=0;
			while(i<selections.size()){
				Selections.add("id: "+selections.get(i).getId()+",selection_month: "+dt.format(selections.get(i).getDate().getTime())+",type: "+selections.get(i).getType()+"");				
				i++;
			}
		}
		else{
			throw new java.lang.NullPointerException("Monthly Selections not found");
		}
		response.setMonthly_selection(Selections);
		return response;
		
	}
	
	public DisplayMonthlySelectionsResponse displaySelectionsById(int mid) throws java.lang.NullPointerException{
		DisplayMonthlySelectionsResponse response = new DisplayMonthlySelectionsResponse();
		SimpleDateFormat dt = new SimpleDateFormat("MMM/YYYY");
		ArrayList<Object> Selections = new ArrayList<Object>();
		WineClub club = this.getClub();
		if(club.getSelectionById(mid)!=null){
			MonthlySelection selection = club.getSelectionById(mid); 
			
				Selections.add("id: "+selection.getId()+",selection_month: "+dt.format(selection.getDate().getTime())+",type: "+selection.getType()+",created_by: "+selection.getCreated_by()+", wines: [");	
				ArrayList<Wine> wines = selection.getWines();
				int j=0;
				while(j<wines.size()){
				
					Selections.add("{id: "+selection.getWines().get(j).getID());
					Selections.add("label_name: "+selection.getWines().get(j).getLabelName()+"}");
					j++;
				}
				//Selections.add("]");
		}
		else{
			throw new java.lang.NullPointerException("Monthly Selections not found");
		}
		response.setMonthly_selection(Selections);
		return response;
		
	}
	
	
}
