package com.infor.hnlmnl.genesis.design.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class IconDownloadReport {
	private int downloadId;
	private String downloadTime;
	private String emailAddress;
	private int productId;
	private String productName;
	private int iconId;
	private String iconName;
	
	@JsonCreator
	public IconDownloadReport(@JsonProperty("downloadId") int downloadId, @JsonProperty("downloadTime") String downloadTime, @JsonProperty("emailAddress") String emailAddress,
			@JsonProperty("productId") int productId, @JsonProperty("productName") String productName, @JsonProperty("iconId") int iconId, @JsonProperty("iconName") String iconName) {
		this.downloadId = downloadId;
		this.downloadTime = downloadTime;
		this.emailAddress = emailAddress;
		this.productId = productId;
		this.productName = productName;
		this.iconId = iconId;
		this.iconName = iconName;
	}
	
	public int getDownloadId() {
		return downloadId;
	}
	
	public void setDownloadId(int downloadId) {
		this.downloadId = downloadId;
	}
	
	public String getDownloadTime() {
		return downloadTime;
	}
	
	public void setDownloadTime(String downloadTime) {
		this.downloadTime = downloadTime;
	}
	
	public String getEmailAddress() {
		return emailAddress;
	}
	
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	public int getProductId() {
		return productId;
	}
	
	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	public String getProductName() {
		return productName;
	}
	
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public int getIconId() {
		return iconId;
	}
	
	public void setIconId(int iconId) {
		this.iconId = iconId;
	}
	
	public String getIconName() {
		return iconName;
	}
	
	public void setIconName(String iconName) {
		this.iconName = iconName;
	}
	
}
