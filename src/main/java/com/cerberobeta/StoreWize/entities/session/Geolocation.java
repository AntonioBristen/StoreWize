package com.cerberobeta.StoreWize.entities.session;

public class Geolocation{
	private String longi;
	private String lat;

	public void setLongi(String longi){
		this.longi = longi;
	}

	public String getLongi(){
		return longi;
	}

	public void setLat(String lat){
		this.lat = lat;
	}

	public String getLat(){
		return lat;
	}

	public Geolocation() {
	}
}
