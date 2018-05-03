package com.infor.hnlmnl.genesis.design.dao;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.infor.hnlmnl.genesis.design.dto.Icon;
import com.infor.hnlmnl.genesis.design.dto.IconDownloadReport;
import com.infor.hnlmnl.genesis.design.dto.IconDownloadUpdate;
import com.infor.hnlmnl.genesis.design.dto.IconTag;
import com.infor.hnlmnl.genesis.design.dto.IconType;
import com.infor.hnlmnl.genesis.design.dto.SoHoResponse;
import com.infor.hnlmnl.genesis.design.mapper.HNLWebDataMapper;
import com.infor.hnlmnl.genesis.design.utility.Common;

@Repository("iconDao")
public class IconDaoImpl extends HNLWebDataMapper implements IconDao {
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Icon> getIcons() {
		// TODO Auto-generated method stub
		String sql = "SELECT tbl_soho_icon.iconId, tbl_soho_icon.iconName, tbl_soho_icon.iconCounter, " + 
				"tbl_soho_icon.iconStatus, tbl_soho_icon_type.typeId, tbl_soho_icon_type.typeName, tbl_soho_icon_type.typeClass, tbl_soho_icon_type.typeSize, " + 
				"tbl_soho_icon_tag.tagId, tbl_soho_icon_tag.tagName, tbl_soho_icon_tag.tagStatus " + 
				"FROM tbl_soho_icon " + 
				"INNER JOIN tbl_soho_icon_type " + 
				"ON tbl_soho_icon.typeId = tbl_soho_icon_type.typeId " + 
				"INNER JOIN tbl_soho_icon_tag " + 
				"ON tbl_soho_icon.iconId = tbl_soho_icon_tag.iconId " + 
				"WHERE tbl_soho_icon.iconStatus = 'active' " +
				"ORDER BY tbl_soho_icon_type.typeClass ASC, tbl_soho_icon_type.typeId ASC, tbl_soho_icon.iconId, tbl_soho_icon.iconName;";
		List<Icon> icons = getIconMapper().mapRowsFromQuery(jdbcTemplate.queryForList(sql));
		Common.getQueryReport("getIcons", sql);
		return icons;
	}
	
	@Override
	public List<IconType> getTypes() {
		// TODO Auto-generated method stub
		String sql = "SELECT COUNT(tbl_soho_icon.iconId) AS typeCount, tbl_soho_icon_type.typeId, tbl_soho_icon_type.typeName, tbl_soho_icon_type.typeClass, tbl_soho_icon_type.typeSize " + 
				"FROM tbl_soho_icon_type " + 
				"INNER JOIN tbl_soho_icon " + 
				"ON tbl_soho_icon_type.typeId = tbl_soho_icon.typeId " +
				"GROUP BY tbl_soho_icon.typeId " + 
				"ORDER BY typeClass, typeName;";
		List<IconType> iconTypes = getIconTypeMapper().mapRowsFromQuery(jdbcTemplate.queryForList(sql));
		Common.getQueryReport("getTypes", sql);
		return iconTypes;
	}

	@Override
	public List<Icon> getIconProducts(List<Icon> icons) {
		// TODO Auto-generated method stub
		String sql = "SELECT DISTINCT tbl_soho_icon.iconId, tbl_soho_icon.iconName, tbl_soho_product.productId, tbl_soho_product.productName " + 
				"FROM tbl_soho_icon_download " + 
				"INNER JOIN tbl_soho_icon " + 
				"ON tbl_soho_icon_download.iconId = tbl_soho_icon.iconId " + 
				"INNER JOIN tbl_soho_product " + 
				"ON tbl_soho_icon_download.productId = tbl_soho_product.productId " + 
				"ORDER BY tbl_soho_icon.iconId, tbl_soho_product.productName;";
		icons = getCommonMapper().mapIconProducts(icons, jdbcTemplate.queryForList(sql));
		Common.getQueryReport("getIconProducts", sql);
		return icons;
	}
	
