package entities;

import java.util.Calendar;

public class Receipt {

	private int id;
	private Calendar date;
	private Calendar time;
	private int subscriber;
	private String name;
	private String received_by;
	
	public Receipt(){
		this.id = IdGenerator.newID();
		this.date = Calendar.getInstance();
		this.time = Calendar.getInstance();
		this.subscriber =0;
		this.name ="";
		this.received_by = "";
	}

	public Receipt(int id, Calendar date, Calendar time, int subscriber,String name, String received_by) {
		this.id = IdGenerator.newID();
		this.date = Calendar.getInstance();
		this.time = Calendar.getInstance();
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

	public Calendar getDate() {
		return date;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}

	public Calendar getTime() {
		return time;
	}

	public void setTime(Calendar time) {
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
