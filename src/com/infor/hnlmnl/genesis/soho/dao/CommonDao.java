package com.infor.hnlmnl.genesis.soho.dao;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.infor.hnlmnl.genesis.soho.dto.Icon;
import com.infor.hnlmnl.genesis.soho.dto.IconZip;
import com.infor.hnlmnl.genesis.soho.dto.Product;
import com.infor.hnlmnl.genesis.soho.dto.SoHoResponse;
import com.infor.hnlmnl.genesis.soho.dto.Version;

public interface CommonDao {
	public List<Product> getProducts();
	public Version getVersion();
	public IconZip getZipPath(List<Icon> icons);
	public SoHoResponse saveIconImage(List<MultipartFile> imageList, String iconData, String mode);
}