	@Override
	public List<Icon> getIconProperties(List<Icon> icons) {
		// TODO Auto-generated method stub
		String sql = "SELECT tbl_soho_icon_properties.propertyId, tbl_soho_icon_properties.propertySize, tbl_soho_icon_properties.propertyFormat, tbl_soho_icon_properties.propertyPrefix, tbl_soho_icon_properties.iconId " + 
				"FROM tbl_soho_icon_properties " + 
				"INNER JOIN tbl_soho_icon " + 
				"ON tbl_soho_icon_properties.iconId = tbl_soho_icon.iconId " + 
				"INNER JOIN tbl_soho_icon_type " + 
				"ON tbl_soho_icon.typeId = tbl_soho_icon_type.typeId " + 
				"WHERE tbl_soho_icon_properties.propertyStatus = 'active' " +
				"AND tbl_soho_icon_properties.propertyPrefix IN ('', 'g')" +
				"ORDER BY tbl_soho_icon_type.typeClass ASC, tbl_soho_icon_type.typeId ASC, tbl_soho_icon.iconId, tbl_soho_icon.iconName, tbl_soho_icon_properties.propertyPrefix ASC;";
		icons = getCommonMapper().mapIconProperties(icons, jdbcTemplate.queryForList(sql));
		Common.getQueryReport("getIconProperties", sql);
		return icons;
	}

	@Override
	public List<IconTag> getTags() {
		// TODO Auto-generated method stub
		String sql = "SELECT tagId, tagName " + 
				"FROM tbl_soho_icon_tag " + 
				"WHERE tagStatus = 'active' " +
				"ORDER BY iconId;";
		List<IconTag> iconTags = getIconTagMapper().mapRowsFromQuery(jdbcTemplate.queryForList(sql));
		Common.getQueryReport("getTags", sql);
		return iconTags;
	}

	@Override
	public List<IconDownloadReport> getDownloadReport() {
		// TODO Auto-generated method stub
		String sql = "SELECT tbl_soho_icon_download.downloadId, tbl_soho_icon_download.downloadDateTime, " + 
				"tbl_soho_icon_download.emailAddress, tbl_soho_icon_download.productId, " + 
				"tbl_soho_product.productName, tbl_soho_icon_download.iconId, tbl_soho_icon.iconName " + 
				"FROM tbl_soho_icon_download " + 
				"INNER JOIN tbl_soho_product " + 
				"ON tbl_soho_icon_download.productId = tbl_soho_product.productId " + 
				"INNER JOIN tbl_soho_icon " + 
				"ON tbl_soho_icon_download.iconId = tbl_soho_icon.iconId " + 
				"ORDER BY downloadId;";
		List<IconDownloadReport> iconDownloads = getIconDownloadReportMapper().mapRowsFromQuery(jdbcTemplate.queryForList(sql));
		Common.getQueryReport("getDownloadReport", sql);
		return iconDownloads;
	}

	@Override
	public IconDownloadUpdate getDownloadUpdate(String data) {
		// TODO Auto-generated method stub
		Map<String, Object> mapData = getCommonMapper().mapRowsFromJSON(data);
		int productId;
		
		String emailAddress = mapData.get(Common.EMAIL_ADDRESS).toString();
		String isNewProduct = mapData.get(Common.IS_NEW_PRODUCT).toString();
		String productNew = mapData.get(Common.PRODUCT_NEW).toString();
		List<String[]> iconList = getCommonMapper().mapIconList(mapData.get("iconList").toString());
		
		List<String> sqlUpdatorList = getCommonMapper().queryIconUpdator(iconList);
		for (String sqlUpdator: sqlUpdatorList) {
			jdbcTemplate.update(sqlUpdator);
			Common.getQueryReport("getDownloadUpdate", sqlUpdator);
		}
		
		if (isNewProduct.equals(Common.STRING_TRUE)) {
			String sqlInsertNewProduct = "INSERT INTO tbl_soho_product (productName) " + 
					"VALUES ('" + productNew + "');";
			jdbcTemplate.update(sqlInsertNewProduct);
			Common.getQueryReport("getDownloadUpdate", sqlInsertNewProduct);
			
			
			String sqlProductId = "SELECT productId FROM tbl_soho_product ORDER BY productId DESC LIMIT 1;";
			productId = getCommonMapper().mapProductId(jdbcTemplate.queryForList(sqlProductId));
			Common.getQueryReport("getDownloadUpdate", sqlProductId);
		} else {
			productId = Integer.parseInt(mapData.get(Common.PRODUCT_ID).toString());
		}
		
		
		String sqlInsertDownload = getCommonMapper().queryDownloadMultipleInserter(iconList, emailAddress, productId);
		jdbcTemplate.update(sqlInsertDownload);
		Common.getQueryReport("getDownloadUpdate", sqlInsertDownload);
		
		String iconQuery = getCommonMapper().queryIconSelector(iconList);
		
		String sql = "SELECT tbl_soho_icon.iconId, tbl_soho_icon.iconName, tbl_soho_icon.iconCounter, " + 
				"tbl_soho_icon.iconStatus, tbl_soho_icon_type.typeId, tbl_soho_icon_type.typeName, tbl_soho_icon_type.typeClass, " + 
				"tbl_soho_icon_tag.tagId, tbl_soho_icon_tag.tagName " + 
				"FROM tbl_soho_icon " + 
				"INNER JOIN tbl_soho_icon_type " + 
				"ON tbl_soho_icon.typeId = tbl_soho_icon_type.typeId " + 
				"INNER JOIN tbl_soho_icon_tag " + 
				"ON tbl_soho_icon.iconId = tbl_soho_icon_tag.iconId " + 
				"WHERE tbl_soho_icon.iconStatus = 'active' " + 
				"AND tbl_soho_icon.iconId IN (" + iconQuery + ") " + 
				"ORDER BY tbl_soho_icon_type.typeClass ASC, tbl_soho_icon_type.typeId ASC, tbl_soho_icon.iconId, tbl_soho_icon.iconName;";
		IconDownloadUpdate iconDownloadUpdate = (IconDownloadUpdate) getIconDownloadUpdateMapper().mapRowsFromQuery(jdbcTemplate.queryForList(sql)).get(0);
		Common.getQueryReport("getDownloadUpdate", sql);
		return iconDownloadUpdate;
	}

