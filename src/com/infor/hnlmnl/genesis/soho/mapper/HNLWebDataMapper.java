package com.infor.hnlmnl.genesis.soho.mapper;

public class HNLWebDataMapper {
	
	public CommonMapper getCommonMapper() {
		return new CommonMapper();
	}
	
	public IconMapper getIconMapper() {
		return new IconMapper();
	}
	
	public IconTypeMapper getIconTypeMapper() {
		return new IconTypeMapper();
	}
	
	public IconTagMapper getIconTagMapper() {
		return new IconTagMapper();
	}
	
	public IconDownloadReportMapper getIconDownloadReportMapper() {
		return new IconDownloadReportMapper();
	}
	
	public IconDownloadUpdateMapper getIconDownloadUpdateMapper() {
		return new IconDownloadUpdateMapper();
	}
	
	public ProductMapper getProductMapper() {
		return new ProductMapper();
	}
	
	public VersionMapper getVersionMapper() {
		return new VersionMapper();
	}
	
}
