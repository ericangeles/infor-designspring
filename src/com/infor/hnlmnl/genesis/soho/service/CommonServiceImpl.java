package com.infor.hnlmnl.genesis.soho.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.infor.hnlmnl.genesis.soho.dao.CommonDao;
import com.infor.hnlmnl.genesis.soho.dto.Icon;
import com.infor.hnlmnl.genesis.soho.dto.IconZip;
import com.infor.hnlmnl.genesis.soho.dto.Product;
import com.infor.hnlmnl.genesis.soho.dto.SoHoResponse;
import com.infor.hnlmnl.genesis.soho.dto.Version;

@Service("commonService")
public class CommonServiceImpl implements CommonService {

	@Autowired
	private CommonDao commonDao;
	
	@Override
	public List<Product> getProducts() {
		// TODO Auto-generated method stub
		List<Product> products = commonDao.getProducts();
		return products;
	}

	@Override
	public Version getVersion() {
		// TODO Auto-generated method stub
		Version version = commonDao.getVersion();
		return version;
	}

	@Override
	public IconZip getZipPath(List<Icon> icons) {
		// TODO Auto-generated method stub
		IconZip iconZip = commonDao.getZipPath(icons);
		return iconZip;
	}

	@Override
	public SoHoResponse saveIconImage(List<MultipartFile> imageList, String iconData, String mode) {
		// TODO Auto-generated method stub
		SoHoResponse response = commonDao.saveIconImage(imageList, iconData, mode);
		return response;
	}

}
