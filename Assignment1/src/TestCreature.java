import java.util.ArrayList;


public class TestCreature {
	
		
	public static final int THING_COUNT = 10;
	public static final int CREATURE_COUNT = 9;
	
	public static void main(String[] args) {

		ArrayList<Thing> list = new ArrayList<Thing>() ;
		
		for (int i=0;i<THING_COUNT; i++){
			
			
			Thing thing = new Thing("toto");
			Thing tiger = new Tiger("tigrou",null);
			if (i<=5){
				list.add(i,thing);
			}
			else{
				list.add(i,tiger);
			}
			
		}
			
		System.out.println("Things: -----------------");
		System.out.println("");
		
		for (int i=0;i<THING_COUNT; i++){
			
			System.out.println(list.get(i));
			
		}
		
		System.out.println("");
		System.out.println("Creatures: -----------------");
		System.out.println("");
		
		ArrayList<Creature> listCreature = new ArrayList<Creature>() ;
		
		for (int i=0;i<CREATURE_COUNT; i++){

			Tiger tiger = new Tiger("tata",null);
			Ant ant = new Ant("titi",null);
			Bat bat = new Bat("bruce",null);
			
			if(i<=2){
				listCreature.add(i,tiger);	
			}
			else if (i<=6){
				listCreature.add(i,ant);
			}
			else{
				listCreature.add(i,bat);
			}
			
		}
		
		for (int i=0;i<CREATURE_COUNT; i++){
			
			System.out.println(listCreature.get(i));
			if(i<8){
			listCreature.get(i).eat(listCreature.get(i+1));
			System.out.println("\n");
			listCreature.get(i).move();
			System.out.println("\n");
			}
		}
		System.out.println("");
		

		
		
	}


}
