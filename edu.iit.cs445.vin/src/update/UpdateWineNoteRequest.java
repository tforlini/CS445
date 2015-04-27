package update;

public class UpdateWineNoteRequest {

	private String content;

	public UpdateWineNoteRequest(){
		
	}
	
	public UpdateWineNoteRequest(String content) {
		this.content = content;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	
}
