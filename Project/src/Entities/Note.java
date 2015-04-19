package Entities;

import java.util.Date;

public class Note {
	
private int id;
private Date date;
private String content;
private static int numberOfNotes;

public Note(){

	this.date=new Date();
	this.content="";
	numberOfNotes++;
	this.id=numberOfNotes;
}

public Note(Date date,String content){

	this.date=date;
	this.content=content;
	numberOfNotes++;
	this.id=numberOfNotes;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public Date getDate() {
	return date;
}

public void setDate(Date date) {
	this.date = date;
}

public String getContent() {
	return content;
}

public void setContent(String content) {
	this.content = content;
}



}
