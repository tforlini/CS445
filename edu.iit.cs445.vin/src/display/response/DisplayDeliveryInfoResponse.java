package display.response;

import entities.DayOfWeek;
import entities.TimeOfDay;

public class DisplayDeliveryInfoResponse {
	
	DayOfWeek dow;
	TimeOfDay tod;
	
	public DisplayDeliveryInfoResponse(){
		
	}
	public DisplayDeliveryInfoResponse(DayOfWeek dow,TimeOfDay tod){
		this.dow=dow;
		this.tod=tod;
	}
	public DayOfWeek getDow() {
		return dow;
	}
	public void setDow(DayOfWeek dow) {
		this.dow = dow;
	}
	public TimeOfDay getTod() {
		return tod;
	}
	public void setTod(TimeOfDay tod) {
		this.tod = tod;
	}
	
	
}
