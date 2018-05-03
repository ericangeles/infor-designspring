package com.infor.hnlmnl.genesis.soho.dao;

import java.util.List;

import com.infor.hnlmnl.genesis.soho.dto.Icon;
import com.infor.hnlmnl.genesis.soho.dto.IconDownloadReport;
import com.infor.hnlmnl.genesis.soho.dto.IconDownloadUpdate;
import com.infor.hnlmnl.genesis.soho.dto.IconTag;
import com.infor.hnlmnl.genesis.soho.dto.IconType;
import com.infor.hnlmnl.genesis.soho.dto.SoHoResponse;

public interface IconDao {
	public List<Icon> getIcons();
	public List<IconType> getTypes();
	public List<Icon> getIconProducts(List<Icon> icons);
	public List<Icon> getIconProperties(List<Icon> icons);
	public List<IconTag> getTags();
	public List<IconDownloadReport> getDownloadReport();
	public Icon getIconInfoById(String iconId);
	public IconDownloadUpdate getDownloadUpdate(String data);
	public SoHoResponse saveIcon(String data, String mode);
}
