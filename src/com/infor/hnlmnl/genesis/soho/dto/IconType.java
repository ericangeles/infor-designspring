package com.infor.hnlmnl.genesis.soho.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class IconType {
	private int typeId;
	private String typeName;
	private int typeClass;
	private long typeCount;
	private String typeSize;
	
	@JsonCreator
	public IconType(@JsonProperty("typeId") int typeId, @JsonProperty("typeName") String typeName, 
			@JsonProperty("typeClass") int typeClass, @JsonProperty("typeCount") long typeCount,
			@JsonProperty("typeSize") String typeSize) {
		this.typeId = typeId;
		this.typeName = typeName;
		this.typeClass = typeClass;
		this.typeCount = typeCount;
		this.typeSize = typeSize;
	}
	
	public int getTypeId() {
		return typeId;
	}
	
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
	
	public String getTypeName() {
		return typeName;
	}
	
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	
	public int getTypeClass() {
		return typeClass;
	}
	
	public void setTypeClass(int typeClass) {
		this.typeClass = typeClass;
	}

	public long getTypeCount() {
		return typeCount;
	}

	public void setTypeCount(long typeCount) {
		this.typeCount = typeCount;
	}

	public String getTypeSize() {
		return typeSize;
	}

	public void setTypeSize(String typeSize) {
		this.typeSize = typeSize;
	}
}
