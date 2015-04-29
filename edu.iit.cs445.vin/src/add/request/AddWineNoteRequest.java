package add.request;

public class AddWineNoteRequest {

	private String content;

	public AddWineNoteRequest(){
		
	}
	
	public AddWineNoteRequest(String content) {
		super();
		this.content = content;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	
}
