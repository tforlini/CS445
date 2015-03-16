package WineClub;

public class NoShipList {

	protected String[] forbiddenStates;
	
	public NoShipList() {
		this.forbiddenStates=null;
		
	}

	public NoShipList(String[] forbiddenStates) {
		this.forbiddenStates=forbiddenStates;
		
	}

	public String[] getForbiddenStates() {
		return forbiddenStates;
	}

	public void setForbiddenStates(String[] forbiddenStates) {
		this.forbiddenStates = forbiddenStates;
	}
	
	
}
