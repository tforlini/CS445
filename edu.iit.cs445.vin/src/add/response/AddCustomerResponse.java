package add.response;

import java.util.ArrayList;

import entities.ErrorResponse;

public class AddCustomerResponse {
	private int id;
	private ArrayList<ErrorResponse> errors;
	
	public AddCustomerResponse(){
		
	}
	
	public AddCustomerResponse(int id,ArrayList<ErrorResponse> errors) {
		this.id = id;
		this.errors=errors;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ArrayList<ErrorResponse> getErrors() {
		return errors;
	}

	public void setErrors(ArrayList<ErrorResponse> errors) {
		this.errors = errors;
	}

	
	
}


