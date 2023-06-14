package com.cerberobeta.StoreWize.entities.session;

public class NameEntity{
	private String firstname;
	private String lastname;

	public void setFirstname(String firstname){
		this.firstname = firstname;
	}

	public String getFirstname(){
		return firstname;
	}

	public void setLastname(String lastname){
		this.lastname = lastname;
	}

	public String getLastname(){
		return lastname;
	}

	public NameEntity() {
	}
}
