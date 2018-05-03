package com.infor.hnlmnl.genesis.design.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class IconZip {
	private String zipName;
	private String zipPath;
	
	@JsonCreator
	public IconZip(@JsonProperty("zipName") String zipName, @JsonProperty("zipPath") String zipPath) {
		this.zipName = zipName;
		this.zipPath = zipPath;
	}
	
	public String getZipName() {
		return zipName;
	}
	
	public void setZipName(String zipName) {
		this.zipName = zipName;
	}
	
	public String getZipPath() {
		return zipPath;
	}
	
	public void setZipPath(String zipPath) {
		this.zipPath = zipPath;
	}
	
}
