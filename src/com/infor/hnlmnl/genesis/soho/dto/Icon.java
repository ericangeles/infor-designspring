package com.infor.hnlmnl.genesis.soho.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Icon {
	private int iconId;
	private String iconName;
	private int iconCounter;
	private String iconStatus;
	private IconType type;
	private List<IconTag> tags;
	private List<IconProperty> properties;
	private List<Product> products;

	@JsonCreator
	public Icon(@JsonProperty("iconId") int iconId, @JsonProperty("iconName") String iconName, @JsonProperty("iconCounter") int iconCounter, 
			@JsonProperty("iconStatus") String iconStatus, @JsonProperty("type") IconType type, @JsonProperty("tags") List<IconTag> tags, 
			@JsonProperty("properties") List<IconProperty> properties, @JsonProperty("products") List<Product> products) {
		this.iconId = iconId;
		this.iconName = iconName;
		this.iconCounter = iconCounter;
		this.iconStatus = iconStatus;
		this.type = type;
		this.tags = tags;
		this.properties = properties;
		this.products = products;
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

	public List<IconTag> getTags() {
		return tags;
	}

	public void setTags(List<IconTag> tags) {
		this.tags = tags;
	}

	public List<IconProperty> getProperties() {
		return properties;
	}

	public void setProperties(List<IconProperty> properties) {
		this.properties = properties;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
}