	@Override
	public SoHoResponse saveIcon(String data, String mode) {
		// TODO Auto-generated method stub
		SoHoResponse response = null;
		
		try {
			Map<String, Object> mapData = getCommonMapper().mapRowsFromJSON(data);
			String sqlIconInfo, sqlIconProduct, sqlIconDownload, sqlIconProperty, sqlIconTag, sql, iconId;
			int productId = Common.ZERO;
			
			String iconName = mapData.get(Common.ICON_NAME).toString();
			int iconType = Integer.parseInt(mapData.get(Common.ICON_TYPE).toString());
			
			if (mode.equals(Common.MODE_ADD)) {
				sqlIconInfo = "INSERT INTO tbl_soho_icon (iconName, typeId) " + 
						"VALUES ('" + iconName + "','" + iconType + "');";
				jdbcTemplate.update(sqlIconInfo);
				Common.getQueryReport("saveIcon", sqlIconInfo);
			}
			
			if (mode.equals(Common.MODE_ADD)) {
				sql = "SELECT * FROM tbl_soho_icon ORDER BY iconId DESC LIMIT 1;";
				iconId = jdbcTemplate.queryForList(sql).get(0).get(Common.ICON_ID).toString();
				Common.getQueryReport("saveIcon", sql);
			} else {
				iconId = mapData.get("iconId").toString();
			}
			
			if (mapData.get(Common.HAS_PRODUCT_NEW) == Common.BIG_Y) {
				String productNew = mapData.get(Common.PRODUCT_NEW).toString();
				sqlIconProduct = "INSERT INTO tbl_soho_product (productNew) " + 
						"VALUES ('" + productNew + "');";
				jdbcTemplate.update(sqlIconProduct);
				Common.getQueryReport("saveIcon", sqlIconProduct);

				String sqlProductId = "SELECT productId FROM tbl_soho_product ORDER BY productId DESC LIMIT 1;";
				productId = getCommonMapper().mapProductId(jdbcTemplate.queryForList(sqlProductId));
				Common.getQueryReport("saveIcon", sqlProductId);
			} else if (mapData.get(Common.PRODUCT_ID) != null && !mapData.get(Common.PRODUCT_ID).toString().equals(Common.STRING_EMPTY)) {
				productId = Integer.parseInt(mapData.get(Common.PRODUCT_ID).toString());
			}
			
			
			if (productId != Common.ZERO) {
				sqlIconDownload = getCommonMapper().queryDownloadSingleInserter(iconId, Common.ADMIN, productId);
				jdbcTemplate.update(sqlIconDownload);
				Common.getQueryReport("saveIcon", sqlIconDownload);
			}
			
			sqlIconProperty = "INSERT INTO tbl_soho_icon_properties (propertySize, propertyFormat, propertyPrefix, iconId) " + 
					"VALUES ";
		
			if (mapData.get(Common.HAS_SVG) != null && mapData.get(Common.HAS_SVG).toString().equals(Common.BIG_Y) && mapData.get(Common.HAS_NEW_SVG).equals(Common.BIG_Y)) {	
				sqlIconProperty += "('" + Common.STRING_EMPTY + "','" + Common.EXTENSION_SVG + "','" + Common.STRING_EMPTY + "','" + iconId + "'), ";
			}
			
			if (mapData.get(Common.HAS_PNG) != null && mapData.get(Common.HAS_PNG).toString().equals(Common.BIG_Y) && mapData.get(Common.HAS_NEW_PNG).equals(Common.BIG_Y)) {
				if (mapData.get(Common.S_18) != null && mapData.get(Common.S_18).toString().equals(Common.BIG_Y)) {
					sqlIconProperty += "('" + Common.SIZE_18 + "','" + Common.EXTENSION_PNG + "','" + Common.SMALL_G + "','" + iconId + "'), ";
				}
				
				if (mapData.get(Common.S_22) != null && mapData.get(Common.S_22).toString().equals(Common.BIG_Y)) {
					sqlIconProperty += "('" + Common.SIZE_22 + "','" + Common.EXTENSION_PNG + "','" + Common.SMALL_G + "','" + iconId + "'), ";
				}
				
				if (mapData.get(Common.S_29) != null && mapData.get(Common.S_29).toString().equals(Common.BIG_Y)) {
					sqlIconProperty += "('" + Common.SIZE_29 + "','" + Common.EXTENSION_PNG + "','" + Common.SMALL_G + "','" + iconId + "'), ";
				}
				
				if (mapData.get(Common.S_40) != null && mapData.get(Common.S_40).toString().equals(Common.BIG_Y)) {
					sqlIconProperty += "('" + Common.SIZE_40 + "','" + Common.EXTENSION_PNG + "','" + Common.SMALL_G + "','" + iconId + "'), ";
				}
				
				if (mapData.get(Common.S_48) != null && mapData.get(Common.S_48).toString().equals(Common.BIG_Y)) {
					sqlIconProperty += "('" + Common.SIZE_48 + "','" + Common.EXTENSION_PNG + "','" + Common.SMALL_G + "','" + iconId + "'), ";
				}
				
				if (mapData.get(Common.S_50) != null && mapData.get(Common.S_50).toString().equals(Common.BIG_Y)) {
					sqlIconProperty += "('" + Common.SIZE_50 + "','" + Common.EXTENSION_PNG + "','" + Common.SMALL_G + "','" + iconId + "'), ";
				}
				
				if (mapData.get(Common.S_57) != null && mapData.get(Common.S_57).toString().equals(Common.BIG_Y)) {
					sqlIconProperty += "('" + Common.SIZE_57 + "','" + Common.EXTENSION_PNG + "','" + Common.SMALL_G + "','" + iconId + "'), ";
				}
				
				if (mapData.get(Common.S_58) != null && mapData.get(Common.S_58).toString().equals(Common.BIG_Y)) {
					sqlIconProperty += "('" + Common.SIZE_58 + "','" + Common.EXTENSION_PNG + "','" + Common.SMALL_G + "','" + iconId + "'), ";
				}
				
				if (mapData.get(Common.S_72) != null && mapData.get(Common.S_72).toString().equals(Common.BIG_Y)) {
					sqlIconProperty += "('" + Common.SIZE_72 + "','" + Common.EXTENSION_PNG + "','" + Common.SMALL_G + "','" + iconId + "'), ";
				}
				
				if (mapData.get(Common.S_76) != null && mapData.get(Common.S_76).toString().equals(Common.BIG_Y)) {
					sqlIconProperty += "('" + Common.SIZE_76 + "','" + Common.EXTENSION_PNG + "','" + Common.SMALL_G + "','" + iconId + "'), ";
				}
				
				if (mapData.get(Common.S_80) != null && mapData.get(Common.S_80).toString().equals(Common.BIG_Y)) {
					sqlIconProperty += "('" + Common.SIZE_80 + "','" + Common.EXTENSION_PNG + "','" + Common.SMALL_G + "','" + iconId + "'), ";
				}
				
				if (mapData.get(Common.S_100) != null && mapData.get(Common.S_100).toString().equals(Common.BIG_Y)) {
					sqlIconProperty += "('" + Common.SIZE_100 + "','" + Common.EXTENSION_PNG + "','" + Common.SMALL_G + "','" + iconId + "'), ";
				}
				
				if (mapData.get(Common.S_114) != null && mapData.get(Common.S_114).toString().equals(Common.BIG_Y)) {
					sqlIconProperty += "('" + Common.SIZE_114 + "','" + Common.EXTENSION_PNG + "','" + Common.SMALL_G + "','" + iconId + "'), ";
				}
				
				if (mapData.get(Common.S_120) != null && mapData.get(Common.S_120).toString().equals(Common.BIG_Y)) {
					sqlIconProperty += "('" + Common.SIZE_120 + "','" + Common.EXTENSION_PNG + "','" + Common.SMALL_G + "','" + iconId + "'), ";
				}
				
				if (mapData.get(Common.S_144) != null && mapData.get(Common.S_144).toString().equals(Common.BIG_Y)) {
					sqlIconProperty += "('" + Common.SIZE_144 + "','" + Common.EXTENSION_PNG + "','" + Common.SMALL_G + "','" + iconId + "'), ";
				}
				
				if (mapData.get(Common.S_152) != null && mapData.get(Common.S_152).toString().equals(Common.BIG_Y)) {
					sqlIconProperty += "('" + Common.SIZE_152 + "','" + Common.EXTENSION_PNG + "','" + Common.SMALL_G + "','" + iconId + "'), ";
				}
				
				if (mapData.get(Common.S_512) != null && mapData.get(Common.S_512).toString().equals(Common.BIG_Y)) {
					sqlIconProperty += "('" + Common.SIZE_512 + "','" + Common.EXTENSION_PNG + "','" + Common.SMALL_G + "','" + iconId + "'), ";
				}
				
				if (mapData.get(Common.S_1024) != null && mapData.get(Common.S_1024).toString().equals(Common.BIG_Y)) {
					sqlIconProperty += "('" + Common.SIZE_1024 + "','" + Common.EXTENSION_PNG + "','" + Common.SMALL_G + "','" + iconId + "'), ";
				}
			}
			
			if (mapData.get(Common.HAS_NEW_SVG).equals(Common.BIG_Y) && mapData.get(Common.HAS_NEW_PNG).equals(Common.BIG_Y)) {
				sqlIconProperty = sqlIconProperty.substring(0, sqlIconProperty.length() - 2);
				sqlIconProperty += ";";
				jdbcTemplate.update(sqlIconProperty);
				Common.getQueryReport("saveIcon", sqlIconProperty);
			}
			
			if (mapData.get(Common.TAGS) != null) {
				String[] tags = getCommonMapper().mapTagsFromRows(mapData.get(Common.TAGS).toString());
				
				String sqlTagChecker = "SELECT tagName FROM tbl_soho_icon_tag WHERE iconId = '" + iconId +"';";
				String[] tagExistList = getCommonMapper().mapTagsFromRows(jdbcTemplate.queryForList(sqlTagChecker));
				
				sqlIconTag = "INSERT INTO tbl_soho_icon_tag (tagName, iconId) " + 
						"VALUES ";
				
				for (int i = 0; i < tags.length; i++) {
					if (!Arrays.asList(tagExistList).contains(tags[i])) {
						sqlIconTag += "('" + tags[i] + "','" + iconId + "') ,";
					}
				}
				
				sqlIconTag = sqlIconTag.substring(0, sqlIconTag.length() - 2);
				sqlIconTag += ";";
				jdbcTemplate.update(sqlIconTag);
				Common.getQueryReport("saveIcon", sqlIconTag);
			}
			
			response = new SoHoResponse(Common.ONE, Common.WEB_MESSAGE_OK, Common.STRING_EMPTY);
		} catch (Exception e) {
			response = new SoHoResponse(Common.ZERO, Common.WEB_MESSAGE_ERROR, e.getMessage());
		}
		return response;
	}

