import java.util.ArrayList;
import java.util.StringTokenizer;

public class ImprovedStringTokenizer extends StringTokenizer{


	public ImprovedStringTokenizer(String delimiters) {
		super(delimiters);
	}

	public ImprovedStringTokenizer(String delimiters,boolean delimsChanged) {
		super(delimiters, delimiters, delimsChanged);
	}
	
	public static ArrayList<String> tokenArray(String string){
		
		StringTokenizer tokenizer = new StringTokenizer(string);
		ArrayList<String> result = new ArrayList<String>();
		while (tokenizer.hasMoreTokens()){
			result.add(tokenizer.nextToken());
		}
		return result;
	}
	public static void main(String[] args) {

	}

}
