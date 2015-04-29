package add.response;

public class AddNoteResponse {
	int id;
	
	public AddNoteResponse(){
		this.id=0;
	}
	public AddNoteResponse(int id){
		this.id=id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
}
