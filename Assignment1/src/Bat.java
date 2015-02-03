
public class Bat extends Creature implements Flyer {

	public Bat() {
		super();
	}

	
	public Bat(String name,Thing lastEat) {
		super(name,lastEat);

	}

	@Override
	public void fly() {

		String msg = new String();
		msg = this.toString() + " is swooping through the dark.";
		System.out.print(msg);
		
	}


	@Override
	public void move() {

		this.fly();
		
	}

}
