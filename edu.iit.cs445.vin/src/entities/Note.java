package entities;

import java.util.Calendar;

public class Note {
	
private int id;
private Calendar date;
private String content;

public Note(){

	this.date=Calendar.getInstance();
	this.content="";
	this.id=IdGenerator.newID();
}

public Note(Calendar date,String content){

	this.date=date;
	this.content=content;
	this.id=IdGenerator.newID();
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

public String getContent() {
	return content;
}

public void setContent(String content) {
	this.content = content;
}



}
