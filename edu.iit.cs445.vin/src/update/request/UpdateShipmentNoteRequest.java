package update.request;

public class UpdateShipmentNoteRequest {

	private String content;

	public UpdateShipmentNoteRequest(){
		
	}
	
	public UpdateShipmentNoteRequest(String content) {
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
