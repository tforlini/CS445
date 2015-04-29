package update.request;

public class UpdateShipmentRequest {

	private String delivery_day;
	private String time_of_day;
	private int number_of_selections;
	
	public UpdateShipmentRequest() {
	
	}
	public UpdateShipmentRequest(String delivery_day,String time_of_day, int number_of_selection) {
		this.delivery_day=delivery_day;
		this.time_of_day=time_of_day;
		this.number_of_selections=number_of_selection;
	}
	public String getDelivery_day() {
		return delivery_day;
	}
	public void setDelivery_day(String delivery_day) {
		this.delivery_day = delivery_day;
	}
	public String getTime_of_day() {
		return time_of_day;
	}
	public void setTime_of_day(String time_of_day) {
		this.time_of_day = time_of_day;
	}
	public int getNumber_of_selections() {
		return number_of_selections;
	}
	public void setNumber_of_selections(int number_of_selections) {
		this.number_of_selections = number_of_selections;
	}
	
	
}
