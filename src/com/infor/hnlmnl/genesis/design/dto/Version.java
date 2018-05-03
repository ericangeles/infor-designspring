package com.infor.hnlmnl.genesis.design.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Version {
	private int versionId;
	private String versionName;
	private String versionDateTime;
	
	@JsonCreator
	public Version(@JsonProperty("versionId") int versionId, @JsonProperty("versionName") String versionName, @JsonProperty("versionDateTime") String versionDateTime) {
		this.versionId = versionId;
		this.versionName = versionName;
		this.versionDateTime = versionDateTime;
	}
	
	public int getVersionId() {
		return versionId;
	}
	
	public void setVersionId(int versionId) {
		this.versionId = versionId;
	}
	
	public String getVersionName() {
		return versionName;
	}
	
	public void setVersionName(String versionName) {
		this.versionName = versionName;
	}
	
	public String getVersionDateTime() {
		return versionDateTime;
	}
	
	public void setVersionDateTime(String versionDateTime) {
		this.versionDateTime = versionDateTime;
	}
}
