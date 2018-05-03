package com.infor.hnlmnl.genesis.design.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class IconTag {
	private int tagId;
	private String tagName;
	
	@JsonCreator
	public IconTag(@JsonProperty("tagId") int tagId, @JsonProperty("tagName") String tagName) {
		this.tagId = tagId;
		this.tagName = tagName;
	}
	
	public int getTagId() {
		return tagId;
	}
	
	public void setTagId(int tagId) {
		this.tagId = tagId;
	}
	
	public String getTagName() {
		return tagName;
	}
	
	public void setTagName(String tagName) {
		this.tagName = tagName;
	}
}
