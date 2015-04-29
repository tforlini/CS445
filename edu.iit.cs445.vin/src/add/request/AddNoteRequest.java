package add.request;

public class AddNoteRequest {
	
	private String content;

	public AddNoteRequest(){
		
	}
	
	public AddNoteRequest(String content) {
		this.content = content;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	
}
