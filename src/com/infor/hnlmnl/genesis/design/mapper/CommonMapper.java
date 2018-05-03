package com.infor.hnlmnl.genesis.design.mapper;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

import com.infor.hnlmnl.genesis.design.dto.Icon;
import com.infor.hnlmnl.genesis.design.dto.IconProperty;
import com.infor.hnlmnl.genesis.design.dto.Product;
import com.infor.hnlmnl.genesis.design.utility.Common;

public class CommonMapper {
	public Map<String, Object> mapRowsFromJSON(String data) {
		String[] dataList = data.split(";");
		
		Map<String, Object> mapData = new HashMap<String, Object>();
		
		for (int i = 0; i < dataList.length; i++) {
			String[] dataListValue = dataList[i].split(":");
			
			if (dataListValue.length > 1) {
				mapData.put(dataListValue[0].trim(), dataListValue[1].trim());
			} else {
				mapData.put(dataListValue[0].trim(), Common.STRING_EMPTY);
			}
			
		}
		
		return mapData;
	}
	
	public String[] mapTagsFromRows(String tags) {
		String[] dataList = tags.split(",");
		return dataList;
	}
	
	public String[] mapTagsFromRows(List<Map<String, Object>> resultSet) {
		String dataSet = Common.STRING_EMPTY;
		for (Map<String, Object> result : resultSet) {
			dataSet += result.get(Common.TAG_NAME) + ",";
		}
		
		dataSet = dataSet.substring(0, dataSet.length() - 1);
		
		String[] dataList = dataSet.split(",");
		return dataList;
	}
	
	public List<String[]> mapIconList(String data) {
		String dataList[] = data.split("§");
		List<String[]> iconDataList = new ArrayList<String[]>();
		
		for (int i = 0; i < dataList.length; i++) {
			String[] iconData = dataList[i].split("†");
			iconDataList.add(iconData);
		}
	
		return iconDataList;
	}
	
	public String queryIconSelector(List<String[]> data) {
		String queryBuilder = Common.STRING_EMPTY;
		
		for (String[] dataItem : data) {
			queryBuilder += "'" + dataItem[0] + "',";
		}
		
		queryBuilder = queryBuilder.substring(0, queryBuilder.length() - 1);
		
		return queryBuilder;
	}
	
	public List<String> queryIconUpdator(List<String[]> data) {
		List<String> queryBuilder = new ArrayList<String>();
		
		for (String[] dataItem : data) {
			String sqlUpdateCounter = "UPDATE tbl_soho_icon " + 
					"SET iconCounter = '" + (Integer.parseInt(dataItem[1]) + 1) + "' " + 
					"WHERE iconId = '" + dataItem[0] + "';";
			queryBuilder.add(sqlUpdateCounter);
		}
		return queryBuilder;
	}

	public String queryDownloadMultipleInserter(List<String[]> data, String emailAddress, int productId) {
		String queryBuilder = Common.STRING_EMPTY;
		String downloadDateTime = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		
		queryBuilder += "INSERT INTO tbl_soho_icon_download "
				+ "(downloadDateTime, emailAddress, productId, iconId) VALUES ";
		for (String[] dataItem : data) {
			queryBuilder += "('" + downloadDateTime + "','" + emailAddress + "','" + productId + "','" + dataItem[0] + "'),";  
		}
		
		queryBuilder = queryBuilder.substring(0, queryBuilder.length() - 1);
		queryBuilder += ";";
		
		return queryBuilder;
	}
	
	public String queryDownloadSingleInserter(String iconId, String emailAddress, int productId) {
		String queryBuilder = Common.STRING_EMPTY;
		String downloadDateTime = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		
		queryBuilder += "INSERT INTO tbl_soho_icon_download "
				+ "(downloadDateTime, emailAddress, productId, iconId) VALUES ";
		queryBuilder += "('" + downloadDateTime + "','" + emailAddress + "','" + productId + "','" + iconId + "'),";
		
		queryBuilder = queryBuilder.substring(0, queryBuilder.length() - 1);
		queryBuilder += ";";
		
		return queryBuilder;
	}
	
	public int mapProductId(List<Map<String, Object>> resultSet) {
		int productId = Common.ZERO;
		for (Map<String, Object> result : resultSet) {
			productId = (int) result.get(Common.PRODUCT_ID);
		}
		
		return productId;
	}
	
	public List<Icon> mapIconProducts(List<Icon> icons, List<Map<String, Object>> resultSet) {
		for (Map<String, Object> result : resultSet) {
			try {
				int iconId = (int) result.get(Common.ICON_ID);
				Predicate<Icon> itemPredicator = iconPredicated-> iconPredicated.getIconId() == iconId;
				Icon iconResult = icons.stream().filter(itemPredicator).findFirst().get();
				icons.remove(iconResult);
				
				int productId = (int) result.get(Common.PRODUCT_ID);
				String productName = (String) result.get(Common.PRODUCT_NAME);
				iconResult.getProducts().add(new Product(productId, productName));
				
				icons.add(iconResult);
			} catch(NoSuchElementException e) {
				continue;
			}
		}
		
		return icons;
	}
	
	public List<Icon> mapIconProperties(List<Icon> icons, List<Map<String, Object>> resultSet) {
		for (Map<String, Object> result : resultSet) {
			try {
				int iconId = (int) result.get(Common.ICON_ID);
				Predicate<Icon> itemPredicator = iconPredicated-> iconPredicated.getIconId() == iconId;
				Icon iconResult = icons.stream().filter(itemPredicator).findFirst().get();
				icons.remove(iconResult);
	
				int propertyId = (int) result.get(Common.PROPERTY_ID);
				String propertySize;
				if (!result.get(Common.PROPERTY_SIZE).toString().equals(Common.STRING_EMPTY)) {
					propertySize = (String) result.get(Common.PROPERTY_SIZE);
				} else {
					propertySize = Common.STRING_EMPTY;
				}
				 
				String propertyFormat = (String) result.get(Common.PROPERTY_FORMAT);
				
				String propertyPrefix;
				if (!result.get(Common.PROPERTY_PREFIX).toString().equals(Common.STRING_EMPTY)) {
					propertyPrefix = (String) result.get(Common.PROPERTY_PREFIX);
				} else {
					propertyPrefix = Common.STRING_EMPTY;
				}
				
				iconResult.getProperties().add(new IconProperty(propertyId, propertySize, propertyFormat, propertyPrefix));
				
				icons.add(iconResult);
			} catch(NoSuchElementException e) {
				continue;
			}
		}
		
		return icons;
	}
}
