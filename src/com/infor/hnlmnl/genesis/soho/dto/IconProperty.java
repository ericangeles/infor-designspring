package com.infor.hnlmnl.genesis.soho.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class IconProperty {
	private int propertyId;
	private String propertySize;
	private String propertyFormat;
	private String propertyPrefix;
	
	@JsonCreator
	public IconProperty(@JsonProperty("propertyId") int propertyId, @JsonProperty("propertySize") String propertySize, 
			@JsonProperty("propertyFormat") String propertyFormat, @JsonProperty("propertyPrefix") String propertyPrefix) {
		this.propertyId = propertyId;
		this.propertySize = propertySize;
		this.propertyFormat = propertyFormat;
		this.propertyPrefix = propertyPrefix;
	}
	
	public int getPropertyId() {
		return propertyId;
	}
	
	public void setPropertyId(int propertyId) {
		this.propertyId = propertyId;
	}
	
	public String getPropertySize() {
		return propertySize;
	}
	
	public void setPropertySize(String propertySize) {
		this.propertySize = propertySize;
	}
	
	public String getPropertyFormat() {
		return propertyFormat;
	}
	
	public void setPropertyFormat(String propertyFormat) {
		this.propertyFormat = propertyFormat;
	}
	
	public String getPropertyPrefix() {
		return propertyPrefix;
	}
	
	public void setPropertyPrefix(String propertyPrefix) {
		this.propertyPrefix = propertyPrefix;
	}
}
