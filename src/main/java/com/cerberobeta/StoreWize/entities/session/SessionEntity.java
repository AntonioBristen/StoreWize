package com.cerberobeta.StoreWize.entities.session;

public class SessionEntity{
	private String password;
	private AddressEntity address;
	private String phone;
	private NameEntity name;
	private int id;
	private String email;
	private String username;

	public void setPassword(String password){
		this.password = password;
	}

	public String getPassword(){
		return password;
	}

	public void setAddress(AddressEntity address){
		this.address = address;
	}

	public AddressEntity getAddress(){
		return address;
	}

	public void setPhone(String phone){
		this.phone = phone;
	}

	public String getPhone(){
		return phone;
	}

	public void setName(NameEntity name){
		this.name = name;
	}

	public NameEntity getName(){
		return name;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}

	public void setUsername(String username){
		this.username = username;
	}

	public String getUsername(){
		return username;
	}

	public SessionEntity() {
	}
}
