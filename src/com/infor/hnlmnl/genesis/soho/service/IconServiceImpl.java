package com.infor.hnlmnl.genesis.soho.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infor.hnlmnl.genesis.soho.dao.IconDao;
import com.infor.hnlmnl.genesis.soho.dto.Icon;
import com.infor.hnlmnl.genesis.soho.dto.IconDownloadReport;
import com.infor.hnlmnl.genesis.soho.dto.IconDownloadUpdate;
import com.infor.hnlmnl.genesis.soho.dto.IconTag;
import com.infor.hnlmnl.genesis.soho.dto.IconType;
import com.infor.hnlmnl.genesis.soho.dto.SoHoResponse;

@Service("iconService")
public class IconServiceImpl implements IconService {
	
	@Autowired
	private IconDao iconDao;
	
	@Override
	public List<Icon> getIcons() {
		// TODO Auto-generated method stub
		List<Icon> icons = iconDao.getIcons();
		return icons;
	}
	
	@Override
	public List<IconType> getTypes() {
		// TODO Auto-generated method stub
		List<IconType> types = iconDao.getTypes();
		return types;
	}
	
	@Override
	public List<Icon> getIconProducts(List<Icon> icons) {
		// TODO Auto-generated method stub
		icons = iconDao.getIconProducts(icons);
		return icons;
	}
	
	@Override
	public List<Icon> getIconProperties(List<Icon> icons) {
		// TODO Auto-generated method stub
		icons = iconDao.getIconProperties(icons);
		return icons;
	}

	@Override
	public List<IconTag> getTags() {
		// TODO Auto-generated method stub
		List<IconTag> tags = iconDao.getTags();
		return tags;
	}

	@Override
	public List<IconDownloadReport> getDownloadReport() {
		// TODO Auto-generated method stub
		List<IconDownloadReport> downloads = iconDao.getDownloadReport();
		return downloads;
	}

	@Override
	public IconDownloadUpdate getDownloadUpdate(String data) {
		// TODO Auto-generated method stub
		IconDownloadUpdate iconDownloadUpdate = iconDao.getDownloadUpdate(data);
		return iconDownloadUpdate;
	}
	
	@Override
	public SoHoResponse saveIcon(String data, String mode) {
		// TODO Auto-generated method stub
		SoHoResponse saveResponse = iconDao.saveIcon(data, mode);
		return saveResponse;
	}

	@Override
	public Icon getIconInfoById(String iconId) {
		// TODO Auto-generated method stub
		Icon icon = iconDao.getIconInfoById(iconId);
		return icon;
	}
	
}
