
public class Tiger extends Creature{

	public Tiger() {

		super();
	}

	public Tiger(String name,Thing lastEat) {

		super(name,lastEat);
	}
	
	@Override
	public void move() {

		System.out.print(this.toString() + " has just pounced.");
		
	}

}
