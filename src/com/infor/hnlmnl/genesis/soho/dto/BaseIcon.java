package com.infor.hnlmnl.genesis.soho.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BaseIcon {
	private int iconId;
	private String iconName;
	private int iconCounter;
	private String iconStatus;
	private IconType type;
	
	@JsonCreator
	public BaseIcon(@JsonProperty("iconId") int iconId, @JsonProperty("iconName") String iconName, @JsonProperty("iconCounter") int iconCounter, 
			@JsonProperty("iconStatus") String iconStatus, @JsonProperty("type") IconType type) {
		this.iconId = iconId;
		this.iconName = iconName;
		this.iconCounter = iconCounter;
		this.iconStatus = iconStatus;
		this.type = type;
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

	public int getIconCounter() {
		return iconCounter;
	}

	public void setIconCounter(int iconCounter) {
		this.iconCounter = iconCounter;
	}

	public String getIconStatus() {
		return iconStatus;
	}

	public void setIconStatus(String iconStatus) {
		this.iconStatus = iconStatus;
	}

	public IconType getType() {
		return type;
	}

	public void setType(IconType type) {
		this.type = type;
	}
}
