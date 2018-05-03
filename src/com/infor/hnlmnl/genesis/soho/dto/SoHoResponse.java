package com.infor.hnlmnl.genesis.soho.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SoHoResponse {
	private int response;
	private String serviceMessage;
	private String errorMessage;

	@JsonCreator
	public SoHoResponse(@JsonProperty("response") int response, @JsonProperty("serviceMessage") String serviceMessage,
			@JsonProperty("errorMessage") String errorMessage) {
		this.response = response;
		this.serviceMessage = serviceMessage;
		this.errorMessage = errorMessage;
	}
	
	public int getResponse() {
		return response;
	}

	public void setResponse(int response) {
		this.response = response;
	}

	public String getServiceMessage() {
		return serviceMessage;
	}

	public void setServiceMessage(String serviceMessage) {
		this.serviceMessage = serviceMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}
