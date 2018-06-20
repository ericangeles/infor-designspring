package com.infor.hnlmnl.genesis.design.service;

import java.util.List;

import com.infor.hnlmnl.genesis.design.dto.Icon;
import com.infor.hnlmnl.genesis.design.dto.IconDownloadReport;
import com.infor.hnlmnl.genesis.design.dto.IconDownloadUpdate;
import com.infor.hnlmnl.genesis.design.dto.IconTag;
import com.infor.hnlmnl.genesis.design.dto.IconType;
import com.infor.hnlmnl.genesis.design.dto.SoHoResponse;

public interface IconService {
	public List<Icon> getIcons();
	public List<IconType> getTypes();
	public List<Icon> getIconProducts(List<Icon> icons);
	public List<Icon> getIconProperties(List<Icon> icons);
	public List<IconTag> getTags();
	public List<IconDownloadReport> getDownloadReport();
	public Icon getIconInfoById(String iconId);
	public IconDownloadUpdate getDownloadUpdate(String data);
	public SoHoResponse saveIcon(String data, String mode);
	public String getIconDisplayImageName(String iconId);
}
