import java.util.Random;

public class ImprovedRandom extends Random{

	private static final long serialVersionUID = 1L;

	public ImprovedRandom() {
		super();
	}
	
	public ImprovedRandom(long seed) {
		super(seed);
	}
	
	protected static int randomNumber(int start, int end, Random rand){
		
		int range = end - start +1;
		long quotient = (long)(range*rand.nextDouble());
		System.out.println(rand.nextDouble());
		long result = (long)start + quotient;
		return (int)result;
	}
	
}
