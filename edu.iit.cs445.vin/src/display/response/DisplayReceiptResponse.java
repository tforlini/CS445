package display.response;

public class DisplayReceiptResponse {
	private int id;
	private String date;
	private String time;
	private int subscriber;
	private String name;
	private String received_by;
	
	public DisplayReceiptResponse(){
		
	}
	
	public DisplayReceiptResponse(int id, String date, String time,int subscriber, String name, String received_by) {
		this.id = id;
		this.date = date;
		this.time = time;
		this.subscriber = subscriber;
		this.name = name;
		this.received_by = received_by;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public int getSubscriber() {
		return subscriber;
	}

	public void setSubscriber(int subscriber) {
		this.subscriber = subscriber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getReceived_by() {
		return received_by;
	}

	public void setReceived_by(String received_by) {
		this.received_by = received_by;
	}
	
	
	
}
