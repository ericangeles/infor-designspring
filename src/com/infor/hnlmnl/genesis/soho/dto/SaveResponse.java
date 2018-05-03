package com.infor.hnlmnl.genesis.soho.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SaveResponse {
	private int response;

	@JsonCreator
	public SaveResponse(@JsonProperty("response") int response) {
		this.response = response;
	}
	
	public int getResponse() {
		return response;
	}

	public void setResponse(int response) {
		this.response = response;
	}
}