	@Override
	public Icon getIconInfoById(String iconId) {
		// TODO Auto-generated method stub
		String sql = "SELECT tbl_soho_icon.iconId, tbl_soho_icon.iconName, tbl_soho_icon.iconCounter, " + 
				"tbl_soho_icon.iconStatus, tbl_soho_icon_type.typeId, tbl_soho_icon_type.typeName, tbl_soho_icon_type.typeClass, " + 
				"tbl_soho_icon_tag.tagId, tbl_soho_icon_tag.tagName, tbl_soho_icon_tag.tagStatus " + 
				"FROM tbl_soho_icon " + 
				"INNER JOIN tbl_soho_icon_type " + 
				"ON tbl_soho_icon.typeId = tbl_soho_icon_type.typeId " + 
				"INNER JOIN tbl_soho_icon_tag " + 
				"ON tbl_soho_icon.iconId = tbl_soho_icon_tag.iconId " + 
				"WHERE tbl_soho_icon.iconStatus = 'active' " + 
				"AND tbl_soho_icon.iconId = '" + iconId + "' " + 
				"ORDER BY tbl_soho_icon_type.typeClass ASC, tbl_soho_icon_type.typeId ASC, tbl_soho_icon.iconId, tbl_soho_icon.iconName;";
		List<Icon> icons = getIconMapper().mapRowsFromQuery(jdbcTemplate.queryForList(sql));
		Common.getQueryReport("getIconInfoById", sql);
		return icons.get(0);
	}

}
