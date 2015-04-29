package entities;

import java.util.ArrayList;


public class Wine {

	private int ID;
	private int price;
	private WineVariety wineVariety;
	private WineType wineType;
	private String labelName;
	private String grape;	
	private String region;	
	private String country; 
	private String maker;	
	private String year;		
	private ArrayList<Note> notes;
	private float rating;
	private static int numberOfWines;
	private int numberOfRatings;
	
	
	public Wine() {	
		
		this.price=0;
		this.wineVariety = WineVariety.RED;
		this.wineType = WineType.TABLE;
		this.labelName="";
		this.grape="";
		this.region = "";
		this.country = "";
		this.maker = "";
		this.year = "";
		this.notes=new ArrayList<Note>();
		numberOfWines++;
		this.ID=IdGenerator.newID();
		
		
	}

	public Wine(int price,WineVariety wineVariety ,WineType wineType,String labelName,String grape, String region, String country, String maker, String year,ArrayList<Note> notes) {

		
		this.price=price;
		this.wineVariety = wineVariety;
		this.wineType=wineType;
		this.labelName=labelName;
		this.grape=grape;
		this.region = region;
		this.country = country;
		this.maker = maker ;
		this.year = year;
		this.notes=notes;
		numberOfWines++;
		this.ID=IdGenerator.newID();
		
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public WineVariety getWineVariety() {
		return wineVariety;
	}

	public void setWineVariety(WineVariety wineVariety) {
		this.wineVariety = wineVariety;
	}

	public WineType getWineType() {
		return wineType;
	}

	public void setWineType(WineType wineType) {
		this.wineType = wineType;
	}

	public String getLabelName() {
		return labelName;
	}

	public void setLabelName(String labelName) {
		this.labelName = labelName;
	}

	public String getGrape() {
		return grape;
	}

	public void setGrape(String grape) {
		this.grape = grape;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getMaker() {
		return maker;
	}

	public void setMaker(String maker) {
		this.maker = maker;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public  int getNumberOfWines() {
		return numberOfWines;
	}

	public  void setNumberOfWines(int numberOfWines) {
		Wine.numberOfWines = numberOfWines;
	}

	public int getNumberOfRatings() {
		return numberOfRatings;
	}

	public void setNumberOfRatings(int numberOfRatings) {
		this.numberOfRatings = numberOfRatings;
	}

	public void updateNote(Note newNote){
		int newId = newNote.getId();
		ArrayList<Note> notes = this.getNotes();
		if(notes != null){
		int i=0;
		while(i<notes.size()){
			if(notes.get(i).getId() == newId){
				notes.set(i, newNote);
			}
			i++;
		}
		this.setNotes(notes);
		}
	}
	
	public ArrayList<Note> getNotes() {
		return notes;
	}

	public void setNotes(ArrayList<Note> notes) {
		this.notes = notes;
	}

	public void addNote(Note note){
		this.notes.add(note);
	}
	
	public Note getNoteById(int nid){
		ArrayList<Note> notes = this.getNotes();
		if(notes != null){
		int i=0;
		while(i<notes.size()){
			if(notes.get(i).getId() == nid){
				return notes.get(i);
			}
			i++;
		}
		}
		else{
			System.out.println("Note not found \n");
		}
		return null;
	}
	
	public void addRating(int rate) {
		numberOfRatings = numberOfRatings + 1;
		rating = rating*((float)(numberOfRatings - 1)/numberOfRatings) + (float)rate/numberOfRatings;
	}
    private boolean isMatchVariety(String kw) {
    	String regex = "(?i).*" + kw + ".*";
        return this.wineVariety.name().matches(regex);
    }

    private boolean isMatchType(String kw) {
    	String regex = "(?i).*" + kw + ".*";
        return this.wineType.name().matches(regex);
    }
    
    private boolean isMatchLabel(String kw) {
        String regex = "(?i).*" + kw + ".*";
        return this.labelName.matches(regex);
    }
    private boolean isMatchGrape(String kw) {
    	return false;
    }
    
    private boolean isMatchRegion(String kw) {
    	return false;
    }

    private boolean isMatchCountry(String kw) {
    	return false;
    }

    private boolean isMatchMaker(String kw) {
    	return false;
    }

    private boolean isMatchYear(String kw) {
    	return false;
    }
    
	public boolean isMatch(String kw) {
        if (isMatchVariety(kw) || isMatchType(kw) || isMatchLabel(kw) || isMatchGrape(kw) || isMatchRegion(kw) || isMatchCountry(kw) || isMatchMaker(kw) || isMatchYear(kw)) {
                return true;
        } else return false;
	}
}
