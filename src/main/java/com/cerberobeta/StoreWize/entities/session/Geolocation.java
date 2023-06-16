package com.cerberobeta.StoreWize.entities.session;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Geolocation{

	@JsonProperty("long")
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
