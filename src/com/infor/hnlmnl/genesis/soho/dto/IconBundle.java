package com.infor.hnlmnl.genesis.soho.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class IconBundle {
	private List<Icon> icons;
	private List<IconType> types;
	private List<Product> products;
	
	@JsonCreator
	public IconBundle(@JsonProperty("icons") List<Icon> icons, @JsonProperty("types") List<IconType> types, @JsonProperty("products") List<Product> products) {
		this.icons = icons;
		this.types = types;
		this.products = products;
	}
	
	public List<Icon> getIcons() {
		return icons;
	}
	
	public void setIcons(List<Icon> icons) {
		this.icons = icons;
	}
	
	public List<IconType> getTypes() {
		return types;
	}
	
	public void setTypes(List<IconType> types) {
		this.types = types;
	}
	
	public List<Product> getProducts() {
		return products;
	}
	
	public void setProducts(List<Product> products) {
		this.products = products;
	}
}
