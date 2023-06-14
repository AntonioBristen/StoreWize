package com.cerberobeta.StoreWize.entities.session;

public class AddressEntity{
	private String zipcode;
	private int number;
	private String city;
	private String street;
	private Geolocation geolocation;

	public void setZipcode(String zipcode){
		this.zipcode = zipcode;
	}

	public String getZipcode(){
		return zipcode;
	}

	public void setNumber(int number){
		this.number = number;
	}

	public int getNumber(){
		return number;
	}

	public void setCity(String city){
		this.city = city;
	}

	public String getCity(){
		return city;
	}

	public void setStreet(String street){
		this.street = street;
	}

	public String getStreet(){
		return street;
	}

	public void setGeolocation(Geolocation geolocation){
		this.geolocation = geolocation;
	}

	public Geolocation getGeolocation(){
		return geolocation;
	}

	public AddressEntity() {
	}
}
