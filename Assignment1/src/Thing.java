
public class Thing {

	protected String name;
	protected Thing lastEat;
	
	public Thing(){
		name = "";
		
	}
	
	public Thing(String name){
		this.name = name;
		
	}
	
	public String toString(){
		
		return name;
	}
	
	public String getName(){
		
		return this.name;
	}
	

	
	public void setName(String name){
		
		this.name = name;
	}
	

	
}
