
 abstract class Creature extends Thing {

	 
	public Creature() {
		
		super();
		lastEat = new Thing();

	}

	public Creature(String name,Thing lastEat) {
		
		super(name);
		this.lastEat = lastEat;
	}
	
	public abstract void move();
	
	public Thing getLastEat(){
		
		return this.lastEat;
	}
	
	public void setLastEat(Thing lastEat){
		
		this.lastEat = lastEat;
	}
	
	public void eat(Creature aThing){
		
		
		String msg = new String();
		msg = this.toString() + " has just eaten a " + aThing.toString() + "\n";
		System.out.print(msg);
		this.setLastEat(aThing);
		
		
	}
	
	public String toString(){
		
		return this.name + " " + this.getClass().getSimpleName();
	}
	
	public void whatDidYouEat(){
		
		String msg = new String();
		if (this.lastEat.toString().equals("")){
			System.out.print(this.toString()+ " has had nothing to eat!");
		}
		else{
			msg = this.toString() + " has eaten " + this.getLastEat().toString(); 
			System.out.print(msg);
		
		}
	}
	
}
