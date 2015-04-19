package Entities;


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
	private static float rating;
	private static int numberOfWines;
	private static int numberOfRatings;
	
	
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
		numberOfWines++;
		this.ID=numberOfWines;
		
		
	}

	public Wine(int price,WineVariety wineVariety ,WineType wineType,String labelName,String grape, String region, String country, String maker, String year) {

		
		this.price=price;
		this.wineVariety = wineVariety;
		this.wineType=wineType;
		this.labelName=labelName;
		this.grape=grape;
		this.region = region;
		this.country = country;
		this.maker = maker ;
		this.year = year;
		numberOfWines++;
		this.ID=numberOfWines;
		
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
		Wine.rating = rating;
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
		Wine.numberOfRatings = numberOfRatings;
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
    	String regex = "(?i).*" + kw + ".*";
        return this.grape.matches(regex);
    }
    
    private boolean isMatchRegion(String kw) {
    	String regex = "(?i).*" + kw + ".*";
        return this.region.matches(regex);
    }

    private boolean isMatchCountry(String kw) {
    	String regex = "(?i).*" + kw + ".*";
        return this.country.matches(regex);
    }

    private boolean isMatchMaker(String kw) {
    	String regex = "(?i).*" + kw + ".*";
        return this.maker.matches(regex);
    }

    private boolean isMatchYear(String kw) {
    	String regex = "(?i).*" + kw + ".*";
        return this.year.matches(regex);
    }
    
	public boolean isMatch(String kw) {
        if (isMatchVariety(kw) || isMatchType(kw) || isMatchLabel(kw) || isMatchGrape(kw) || isMatchRegion(kw) || isMatchCountry(kw) || isMatchMaker(kw) || isMatchYear(kw)) {
                return true;
        } else return false;
	}
}
