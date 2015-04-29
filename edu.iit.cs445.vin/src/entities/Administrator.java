package entities;

import java.util.Calendar;

public class Administrator {
	
	private int id;
	private String name;
	private Calendar create_date;
	private int created_by;

	public Administrator(){
		this.id=IdGenerator.newID();
		this.name="";
		this.create_date=Calendar.getInstance();
		this.created_by=IdGenerator.newID();
	}
	
	public Administrator(String name){
		this.id=IdGenerator.newID();
		this.name=name;
		this.create_date=Calendar.getInstance();
		this.created_by=IdGenerator.newID();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Calendar getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Calendar create_date) {
		this.create_date = create_date;
	}

	public int getCreated_by() {
		return created_by;
	}

	public void setCreated_by(int created_by) {
		this.created_by = created_by;
	}
	
	
}
