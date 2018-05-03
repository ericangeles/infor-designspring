package com.infor.hnlmnl.genesis.design.dao;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.infor.hnlmnl.genesis.design.dto.Icon;
import com.infor.hnlmnl.genesis.design.dto.IconZip;
import com.infor.hnlmnl.genesis.design.dto.Product;
import com.infor.hnlmnl.genesis.design.dto.SoHoResponse;
import com.infor.hnlmnl.genesis.design.dto.Version;
import com.infor.hnlmnl.genesis.design.mapper.HNLWebDataMapper;
import com.infor.hnlmnl.genesis.design.utility.Common;

@Repository("commonDao")
public class CommonDaoImpl extends HNLWebDataMapper implements CommonDao {

private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Product> getProducts() {
		// TODO Auto-generated method stub
		String sql = "SELECT productId, productName FROM tbl_soho_product ORDER BY productName";
		List<Product> products = getProductMapper().mapRowsFromQuery(jdbcTemplate.queryForList(sql));
		Common.getQueryReport("getProducts", sql);
		return products;
	}

	@Override
	public Version getVersion() {
		// TODO Auto-generated method stub
		String sql = "SELECT versionId, versionName, versionDateTime " + 
				"FROM tbl_soho_icon_version " + 
				"ORDER BY versionId DESC " + 
				"LIMIT 1;";
		Version version = (Version) getVersionMapper().mapRowsFromQuery(jdbcTemplate.queryForList(sql)).get(0);
		Common.getQueryReport("getVersion", sql);
		return version;
	}

	@Override
	public IconZip getZipPath(List<Icon> icons) {
		// TODO Auto-generated method stub
		
		IconZip iconZip = null;
		List<File> fileList = new ArrayList<File>();
		
		for (Icon icon: icons) {
			String fileName = Common.PATH_DEV + Common.PATH_ICON + icon.getType().getTypeName() + Common.BACKSLASH + icon.getIconName() + Common.BACKSLASH + icon.getIconName() + Common.EXTENSION_ZIP;
			Common.getDataReport("getZipPath", fileName);
			fileList.add(new File(fileName));
		}
		
		String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		String iconPack = Common.ICONPACK + "-" + timeStamp + Common.EXTENSION_ZIP;

		String zipPath = Common.generateZipPath(iconPack);
			
		Common.getDataReport("getZipPath", zipPath);
		Common.zip(fileList, zipPath);
		iconZip = new IconZip(iconPack, zipPath);
		
		return iconZip;
	}

	@Override
	public SoHoResponse saveIconImage(List<MultipartFile> imageList, String iconData, String mode) {
		// TODO Auto-generated method stub
		SoHoResponse response = null;
		try {
			Map<String, Object> mapData = getCommonMapper().mapRowsFromJSON(iconData);
			String iconName = mapData.get(Common.ICON_NAME).toString();
			int iconType = Integer.parseInt(mapData.get(Common.ICON_TYPE).toString()) - 1;
			String typeName = Common.ARRAY_ICON_TYPES[iconType];
			
			String filePath = Common.PATH_DEV + Common.PATH_ICON + typeName + Common.BACKSLASH + iconName;
			
			if (mode.equals(Common.MODE_ADD)) {
				File folder = new File(filePath);
				folder.mkdir();
			}
			
			for (MultipartFile file : imageList) {
				BufferedImage src = ImageIO.read(new ByteArrayInputStream(file.getBytes()));
				String fileName = iconName + "_" + Common.SMALL_G + src.getWidth() + Common.SMALL_X + src.getHeight() + Common.EXTENSION_PNG;
				
				File destination = new File(filePath + Common.BACKSLASH + fileName);
				ImageIO.write(src, Common.IMAGE_PNG, destination);
			}
			response = new SoHoResponse(Common.ONE, Common.WEB_MESSAGE_OK, Common.STRING_EMPTY);
		} catch (IOException e) {
			response = new SoHoResponse(Common.ZERO, Common.WEB_MESSAGE_ERROR, e.getMessage());
		}
		
		return response;
	}

}
