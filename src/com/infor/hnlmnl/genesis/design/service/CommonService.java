package com.infor.hnlmnl.genesis.design.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.infor.hnlmnl.genesis.design.dto.Icon;
import com.infor.hnlmnl.genesis.design.dto.IconZip;
import com.infor.hnlmnl.genesis.design.dto.Product;
import com.infor.hnlmnl.genesis.design.dto.SoHoResponse;
import com.infor.hnlmnl.genesis.design.dto.Version;

public interface CommonService {
	public List<Product> getProducts();
	public Version getVersion();
	public IconZip getZipPath(List<Icon> icons);
	public SoHoResponse saveIconImage(List<MultipartFile> imageList, String iconData, String mode);
}
