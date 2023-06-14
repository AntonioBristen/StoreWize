package com.cerberobeta.StoreWize.entities.session;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GeolocationEntity{
	private String lat;

	@JsonProperty(value = "long")
	private String longi;

	public void setLat(String lat){
		this.lat = lat;
	}

	public String getLat(){
		return lat;
	}

	public void setLongi(String longi){
		this.longi = longi;
	}

	public String getLongi(){
		return longi;
	}

	public GeolocationEntity() {
	}
}
