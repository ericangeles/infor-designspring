package com.infor.hnlmnl.genesis.design.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class IconDownloadUpdate {
	private List<Icon> icons;
	private IconZip iconZip;

	@JsonCreator
	public IconDownloadUpdate(@JsonProperty("icons") List<Icon> icons, @JsonProperty("iconZip") IconZip iconZip) {
		this.icons = icons;
		this.iconZip = iconZip;
	}
	
	public List<Icon> getIcons() {
		return icons;
	}

	public void setIcons(List<Icon> icons) {
		this.icons = icons;
	}

	public IconZip getIconZip() {
		return iconZip;
	}

	public void setIconZip(IconZip iconZip) {
		this.iconZip = iconZip;
	}
}
