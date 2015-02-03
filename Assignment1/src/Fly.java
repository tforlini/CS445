
public class Fly extends Creature implements Flyer {

	public Fly() {
		super();
	}

	public Fly(String name,Thing lastEat) {
		super(name,lastEat);
	}
	
	@Override
	public void fly() {

		String msg = new String();
		msg = this.toString() + " is buzzing around in flight.";
		System.out.print(msg);

	}

	@Override
	public void move() {
		this.fly();
		
	}

	public void eat(Thing aThing){
		
		if (aThing.getClass().getName().equals("Thing")){
		String msg = new String();
		msg = this.toString() + " has just eaten a " + aThing.toString();
		System.out.print(msg);
		this.setLastEat(aThing);
		}
		else{
			System.out.println("Fly only eats Things");
			}
		
	}
	
}
