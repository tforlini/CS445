
public class Ant extends Creature{

	public Ant() {
		super();
	}

	public Ant(String name,Thing lastEat) {
		super(name,lastEat);
	}

	@Override
	public void move() {

		System.out.print(this.toString() + " is crawling around.");
		
	}
	
	
}
